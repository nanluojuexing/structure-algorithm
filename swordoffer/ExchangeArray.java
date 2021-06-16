package swordoffer;

import org.junit.Test;

import java.util.Arrays;

/**
 * 奇数交换
 */
public class ExchangeArray {

    @Test
    public void test(){
        int[] nums = {1,2,3,4};

        System.out.println(Arrays.toString(exchange(nums)));
    }

    /**
     * 双指针遍历法
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        //定义起点和结束点位置
        int i =0;
        int j = nums.length-1;
        while(i<j){
            // 处理奇数 记录坐标位
            while(i<j && nums[i]%2 ==1 ){
                i++;
            }
            // 处理偶数，记录坐标位
            while(i<j && nums[j]%2 ==0 ){
                j--;
            }
            // 奇偶数交换位置
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}
