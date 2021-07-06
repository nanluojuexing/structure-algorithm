package swordoffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 和为s的两个数
 *
 * 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[2,7] 或者 [7,2]
 * 示例 2：
 *
 * 输入：nums = [10,26,30,31,47,60], target = 40
 * 输出：[10,30] 或者 [30,10]
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
 */
public class TwoSum {

    @Test
    public void test(){
        int[] nums1 = {2,7,11,15};
        int[] nums2 = {10,26,30,31,47,60};
        int[] nums3 = new int[0];

        System.out.println(Arrays.toString(twoSum2(nums1,9)));
        System.out.println(Arrays.toString(twoSum2(nums2,40)));
        System.out.println(Arrays.toString(twoSum2(nums3,40)));

    }

    /**
     * 循环遍历
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        if(nums == null || nums.length ==0){
            return new int[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{nums[i],nums[j]};
                }
            }
        }
        return new int[0];
    }

    /**
     * 双指针移动
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        int i =0;
        int j = nums.length-1;
        while (i<j){
            int temp = nums[i]+nums[j];
            if(temp == target){
                return new int[]{nums[i],nums[j]};
            }else if(temp < target ){
                i++;
            }else {
                j--;
            }
        }
        return new int[0];
    }
}
