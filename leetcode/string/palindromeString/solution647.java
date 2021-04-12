package leetcode.string.palindromeString;

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
        System.out.println(countSubstrings(b));
        System.out.println(countPalindromicSubstringsDP(b));
    }

    /**
     * 暴力解法
     * @param s
     * @return
     */
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

    /**
     * 动态规划
     */
    public static int countPalindromicSubstringsDP(String s){
        // 校验参数
        if(s == null || s.length() == 0){
            return 0;
        }

        int n = s.length(),count = 0;
        // 定义二维数组记录字符串状态
        boolean[][] d = new boolean[n][n];

        for (int i = n-1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                // 当 i = j 时，只有一个字符，肯定为回文字符串
                if( i == j ){
                    d[i][j] = true;
                    // 当 i+1 = j 是为两个字符，如果两个字符相等，则为回文字符串
                }else if ( i+1 == j){
                    d[i][j] = s.charAt(i)==s.charAt(j);
                }else{ // 当不相邻的时候，需要处理中间字串是否为回文字串
                    d[i][j] = s.charAt(i) == s.charAt(j) && d[i+1][j-1];
                }
                // 统计回文字符串个数
                if(d[i][j]){
                    count++;
                }
            }
        }

      return count;
    }
}
