package structure.stack;

import structure.array.Array;

/**
 * 基于数组实现的栈
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    // 初始容量设置
    public ArrayStack(int capacity) {
        array = new Array<E>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 元素入栈
     * @param e
     */
    @Override
    public void push(E e) {
        // 栈是先入后出的数据结构，基于数组实现，默认将添加的元素添加到后面的位置
        array.addLast(e);
    }

    /**
     * 从栈中弹出一个元素
     * @return
     */
    @Override
    public E pop() {
        // 栈是先入后出的数据结构，基于数组实现，移除的的元素是从后面到前面开始移除
        return array.removeLast();
    }

    /**
     * 获得栈顶的元素
     * @return
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack , [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if(i != array.getSize()-1)
                res.append(",");
        }
        res.append("] , top");
        return res.toString();
    }
}
