package swordoffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 数组中出现超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 */
public class MajorityElement {

    @Test
    public void test(){

        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums1 = {2,2,1,1,1,2,2};

        //System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums1));
    }


    public int majorityElement(int[] nums) {
        // 定义map存储元素和元素数量
        Map<Object, Integer> numMap = new HashMap<>();
        // 数组长度
        int n = nums.length;
        // 遍历数组统计
        for (int i = 0; i < nums.length; i++) {
            int num = numMap.getOrDefault(nums[i],0)+1;
            numMap.put(nums[i], num);

            if(num > n>>1){
                return nums[i];
            }

        }
        return 0;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length>>1];
    }

}
