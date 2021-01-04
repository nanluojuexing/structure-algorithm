package dailyPractice.dp;

/**
 * 按摩师
 *
 * 一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。
 * 在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。
 * 给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 * 示例 2：
 *
 * 输入： [2,7,9,3,1]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约和 5 号预约，总时长 = 2 + 9 + 1 = 12。
 * 示例 3：
 *
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12
 * 解释： 选择 1 号预约、 3 号预约、 5 号预约和 8 号预约，总时长 = 2 + 4 + 3 + 3 = 12
 */
public class messager {

    public static void main(String[] args) {

        int[] nums = {1,2,3,1};
        int[] nums2 = {2,7,9,3,1};
        int[] nums3 = {2,1,4,5,3,1,1,3};

        System.out.println(massage(nums));
        System.out.println(massage(nums2));
        System.out.println(massage(nums3));
    }

    /**
     * 不限定下标为 i 这一天是否接受预约，因此需要分类讨论：
     *
     * 接受预约，那么昨天就一定休息，由于状态 dp[i - 1] 的定义涵盖了下标为 i - 1 这一天接收预约的情况，状态只能从下标为 i - 2 的状态转移而来：dp[i - 2] + nums[i]；
     *
     * 不接受预约，那么昨天可以休息，也可以不休息，状态从下标为 i - 1 的状态转移而来：dp[i - 1]；
     * 二者取最大值，因此状态转移方程为 dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
     *
     * @param nums
     * @return
     */
    public static int massage(int[] nums) {
        int n = nums.length;
        
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return nums[0];
        }
        // dp[i]：区间 [0, i] 里接受预约请求的最大时长
        int[] dp = new int[n];
        
        dp[0]= nums[0];
        dp[1] = Math.max(nums[1],dp[0]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];

    }
}
