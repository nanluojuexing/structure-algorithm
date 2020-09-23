package leetcode.string;

import org.junit.Test;

import java.util.Stack;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 *
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 *
 * 题目解析：
 * 1.去重
 * 2.
 */
public class solution316 {

    @Test
    public void test(){

        System.out.println(removeDuplicateLetters("bcabc"));
//        System.out.println(removeDuplicateLetters("cbacdcbc"));

    }

    public String removeDuplicateLetters(String s) {
        // 用来记录最终取重后的字符
        Stack<Character> stack = new Stack();
        //遍历字符 统计字符中每个字符的数量
        // 当字典序较小的字符试图「挤掉」栈顶元素的时候，在count中检查栈顶元素是否是唯一的，只有当后面还存在栈顶元素的时候才能挤掉，否则不能挤掉
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        // 定义boolean数组，标记字符是否在存在
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            // 每遍历一个字符，就应该减少一个
            count[c]--;
            if(inStack[c]){
                continue;
            }
            // 判断栈顶字符和当前遍历字符的大小，如果小于当前字符，就需要pop然后替换位置
            while (!stack.isEmpty() && stack.peek() > c ){
                // 这是否还在在对应的字符，如果不存在栈顶元素了
                if(count[stack.peek()] ==0){
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c]= true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
