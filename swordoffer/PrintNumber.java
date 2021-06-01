package swordoffer;

import org.junit.Test;

import java.util.Arrays;

public class PrintNumber {


    @Test
    public void test(){
        System.out.println(Arrays.toString(printNumbers(1)));
    }


    public int[] printNumbers(int n) {

        int number = (int) Math.pow(10,n);
        int[] result = new int[number-1];
        for (int i = 0; i < number-1; i++) {
            result[i] = i+1;
        }
        return result;
    }
}
