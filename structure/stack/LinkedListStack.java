package structure.stack;

import structure.linklist.LinkList;

/**
 * 基于链表实现的栈
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkList<E> list;

    // 链表支持动态扩容
    public LinkedListStack() {
        list = new LinkList<>();
    }

    // 获取栈中的元素个数
    @Override
    public int getSize() {
        return list.getSize();
    }

    // 判断栈是否为空
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    //向栈中添加元素
    //链表是线性链结构，栈是先入后出的结构，所以往栈中添加元素就意味着往链表的头位置添加元素，一次向后压栈
    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    // 栈中弹出元素
    @Override
    public E pop() {
        return list.removeFirst();
    }

    // 获得栈定的元素
    @Override
    public E peek() {
        return list.getFirst();
    }

    // 遍历
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("stack : top ");
        res.append(list);
        return res.toString();
    }
}
