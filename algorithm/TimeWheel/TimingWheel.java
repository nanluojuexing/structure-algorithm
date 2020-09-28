package algorithm.TimeWheel;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 时间轮
 * @param <E>
 */
public class TimingWheel<E> {

    /**
     * 时间跨度
     */
    private final long tickDuration;

    /**
     * 时间轮大小
     */
    private final int ticksPerWheel;

    /**
     * 当前层级
     */
    private volatile int currentIndex =0;

    /**
     * 过期事件监听
     */
    private final CopyOnWriteArrayList<ExpirationListener<E>> expirationListeners = new CopyOnWriteArrayList<ExpirationListener<E>>();

    /**
     *
     */
    private final ArrayList<Slot<E>> wheel;

    /**
     *
     */
    private final Map<E, Slot<E>> indicator = new ConcurrentHashMap<E, Slot<E>>();

    /**
     * 中断标志
     */
    private final AtomicBoolean shutdown = new AtomicBoolean(false);

    /**
     * 读写锁
     */
    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 工作线程
     */
    private Thread workerThread;

    /**
     * 时间轮构造方法
     * @param tickDuration
     * @param ticksPerWheel
     * @param timeUnit
     */
    public TimingWheel(long tickDuration, int ticksPerWheel, TimeUnit timeUnit) {
        // 参数校验
        if(timeUnit == null){
            throw new NullPointerException("unit is not empty");
        }
        if(tickDuration <= 0){
            throw  new IllegalArgumentException(" tickDuration must be greater than 0: " + tickDuration);
        }
        if(ticksPerWheel <= 0){
            throw  new IllegalArgumentException(" ticksPerWheel must be greater than 0: " + tickDuration);
        }

        // 初始化数组
        this.wheel = new ArrayList<Slot<E>>();
        //初始化时间
        this.tickDuration = timeUnit.MILLISECONDS.convert(tickDuration,timeUnit);
        // 初始化槽的数量
        this.ticksPerWheel = ticksPerWheel+1;
        // 循环添加槽
        for (int i = 0; i < this.ticksPerWheel; i++) {
            wheel.add(new Slot<E>(i));
        }
        //
        wheel.trimToSize();
        // 初始化工作线程
        workerThread = new Thread(new TickWorker(), "Timing-Wheel");
    }

    public void start(){
        if(shutdown.get()){
            throw new IllegalStateException("Cannot be started once stopped");
        }
        if(!workerThread.isAlive()){
            workerThread.start();
        }
    }

    public boolean stop(){

        if (!shutdown.compareAndSet(false, true)) {
            return false;
        }

        boolean interrupted = false;
        while (workerThread.isAlive()) {
            workerThread.interrupt();
            try {
                workerThread.join(100);
            } catch (InterruptedException e) {
                interrupted = true;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }

        return true;

    }

    /**
     * 增加失败事件监听器
     * @param listener
     */
    public void addExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.add(listener);
    }

    /**
     * 移除失败事件监听器
     * @param listener
     */
    public void removeExpirationListener(ExpirationListener<E> listener) {
        expirationListeners.remove(listener);
    }

    /**
     * Add a element to {@link TimingWheel} and start to count down its life-time.
     *
     * @param e
     * @return remain time to be expired in millisecond.
     */
    public long add(E e) {
        synchronized(e) {
            checkAdd(e);

            int previousTickIndex = getPreviousTickIndex();
            // 获得时间轮中的位置
            Slot<E> slot = wheel.get(previousTickIndex);
            slot.add(e);
            // key为事件 value为槽
            indicator.put(e, slot);
            // 返回间隔的时间
            return (ticksPerWheel - 1) * tickDuration;
        }
    }

    /**
     * 检查是否已经添加
     * @param e
     */
    private void checkAdd(E e) {
        Slot<E> slot = indicator.get(e);
        if (slot != null) {
            slot.remove(e);
        }
    }

    private int getPreviousTickIndex() {
        lock.readLock().lock();
        try {
            int cti = currentIndex;
            if (cti == 0) {
                return ticksPerWheel - 1;
            }

            return cti - 1;
        } finally {
            lock.readLock().unlock();
        }
    }

    /**
     * Removes the specified element from timing wheel.
     *
     * @param e
     * @return <tt>true</tt> if this timing wheel contained the specified
     *         element
     */
    public boolean remove(E e) {
        synchronized (e) {
            Slot<E> slot = indicator.get(e);
            if (slot == null) {
                return false;
            }

            indicator.remove(e);
            return slot.remove(e) != null;
        }
    }

    /**
     * 提升是否过期
     * @param idx
     */
    private void notifyExpired(int idx) {
        Slot<E> slot = wheel.get(idx);
        Set<E> elements = slot.elements();
        for (E e : elements) {
            slot.remove(e);
            synchronized (e) {
                Slot<E> latestSlot = indicator.get(e);
                if (latestSlot.equals(slot)) {
                    indicator.remove(e);
                }
            }
            for (ExpirationListener<E> listener : expirationListeners) {
                listener.expired(e);
            }
        }
    }

    public  class TickWorker implements Runnable {

        /**
         * 开始时间
         */
        private long startTime;

        /**
         *
         */
        private long tick;

        @Override
        public void run() {
            // 初始化开始时间
            startTime = System.currentTimeMillis();
            tick = 1;

            for (int i = 0; !shutdown.get(); i++) {
                if (i == wheel.size()) {
                    i = 0;
                }
                lock.writeLock().lock();
                try {
                    currentIndex = i;
                } finally {
                    lock.writeLock().unlock();
                }
                notifyExpired(currentIndex);
                waitForNextTick();
            }
        }

        /**
         *
         */
        private void waitForNextTick() {
            for (;;) {
                long currentTime = System.currentTimeMillis();
                long sleepTime = tickDuration * tick - (currentTime - startTime);

                if (sleepTime <= 0) {
                    break;
                }

                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    return;
                }
            }
            tick++;
        }
    }

}
