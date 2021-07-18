package swordoffer;

import org.junit.Test;

public class SearchNumber {

    @Test
    public void test(){
        int[] nums = {5,7,7,8,8,10};

        System.out.println(search(nums,8));
        System.out.println(search(nums,6));
    }

    /**
     * 二分查找法
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {

        int count=0;
        int left =0;
        int right = nums.length-1;
        // 确定 目标值边界,中间值大于目标值，则不在移动
        while (left < right){
            int mid = left + (right-left)/2;
            if(nums[mid] >= target){
                right = mid;
            }else if(nums[mid] < target) {
                left = mid+1;
            }
        }
        while(left<nums.length && nums[left++]==target){
            count++;
        }
        return count;
    }

    /**
     * 题解：
     *
     *
     */
}
