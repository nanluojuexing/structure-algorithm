package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组的集合，返回该数组所有可能的子集
 */
public class solution78 {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(subsets(nums).toString());
    }

    public static List<List<Integer>> subsets(int[] nums){

        //定义接受的集合
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length==0){
           return result;
        }
        List<Integer> receive = new ArrayList<>();
        // 0 表示起始位置
        subsets(0,nums,result,receive);
        return result;
    }

    public static void subsets(int start,int[] nums ,List<List<Integer>> result,List<Integer> recieve){
        // 这里添加到集合中
        result.add(new ArrayList<>(recieve));
        for (int i = start; i < nums.length; i++) {
            //加入当前的数组
            recieve.add(nums[i]);
            subsets(i+1,nums,result,recieve);
            //这里必须移除
            recieve.remove(recieve.size()-1);
        }
    }






}
