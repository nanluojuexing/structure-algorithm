package leetcode.array.prefixAnd;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 和为K的子数组
 *
 *
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]
 *
 * 链接：https://leetcode-cn.com/problems/subarray-sum-equals-k
 */
public class solution560 {

    public static void main(String[] args) {
        int[] nums ={1,1,1};
        System.out.println(subarraySum2(nums,2));
    }

    /**
     * 计算数组中的和为k的连续数组个数
     * 可以先求出全部数组前缀后，穷举出所有可能
     *
     * 假设连续的数组的为 i～j,针对数组的前缀和其实就是如下的公式
     * sum(i,j) = sum(0,j) - sum(0,i)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {
        int n = nums.length;
        // 定义数组接受数组的前缀和
        int[] preSums = new int[n+1];
        //定义数组和
        int sum =0;
        for (int i = 0; i < n; i++) {
            preSums[i] = sum;
            sum += nums[i];
        }
        // 标记最终的全部和
        preSums[n]= sum;
        int count =0;
        for (int i = 0; i <= n ; i++) {

            for (int j = i+1; j <= n; j++) {
                if(preSums[j]-preSums[i] == k){
                    count++;
                }
            }

        }
        return count;
    }

    /**
     * 减少循环遍历此时，提高时间复杂度 ，优化为 O(n)
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum2(int[] nums, int k) {
        // 前缀和 -> 该前缀和（的值）出现的次数
        Map<Integer, Integer> presum = new HashMap<>();
        // base case，前缀和 0 出现 1 次
        presum.put(0, 1);

        int sum = 0; // 前缀和
        int res = 0;
        for (int n : nums) {
            sum += n; // 计算前缀和
            // 查找有多少个 sum[i] 等于 sum[j] - k
            if (presum.containsKey(sum - k)) {
                res += presum.get(sum - k);
            }
            // 更新 sum[j] 的个数
            if (presum.containsKey(sum)) {
                presum.put(sum, presum.get(sum) + 1);
            } else {
                presum.put(sum, 1);
            }
        }
        return res;
    }
}
