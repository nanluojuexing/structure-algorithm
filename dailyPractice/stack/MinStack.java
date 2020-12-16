package dailyPractice.stack;


import java.util.Stack;

/**
 * 实现一个栈，该栈带有出栈pop，入栈push 获取最小元素 getMin，要求保证这3个方法的时间复杂度都是O(1)
 *
 * 解析思路：利用辅助栈记录最小元素，因为栈本身的出栈与入栈就是O(1)的，所以辅助栈记录最小元素，即栈顶元素，所以也可以O(1)
 */
public class MinStack {
    /**
     * 定义存储元素的栈
     */
    private Stack<Integer> mainStack = new Stack<>();

    /**
     * 定义存储最小元素的栈
     */
    private Stack<Integer> minStack = new Stack<>();

    /**
     * 入栈操作
     * @param element
     */
    public void  push(int element){
        // 直接push进主栈中
        mainStack.push(element);
        // 同时将最小的元素添加到最小栈中，元素要小于最小栈的栈顶元素
        if(minStack.empty() || element <= minStack.peek()){
            minStack.push(element);
        }
    }

    /**
     * 出栈操作
     * @return
     */
    public Integer pop(){
        // 如果出栈元素和辅助栈元素值相同，辅助栈出栈
        if(mainStack.peek().equals(mainStack.peek())){
            minStack.pop();
        }
        return mainStack.pop();
    }

    public int getMin() throws Exception {
        if (mainStack.empty()){
            throw new Exception("stack is empty");
        }
        return minStack.peek();
    }

    public static void main(String[] args) throws Exception {
        MinStack stack = new MinStack();
        stack.push(4);
        stack.push(9);
        stack.push(7);
        stack.push(5);
        stack.push(8);
        stack.push(3);

        System.out.println(stack.getMin());
    }

}
