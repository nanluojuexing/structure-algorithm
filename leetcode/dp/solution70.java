package leetcode.dp;

/**
 * 爬楼梯 问题
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * https://leetcode-cn.com/problems/climbing-stairs/submissions/
 */
public class solution70 {
    public static void main(String[] args) {

        System.out.println(climbStairs3(10));
    }

    /**
     * 递归求解
     * @param n
     * @return
     */
    public  static int climbStairs(int n) {

        if(n < 1){
            return 0;
        }
        if(n == 1 || n==2 ){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     *  动态规划
     */
    public  static int climbStairs2(int n) {

        if(n < 1){
            return 0;
        }
        if(n == 1 || n==2 ){
            return n;
        }
        int a=1,b=2,temp=0;
        for (int i = 3; i <= n; i++) {
            temp = a+b;
            a=b;
            b= temp;
        }
        return temp;
    }

    public static int climbStairs3(int n) {
        if (n <= 1)
            return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
