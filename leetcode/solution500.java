package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 键盘问题
 */
public class solution500  {

    public static void main(String[] args) {
        String[] words = {"Hello","Alaska","Dad","Peace"};
        System.out.println(Arrays.toString(findWords2(words)));
    }

    /**
     * 解法1
     * @param words
     * @return
     */
    public static String[] findWords(String[] words){
        return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
    }

    /**
     * 解法2
     *
     * 遍历数组，那每个char字符来判断
     * @param words
     * @return
     */
    public static String[] findWords2(String[] words){
        String[] rec ={"qwertyuiop","asdfghjkl","zxcvbnm"};
        List<String> list = new ArrayList<>();
        //循环遍历数组
        for (String word : words) {
            for (int i = 0; i < 3; i++) {
                boolean flag = true;
                for (int j = 0; j < word.length(); j++) {
                    char c = word.toLowerCase().charAt(j);
                    if(rec[i].indexOf(c) == -1){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(word);
                    break;
                }
            }
        }
        return list.toArray(new String[]{});
    }
}
