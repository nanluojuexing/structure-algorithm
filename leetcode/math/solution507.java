package leetcode.math;

/**
 * 完美数
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 28 = 1 + 2 + 4 + 7 + 14
 */
public class solution507 {


    public static void main(String[] args) {

        System.out.println(checkPerfectNumber(28));
    }

    public static boolean checkPerfectNumber(int num) {
        // 先处理0和1, 直接返回false
        if(num == 1 || num == 0){
            return false;
        }
        // 记录起始值
        int sum = 1;
        // 每次去取 / 向下取整
        for (int i = 2; i < num/i ; i++) {
            // 取摸运算，如果是 num的因子，为0
            if( num % i ==0 ){
                //此时对值进行累加，这里获取到两个因子
                sum += i + num/i;
            }
        }
        return sum==num;
    }
}
