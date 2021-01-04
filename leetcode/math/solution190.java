package leetcode.math;

/**
 * @Author: mianba
 * @Date: 2019/12/24 16:49
 * @Description: 颠倒二进制位
 *
 * 颠倒给定的 32 位无符号整数的二进制位
 */
public class solution190 {

    public static void main(String[] args) {
        System.out.println(reverseBits(1011));
    }

    public static int reverseBits(int n) {
        // 记录结果值
        int result =0;
        // 遍历元素的计数
        int count =0;
        while(count < 4){
            // 将result左移一位
            result <<= 1;
            result |= (n & 1);
            n >>= 1;
            count ++;
        }
        return result;
    }

    /**
     * 题解：
     *
     * 原数字 1011 ，res = 0
     *
     * res 左移一位，res = 0，
     * 得到 1011 的最低位 1 加过来, res = 1
     * n = 1011 右移一位变为 101
     *
     * res = 1 左移一位，res = 10，
     * 得到 101 的最低位 1 加过来, res = 11
     * n = 101 右移一位变为 10
     *
     * res = 11 左移一位，res = 110，
     * 得到 10 的最低位 0 加过来, res = 110
     * n = 10 右移一位变为 1
     *
     * res = 110 左移一位，res = 1100，
     * 得到 1 的最低位 1 加过来, res = 1101
     * n = 1 右移一位变为 0, 结束
     */
}
