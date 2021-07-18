package swordoffer;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 *
 * 示例1:
 *
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例2:
 *
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 * 链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 */
public class IsStraight {

    @Test
    public void test(){

        int[] nums={1,2,3,4,5};
        System.out.println(isStraight(nums));
        int[] nums2={0,0,3,4,5};
        System.out.println(isStraight(nums2));

        int[] nums3={1,9,3,4,5};
        System.out.println(isStraight(nums3));
    }

    /**
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {

        // 定义set集合存储元素
        Set<Integer> repeats = new HashSet<>();
        // 设置最小值，最大值 需要注意符合题意即扑克牌
        int min = 14;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            // 取最大值和最小值
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
            if(repeats.contains(nums[i])){
                return false;
            }
            repeats.add(nums[i]);
        }
        return max-min < 5;
    }
}
