package swordoffer;

import org.junit.Test;

/**
 * 存照二位数中的目标元素
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 */
public class FindNumberIn2DArray {


    @Test
    public void test(){

        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        //int[][] nums = {{-1,3}};

        System.out.println(findNumberIn2DArray2(nums,3));
    }


    /**
     * 循环遍历  时间复杂度 O(n*n)
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        // 遍历目标数组
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * 双指针优化 时间复杂度 O(m+n) 利用二维数组中 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序特性
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        // 处理临界值
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length==0){
            return false;
        }
        // 获取数组中长度
        int m = matrix.length;
        // matrix[0] 长度
        int n = matrix[0].length;
        // 定义 i 表示行数，j 表示列数
        int i =0,j = n-1;
        // 遍历寻找,第一个数组中的最大值与目标值对比，1 如果比目标值大，则在该数组中向前移动，列变更 j--;
        // 2如果比目标值小，则j不动，将横坐标向下移动 i++;
        // 此时 如果matrix[i][j] 大于数组，继续1，否则继续2
        // 如果相等，则返回true
        while(i < m && j >=0){
            if(matrix[i][j] > target){
                j--;
            }else if(matrix[i][j] < target){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }

}
