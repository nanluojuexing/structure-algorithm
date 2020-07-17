package leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 两句话中的不常见单词
 */
public class solution884 {

    public static void main(String[] args) {
        String A ="this apple is sweet";
        String B ="this apple is sour";

        System.out.println(uncommonFormSentences(A,B).toString());

    }

    public static String[] uncommonFormSentences(String A,String B){
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String s : A.split(" ")) {
            if(!hashMap.containsKey(s)){
                hashMap.put(s,1);
            }else {
                hashMap.put(s,2);
            }
        }

        for (String s : B.split(" ")) {
            if(!hashMap.containsKey(s)){
                hashMap.put(s,1);
            }else {
                hashMap.put(s,2);
            }
        }
        List<String> strings = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            if(hashMap.get(s).equals(1)){
                strings.add(s);
            }
        }

        return strings.toArray(new String[strings.size()]);
    }


}
