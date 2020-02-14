package leetcode;

import java.util.HashMap;

/**
 * @Author: mianba
 * @Date: 2019-08-04 17:52
 * @Description: 至少有K个重复字符的最长子串
 */
public class solution395 {

    public static void main(String[] args) {
        System.out.println(longestSubstring2("ababacb",3));
    }

    public static int longestSubstring(String s, int k) {
        return longestSubstring(s,k,0,s.length()-1);
    }

    public static int longestSubstring(String s, int k,int start,int end) {

        if(start>end){
            return 0;
        }

        //定义数组，记录每个字符可能出现的次数
        int[] count= new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i)-'a']++;
        }

        // 这边处理每个字符的次数是否超过预期的次数
        for (int i = 0; i < count.length; i++) {
            if( count[i]>0 && count[i] < k ){
                // 获得第一次出现的位置，从指定索引开始
                int pos = s.indexOf((char)(i+'a'),start);
                //
                return Math.max(longestSubstring(s,k,start,pos -1),longestSubstring(s,k,pos+1,end));
            }
        }
        return end-start+1;
    }

    /**
     *解法二
     *  双指针遍历
     * @return
     */
    public static int longestSubstring2(String s, int k){
        int length = s.length();
        if (length ==0 && k>length){
            return 0;
        }
        if(k<2){
            return length;
        }
        return statistics(s.toCharArray(),k,0,length-1);
    }

    public static int statistics(char[] chars, int k,int start,int end){
        if( end -start + 1 < k){
            return 0;
        }

        int[] times = new int[26];
        // 统计每个字母出现的次数
        for (int i = 0; i < end; i++) {
            times[chars[i]-'a']++;
        }
        // 如果改字符出现的次数小于k，则不可能出现在结果子串中
        while ( end-start+1 >= k && times[chars[start]-'a'] < k){
            ++start;
        }
        while ( end-start+1 >= k && times[chars[end]-'a'] < k){
            --end;
        }
        if(end-start+1 < k){
            return 0;
        }

        for (int i = start; i <= end; ++i) {
            //  如果第i个不符合要求，切分成左右两段分别递归求得
            if (times[chars[i] - 'a'] < k) {
                return Math.max(statistics(chars, k, start, i - 1), statistics(chars, k, i + 1, end));
            }
        }
        return end-start+1;
    }
}
