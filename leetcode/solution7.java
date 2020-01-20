package leetcode;

/**
 * 反转整数
 */
public class solution7 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
    }

    public static int reverse(int x){
        long y =x;
        long result =0;

        do {
            result = 10 * result + y % 10;
        }while (( y /= 10 ) != 0);

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }
}
