package leetcode.slidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: mianba
 * @Date: 2019-07-29 11:43
 * @Description: 数组滑动窗口的最大值，nums=[1,3,-1,-3,5,3,6,7]  k=3 输出 [3,3,5,5,6,7]
 */
public class solution239 {

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums ={1,-1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums,1)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        // 先判断数组
        if(nums == null || nums.length==0){
            return new int[0];
        }
        // 创建优先队列 Collections.reverseOrder() 获取一个比较有否就实现Comparable接口的对象的集合的自然顺序集合
        PriorityQueue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        // 定义数组，接受最大值
        int[] max = new int[nums.length+1-k];
        for (int i = 0; i < nums.length; i++) {
            // 判断是否为最左边开始
            if( i > k ){
                queue.remove(nums[i-k]);
            }
            // 添加数据
            queue.offer(nums[i]);
            // 获取移动窗口的最大值,当数组大于k的时候才会有最大值
            if(i+1 >= k){
                max[i+1-k] = queue.peek();
            }
        }
        return max;
    }

    /**
     * 题解思路:
     *    优先队列
     *    PirorotyQueue 对内部元素进行自然排序
     *   将元素添加到队列中，对元素进行判断
     *
     *
     *
     */
}
