package dailyPractice.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: mianba
 * @Date: 2019/11/11 20:56
 * @Description: 数组问题： m*n的二维整形数组arr，对数组进行如下操作，规则如下，arr[i,j]的原始值为0，则将第i行和j列的所哟元素全部置为0，
 *
 * 输入：
 * 1 2 3
 * 0 4 5
 * 6 7 0
 *
 * 输出：
 * 0 2 0
 * 0 0 0
 * 0 0 0
 */
public class ArrayProblem {

    public static void main(String[] args) {
        int[][] arr ={{1,2,3},{0,4,5},{6,7,0}};
        int[][] change = change(arr);
        System.out.printf(change.toString());
    }


    public static int[][] change(int[][] arr){

        //用来记录为0的数组位置
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length ; j++) {
                if(arr[i][j]==0){
                    list.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            int[] ints = list.get(i);
            //横坐标
            int x= ints[0];
            //竖坐标
            int y = ints[1];
            //将行全部设置为0
            for (int j = 0; j < arr[x].length; j++) {
                arr[x][j] = 0;
            }
            //将列全部设置为0
            for (int j = 0; j < arr.length; j++) {
                arr[j][y] = 0;
            }
        }
        return arr;
    }

    /**
     * 题解思路：
     *
     * 遍历循环获取到所有 为0 的位置索引，然后遍历所以位置将对应的i行和j列的数值都置为索引
     */
}
