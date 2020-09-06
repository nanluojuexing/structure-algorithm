package algorithm.sort;

import org.junit.Test;

/**
 * 快速排序
 */
public class QuickSort {

    @Test
    public void test() {
        int[] arr = {1,8,3,6,2,7,0,11};
        for (int i : arr) {
            System.out.print(i+",");
        }
        System.out.println("-----------");
        quickSort(arr,0,arr.length-1);

        for (int i : arr) {
            System.out.print(i+",");
        }
    }

    /**
     * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr,int start,int end){
        int i = start,j = end;
        // 定义支点
        //支点
        int pivot = arr[(start + end) / 2];
        //左右两端进行扫描，只要两端还没有交替，就一直扫描
        while (i <= j) {
            //寻找直到比支点大的数
            while (pivot > arr[i])
                i++;
            //寻找直到比支点小的数
            while (pivot < arr[j])
                j--;
            //此时已经分别找到了比支点小的数(右边)、比支点大的数(左边)，它们进行交换
            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        //上面一个while保证了第一趟排序支点的左边比支点小，支点的右边比支点大了。
        //“左边”再做排序，直到左边剩下一个数(递归出口)
        if (start < j)
            quickSort(arr, start, j);
        //“右边”再做排序，直到右边剩下一个数(递归出口)
        if (i < end)
            quickSort(arr, i, end);
    }
}
