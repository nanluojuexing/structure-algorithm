package leetcode.recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/permutations
 */
public class solution46 {

    @Test
    public void test1(){
        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(permute(nums).toArray()));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        recall(res,nums,new ArrayList<>(),visited);
        return res;
    }

    private void recall(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited) {
        if(nums.length == temp.size()){
            res.add(new ArrayList<Integer>(temp));
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] ==1){
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            recall(res,nums,temp,visited);
            visited[i] = 0;
            temp.remove(temp.size()-1);
        }

    }

}
