package leetcode;

/**
 * @Author: mianba
 * @Date: 2019-08-26 15:25
 * @Description: 爬楼梯 问题
 */
public class solution70 {
    public static void main(String[] args) {

        System.out.println(climbStairs2(10));
    }

    /**
     * 递归求解
     * @param n
     * @return
     */
    public  static int climbStairs(int n) {

        if(n < 1){
            return 0;
        }
        if(n == 1 || n==2 ){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     *  动态规划
     */
    public  static int climbStairs2(int n) {

        if(n < 1){
            return 0;
        }
        if(n == 1 || n==2 ){
            return n;
        }
        int a=1,b=2,temp=0;
        for (int i = 3; i <= n; i++) {
            temp = a+b;
            a=b;
            b= temp;
        }
        return temp;
    }
}
