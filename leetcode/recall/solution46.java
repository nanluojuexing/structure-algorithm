package leetcode.recall;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        // 标记位置
        int[] visited = new int[nums.length];
        recall(res,nums,new ArrayList<>(),visited);
        return res;
    }

    /**
     * 递归存储元素
     * @param res 存储所有最终的结果集
     * @param nums 数组
     * @param temp 存储一组排列
     * @param visited 标记是否处理过
     */
    private void recall(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int[] visited) {
        // 终止条件，当数组长度等于临时数组长度，说明所有元素已遍历
        if(nums.length == temp.size()){
            res.add(new ArrayList<>(temp));
            return ;
        }
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 如果元素已存储，则跳过
            if(visited[i] ==1){
                continue;
            }
            // 标记该未知的元素的为已使用
            visited[i] = 1;
            // 元素加入数组中
            temp.add(nums[i]);
            // 递归遍历
            recall(res,nums,temp,visited);
            // 处理完后，标记为改为0
            visited[i] = 0;
            temp.remove(temp.size()-1);
        }
    }

    /**
     * 解法2
     * @param nums
     * @return
     */
    public List<List<Integer>>  permute2(int[] nums){
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        // 存储最终的结果
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int num : nums) {
            list.add(num);
        }
        permuteRec(list,0,res);
        return res;
    }

    /**
     *
     * @param nums
     * @param start
     * @param res
     */
    private void permuteRec(List<Integer> nums, int start, List<List<Integer>> res) {
        if(start == nums.size()){
            res.add(new ArrayList<>(nums));
        }else {
            for (int j = start; j < nums.size(); j++) {
                Collections.swap(nums,j,start);
                permuteRec(nums,j+1,res);
                Collections.swap(nums,j,start);
            }
        }
    }


}
