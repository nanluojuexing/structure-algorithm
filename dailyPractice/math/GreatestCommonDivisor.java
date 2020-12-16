package dailyPractice.math;

import org.junit.Test;

/**
 * 最大公约数
 *
 * 求出两个整数的最大公约数，尽量优化算法性能
 */
public class GreatestCommonDivisor {

    @Test
    public void test(){

        System.out.println(getGreatestCommonDivisor(25,5));
        System.out.println(getGreatestCommonDivisor(100,80));
        System.out.println(getGreatestCommonDivisor(27,14));
    }

    /**
     *
     * @param a
     * @param b
     * @return
     */
    public  int getGreatestCommonDivisor(int a,int b){
        if(a==b) return a;
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisor(big-small,small);
    }

    /**
     * 两个正整数a和b(a>b),它们的最大公约数等于 a-b的差值c 和较小数b的最大公约数
     *
     * 最大公约数 指两个或多个整数共有约数中最大的一个
     */
}
