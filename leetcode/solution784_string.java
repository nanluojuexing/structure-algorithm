package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mianba
 * @Date: 2019/12/19 17:07
 * @Description: 给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合
 *
 * 示例:
 * 输入: S = "a1b2"
 * 输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
 *
 * 输入: S = "3z4"
 * 输出: ["3z4", "3Z4"]
 *
 * 输入: S = "12345"
 * 输出: ["12345"]
 */
public class solution784_string {

    public static void main(String[] args) {
        String s = "a1b2";
        List<String> strings = letterCasePermutation(s);

        for (String string : strings) {
            System.out.println(string);
        }
    }

    /**
     * @param s
     * @return
     */
    public static List<String> letterCasePermutation(String s) {

        List<StringBuilder> list1 = new ArrayList<>();
        list1.add(new StringBuilder());
        // 遍历字符串
        for (char c : s.toCharArray()) {
            int n = list1.size();
            //这里判断是不是字母
            if(Character.isLetter(c)){
                for (int i = 0; i < n; ++i) {
                    list1.add(new StringBuilder(list1.get(i)));
                    list1.get(i).append(Character.toLowerCase(c));
                    list1.get(n+i).append(Character.toUpperCase(c));
                }
            }else{
                for (int i = 0; i < n; ++i) {
                    list1.get(i).append(c);
                }
            }
        }

        List<String> finalans = new ArrayList();
        for (StringBuilder sb: list1) {
            finalans.add(sb.toString());
        }
        return finalans;

    }
    /**
     *  题解：
     *  当 S = "abc" 时，考虑字母 "a", "b", "c"，初始令 ans = [""]，依次更新 ans = ["a", "A"]， ans = ["ab", "Ab", "aB", "AB"]， ans = ["abc", "Abc", "aBc", "ABc", "abC", "AbC", "aBC", "ABC"]
     *
     *  如果下一个字符 c 是字母，将当前已遍历过的字符串全排列复制两份，在第一份的每个字符串末尾添加 lowercase(c)，在第二份的每个字符串末尾添加 uppercase(c)。
     *
     *  如果下一个字符 c 是数字，将 c 直接添加到每个字符串的末尾
     *
     */
}
