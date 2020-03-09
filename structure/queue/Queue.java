package structure.queue;

public interface Queue<E> {

    /**
     * 元素入队
     * @param e
     */
    void enqueue(E e);

    /**
     * 元素出队
     * @return
     */
    E dequeue();

    /**
     * 获得队首的元素
     * @return
     */
    E getFront();


    /**
     * 获得队列中元素的个数
     * @return
     */
    int getSize();

    /**
     * 判断队列是否为空
     * @return
     */
    boolean isEmpty();
}
