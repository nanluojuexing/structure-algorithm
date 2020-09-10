package algorithm.sort;

import org.junit.Test;

import java.util.*;

/**
 * 桶排序
 */
public class BucketSort {

    @Test
    public void test(){
        double[] array ={4.12,6.241,0.0023,3.0,0.2,2.213,8.122,4.12,10.09};
        System.out.println(Arrays.toString(bucketSort(array)));
    }

    /**
     * 桶排序算法
     * @param array
     */
    public double[] bucketSort(double[] array){
        // 首先获取数列中的最大值和最小值
        double max = array[0];
        double min = array[0];

        for (int i = 1; i < array.length ; i++) {
            if(array[i]>max){
                max= array[i];
            }
            if(array[i]<min){
                min = array[i];
            }
        }
        // 计算最大值和最小值的数据差
        double d = max-min;
        //初始化桶
        int bucketNum= array.length;
        // 新建一个桶的集合
        List<LinkedList<Double>> bucketList = new ArrayList<>();
        // 给每个桶都分配空间
        for (int i = 0; i < bucketNum ; i++) {
            bucketList.add(new LinkedList<>());
        }
        // 遍历数组，将元素都放入桶中
        for (int i = 0; i < array.length; i++) {
            int num = (int) ((array[i]-min)*(bucketNum-1)/d);
            bucketList.get(num).add(array[i]);
        }
        // 针对每个桶内的数据进行排序
        for (int i = 0; i < bucketList.size() ; i++) {
            Collections.sort(bucketList.get(i));
        }
        // 输出所有的元素
        // 将桶中元素全部取出来并放入 arr 中输出
        int index = 0;
        double[] arr = new double[array.length];
        for (LinkedList<Double> bucket : bucketList) {
            for (Double data : bucket) {
                arr[index++] = data;
            }
        }
        return arr;
    }
}
