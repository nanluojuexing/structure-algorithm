package algorithm.kmp;

/**
 * 暴力递归
 *
 * 字符串匹配
 */
public class BruteForce {

    public static void main(String[] args) {

        String source = "ababcabcdabcde";
        String pattern = "abcd";
        System.out.println(violentMatch(source,pattern));
    }


    public static int violentMatch(String source , String pattern){
        // 定义两个索引位，记录字符串遍历的索引
        int i=0 , j=0;
        // 目标字符串的长度
        int sourceLen = source.length();
        // 匹配字符串的长度
        int patternLen = pattern.length();
        char[] sourceChars = source.toCharArray();
        char[] patternChars = pattern.toCharArray();

        while(i < sourceLen && j < patternLen){
            // 当前字符匹配上，直接移动匹配下一个字符
            if(sourceChars[i] == patternChars[j]){
                i++;
                j++;
            }else { // 如果当前字符没有匹配上，则移动主串向后移动，然后
                i = i-j+1;
                j=0;
            }
        }
        // 匹配成功，返回匹配串中的任务
        if(j == patternLen){
            return i-j;
        }else {
            return -1;
        }
    }

}
