package dailyPractice.array;

import org.junit.Test;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回false 。
 */
public class RepeatElementArray {

    @Test
    public void test1(){
        int[] arr = {2,3,2,4,6,7,4};
        System.out.println(duplicateElement(arr));
    }

    @Test
    public void test2(){
        int[] arr = {1,2,3,1};
        System.out.println(duplicateElement(arr));
    }

    @Test
    public void test3(){
        int[] arr = {3,1};
        System.out.println(duplicateElement(arr));
    }

    /**
     * 利用桶排思想解决，
     * 1. 取数组最大值和最小值，然后创建差值的数量的桶
     * 2. 遍历数组，将数组元素，放入对应的桶位，遇到相同的元素+1
     * 3. 最后遍历桶数组，如果有存在大于等于2的，说明对应的桶存在重复的元素，即数组中又重复元素
     *
     * 事件复杂度O(n),空间复杂度O(n)
     * @param arr
     * @return
     */
    public boolean duplicateElement(int[] arr){
        if(arr.length==0){
            return false;
        }
        // 获取数组的最大值和最小值
        int min = arr[0];
        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max) max = arr[i];
            if(arr[i]<min) min = arr[i];
        }
        // 创建新的数组
        int length = max-min;
        int[] buckets = new int[length+1];
        // 遍历数组
        for (int i = 0; i < arr.length; i++) {
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
