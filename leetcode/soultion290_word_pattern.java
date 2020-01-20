package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Author: mianba
 * @Date: 2019/12/11 18:46
 * @Description:
 */
public class soultion290_word_pattern {

    public static void main(String[] args) {
       String pattern = "abba", str = "dog cat cat dog";

        System.out.println(wordPattern(pattern,str));
    }

    public static boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (s.length != pattern.length()){
            return  false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!Objects.equals(map.put(s[i], i), map.put(pattern.charAt(i), i))) return false;
        }
        return true;
    }
}
