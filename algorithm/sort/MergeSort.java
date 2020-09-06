package algorithm.sort;

import org.junit.Test;

/**
 * 归并排序
 *
 * 将两个已排好序的数组合并成一个有序的数组。
 * 将元素分隔开来，看成是有序的数组，进行比较合并
 * 不断拆分和合并，直到只有一个元素
 */
public class MergeSort {


    @Test
    public void test1(){

        int[] arr = {1,8,3,6,2,7,0,11};
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println("-----------");
        mergeSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    /**
     * 归并排序方法
     * @param arr 数组
     * @param p 起始位置
     * @param r 终止位置
     */
    public void mergeSort(int[] arr,int p,int r){
        // 终止递归的条件
        if(p>= r) return;

        // 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值
        int q = p+(r-p)/2;
        // 左边的数据不断拆分
        mergeSort(arr,p,q);
        // 右边的数据不断拆分
        mergeSort(arr,q+1,r);

        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(arr,p,q,r);
    }

    public void merge(int[] arr,int p,int q , int r){
        //申请一个大小跟a[p...r]一样的临时数组
        int[] temp = new int[r-p+1];
        // 定义临时变量
        int s = p;
        int t = q+1;
        int k = 0;
        while(s<=q && t <= r){
            if(arr[s]<= arr[t]){
                temp[k] = arr[s];
                s++;
            }else {
                temp[k] = arr[t];
                t++;
            }
            k++;
        }
        // 判断哪个子数组中有剩余的数据
        int start = s;
        int end = q;
        if (t <= r) {
            start = t;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            temp[k++] = arr[start++];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (int i = 0; i <= r-p; ++i) {
            arr[p+i] = temp[i];
        }
    }


}
