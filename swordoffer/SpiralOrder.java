package swordoffer;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 * 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/
 *
 * 链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 */
public class SpiralOrder {

    @Test
    public void test(){
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        System.out.println(Arrays.toString(spiralOrder(matrix).toArray()));
        System.out.println(Arrays.toString(spiralOrder2(matrix)));
    }


    public List<Integer> spiralOrder(int[][] matrix) {

        // 定义集合存储结果集
        List<Integer> result = new LinkedList<>();
        if(matrix == null || matrix[0].length == 0){
            return result;
        }
        // 定义初始的高和实际高
        int top =0;
        int height = matrix.length-1;

        // 矩阵初始长为 right width
        int right = 0;
        int width = matrix[0].length-1;
        // 集合长度
        int num = matrix.length * matrix[0].length;
        // 依次遍历
        while(num >= 1){
            // 从左往右走
            for (int i = right; i <= width && num >= 1 ; i++) {
                result.add(matrix[top][i]);
                num--;
            }
            // 第一层遍历完height +1
            top++;
            // 最左侧从上往下走
            for (int i = top; i <= height && num >= 1 ; i++) {
                result.add(matrix[i][width]);
                num--;
            }
            // 从右往左走
            width--;
            for (int i = width; i >= right && num >= 1 ; i--) {
                result.add(matrix[height][i]);
                num--;
            }
            height--;
            // 从下往上走
            for (int i = height; i >= top && num >= 1 ; i--) {
                result.add(matrix[i][right]);
                num--;
            }
            right++;
        }
        return result;
    }

    public int[] spiralOrder2(int[][] matrix) {

        // 定义集合存储结果集
        if( matrix == null || matrix.length ==0 || matrix[0].length == 0){
            return new int[0];
        }

        // 定义初始的高和实际高
        int top =0;
        int height = matrix.length-1;

        // 矩阵初始长为 right width
        int right = 0;
        int width = matrix[0].length-1;
        // 集合长度
        int num = matrix.length * matrix[0].length;
        int[] result = new int[num];
        int n = 0;
        // 依次遍历
        while(num >= 1){
            // 从左往右走
            for (int i = right; i <= width && num >= 1 ; i++) {
                result[n++] = matrix[top][i];
                num--;
            }
            // 第一层遍历完height +1
            top++;
            // 最左侧从上往下走
            for (int i = top; i <= height && num >= 1 ; i++) {
                result[n++] = matrix[i][width];
                num--;
            }
            // 从右往左走
            width--;
            for (int i = width; i >= right && num >= 1 ; i--) {
                result[n++] = matrix[height][i];
                num--;
            }
            height--;
            // 从下往上走
            for (int i = height; i >= top && num >= 1 ; i--) {
                result[n++] = matrix[i][right];
                num--;
            }
            right++;
        }
        return result;
    }
}
