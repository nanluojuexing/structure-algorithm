package dailyPractice.array;

import org.junit.Test;

public class RepeatElementArray {

    @Test
    public void test1(){
        int[] arr = {2,3,2,4,6,7,4};
        System.out.println(duplicateElement(arr));
    }

    @Test
    public void test2(){
        int[] arr = {2,1,9,8,6,7,4};
        System.out.println(duplicateElement(arr));
    }

    /**
     * 利用桶排思想解决
     * @param arr
     * @return
     */
    public boolean duplicateElement(int[] arr){
        // 获取数组的最大值和最小值
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i] > max) max = arr[i];

            if(arr[i]<min) min = arr[i];

        }
        // 创建新的数组
        int length = max-min;
        int[] buckets = new int[length+1];
        // 遍历数组
        for (int i = 0; i < arr.length-1; i++) {
            // 计算数组索引位置
            int num = arr[i]-min;
            if(buckets[num] == 0){
                buckets[num] = 1;
            }else {
                buckets[num] = buckets[num] + 1 ;
            }
        }

        for (int i = 0; i < buckets.length; i++) {
            if(buckets[i]>=2) return true;
        }
        return false;
    }

    /**
     * 循环对比
     */
    public void duplicateElement2(){

    }
}
