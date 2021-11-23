package leetcode.recall;

import org.junit.Test;

import java.util.*;

/**
 * 回溯算法
 *
 * 全排列
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 *
 */
public class solution47 {


    @Test
    public void test(){
        int[] nums={1,1,2};
        int[] nums2 = {1,2,3};
        int[] nums3 = {3,3,3,0};
        System.out.println(Arrays.toString(permuteUnique2(nums).toArray()));
        System.out.println(Arrays.toString(permuteUnique2(nums2).toArray()));
        System.out.println(Arrays.toString(permuteUnique2(nums3).toArray()));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==0){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permuteUniqueHelper(result,list,nums,0,visited);
        return result;
    }

    /**
     *
     * @param result
     * @param list
     * @param start
     */
    private void permuteUniqueHelper(List<List<Integer>> result, List<Integer> list, int[] nums,int start,boolean[] visited) {
        if(start == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || (i>0 && nums[i] == nums[i-1 ] && !visited[i-1])){
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            permuteUniqueHelper(result,list,nums,start+1,visited);
            visited[i] = false;
            list.remove(start);
        }
    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length ==0){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        permuteUniqueHelper2(result,list,0);
        return result;
    }

    /**
     *
     * @param result
     * @param list
     * @param start
     */
    private void permuteUniqueHelper2(List<List<Integer>> result, List<Integer> list,int start) {
        if(start == list.size()){
            result.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> set = new HashSet();
        for (int i = start; i < list.size(); i++) {

            if(set.add(list.get(i))){
                Collections.swap(list,i,start);
                permuteUniqueHelper2(result,list,start+1);
                Collections.swap(list,i,start);
            }
        }
    }


}
