package leetcode.palindromeString;

/**
 * 回文子串
 *
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class solution647 {

    public static void main(String[] args) {

        //String a ="abc";
        //System.out.println(countSubstrings(a));
        String b ="aaa";
        System.out.println(countSubstrings2(b));
    }

    public static int countSubstrings(String s){
        //字符串长度
        int n = s.length();
        //统计数量
        int count = 0;
        for (int i = 0; i < n ; i++) {
            for (int j = i; j < n ; j++) {
                boolean flag = true;
                int a =i;
                int b =j;
                while(a <= b){
                    if(s.charAt(a++) != s.charAt(b--)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * 解题思路：暴力破解
     *  循环遍历，统计，判断单个字符结果
     *
     *
     */


    /**
     *  解法2 中心扩展法
     */
    public static int countSubstrings2(String s){
        int result =0;
        for (int i = 0; i < s.length(); i++) {
            result += countSegment(s,i,i);
            result += countSegment(s,i,i+1);
        }
        return  result;
    }

    public static int countSegment(String s,int start,int end){
        int count = 0;
        while(start>=0 && end<s.length() && s.charAt(start--) == s.charAt(end++)){
            count++;
        }
        return  count;
    }
}
