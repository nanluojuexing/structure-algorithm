package leetcode.dp;

/**
 * 判断子序列
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 * 后续挑战 :
 *
 * 如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 *
 * 链接：https://leetcode-cn.com/problems/is-subsequence
 *
 */
public class solution392 {

    public static void main(String[] args) {

        System.out.println(isSubsequence2("abc","ahbgdc"));
//        System.out.println(isSubsequence2("acb","ahbgdc"));
//        System.out.println(isSubsequence2("axc","ahbgdc"));

    }


    /**
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence(String s, String t) {
        char[] chars = s.toCharArray();

        int j = -1;
        for (int i = 0; i < chars.length ; i++) {

            j = t.indexOf(chars[i], j + 1);
            if(j ==-1){
                return false;
            }
        }
        return true;
    }

    /**
     * 动态规划解法
     *
     * 状态：dp[i][j]为s的从头开始到i的子字符串是否为t从头开始到j的子字符串的子序列
     *
     * 状态转移公式：
     *
     * 当char[i]==char[j]时，则字符i一定是j的子序列，如果0~i-1子字符串是0~j-1子字符串的子序列，则dp[i][j]=true，所以dp[i][j] = dp[i-1][j-1]；
     * 当char[i]!=char[i]时，即判断当前0~i子字符串是否是0~j-1的子字符串的子序列，即dp[i][j] = dp[i][j - 1]
     * 如ab，eabc，虽然s的最后一个字符和t中最后一个字符不相等，但是因为ab是eab的子序列，所以ab也是eabc的子序列
     * 初始化：空字符串一定是t的子字符串的子序列，所以dp[0][j]=true
     *
     *
     * @param s
     * @param t
     * @return
     */
    public static boolean isSubsequence2(String s, String t) {

        int sn = s.length();
        int tn = t.length();
        // 定义备忘录
        boolean[][] dp = new boolean[sn+1][tn+1];
        // 初始化
        dp[0][0] = true;
        for (int i = 0; i < dp[0].length ; i++) {
            dp[0][i] = true;
        }
        // 推导结果
        for (int i = 1; i <= sn ; i++) {
            for (int j = 1; j <= tn ; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j]=dp[i][j-1];

                }
            }
        }
        return dp[sn][tn];
    }

}
