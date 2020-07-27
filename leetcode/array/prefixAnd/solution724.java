package leetcode.array.prefixAnd;

/**
 *
 * 寻找数组的中心索引
 *
 *
 * 给定一个整数类型的数组 nums，请编写一个能够返回数组 “中心索引” 的方法。
 *
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 索引 3 (nums[3] = 6) 的左侧数之和 (1 + 7 + 3 = 11)，与右侧数之和 (5 + 6 = 11) 相等。
 * 同时, 3 也是第一个符合要求的中心索引。
 * 示例 2：
 *
 * 输入：
 * nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心索引
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-pivot-index
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class solution724 {

    public static void main(String[] args) {

        int[] nums= {1, 7, 3, 6, 5, 6};
        int[] nums2= {1, 2, 3};

        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex(nums2));
    }

    /**
     * 根据前缀和的方式解处
     * 对于x元素，假设x元素左边的和为为A ，右侧的元素和为B，那么x元素满足的条件就是 A=B
     *
     * x右侧元素 之和可以更具A直接求出来，假设数组的元素和为 S  则 B 可以表示为 S-A-x
     *  枢纽元素需要满足 A=B ，所以可以得到  A=B=S-A-x
     *   可以推导出  2A +x = S,所以如果满足上述关系，就是枢纽元素
     *
     * @param nums
     * @return
     */

    public static int pivotIndex(int[] nums) {
        int S  = 0;
        for (int num : nums) {
            S+=num;
        }
        // 定义前缀和 A
        int A =0;
        for (int i = 0; i < nums.length; i++) {
            // 获得当前元素
            int x = nums[i];
            // 判断前缀和是否符合条件
            if( 2*A+x == S ){
                return  i;
            }
            A+=x;
        }
        return -1;
    }
}
