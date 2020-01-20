package leetcode;

import java.util.List;

/**
 * @Author: mianba
 * @Date: 2019-08-19 16:42
 * @Description: 三角形的最短路径 动态规划 每一步只能移动到下一行的相邻的节点
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 */
public class solution120 {

    public static void main(String[] args) {

    }

    public static int minimumTotal(List<List<Integer>> triangle){
        int[] result = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i >=0  ; i--) {
            for (int j = 0; j < triangle.get(i).size() ; j++) {
                result[j] = Math.max(result[j],result[j+1])+ triangle.get(i).get(j);
            }
        }
        return result[0];
    }

    /**
     * 题解：
     *
     *
     *
     */
}
