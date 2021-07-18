package swordoffer;

import org.junit.Test;

/**
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 */
public class FirstUniqChar {

    @Test
    public void test(){

        String s = "abaccdeff";
        System.out.println(firstUniqChar(s));
    }

    public char firstUniqChar(String s) {

        if("".equals(s)){
            return ' ';
        }

        // 定义数组统计字符串的各字符出现次数
        int[] nums = new int[26];
        char[] chars = s.toCharArray();
        // 字典数组
        for (int i = 0; i < chars.length; i++) {
            nums[chars[i]-'a'] = nums[chars[i]-'a'] +1 ;
        }
        // 遍历字典数组，判断值为1的
        for (int i = 0; i < chars.length; i++) {
            if(nums[chars[i]-'a'] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 题解：
     *
     *
     */
}
