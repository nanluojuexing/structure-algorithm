package leetcode.math;

/**
 * 汉明距离
 */
public class solution461 {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    /**
     * 亦或运算(针对二进制位，相同的为0，不同的为1)，与运算(又一个为0，就为0)
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance(int x,int y){
        // 两个数进行亦或运算，针对二进制位，相同的取0，不同的取1
        int a = x ^ y;
        // 定义统计数量的count
        int count=0;
        // a != 0 说明存在，针对二进制，存在为1的
        while(a != 0){
            a = a & (a-1);
            count ++;
        }

        return count;
    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    public static int hammingDistance2(int x,int y){
        // 两个数进行亦或运算，针对二进制位，相同的取0，不同的取1
        return Integer.toBinaryString( x ^ y).replace("0","").length();
    }
}
