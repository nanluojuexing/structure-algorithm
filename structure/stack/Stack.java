package structure.stack;

/**
 * 定义栈所对应的接口
 */
public interface Stack<E> {
    /**
     * 元素数量
     * @return
     */
    int getSize();

    /**
     * 是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e);

    /**
     * 出栈
     * @return
     */
    E pop();

    /**
     * 获得栈顶的元素，不移除
     * @return
     */
    E peek();
}
