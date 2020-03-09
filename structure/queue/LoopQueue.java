package structure.queue;

import org.omg.CORBA.Object;

/**
 * 基于数组实现的自动扩容 循环队列
 *
 * 循环队列的条件 (循环队列tail位置不存储元素)
 *  队列为空  head == tail
 *  队列已满 (tail+1) % 数组长度 == head
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 定义数组
     */
    private E[] items;

    /**
     * 定义队首下标
     */
    private int head;

    /**
     * 队尾下标
     */
    private int tail;

    /**
     * 队列中的元素个数
     */
    private int size;

    public LoopQueue(int capacity){
        items = (E[]) new Object[capacity + 1];
        head=0;
        tail=0;
        size=0;
    }

    public int getCapacity(){
        return items.length-1;
    }

    @Override
    public void enqueue(E e) {
        //说明队列已满，需要扩容
        if((tail+1)%items.length == head){
            resize(getCapacity()*2);
        }
        items[tail] = e;
        tail = (tail+1) % items.length;
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw  new IllegalArgumentException("queue ie empty!");
        }
        E item = items[head];
        // 释放引用
        items[head] = null;
        // 重置head下标
        head = (head+1) % items.length;
        size --;
        if(size == getCapacity()/4 && getCapacity() / 2 != 0){
            resize(getCapacity()/2);
        }
        return item;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw  new IllegalArgumentException("queue ie empty!");
        }
        return items[head];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private void resize(int capacity){

        E[] newItems = (E[]) new Object[capacity+1];
        // 数据迁移
        for (int i = 0; i < items.length; i++) {
            newItems[i] = items[(i+head)%items.length];
        }
        // 数据迁移完成后，将新的数组赋值，并重新修正队首和队尾的下标
        items = newItems;
        head=0;
        tail =size;
    }
}
