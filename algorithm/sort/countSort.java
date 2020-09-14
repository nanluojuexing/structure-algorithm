package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 计数排序
 */
public class countSort {

    @Test
    public void test(){
        int[] array ={2,5,3,0,2,3,0,3};
        //System.out.println(Arrays.toString(countSort(array)));
        System.out.println(Arrays.toString(countSort2(array,array.length)));
    }

    /**
     * 计数排序代码
     * @param array
     */
    public int[] countSort(int[] array){

        // 获取数组中的最大值
        int max= array[0];
        for (int i = 1; i < array.length ; i++) {
            if(max < array[i]){
                max = array[i];
            }
        }
        // 根据数列最大值确定统计数组的长度
        int[] countArray = new int[max+1];
        // 遍历元数组，填充统计数组
        for (int i = 0; i < array.length ; i++) {
            countArray[array[i]]++;
        }
        // 遍历统计数组，输出结果
        int index = 0;
        int[] sortArray = new int[array.length];
        // 这里遍历统计数组，统计数组记录每个元素的个数
        for (int i = 0; i < countArray.length ; i++) {
            // 这边循环打印元素超过大于0的
            for (int j = 0; j < countArray[i] ; j++) {
                sortArray[index++] = i;
            }
        }
        return sortArray;
    }

    /**
     * 优化后的计数排序，确保原来有序的部分依然有序
     * @param array
     * @param n 数组长度
     * @return
     */
    public int[] countSort2(int[] array,int n){

        if (n<=1) return array;

        //查找数组中的范围
        int max= array[0];
        for (int i = 1; i <n ; i++) {
            if(max<array[i]){
                max= array[i];
            }
        }
        // 申请计数数组，下表大小为0 到max
        int[] countSort = new int[max+1];
        for (int i = 0; i < max+1; i++) {
            countSort[i]=0;
        }

        //计算每个元素的个数，放入c中
        for (int i = 0; i < n ; i++) {
            countSort[array[i]]++;
        }
        // 依次累加
        for (int i = 1; i < max+1 ; i++) {
            countSort[i]=countSort[i-1]+countSort[i];
        }
        // 临时数组，存储排序后的结果
        int[] result = new int[n];
        //从后往前遍历
        for (int i = n - 1; i >= 0; --i) {
            int index = countSort[array[i]]-1;
            result[index] = array[i];
            countSort[array[i]]--;
        }
        // 将结果拷贝到a数组
        for (int i = 0; i < n; i++) {
            array[i] = result[i];
        }

        return array;
    }
}
