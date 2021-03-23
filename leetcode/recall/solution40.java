package leetcode.recall;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例1:
 *
 * 输入: candidates =[10,1,2,7,6,1,5], target =8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例2:
 *
 * 输入: candidates =[2,5,2,1,2], target =5,
 * 所求解集为:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class solution40 {


    @Test
    public void test(){
        int[] candidates={2,5,2,1,2};
        List<List<Integer>> lists = combinationSum2(candidates, 5);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    @Test
    public void test2(){
        int[] candidates={10,1,2,7,6,1,5};
        List<List<Integer>> lists = combinationSum2(candidates, 8);
        System.out.println(Arrays.toString(lists.toArray()));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 数组长度
        int length = candidates.length;
        List<List<Integer>> res = new ArrayList<>();

        if(length==0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        recall(candidates,0,length,path,target,res);
        return res;
    }

    /**
     *
     * @param candidates 目标数组
     * @param start 起点
     * @param length 数组长度
     * @param path  用来接收遍历的数组
     * @param target 目标值
     * @param res 结果集
     */
    private void recall(int[] candidates, int start, int length, Deque<Integer> path, int target, List<List<Integer>> res) {
        // 目标值为0的时候，说明子集的和刚好为目标值
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < length; i++) {

            // 进行减枝操作
            if(target-candidates[i]<0){
                break;
            }
            // 处理相同层级，出现重复元素的
            if(i > start && candidates[i]==candidates[i-1]){
                continue;
            }

            path.addLast(candidates[i]);
            System.out.println("递归之前 => " + path + "，剩余 = " + (target - candidates[i]));
            // 这里需要注意 要去除掉已经用过的元素，所以数组的起始位置需要变动向前,数组已经排序，要保证数组中元素的唯一 ，所以 i+1
            recall(candidates,i+1,length,path,target-candidates[i],res);
            path.removeLast();
            System.out.println("递归之后 => " + path);
        }
    }
}
