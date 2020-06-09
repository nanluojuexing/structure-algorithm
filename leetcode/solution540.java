package leetcode;

/**
 * 有序数组中的单一元素
 *
 *
 给定一个只包含整数的有序数组，每个元素都会出现两次，唯有一个数只会出现一次，找出这个数。

 示例 1:

 输入: [1,1,2,3,3,4,4,8,8]
 输出: 2
 示例 2:

 输入: [3,3,7,7,10,11,11]
 输出: 10
 注意: 您的方案应该在 O(log n)时间复杂度和 O(1)空间复杂度中运行
 */
public class solution540 {

    public static void main(String[] args) {
        int[] arr ={2,2,1,1,3,3,4,5,5};
        System.out.println(singleNonDuplicate(arr));
    }


    public static int singleNonDuplicate(int[] nums) {

        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int mid = (low) + (high-low)/2;
            // 判断 元素个数  右边的元素个数 是否为偶数
            boolean flag = ( high - mid ) % 2 == 0;
            if(nums[mid+1] == nums[mid]){
                if(flag){
                    low = mid + 2;
                }else {
                    high = mid - 1;
                }
            }else if(nums[mid-1] == nums[mid]){
                if(flag){
                    high = mid - 2;
                }else {
                    low = mid + 1;
                }
            }else {
                return nums[mid];
            }
        }
        return nums[low];
    }
}
