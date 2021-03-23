package leetcode.math;

import org.junit.Test;

/**
 *  数值的n次方
 *
 *  实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）
 *  这个题目说的是，你要实现一个函数，用它来计算浮点数的 n 次方。
 *
 *  比如说，给你 2 和 11，你要计算出 2 的 11 次方的结果：
 *
 *  f(2, 11) = 211
 *
 */
public class solution50 {

    @Test
    public void test(){

        System.out.println(powFast(2,11));
    }

    @Test
    public void test1(){

        System.out.println(myPow(2.0000,10));
    }

    @Test
    public void test2(){

        System.out.println(myPow(2.10000,3));
    }

    @Test
    public void test3(){

        System.out.println(powFast(2.0000,-2));
    }


    /**
     * 循环递归的话，会超出时间限制，如果 n 最够大
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double result = 1;
        // int转long，处理最小值的问题
        long abs = Math.abs((long)n);

        for (int i = 0; i < abs; i++) {
            result *= x;
        }
        return n < 0 ? 1 / result : result;
    }

    /**
     * 利用二进制计算结果 x的11次幂 = x的8次幂 * x的2次幂 * x
     * @param x
     * @param n
     */
    public double powFast(double x, int n){

        double result = 1;
        long N = Math.abs((long)n);

        while (N != 0) {
            if ((N & 1) == 1) result *= x;
            System.out.println(N+"->"+result+"->"+x);
            x *= x;
            System.out.println("x="+x);
            N >>= 1;
            System.out.println("N="+N);
        }
        return n < 0 ? 1/result : result;
    }
}
