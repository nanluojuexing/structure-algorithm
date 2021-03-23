package leetcode.array.kLargestElement;

import org.junit.Test;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 *
 * 示例2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4

 * 链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array
 */
public class solution215 {

    @Test
    public void test(){
        int[] nums = {3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums2,4));

        int[] nums3 = {-1,2,0};
        System.out.println(findKthLargest(nums3,1));

        int[] nums4 = {2,1};
        System.out.println(findKthLargest(nums4,1));
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 1){
            return nums[0];
        }
        find(nums,0,nums.length-1);
        return nums[nums.length-k];
    }

    public void find(int[] arr ,int start,int end){
        if(start < end){
            // 获取基准位置元素
            int pos = partition(arr,start,end);
            // 对index之前和index之后的数组进行相同的操作使得整个数组变得有序
            find(arr,start,pos-1);
            find(arr,pos+1,end);
        }
    }

    public static int partition(int[] arr ,int start,int end){
        // 定义基准数据
        int pivot = arr[start];
        while(start < end){
            // 队尾元素大于基准元素，向前挪动指针
            while(start < end && arr[end] >= pivot){
                end--;
            }
            // 队尾元素小于基准元素，将值赋给低位值
            arr[start] = arr[end];
            //当队头的元素小于等于基准元素时，向后挪动指针
            while(start < end && arr[start] <= pivot){
                start++;
            }
            //若队头元素大于基准元素了，将其值赋值给high位置的值
            arr[end] = arr[start];
        }
        // 跳出循环时 start == end 此时 start 位置就是 pivot元素的正确位置啦
        arr[start] = pivot;
        // 返回当前位置
        return start;
    }
}
