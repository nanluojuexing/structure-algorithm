package leetcode.array;

/**
 * 区域和检索 - 数组不可变
 *
 * 解法 2
 */
public class NumArray_303_2 {

    /**
     * 记录结果
     */
    private int[][] result;

    public static void main(String[] args) {

        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray_303_2 array303 = new NumArray_303_2(nums);
        System.out.println(array303.sumRange(0,2));
    }



    /**
     * 预处理阶段
     *
     * 预处理阶段将所有可能存在的结果，全部穷举计算处理，存储在对应的二维数组，增加空间使用，减少计算复杂度
     *
     *
     * @param nums
     */
    public NumArray_303_2(int[] nums) {
        // 获取数组长度
        int n = nums.length;
        // 定义备忘录存储计算的数据
        result = new int[n][n];

        // 推导结果
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                result[i][j] = sum;
            }
        }
    }

    /**
     * 获取计算结果
     * @param i
     * @param j
     * @return
     */
    public int sumRange(int i, int j) {
        return result[i][j];
    }
}
