package leetcode;

import java.util.*;

/**
 * @Author: mianba
 * @Date: 2019-08-09 11:38
 * @Description: 两个数组的交集
 */
public class solution349 {

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0,j =0,k=0;
        while(i < nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else {
                i++;
            }
        }
        int[] result = new int[set.size()];
        for (Integer integer : set) {
            result[k++]=integer;
        }
        return result;
    }
    /**** 解题思路
     *
     */
}
