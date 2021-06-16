package leetcode.string.palindromeString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入:"aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-partitioning
 */
public class solution131 {

    @Test
    public void test1(){
        System.out.println(Arrays.toString(partition2("aab").toArray()));
    }

    public List<List<String>> partition(String s) {
        return isPalindromeBeforeSplit(s,0);
    }

    /**
     *
     * @param s 目标字符串
     * @param start 起始位置
     * @return
     */
    public List<List<String>> isPalindromeBeforeSplit(String s,int start){
        // 处理临界值
        if(start == s.length()){
            List<List<String>> result = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            result.add(ans);
            return result;
        }
        // 遍历截取字符串
        List<List<String>> ans = new ArrayList<>();
        for (int i = start ; i < s.length() ; i++) {
            if(isPalindrome(s.substring(start,i+1))){
                String left = s.substring(start,i+1);
                for (List<String> list: isPalindromeBeforeSplit(s,i+1)) {
                    list.add(0,left);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    /**
     * 校验字符串是否为 回文字符串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        if(s == null || s.length()==0){
            return true;
        }
        int i =0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> partition2(String s) {
        List<List<String>> ans = new ArrayList<>();
        int length = s.length();
        recall(s,length,new Stack<String>(),0,ans);
        return ans;
    }

    /**
     *
     * @param s 原字符串
     * @param length 字符串长度
     * @param splitStrings 用来存储分割 回文字符串
     * @param start 起始位置
     * @param ans 结果集
     */
    private void recall(String s, int length, Stack<String> splitStrings, int start, List<List<String>> ans) {
        if(start == length){
            ans.add(new ArrayList<>(splitStrings));
            return;
        }

        for (int i = start; i < length; i++) {
            if(!isPalindrome(s.substring(start,i+1))){
                continue;
            }
            splitStrings.push(s.substring(start,i+1));
            recall(s,length,splitStrings,i+1,ans);
            String pop = splitStrings.pop();
            System.out.println(pop);
        }
    }
}
