package leetcode.array.prefixAnd;

/**
 * 区域和检索 - 数组不可变
 *  解法3 前缀和
 */
public class NumArray_303_3 {

    private int[] preSum;

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray_303_3 array303 = new NumArray_303_3(nums);
        System.out.println(array303.sumRange(0,2));
    }

    /**
     *
     * @param nums
     */
    public NumArray_303_3(int[] nums) {

        int n = nums.length;
        // 定义结合处理数组的和 备忘录
        preSum= new int[n + 1];
        // 处理临界值
        preSum[0]= 0;

        // 推导结果
        for (int i = 0; i < n ; i++) {
            preSum[i+1] = preSum[i] + nums[i];
        }

    }

    /**
     * 计算结果
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return preSum[j+1]-preSum[i];
    }

}
