package leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class solution3 {

    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        // 记录没有重复的子串
        Set<Character> chr = new HashSet<Character>();
        // 记录不重复的字符个数
        int ans =0;
        // 索引位置
        int i=0;
        // 索引位置
        int j=0;

        while(i<n && j<n){

            if(!chr.contains(s.charAt(j))){
                chr.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }else{
                chr.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * 题解:
     *
     *
     *
     */
}
