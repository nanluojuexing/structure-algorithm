package leetcode.string.palindromeString;

import org.junit.Test;

/**
 *
 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。

 示例 1:

 输入: "aba"
 输出: True
 示例 2:

 输入: "abca"
 输出: True
 解释: 你可以删除c字符。
 注意:

 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000
 */
public class solution680 {

    @Test
    public void test1(){

        //System.out.println(validPalindrome("aba"));
        System.out.println(validPalindrome("abca"));
    }

    public boolean validPalindrome(String s) {
        ////先校验字符串是否为回文字符串
        //final boolean palindrome = isPalindrome(s,0,s.length()-1);
        //if(palindrome){
        //    return true;
        //}
        int i = 0;
        int j = s.length()-1;
        // 定义双指针移动对比元素
        while ( i < j ){
            // 当元素不想等时候，向后或向前移动一个字符串，对比字符串是否为true
            if(s.charAt(i) != s.charAt(j)){
                return isPalindrome(s,i+1,j) || isPalindrome(s,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }


    /**
     * 校验字符串是否为 回文字符串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s,int i ,int j){
        while (i<j){
            if(s.charAt(i++)!=s.charAt(j--)){
                return false;
            }
        }
        return true;
    }

}
