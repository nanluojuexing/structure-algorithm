package structure.queue;

/**
 * 基于数组实现 队列
 */
public class ArrayQueue {

    /**
     * 定义数组
     */
    private Object[] items;

    /**
     * 数组的大小
     */
    private int n;

    /**
     * 队列头的下标
     */
    private int head = 0;

    /**
     * 队尾的下标
     */
    private int tail = 0;

    public ArrayQueue(int n) {
        items = new Object[n];
        this.n = n;
    }

    /**
     * 元素入队
     * @param e
     * @return
     */
    public boolean enqueue(Object e){
        // 如果队尾的下标等于数组的大小，说明队列已满
        if(tail ==n){
            return false;
        }
        items[tail] = e;
        ++tail;
        return true;
    }

    /**
     * 支持扩容操作的入队
     * @param e
     * @return
     */
    public boolean enqueue2(Object e){
        // 判断队列是否已到队尾
        if(tail == n){
            // 说明队列已经满了
            if(head ==0)
                return false;

            //数据迁移
            for (int i = head; i < n; i++) {
                items[i-head] = items[i];
            }
            // 迁移完毕，需要重新指定下标
            tail -=head;
            head =0;
        }
        items[tail] = e;
        ++tail;
        return true;
    }

    /**
     * 元素出队
     * @return
     */
    public Object dequeue(){
        // head == tail 说明队列为空
        if(head==tail){
            return null;
        }
        // 队列的出队，从队头开始
        Object item = items[head];
        ++head;
        return item;
    }
}
