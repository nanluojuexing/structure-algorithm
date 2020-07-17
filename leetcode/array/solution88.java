package leetcode.array;

import java.util.Arrays;

/**
 * @Author: mianba
 * @Date: 2019-08-23 16:43
 * @Description: 合并两个有序数字
 */
public class solution88 {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int  n = 3;
        System.out.print(Arrays.toString(merge(nums1,m,nums2,n)));
    }


    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        while (m > 0 && n> 0){
            if( nums1[m-1] > nums2[n-1] ){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        // 获取最后的数
        while(n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
        return nums1;
    }
}
