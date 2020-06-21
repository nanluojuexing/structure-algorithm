package algorithm.dailyPractice;

import java.util.Arrays;

/**
 * 两个字符串匹配删除
 *
 * 输入两个字符串，从第一字符串中删除第二个字符串中所有的字符
 *
 * 输入:  str=”They are students”，sub=”aeiou"
 * 输出: ”Thy r stdnts"
 */
public class two_string_remove {

    public static void main(String[] args) {
        int[] arr = {'a','b'};
        System.out.println(Arrays.toString(arr));

        System.out.println(removeString("They are students","aeiou"));
    }

    /**
     *
     * @param str1 目标字符串
     * @param str2 匹配字符串
     * @return
     */
    public static String removeString(String str1,String str2){

        int[] temp = new int[256];
        for (int i = 0; i < str2.length(); i++) {
            System.out.println(str2.charAt(i));
            temp[str2.charAt(i)]++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            if(temp[str1.charAt(i)] == 0){
                ans.append(str1.charAt(i));
            }
        }
        return ans.toString();
    }
}
