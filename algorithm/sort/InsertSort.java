package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * 插入排序是将数组中的数据分为两个区间，**已排序区间** 和 **未排序区间**，初始已排序区间只有一个元素，就是数组的第一个元素，插入排序的核心思想是 取未排序区间中的元素，在已排序区间中找到合适的插入位置将其插入，并保证已排序区间数据一直有序，重复这个过程，直到未排序区间中元素为空，结束
 */
public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {4,5,6,1,3,2};
        sort2(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *
     * @param arr 数组
     * @param n 数组长度
     */
    public static void sort(int[] arr , int n){

        if(n <=1){
            return;
        }
        // 循环比较并替换
        for (int i = 1; i < n; i++) {
            // 从第 位置为  1 元素开始，对比并插入
            int temp = arr[i];
            int j= i-1;
            // 查找插入的位置
            for ( ; j >= 0 && temp < arr[j] ; j--) {
                // 移动数据
                arr[j+1] =arr[j];
            }
            arr[j+1] = temp;
        }
    }

    /**
     *
     * @param arr 数组
     * @param n 数组长度
     */
    public static void sort2(int[] arr , int n){

        if(n <=1){
            return;
        }
        // 循环比较并替换
        for (int i = 1; i < n; ++i) {
            // 从第 位置为  1 元素开始，对比并插入
            int temp = arr[i];
            int j= i-1;
            // 查找插入的位置
            for ( ; j >= 0  ; --j) {
                if(arr[j] > temp){
                    arr[j+1] =arr[j];
                }else {
                    break;
                }
            }
            arr[j+1] = temp;
        }
    }
}
