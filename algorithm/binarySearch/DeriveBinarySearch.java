package algorithm.binarySearch;

import org.junit.Test;

/**
 * 二分查找的衍生问题
 */
public class DeriveBinarySearch {

    @Test
    public void testBinarySearch1(){

    }

    /**
     * 查找第一个等于给定值元素的问题
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bsearch1(int[] arr,int n ,int value){
        int low =0;
        int high = n-1;
        while (low<= high){
            int mid = low + ((high-low) >> 1);
            if(value < arr[mid]){
                high= mid-1;
            }else if(value > arr[mid]){
                low = mid+1;
            }else {
                // 当 arr[mid] == value 时，就是要找的元素；
                // 如果mid=0，说明当前元素为数组的第一个元素
                // 如果当前位置不是数组的第一个索引位，就判断当前元素的前一个元素是否和value值相等，如果不相等，即当前mid索引为就是第一个元素
                if(mid == 0 || arr[mid-1] != value){
                    return mid;
                }else{
                    // a[mid]前面的一个元素 a[mid-1]也等于 value
                    // 那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。那我们就更新 high=mid-1
                    // 要找的元素肯定出现在[low, mid-1]之间
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch2(){

    }

    /**
     * 查找最后一个值等于给定值的元素
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bsearch2(int[] arr,int n ,int value){
        int low =0;
        int high = n-1;
        while (low<= high){
            int mid = low + ((high-low) >> 1);
            if(value < arr[mid]){
                high= mid-1;
            }else if(value > arr[mid]){
                low = mid+1;
            }else {
                // 当 arr[mid] == value 时，就是要找的元素；
                // 如果mid=n-1，说明当前元素为数组的最后元素
                // 如果当前位置不是数组的最后索引位，就判断当前元素的前一个元素是否和value值相等，如果不相等，即当前mid索引为就是第一个元素
                if(mid == n-1 || arr[mid+1] != value){
                    return mid;
                }else{
                    // a[mid]前面的一个元素 a[mid-1]也等于 value
                    // 那说明此时的 a[mid]肯定不是我们要查找的第一个值等于给定值的元素。那我们就更新 low=mid+1
                    // 要找的元素肯定出现在[mid+1, high]之间
                    low = mid+1;
                }
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch3(){
        int[] arr = {3,4,6,7,10};
        System.out.println(bsearch3(arr,arr.length,5));
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bsearch3(int[] arr,int n ,int value){
        int low =0;
        int high = n-1;
        while (low<= high){
            int mid = low + ((high-low) >> 1);
            if(value < arr[mid]){
                if(mid==0 || arr[mid-1]<value){
                    return mid;
                }else {
                    high= mid-1;
                }
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    @Test
    public void testBinarySearch4(){
        int[] arr = {3,5,6,8,9,10};
        System.out.println(bsearch4(arr,arr.length,7));
    }
    /**
     * 查找最后一个小于等于给定值的元素
     * @param arr 目标数组
     * @param n 数组长度
     * @param value 目标值
     * @return
     */
    public int bsearch4(int[] arr,int n ,int value){
        int low =0;
        int high = n-1;
        while (low<= high){
            int mid = low + ((high-low) >> 1);
            if(value < arr[mid]){
                high= mid-1;
            }else{
                if(mid==n-1 || arr[mid+1]>value){
                    return mid;
                }else {
                    low= mid+1;
                }
            }
        }
        return -1;
    }


}
