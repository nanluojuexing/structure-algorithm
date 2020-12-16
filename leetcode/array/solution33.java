package leetcode.array;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，和一个整数 target 。
 *
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] ）。
 *
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 *  
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 *
 */
public class solution33 {

    @Test
    public void test1(){
        int[] arr = {0,1,2,4,5,6,7};

    }

    @Test
    public void test2(){
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
        //System.out.println(search(arr,4));
    }

    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length-1;

        while (low<=high){
            // 获得中间位置索引
            int mid = low+((high-low)>>1);
            // 如果与目标值相等，直接返回
            if(nums[mid]==target){
                return mid;
            }
            // 这里数组可能寻在旋转，如果mid位置小于最后的索引位置元素，说明数组还是升序数组
            if(nums[mid]< nums[high] ){
                if(target < nums[mid] || target > nums[high]){
                    high= mid-1;
                }else {
                    low = mid+1;
                }
            }else{
                // 如果小于 arr[mid]> arr[high] 数组被旋转
                if(target > nums[mid] || target < nums[low]){
                    low= mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
