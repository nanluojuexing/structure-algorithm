package leetcode.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组和一个目标值，你要找到数组里两个整数， 它们的和等于目标值。然后返回这两个整数的下标
 *
 * 比如说给你的整数数组是：
 *
 * 1, 2, 3, 6, 8, 11
 *
 * 目标值是 10。那么，满足条件的两个整数是，2 和 8，它们的和是 10。所以你要返回它们的下标是 1 和 4
 */
public class TwoNumSumToTarget_1 {

    @Test
    public void test1(){

        int[] nums = {1,2,3,6,8,11};
        System.out.println(Arrays.toString(getTwoNumSumToTargetByBruteForce(nums,10)));
    }

    @Test
    public void test2(){
        int[] nums = {1,2,3,6,8,11};
        System.out.println(Arrays.toString(getTwoNumSumToTargetByHashMap(nums,10)));
    }

    /**
     * 暴力递归解法:
     * 外循环遍历，内循环一次遍历，每次相加两个数，对比目标值，如果相等，返回内外循环的索引位置
     * @param nums
     * @param target
     * @return
     */
    public int[] getTwoNumSumToTargetByBruteForce(int[] nums,int target){

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]+nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 采用hash表处理
     *
     * hash表的key是具体的元素值，value是索引
     *
     * 循环一次遍历，用目标值减去当前值，如果不存在则添加到hash表，如果存在，直接返回索引位置
     * @param nums
     * @param target
     * @return
     */
    public int[] getTwoNumSumToTargetByHashMap(int[] nums,int target){
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //用目标值减去当前元素值，在判断是否存在hash表中
            int needNum = target- nums[i];
            if(hashMap.containsKey(needNum)){
                return new int[]{hashMap.get(needNum),i};
            }
            // 这里用值做key,索引为value
            hashMap.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
