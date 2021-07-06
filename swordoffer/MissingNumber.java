package swordoffer;

import org.junit.Test;

public class MissingNumber {

    @Test
    public void  test(){
        int[] nums = {0,1,3};
        int[] nums1 = {0,1,2,3,4,5,6,7,9};

        int[] nums2 ={0};
        int[] nums3 ={1};

        //System.out.println(missingNumber(nums2));
        System.out.println(missingNumber(nums3));
    }


    public int missingNumber(int[] nums) {

        if(nums==null){
            return 0;
        }
        int left =0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)>>1;
            if(nums[mid] == mid){
                left = mid+1;
            }else {
                right = mid-1;
            }
        }
        return left;
    }
}
