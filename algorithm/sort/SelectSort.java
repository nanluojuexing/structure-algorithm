package algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 *
 */
public class SelectSort {
    public static void main(String[] args) {

        int[] arr={1,54,6,3,78,34,12,45};
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * @param arr 数组
     * @param n 数组长度
     */
    public static void sort(int[] arr , int n){

        if(n <=1)
            return;

        // 定义临时变量
        int temp = 0;
        // 循环比较并替换
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                // 这里i 就是已经排序区间的最后一位的索引位置
                if(arr[i] > arr[j]){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
}
