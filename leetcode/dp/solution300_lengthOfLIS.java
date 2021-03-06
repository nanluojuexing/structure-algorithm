package leetcode.dp;

/**
 * 最长上升序列 ** 动态规划
 *
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 *
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 */
public class solution300_lengthOfLIS {

    public static void main(String[] args) {

        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS2(nums));
    }

    /**
     * 不能处理 -- 负数数组
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        // 判断数组长度
        if(nums.length < 2){
            return nums.length;
        }
        // 定义数组记录状态
        int[] stat = new int[nums.length];
        // 初始化状态
        stat[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            int max =0;
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    // 如果当前值大于0
                    if(nums[j] > max){
                        max = stat[j];
                    }
                }
            }
            stat[i] = max+1;
        }

        int result =0;
        for (int i = 0; i < stat.length; i++) {
            if (stat[i] > result)
                result = stat[i];
        }
        return result;
    }

    public static int lengthOfLIS2(int[] nums) {
        // 判断数组长度
        if(nums.length < 2){
            return nums.length;
        }
        // 定义数组记录状态
        int[] stat = new int[nums.length];
        // 初始化状态
        stat[0] = 1;
        // 定义接受长度的值
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            int maxval =0;
            /**
             * 查看以前的序列，比他小的可以形成序列
             */
            for (int j = 0; j < i; j++) {
                if(nums[j]<nums[i]){
                    maxval = Math.max(maxval,stat[j]);
                }
            }
            stat[i] = maxval+1;
            System.out.println(stat[i]);
            max= Math.max(max,stat[i]);
        }
        return max;
    }
}
