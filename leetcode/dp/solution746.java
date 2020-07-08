package leetcode.dp;

/**
 *
 * leetcode746 使用最小花费爬楼梯
 *
 * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
 *
 * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
 *
 * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
 *
 * 示例 1:
 *
 * 输入: cost = [10, 15, 20]
 * 输出: 15
 * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
 *  示例 2:
 *
 * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出: 6
 * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
 * 注意：
 *
 * cost 的长度将会在 [2, 1000]。
 * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]
 *
 * 链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
 */
public class solution746 {

    public static void main(String[] args) {

        int[] cost = {10, 15, 20};
        int[] costs = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};

        System.out.println(minCostClimbingStairs2(cost));
        System.out.println(minCostClimbingStairs2(costs));
    }

    /**
     * 到达第i阶台阶的最小花费有两种办法
     * 1.先付出最小总花费minCost[i-1]到达第i级台阶（即第i-1级台阶的阶梯顶部），踏上第i级台阶需要再花费cost[i]，
     *  再迈一步到达第i级台阶的阶梯顶部，最小总花费为minCost[i-1] + cost[i]；
     *
     * 2. 先付出最小总花费minCost[i-2]到达第i-1级台阶（即第i-2级台阶的阶梯顶部），踏上第i-1级台阶需要再花费cost[i-1]，
     *  再迈两步跨过第i级台阶直接到达第i级台阶的阶梯顶部，最小总花费为minCost[i-2] + cost[i-1]
     *
     *  所以总的最小花费为 minCost[i] = min((minCost[i-1] + cost[i]),(minCost[i-2] + cost[i-1]))
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {

        int length = cost.length;
        // 定义备忘录
        int[] dp = new int[length];
        // 初始化值
        dp[0] = 0;
        dp[1] = Math.min(cost[0],cost[1]);
        // 推导结果
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i-1]+cost[i],dp[i-2]+cost[i-1]);
        }
        return dp[length-1];

    }

    /**
     * 解法2 状态转移方程 dp[i] = min(dp[i-1],dp[i-2])+cost[i]
     *
     * 到达第i阶楼梯的方式有两种
     * 1. 最后到达第i阶楼梯，已经花费dp[i]的力气，最后一步直接到楼梯顶
     * 2. 最后到达第i-1阶楼梯，花费了dp[i-1] 的力气，最后迈过第i阶楼梯，直接到达楼梯顶部
     *
     * 所以从第i阶楼梯到楼梯顶的最小花费为 minCost[i] = min(dp[i],dp(i-1)),所以此问题就会转化为踏上第i阶楼梯的问题
     * 对于踏上第i阶楼梯的有两种方法:
     * 1.先踏上第i-2级台阶（最小总花费dp[i-2]），再直接迈两步踏上第i级台阶（花费cost[i]），最小总花费dp[i-2] + cost[i]；
     * 2.先踏上第i-1级台阶（最小总花费dp[i-1]），再迈一步踏上第i级台阶（花费cost[i]），最小总花费dp[i-1] + cost[i]
     *
     * 初始值
     * dp[0] = cost[0]
     * dp[1]= cost[1];
     *
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs2(int[] cost) {

        int length = cost.length;
        // 定义备忘录
        int[] dp = new int[length];
        // 初始化值
        dp[0] = cost[0];
        dp[1] = cost[1];
        // 推导结果
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[length-2],dp[length-1]);

    }
}
