package leetcode;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12
 *
 * 链接：https://leetcode-cn.com/problems/house-robber
 */
public class solution198 {

    public static void main(String[] args) {

        int[] nums ={1,2,3,1};
        int[] nums2 ={2,7,9,3,1};

        System.out.println(rob(nums));
        System.out.println(rob(nums2));
    }

    public static int rob(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
        int length = nums.length;
        if( length ==1 ){
            return nums[0];
        }

        // 定义备忘录
        int[] dp = new int[length];
        // 处理临界值
        dp[0] = nums[0];
        // 如果只有两间房子的时候应该去金额最大的那个
        dp[1] = Math.max(nums[0],nums[1]);
        // 推导出结果
        // 获取 k个房子的最大金额，且不能相邻房间，那就是在第 k-2个 和最后一个获取到最大金额 ，或者在k-1个获取到最大金额
        // 对应的公式 dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1])
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[length-1];

    }
}
