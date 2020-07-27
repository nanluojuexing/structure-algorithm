package leetcode.array.prefixAnd;

/**
 *
 * 区域和检索 - 数组不可变
 *
 *  前缀和解法
 *
 *
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * 示例：
 *
 * 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * 说明:
 *
 * 你可以假设数组不可变。
 * 会多次调用 sumRange 方法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-immutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
