package dailyPractice;

import java.util.Arrays;

/**
 * 神奇的数字
 *
 * 将字符串数字，为偶数的进行反转，后输出
 */
public class MagicStringNum {

    public static void main(String[] args) {
        System.out.println(reverse("123456"));
        System.out.println(reverse("12345"));
        System.out.println(reverse("1234"));
        System.out.println(reverse("1234567"));
    }
    
    public static String reverse(String numStr){
        char[] nums = new char[numStr.length()];
        for (int i = 0; i < nums.length ; i++) {
            nums[i] = numStr.charAt(i);
        }
        // 移动指针
        int i =0;
        // 处理奇数和偶数长度的问题
        int j = nums.length % 2 ==0 ? numStr.length() : numStr.length()-1;
        // 定义临时变量
        char temp  = 0;
        // 遍历双向移动指针
        while(i<=j){
            if(i % 2 !=0 && j % 2 !=0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
            i++;
            j--;
        }
        return Arrays.toString(nums);
    }
}
