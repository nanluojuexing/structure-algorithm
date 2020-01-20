package leetcode;

/**
 * 最长上升序列 动态规划
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
