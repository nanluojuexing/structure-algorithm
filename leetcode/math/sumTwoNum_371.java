package leetcode.math;

import org.junit.Test;

/**
 * 不用 + ，- 求两数之和
 */
public class sumTwoNum_371 {


    @Test
    public void test(){

        System.out.println(getSumRecursive(9,11));
    }

    public int getSumRecursive(int a,int b){
        return b == 0 ? a : getSumIterative(a^b,(a&b)<<1);
    }

    private int getSumIterative(int a, int b) {
        while (b!=0){
            int sum = a^b;
            int carry= (a&b)<<1;
            a = sum;
            b = carry;
        }
        return a;
    }
}
