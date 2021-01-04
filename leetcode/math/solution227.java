package leetcode.math;

import java.util.Stack;

/**
 * 基本计算器
 */
public class solution227 {

    public static void main(String[] args) {

        String s = "42";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack();
        char[] chars = s.toCharArray();
        // 定义字符记录当前符号
        char lastOp = '+';
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                continue;
            }
            //判断是不是数字
            if(Character.isDigit(chars[i])){
                // 获得当前的数值
                int temp = chars[i] - '0';
                while( ++i < chars.length && Character.isDigit(chars[i]) ){
                    temp = temp * 10 + (chars[i] - '0' );
                }
                i--;
                if(lastOp == '+'){
                    stack.push(temp);
                }else if(lastOp == '-'){
                    stack.push(-temp);
                }else{
                    // 这里计算 * /运算
                    stack.push(res(lastOp,stack.pop(),temp));
                }
            }else{
                lastOp = chars[i];
            }
        }
        // 然后累加栈中的数据
        int ans = 0;
        for(int num : stack) {
            ans += num;
        }
        return ans;
    }

    /**
     * 计算 乘 除运算的
     * @param c
     * @param a
     * @param b
     * @return
     */
    private static int res(char c,int a ,int b){
        int result = 0;
        if(c == '*'){
            result =   a * b;
        }else if(c == '/'){
            result =   a / b;
        }
        return result;
    }
}
