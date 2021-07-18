package swordoffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 */
public class FindContinuousSequence {

    @Test
    public void test(){
        System.out.println((findContinuousSequence(9)));
        System.out.println(findContinuousSequence(15));

    }

    /**
     * 滑动窗口解决问题
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {

        // 定义集合接收结果集
        List<int[]> result = new ArrayList<>();
        // 定义初始边界值
        int i = 1;
        int j = 2;
        int sum = 3;
        while( i < j ){
            if(sum == target){
                int[] nums = new int[j-i+1];
                for (int k = i; k <=j; k++) {
                    nums[k-i]=k;
                }
                result.add(nums);
            }
            if(sum >= target){
                sum -= i;
                i++;
            }
            if(sum < target){
                j++;
                sum += j;
            }
        }
        return result.toArray(new int[0][]);
    }

    /**
     * 题解：
     * 初始化： 左边界 i = 1，右边界 j = 2，元素和 s = 3 ，结果列表 res ；
     *
     * 循环： 当 i 大于等于 j 时跳出；
     *
     * 当 s > target  时： 向右移动左边界 i = i + 1 ，并更新元素和 s ；
     * 当 s < target 时： 向右移动右边界 j = j + 1  ，并更新元素和 s ；
     * 当 s = target 时： 记录连续整数序列，并向右移动左边界 i = i + 1 ；
     * 返回值： 返回结果列表 res
     *
     */
}

