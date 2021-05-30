package swordoffer;

import org.junit.Test;

import java.util.LinkedList;

/**
 * 两个栈实现一个队列
 *
 * 两个栈实现一个队列，。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 */
public class CQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList();
        stack2 = new LinkedList();
    }

    /**
     * 插入元素
     * @param value
     */
    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {

        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }

    @Test
    public void test(){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        cQueue.appendTail(3);
        cQueue.appendTail(4);

        final int i = cQueue.deleteHead();
        System.out.println(i);
    }

    /**
     * 题解
     * 栈是先入后出，队列是先入先出，可以定义链表，作为基础队列，存储元素，符合先入先出的要求，并且都是尾部插入元素
     *
     * 头部删除，用另外一个栈存储基础栈pop出的元素，然后之需要弹出栈2的栈顶元素，就完成头部删除的功能
     */
}
