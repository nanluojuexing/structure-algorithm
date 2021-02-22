package leetcode.array;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个非空的整数数组，这个数组中有一个整数只出现了一次，其它的整数都出现两次，你要找出这个只出现一次的整数
 */
public class SingleNumber_136 {

    @Test
    public void test1(){

    }

    /**
     * 两个相同数字的 异或 操作是0 ，不同数字的
     *
     *  A XOR B XOR B = A XOR 0 = A
     * @param nums
     * @return
     */
    public int singleNumberWithXOR(int[] nums){
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public int singleNumberWithSet(int[] nums){
        Set<Integer> hashset = new HashSet<>();
        int sum = 0;
        int uniqueSum = 0;
        for (int num : nums) {
            if(!hashset.contains(num)){
                uniqueSum += num;
                hashset.add(uniqueSum);
            }
            sum += num;
        }
        return 2*uniqueSum-sum;
    }
}
