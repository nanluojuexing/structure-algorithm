package leetcode.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: mianba
 * @Date: 2019-07-30 21:26
 * @Description: 每日温度
 */
public class solution739 {

    public static void main(String[] args) {
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70};

        System.out.printf(Arrays.toString(dailyTemperatures(temperatures)));
    }
    public static int[] dailyTemperatures(int[] temperatures) {
        // 定义数组接受 每日温度需要等待的天数
        int[] result = new int[temperatures.length];
        // 定义栈接受当前的温度表的下标
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < temperatures.length; i++) {
            while(!stack.empty() &&  temperatures[i] > temperatures[stack.peek()]){
                int index = stack.pop();
                result[index]=i-index;
            }

            stack.push(i);
        }
        return result;
    }
    /****
     *  题解过程:
     *  temperatures = {89,62,70,58,47,47,46,76,100,70}
     *
     *   第一次遍历: i = 0,result =[0,0,0,0,0,0,0,0,0,0],栈stack[] temperatures[0]= 89
     *          第一天 stack[0]
     *
     *   第二次遍历: i = 1, result[0,0,0,0,0,0,0,0,0,0] ,stack[0] temperatures[1]= 62 < temperatures[0]= 89
     *          第二天: result[]  , stack[0,1]
     *
     *   第三次遍历: i = 2,result[0,0,0,0,0,0,0,0,0,0],stack[0,1] temperatures[2]= 70 > temperatures[1]= 62
     *          符合条件的 pop 出去
     *          result[1]= i-1 = 1; stack[0,2]
     *
     *   第四次遍历: i=3 result=[0,1,0,0,0,0,0,0,0,0] temperatures[3]= 58
     *           stack[0,2,3]
     *
     *   第五次遍历 i =4, result=[0,1,0,0,0,0,0,0,0,0] temperatures[4]= 47
     *           stack[0,2,3,4]
     *
     *   第六次遍历 i=5 result=[0,1,0,0,0,0,0,0,0,0] temperatures[5]= 47
     *           stack[0,2,3,4,5]
     *
     *
     *   第7次遍历 i = 6 result=[0,1,0,0,0,0,0,0,0,0] temperatures[6]= 46
     *          stack[0,2,3,4,5,6]
     *
     *   第8次遍历 i = 7 result=[0,1,0,0,0,0,0,0,0,0] temperatures[7]= 76 > temperatures[6] = 46
     *         stack.pop() = [0,2,3,4,5] index = 6 result[6] = 7-6=1 result=[0,1,0,0,0,0,1,0,0,0] temperatures[7]= 76 > temperatures[6] = 46
     *         stack.pop() = [0,2,3,4] index =5 result[5] = 7-5 = 2, result[0,1,0,0,0,2,1,0,0,0] temperatures[7]= 76 > temperatures[5] = 47
     *         stack.pop() = [0,2,3] index =4 result[4] = 7-4 = 3, result[0,1,0,0,3,2,1,0,0,0] temperatures[7]= 76 > temperatures[4] = 47
     *         stack.pop() = [0,2] index =3 result[3] = 7-3 = 4 , result[0,1,0,4,3,2,1,0,0,0] temperatures[7]= 76 > temperatures[3] = 58
     *         stack.pop() = [0] index =2 result[2] = 7-2 = 5, result[0,1,5,4,3,2,1,0,0,0] temperatures[7]= 76 > temperatures[2] = 70
     *
     *         最后 stack [0,7] result[0,1,5,4,3,2,1,0,0,0]
     *
     *   第九次遍历 i = 8, result = [0,1,5,4,3,2,1,0,0,0] temperatures[8]= 100
     *          stack.pop() = [0,7] index = 7 result[7] = 8 - 7 =1 result=[0,1,5,4,3,2,1,1,0,0] temperatures[7]= 100 > temperatures[6] = 76
     *          stack.pop() = [0] index = 0 result[0] = 8 - 0 = 8 result = [8,1,5,4,3,2,1,1,0,0] temperatures[7]= 100 > temperatures[6] = 89
     *
     *         最后stack[8] , result = [8,1,5,4,3,2,1,1,0,0]
     *
     *   第10次遍历 i =9  temperatures[9] =70 < temperatures[7]= 100
     *      stack[8,9] result = [8,1,5,4,3,2,1,1,0,0]
     *
     */
}
