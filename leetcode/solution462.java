package leetcode;

import java.util.Arrays;

/**
 * @Author: mianba
 * @Date: 2019-08-01 15:03
 * @Description: 最少移动次数使数组元素相等 II
 */
public class solution462 {


    public static void main(String[] args) {
        int[] nums = {1,2,4,5,8,10};
        System.out.println(minMoves2(nums));
    }

    public static int minMoves2(int[] nums) {
        // 数组排序
        Arrays.sort(nums);
        int i =0,j =nums.length-1;
        int count=0;
        while(i<j){
            count += nums[j--] - nums[i++];
        }
        return count;
    }
    /***** 解析思路
     *  本质上就是求中间数和其他元素的差值
     *      所以对于数组先进性排序
     *      然后统计两个边数的差值
     * *****/
}
