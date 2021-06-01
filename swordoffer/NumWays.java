package swordoffer;

import org.junit.Test;

/**
 * 爬楼梯问题 解法可动态规划和递归
 *
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 *
 * 输入：n = 0
 * 输出：1
 * 提示：
 *
 * 0 <= n <= 100
 *
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 */
public class NumWays {

    @Test
    public void test(){

        System.out.println(numWays(2));
        System.out.println(numWays(7));
        System.out.println(numWays(0));
    }

    public int numWays(int n) {
        if(n==0 || n ==1){
            return 1;
        }
        // 定义数组
        int[] nums = new int[n+1];
        nums[0] = 1;
        // 台阶为1阶就只有一种跳法
        nums[1] = 1;
        // 两阶台阶，就可以一次跳2个台阶；或者跳两次，每次跳一个台阶
        nums[2] = 2;
        // 状态方程 dp[i] = dp[i-2]+dp[i-1]
        // 从结尾开始往回计算，跳到最后一阶，可能会需要两部，也可能之需要一步，所以回推方程式
        for (int i = 3; i <= n; i++) {
            nums[i]=(nums[i-1]+nums[i-2])%1000000007;
        }
        return nums[n];
    }
}
