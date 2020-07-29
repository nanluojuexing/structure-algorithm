package dailyPractice.topK;

import java.util.Arrays;

/**
 *
 * 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeastNumbers {

    public static void main(String[] args) {
        int[] arr = {3,2,1};

        System.out.println(Arrays.toString(getLeastNumbers(arr,2)));
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        // 定义处理数据结果的
        int[] result = new int[k];
        // 处理临界条件
        if(arr.length < k){
            return result;
        }
        find(arr,0,arr.length-1,k);
        for (int i = 0; i < k ; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    public static void find(int[] arr ,int start,int end ,int k){
        if(start < end){
            int pos = partition(arr,start,end);

            if(pos== k-1){
                return;
            }else if(pos < k-1){
                find(arr,pos+1,end,k);
            }else {
                find(arr,start,pos-1,k);
            }
        }
    }

    public static int partition(int[] arr ,int start,int end){
        int pivot = arr[start];
        while(start < end){
            while(start < end && arr[end] >= pivot){
                end--;
            }
            arr[start] = arr[end];
            while(start < end && arr[start] <= pivot){
                start++;
            }
            arr[end] = arr[start];
        }
        arr[start] = pivot;
        return start;
    }
}
