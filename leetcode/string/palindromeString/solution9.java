package leetcode.string.palindromeString;

import org.junit.Test;

/**
 * 判断数字是否为回文数字
 * 这个题目说的是，给你一个整数，你要判断它是否是一个回文数字。所谓回文数字就是，你正着读和反着读都是同一个数字。
 *
 * 比如，给你的数字是：
 * 12321
 * 无论你从左向右读，还是从右向左读，都是 12321，所以它是一个回文数字，你要返回 true。
 *
 * 再比如说：
 * -232
 * 你从左向右读是 -232，但从右向左读则是 232-，和 -232 不一样，因此它不是一个回文数字，你要返回 false
 *
 *
 */
public class solution9 {

    @Test
    public void test(){
        System.out.println(isPalindromeNumString(12321));
        System.out.println(isPalindromeNumString(-232));
    }

    public boolean isPalindromeNumString(int x){

        String s = String.valueOf(x);
        int i =0;
        int j = s.length()-1;

        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
