package leetcode.recall;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1：
 *
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例2：
 *
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum
 */
public class solution39 {

    @Test
    public void test(){
        int[] candidates={2,3,6,7};
        System.out.println(Arrays.toString(combinationSum(candidates,7).toArray()));
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 数组长度
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if(length==0){
            return res;
        }
        Stack<Integer> deque = new Stack<>();
        recall(candidates,0,length,deque,target,res);
        return res;
    }

    /**
     *
     * @param candidates 目标数组
     * @param start 起点
     * @param length 数组长度
     * @param deque  用来接收遍历的数组
     * @param target 目标值
     * @param res 结果集
     */
    private void recall(int[] candidates, int start, int length, Stack<Integer> deque, int target, List<List<Integer>> res) {
        // 目标值为负数的时候，不再产生子节点
        if(target<0){
            return;
        }
        // 目标值为0的时候，说明子集的和刚好为目标值
        if(target==0){
            res.add(new ArrayList<>(deque));
            return;
        }
        for (int i = start; i < length; i++) {
            deque.push(candidates[i]);
            System.out.println("递归之前 => " + deque + "，剩余 = " + (target - candidates[i]));
            // 这里需要注意 要去除掉已经用过的元素，所以数组的起始位置需要变动向前
            recall(candidates,i,length,deque,target-candidates[i],res);
            deque.pop();
            System.out.println("递归之后 => " + deque);
        }
    }

    /**
     * 递归之前 => [2]，剩余 = 5
     * 递归之前 => [2, 2]，剩余 = 3
     *
     * 递归之前 => [2, 2, 2]，剩余 = 1
     * 递归之前 => [2, 2, 2, 2]，剩余 = -1
     * 递归之后 => [2, 2, 2]
     * 递归之前 => [2, 2, 2, 3]，剩余 = -2
     * 递归之后 => [2, 2, 2]
     * 递归之前 => [2, 2, 2, 6]，剩余 = -5
     * 递归之后 => [2, 2, 2]
     * 递归之前 => [2, 2, 2, 7]，剩余 = -6
     * 递归之后 => [2, 2, 2]
     *
     * 递归之后 => [2, 2]
     * 递归之前 => [2, 2, 3]，剩余 = 0
     *
     * 递归之后 => [2, 2]
     * 递归之前 => [2, 2, 6]，剩余 = -3
     *
     * 递归之后 => [2, 2]
     * 递归之前 => [2, 2, 7]，剩余 = -4
     *
     * 递归之后 => [2, 2]
     *
     * 递归之后 => [2]
     * 递归之前 => [2, 3]，剩余 = 2
     * 递归之前 => [2, 3, 3]，剩余 = -1
     *
     * 递归之后 => [2, 3]
     * 递归之前 => [2, 3, 6]，剩余 = -4
     *
     * 递归之后 => [2, 3]
     * 递归之前 => [2, 3, 7]，剩余 = -5
     *
     * 递归之后 => [2, 3]
     *
     * 递归之后 => [2]
     * 递归之前 => [2, 6]，剩余 = -1
     *
     * 递归之后 => [2]
     * 递归之前 => [2, 7]，剩余 = -2
     *
     * 递归之后 => [2]
     * 递归之后 => []
     *
     * 递归之前 => [3]，剩余 = 4
     * 递归之前 => [3, 3]，剩余 = 1
     * 递归之前 => [3, 3, 3]，剩余 = -2
     * 递归之后 => [3, 3]
     * 递归之前 => [3, 3, 6]，剩余 = -5
     * 递归之后 => [3, 3]
     * 递归之前 => [3, 3, 7]，剩余 = -6
     * 递归之后 => [3, 3]
     * 递归之后 => [3]
     * 递归之前 => [3, 6]，剩余 = -2
     * 递归之后 => [3]
     * 递归之前 => [3, 7]，剩余 = -3
     * 递归之后 => [3]
     * 递归之后 => []
     *
     * 递归之前 => [6]，剩余 = 1
     * 递归之前 => [6, 6]，剩余 = -5
     * 递归之后 => [6]
     * 递归之前 => [6, 7]，剩余 = -6
     * 递归之后 => [6]
     * 递归之后 => []
     * 递归之前 => [7]，剩余 = 0
     * 递归之后 => []
     * [[2, 2, 3], [7]]
     */
}
