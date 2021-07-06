package swordoffer;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 剑指offer 58 左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * 示例 1：
 * 输入: s = "abcdefg", k = 2
 * 输出:"cdefgab"
 *
 * 示例 2：
 * 输入: s = "lrloseumgh", k = 6
 * 输出:"umghlrlose"
 *
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 */
public class LeftRotateString {

    @Test
    public void test(){
        System.out.println(reverseLeftWords2("abcdefg",2));
        System.out.println(reverseLeftWords2("lrloseumgh",6));
    }

    /**
     * 字符串截取拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0,n);
    }

    /**
     * 字符串拼接
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords2(String s,int n){

        // 定义链表
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
        }
        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
