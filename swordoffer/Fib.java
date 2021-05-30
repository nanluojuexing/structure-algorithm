package swordoffer;

import org.junit.Test;

public class Fib {

    @Test
    public void test(){

        System.out.println(fib(2));
        System.out.println(fib(5));
    }


    public int fib(int n) {
        // 校验初始化值
        if(n ==0 || n==1){
            return n;
        }
        // 定义数组存储数列中的每一个值
        int[] nums = new int[n+1];
        nums[0] = 0;
        nums[1] = 1;
        // 遍历对前面的数字进行求和
        for (int i = 2; i <= n; i++) {
            nums[i]=(nums[i-2]+nums[i-1])%1000000007;
        }
        return nums[n];
    }
}
