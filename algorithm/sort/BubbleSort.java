package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * 把相邻的元素两两比较，当一个元素大于右侧相邻元素的时，交换它们的位置，当一个元素小于或等于右侧相邻元素时，位置不变，稳定排序算法
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {3,5,4,1,2,6};
        sort(arr,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将序列中所有元素两两比较，将最大的放在最后面。
     * 将剩余序列中所有元素两两比较，将最大的放在最后面。
     * 重复第二步，直到只剩下一个数
     */
    public static void sort(int[] arr , int n){
        if(n==1){
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n -i -1 ; j++) {
                // 定义临时变量
                int temp =0;
                // 比较大小，与下一个位置的元素，如果大，就进行交换位置
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    /**
     * 优化版1，在某些情况线，数组不需要经过全部轮，就已经有序了，这是做标记，剩下的就不需要执行
     * @param arr
     * @param n
     */
    public static void sort2(int[] arr , int n){
        if(n==1){
            return;
        }
        for (int i = 0; i < n; i++) {
            // 标记可以提前结束循环。每一轮开始的值都是ture
            boolean flag = true;
            for (int j = 0; j < n -i -1 ; j++) {
                // 定义临时变量
                int temp =0;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;

                    // 存在元素交换的时候，将标记改为false；
                    flag = false;
                }
            }
            if(flag){
                break;
            }
        }
    }

    /**
     * 优化版2 ,针对 数组部分有序的情况优化
     *  如 int[] arr = {3，4，2，1，5，6，7，8}
     * @param arr
     * @param n
     */
    public static void sort3(int[] arr,int n){
        // 记录交换的位置
        int lastExchangeIndex =0;
        // 排序的边界位置
        int sortBorder = n-1;
        for (int i = 0; i < n-1; i++) {
            // 标记可以提前结束循环。每一轮开始的值都是ture
            boolean flag = true;
            for (int j = 0; j < sortBorder ; j++) {
                // 定义临时变量
                int temp =0;
                if(arr[j]>arr[j+1]){
                    temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1] = temp;

                    // 存在元素交换的时候，将标记改为false；
                    flag = false;
                    lastExchangeIndex= j;
                }
            }
            // 每一轮排序后的，记录有序位置的边界
            sortBorder = lastExchangeIndex;
            if(flag){
                break;
            }
        }
    }

    /**
     * 鸡尾酒排序
     * @param arr
     */
    public static void sort3(int[] arr){

    }
}
