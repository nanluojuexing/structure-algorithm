package dailyPractice.math;

import org.junit.Test;

/**
 * 两个大整数相加
 */
public class BigNumber {

    @Test
    public void test(){

    }

    /**
     * 倒序，补位
     * @param number1
     * @param number2
     * @return
     */
    public String bigNumberSum(String number1,String number2){

        // 获取新数组的长度
        int length = number1.length()<number2.length() ? number2.length() : number1.length();
        int[] array1 = new int[length+1];
        for (int i = 0; i < number1.length() ; i++) {
            array1[i]=number1.charAt(number1.length()-1-i) -'0';
        }

        int[] array2 = new int[length+1];
        for (int i = 0; i < number2.length() ; i++) {
            array1[i]=number2.charAt(number2.length()-1-i) -'0';
        }

        // 构建结果数组
        int[] result = new int[length+1];
        // 遍历数组
        for (int i = 0; i < result.length; i++) {
            int temp = result[i];
            temp+= array1[i];
            temp+= array2[i];

            // 判断是否大于10 大于的话，需要向前进一位
            if(temp>=10){
                temp = temp-10;
                result[i+1]=1;
            }
            result[i]= temp;
        }

        // 将结果逆序并转成string
        final StringBuilder stringBuilder = new StringBuilder();
        boolean flag = false;
        for (int i = result.length-1; i >= 0; i--) {
            if(!flag){
                if(result[i]==0){
                    continue;
                }
                flag= true;
            }
            stringBuilder.append(result[i]);
        }

        return stringBuilder.toString();
    }
}
