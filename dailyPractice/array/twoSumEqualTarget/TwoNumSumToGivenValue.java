package dailyPractice.array.twoSumEqualTarget;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个整数数组，并且这个数组是按递增排序的，你要找到数组中的两个整数，
 * 它们的和等于给定的目标值，然后返回它们的下标。题目假设给你的数组总是有且只有一个解，而且同一个元素不能使用两次。另外，返回结果的下标要从 1 开始
 *
 * 比如说给你的数组是：
 *
 * 1, 2, 3, 6, 8, 11
 *
 * 目标值是 10。那么，满足条件的两个整数是，2 和 8，它们的和是 10。所以你要返回它们的下标是 [2, 5]。
 */
public class TwoNumSumToGivenValue {

    @Test
    public void test(){

        int[] nums = {1,2,3,6,8,11};

        System.out.println(Arrays.toString(getTwoNumSumToGivenValue(nums,10)));
    }

    /**
     * 题解：
     *  数组是递增的 ，定义前后指针，从前和从后同时取数，判断两数之和 与目标值对比
     *  如果大于目标值，就以前移动尾部指针，向前移动，取小的数
     *  如果小于目标值，就移动 头部指针，向后移动，取大的数
     *  如果相等，即返回两数的索引
     * @param nums
     * @param target
     * @return
     */
    public int[] getTwoNumSumToGivenValue(int[] nums,int target){

        int i = 0;
        int j = nums.length-1;
        while (i<j){
            if(nums[i]+nums[j] < target){
                i++;
            }else if(nums[i]+nums[j] > target){
                j--;
            }else {
                return new int[]{i,j};
            }
        }
        return new int[]{-1,-1};
    }
}
