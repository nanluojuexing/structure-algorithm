package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    @Test
    public void testQuickSort() {
        int[] arr = {1,8,3,6,2,7,0,11};
        System.out.println(Arrays.toString(arr));
        System.out.println("-----------");
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
     * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分
     * @param arr
     * @param start
     * @param end
     */
    public void quickSort(int[] arr,int start,int end){
        int i = start,j = end;
        // 定义支点
        //定义基准元素
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

    @Test
    public void test_quick_sort() {
        int[] arr = {4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        quick_sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 双边循环法
     * @param arr
     * @param start
     * @param end
     */
    public void quick_sort(int[] arr,int start ,int end){

        // 定义递归的终止条件
        if(start>=end){
            return;
        }
        // 获取基准元素
        int pivot = partition(arr,start,end);
        // 根据基准元素分为两部分进行递归排序
        quick_sort(arr,start,pivot-1);
        quick_sort(arr,pivot+1,end);
    }

    /**
     * 分治-双边循环法
     * @param arr
     * @param start
     * @param end
     */
    public int partition(int[] arr ,int start,int end){

        // 获取第一个位置缘故作为基准元素
        int pivot= arr[start];
        int left = start;
        int right = end;
        while(left != right){
            //控制right指针比较并左移
            while (left<right && arr[right]>pivot){
                right--;
            }
            //控制left指针比较并右移
            while(left< right && arr[left]<= pivot){
                left++;
            }
            // 交换left和right的元素
            if(left<right){
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        // pivot和指针元素重合
        arr[start] = arr[left];
        arr[left] = pivot;
        return left;
    }

    @Test
    public void test_quick_sort_2() {
        int[] arr = {4,7,6,5,3,2,8,1};
        System.out.println(Arrays.toString(arr));
        quick_sort_2(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 单边循环法
     * 这里与双边循环法的区别就是 分区方法partition
     */
    public void quick_sort_2(int[] arr,int start,int end){

        // 定义递归的终止条件
        if(start>=end){
            return;
        }
        // 获取基准元素
        int pivot = partition2(arr,start,end);
        // 根据基准元素分为两部分进行递归排序
        quick_sort(arr,start,pivot-1);
        quick_sort(arr,pivot+1,end);
    }

    /**
     * 单边循环法的分区方法
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public int partition2(int[] arr ,int start,int end){

        // 获取第一个位置缘故作为基准元素
        int pivot= arr[start];
        // 定义其实标记位置
        int mark = start;

        for (int i = start+1; i <= end; i++) {
            if(arr[i]< pivot){
                mark++;
                int temp = arr[mark];
                arr[mark]= arr[i];
                arr[i] = temp;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;

        return mark;
    }
}
