package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 *给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 *
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1
 *
 */
public class solution454 {


    public static void main(String[] args) {

        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};

        System.out.println(fourSumCount(A,B,C,D));
    }


    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 记录数组A和B中所有的数字和的可能情况
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                // 获得i,j位置的和，如果存在则累加， key 是和 value 是次数
                int key = A[i]+ B[j];
                map.put(key,map.getOrDefault(key,0)+1);
            }
        }
        // 记录次数
        int result = 0;
        //循环遍历C和D数组，求他们的和，的负数是不是存在map中
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                if(map.containsKey(0-sum)){
                    result += map.get(0-sum);
                }
            }
        }
        return result;
    }
}
