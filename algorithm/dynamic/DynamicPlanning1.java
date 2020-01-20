package algorithm.dynamic;

import java.util.Scanner;

/**
 * @Author: mianba
 * @Date: 2019-08-19 16:15
 * @Description: 动态规划  三角形的最大路径问题
 */
public class DynamicPlanning1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        long max = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = scan.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                int num = scan.nextInt();
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + num;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + num;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
        /********     ***********/
        System.out.println(test());
    }


    public static int test() {
        int[][] dp ={{5},{8,4},{3,6,9},{7,2,9,5}};
        int[] result = new int[dp.length+1];
        for (int i = dp.length-1; i >=0  ; i--) {
            for (int j = 0; j < dp[i].length ; j++) {
                result[j] = Math.max(result[j],result[j+1])+ dp[i][j];
            }
        }
        return result[0];
    }


    /**
     * 题解思路：
     *
     *
     */

}
