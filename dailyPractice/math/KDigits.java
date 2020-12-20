package dailyPractice.math;

import org.junit.Test;

/**
 * 删除K个数字后的最小值
 */
public class KDigits {

    @Test
    public void test(){
        System.out.println(removeKDigits("1593212",3));
    }

    /**
     * 删除数组即删除最高位最大数字，把原有的数字从左到右进行比较，如果发现某一位数字大于他右面的数组，
     * 那么删除该数字后，必然会使用数字的值降低
     * @param str
     * @param num
     * @return
     */
    public String removeKDigits(String num,int k){
        // 遍历删除数字
        for (int i = 0; i < k; i++) {
            boolean flag = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1);
                    flag = true;
                    break;
                }
            }

            // 如果没有找到要删除的数组，直接删除最后一个数字
            if (!flag) {
                num = num.substring(0, num.length() - 1);
            }
        }
        // 清楚整数左侧的数字零
        int start =0;
        for (int i = 0; i < num.length(); i++) {
            if(num.charAt(i) != '0'){
                break;
            }
            start++;
        }
        num = num.substring(start);
        if(num.length()==0){
            return "0";
        }
        return num;
    }
}
