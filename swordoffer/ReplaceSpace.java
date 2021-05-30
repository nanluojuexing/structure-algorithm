package swordoffer;

import org.junit.Test;

import java.util.Objects;

/**
 * 替换空格
 *
 *请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 示例 1：
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 *
 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
 */
public class ReplaceSpace {

    @Test
    public void test(){

        System.out.println(replaceSpace("We are happy."));
    }

    public String replaceSpace(String s) {

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            stringBuilder.append( c ==' ' ? "%20":s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
