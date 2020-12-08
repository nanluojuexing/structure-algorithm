package algorithm.binarySearch;

import org.junit.Test;

/**
 * 二分查找法
 *
 */
public class BinarySearch {

    /**
     * 查找方法
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bSearch(int[] arr,int n ,int value){
        // 获取数组的起始和结束索引位置
        int low = 0;
        int high = n-1;
        // 循环查找
        while (low <= high){
            // 获取中间位置
            int mid = (high+low)/2;
            // 比对目标值与中间位置元素，如果相等即返回当前索引
            if(arr[mid] == value){
                return mid;
            // 如果目标值小于中间元素，说明在 左边 即0  mid-1
            }else if ( arr[mid] > value){
                high = mid - 1;
            }else {
                low = mid+1;
            }
        }
        return -1;
    }

    @Test
    public void test1(){
        int[] arr = {8,11,19,23,27,33,45,55,67,98};
        System.out.println(bSearch(arr,arr.length,33));
    }

    /**
     * 递归实现
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bSearch2(int[] arr,int n ,int value){
        return bsearchInternally(arr, 0, n - 1, value);
    }

    private int bsearchInternally(int[] arr, int low, int high, int value) {

        if (low > high)
            return -1;

        int mid = low + ((high - low) >> 1);

        if (arr[mid] == value) {
            return mid;
        } else if (arr[mid] < value) {
            return bsearchInternally(arr, mid+1, high, value);
        } else {
            return bsearchInternally(arr, low, mid-1, value);
        }
    }

    @Test
    public void test2(){
        int[] arr = {8,11,19,23,27,33,45,55,67,98};
        System.out.println(bSearch2(arr,arr.length,33));
    }

}
