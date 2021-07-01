package swordoffer;

import org.junit.Test;

import java.util.Stack;

/**
 *
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 */
public class MinStack {

    Stack<Integer> stackA;
    // 存储最小的元素，作为辅助栈
    Stack<Integer> stackB;

    public MinStack() {
        stackA = new Stack<>();
        stackB = new Stack<>();
    }

    public void push(int x) {
        // 元素直接加入主栈
        stackA.add(x);
        // 校验是否是最小元素，如果是，压入辅助栈
        if(stackB.empty() || stackB.peek() >= x){
            stackB.add(x);
        }
    }

    // 弹出栈顶元素
    public void pop() {
        // 如果是最小元素，都需要弹出
        if(stackA.pop().equals(stackB.peek())){
            stackB.pop();
        }
    }
    // 栈顶元素
    public int top() {
        return stackA.peek();
    }
    // 最小的元素
    public int min() {
        return stackB.peek();
    }

    @Test
    public void test(){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        // 返回-3
        System.out.println(minStack.min());
        minStack.pop();
        // 输出0
        System.out.println(minStack.top());
        //输出-2
        System.out.println(minStack.min());

    }
}
