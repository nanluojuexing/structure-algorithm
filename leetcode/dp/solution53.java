package leetcode.dp;

/**
 * 最大子序和
 *
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
 *
 */
public class solution53 {

    public static void main(String[] args) {

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArray2(nums));
    }

    public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0 ){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans,sum);
        }
        return ans;
    }

    /**
     *
     * 创建dp数组
     * 初始化值: dp[0] = nums[0]
     * 每次遍历判断dp[i-1]是否大于0
     * 如果大于0, 则用dp[i-1] + nums[i]
     * 如果小于0,则直接使用nums[i]
     * 每次都记录max值
     * 最后返回max
     *
     * @param nums
     * @return
     */
    public static int maxSubArray2(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        // 记录数组和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1] >0){
                dp[i] = dp[i-1] + nums[i];
            }else {
                dp[i] = nums[i];
            }
            max = Math.max(max,dp[i]);
        }

        return max;
    }
}
