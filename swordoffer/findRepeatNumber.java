package swordoffer;

import org.junit.Test;

public class findRepeatNumber {

    @Test
    public void test(){
        int[] nums = {2,3,1,0,2,5,3};
        System.out.println(findRepeatNumber(nums));
    }

    /**
     * 创建数组
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            if(arr[nums[i]] > 1){
                return nums[i];
            }
        }
        return -1;
    }
}
