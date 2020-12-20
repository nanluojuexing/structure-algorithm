package dailyPractice.math;

import org.junit.Test;

/**
 * 判断一个数是否为2的整数次幂
 */
public class PowerOfTwo {

    @Test
    public void test(){
        System.out.println(isPowerOf2(19));
    }

    /**
     *
     * @param num
     * @return
     */
    public boolean isPowerOf2(int num){
        return (num&num-1)==0;
    }
}
