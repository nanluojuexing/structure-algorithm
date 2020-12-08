package algorithm.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * 堆排序，通过移除栈顶元素，调整堆顶元素实现
 */
public class HeapSort {

    @Test
    public  void test(){
        int[] arr = {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort(int[] array){
        // 将无序数组构建成最大堆
        for (int i = (array.length-2)/2; i >=0; i--) {
            downAdjust(array,i,array.length);
        }
        // 循环删除堆顶元素，移除到尾部集合，调整堆产生新的堆顶
        for (int i = array.length-1; i >0 ; i--) {
            // 最后1个元素和第1个元素进行交换
            int temp = array[i];
            array[i]= array[0];
            array[0] = temp;

            downAdjust(array,0,i);
        }
    }

    /**
     * 元素的下沉 最小堆
     * @param arr
     * @param parentIndex 要下沉的父亲节点
     * @param length 堆的大小
     */
    public  void downAdjust(int[] arr,int parentIndex,int length){

        // temp保存父节点的值
        int temp = arr[parentIndex];
        int childIndex = 2 * parentIndex+1;
        while(childIndex < length){
            // 如果右孩子节点，切有孩子节点小于左孩子节点，则定位到有孩子节点
            if(childIndex+1 < length && arr[childIndex+1] > arr[childIndex]){
                childIndex++;
            }
            // 如果父节点大于任何一个节点的值，直接结束
            if(arr[childIndex] <= temp){
                break;
            }
            arr[parentIndex] = arr[childIndex];
            parentIndex = childIndex;
            childIndex = 2 * childIndex+1;
        }
        arr[parentIndex] = temp;
    }
}

