package leetcode;

/**
 * 寻找两个有序数组的中位数
 */
public class solution4 {

    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));

        //int[] arrayB = new int[]{3, 5, 6, 7, 8, 12, 20};
        //int[] arrayA = new int[]{1,10,11,18};
        //System.out.println(findMedianSortedArrays(arrayA,arrayB));
    }

    public static double findMedianSortedArrays(int[] nums1,int[] nums2){
        // 获取数组长度
        int m = nums1.length;
        int n = nums2.length;
        //交换数组 目的避免 两个数组长度差距太大，减少搜索次数
        if( m > n ){
            int[] tempArray = nums1;
            nums1 = nums2;
            nums2 = tempArray;
            int temp = m ;
            m = n;
            n =temp;
        }
        //定义起始的数组
        int start = 0;
        int end =m;
        // 这里 加 1 是避免出现 大数组长度为奇数的情况
        int mid = (m+n+1)/2;
        while( start <= end){
            // 获取长度短的数组的中间位置元素 （上面已经交换过数组，所以此时num1数组就是长度最短的）
            // 确定长数组的值 j
            int i = (start+end)/2;
            int j = mid-i;
            // 判断 num1[i] nums[j-1]的大小
            if(i < end && nums2[j-1] > nums1[i]){
                // i 小了，右移
                start = i+1;
            }else if (i>start && nums1[i-1] > nums2[j]){
                // i 小了，左移
                end = i-1;
            }else { // 刚刚合适
                int maxLeft;// 定义边界值
                if(i == 0){
                    maxLeft = nums2[j-1];
                }else if(j == 0){
                    maxLeft = nums1[i-1];
                }else{
                    maxLeft = Math.max(nums1[i-1],nums2[j-1]);
                }
                // 这里判断是否为奇数还是偶数
                if((m+n) % 2 ==1){
                    //如果大数组的长度是奇数，中位数就是左半部分的最大值
                    return  maxLeft;
                }
                int minRight;
                if(i==m){
                    minRight= nums2[j];
                }else if(j==n){
                    minRight = nums1[i];
                }else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }
                //如果大数组的长度是偶数，取左侧最大值和右侧最小值的平均
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }
}
