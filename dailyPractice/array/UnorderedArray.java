package dailyPractice.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

/**
 * 有一个无序数组，求该数组排序后的任意两个相邻元素的最大差值，要求空间复杂度和时间复杂度最低
 *
 * 无序数组 2，6，3，4，5，10，9
 * 排序后 2，3，4，5，6，9，10 所以最大差值就是3
 */
public class UnorderedArray {

    @Test
    public void test(){

        int[] arr = {2,6,3,4,5,10,9};
        //System.out.println(unorderedArrayGreatestDistance(arr));
        System.out.println(resolve(arr));
    }

    /**
     * 解法1 排序后，去数组的差值
     * @param arr
     * @return
     */
    public int resolve(int[] arr){
        Arrays.sort(arr);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length-1){
                break;
            }
            if(arr[i+1]-arr[i]>max){
                max = arr[i+1]-arr[i];
            }
        }
        return max;
    }

    /**
     * 桶排序解法 记录每个桶的最大值和最小值
     * @param arr
     */
    public int unorderedArrayGreatestDistance(int[] arr){
        // 获取数组的最大值和最小值
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<min){
                min= arr[i];
            }
            if(arr[i]>max){
                max= arr[i];
            }
        }
        //计算最大值和最小值的差值
        int d = max-min;
        //如果d=0,则说明最大值和最小值相同，说明数组元素都是一样大
        if(d==0) return 0;

        // 初始化桶
        int bucketNum = arr.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i = 0; i < bucketNum; i++) {
            buckets[i] = new Bucket();
        }

        // 遍历原始数组，确定每个桶的最大值和最小值
        for (int i = 0; i < arr.length; i++) {
            // 确定数组元素归属桶的下标
            int index = ((arr[i]-min)*(bucketNum-1)/d);
            if(buckets[index].min == null || buckets[index].min > arr[i]){
                buckets[index].min = arr[i];
            }
            if(buckets[index].max == null || buckets[index].max < arr[i]){
                buckets[index].max = arr[i];
            }
        }
        // 遍历当前桶，找到最大值
        int leftMax = buckets[0].max;
        int maxDistance =0;
        for (int i = 0; i < buckets.length ; i++) {
            if(buckets[i].min == null){
                continue;
            }
            if(buckets[i].min - leftMax > maxDistance){
                maxDistance = buckets[i].min - leftMax;
            }
            leftMax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket{
        private Integer max;
        private Integer min;
    }
}
