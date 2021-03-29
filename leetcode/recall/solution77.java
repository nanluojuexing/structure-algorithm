package leetcode.recall;

import org.junit.Test;

import java.util.*;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class solution77 {

    @Test
    public void test1(){
        System.out.println(Arrays.toString(combine(4,2).toArray()));
    }

    public List<List<Integer>> combine(int n, int k) {
        // 获取需要遍历的数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }
        // 定义接收的集合
        List<List<Integer>> result = new ArrayList<>();
        if(k==0){
            return result;
        }
        Deque<Integer> res = new ArrayDeque<>();
        recall(0,nums,k,result,res);
        return result;
    }

    /**
     *
     * @param start
     * @param nums
     * @param k
     * @param result
     * @param res
     */
    private void recall(int start, int[] nums , int k, List<List<Integer>> result, Deque<Integer> res) {
        if(res.size() == k){
            result.add(new ArrayList<>(res));
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            //加入当前的数组
            res.addLast(nums[i]);
            System.out.println("递归之前 => " + res);
            recall(i+1,nums,k,result,res);
            res.removeLast();
            System.out.println("递归之后 => " + res);
        }
    }


}
