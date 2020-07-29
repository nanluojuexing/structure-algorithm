package dailyPractice.topK;

/**
 * 无序数组的 k 小元素
 *
 * 找到一个无序数组中第k小的数
 *
 * 样例 1:
 *
 * 输入: [3, 4, 1, 2, 5], k = 3
 * 输出: 3
 * 样例 2:
 *
 * 输入: [1, 1, 1], k = 2
 * 输出: 1
 */
public class UnorderedArrayK {

    public static void main(String[] args) {
        int[] nums ={3,4,1,2,5};
        System.out.println(kthSmallest(3,nums));
    }

    public static int kthSmallest(int k,int[] nums){
        int n = nums.length;
        return partition(nums,0,n-1,k-1);
    }


    public static int partition(int[] nums,int start,int end,int k){
        int left = start,right = end;
        // 定义左边的元素为分区点
        int pivot= nums[left];

        while(left<=right){

            while(left<= right && nums[left] < pivot){
                left++;
            }
            while(left<= right && nums[right] > pivot){
                right--;
            }

            if(left<=right){
                int temp = nums[left];
                nums[left]= nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        // 处理元素k
        if(k >= left){
            return partition(nums,left,end,k);
        }
        if(k <= right){
            return partition(nums,start,right,k);
        }

        return nums[k];
    }

    /**
     * 解题思路:
     *
     * 通过快速排序算法的partition步骤，可以将小于pivot的值划分到pivot左边，大于pivot的值划分到pivot右边，所以可以直接得到pivot的rank。从而缩小范围继续找第k大的值。
     *
     * partition步骤：
     *
     * 1. 令left = start，right = end，pivot = nums[left]。
     * 2. 当nums[left] < pivot时，left指针向右移动。
     * 3. 当nums[right] > pivot时，right指针向左移动。
     * 4. 交换两个位置的值，right指针左移，left指针右移。
     * 5. 直到两指针相遇，否则回到第2步。
     * 6. 每次partition后根据pivot的位置，寻找下一个搜索的范围
     *
     *
     * 时间复杂度O(n)
     *
     * 对一个数组进行partition的时间复杂度为O(n)。
     * 分治，选择一边继续进行partition。
     * 所以总的复杂度为T(n) = T(n / 2) + O(n)，总时间复杂度依然为O(n)
     *
     *
     */
}
