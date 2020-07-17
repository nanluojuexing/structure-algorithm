package leetcode.string;

/**
 * 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *
 * 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *
 * 注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
 *
 * 返回词汇表 words 中你掌握的所有单词的 长度之和
 *
 */
public class solution1160 {

    public static void main(String[] args) {

        String[] words = {"cat","bt","hat","tree"};
        String chars = "atach";
        System.out.println(countCharacters(words,chars));
    }

    public static int countCharacters(String[] words, String chars) {

        // 定义数字，先统计字母表的字符串
        int[] ch = new int[26];
        int count = 0;
        for (char c : chars.toCharArray()) {
            ch[c-'a'] +=1 ;
        }
        // 然后统计词汇表
        for (String word : words) {
            //获取每一个单词的字母情况
            int[] temp = new int[26];
            boolean flag = true;
            for (char c : word.toCharArray()) {
                temp[c-'a'] +=1;
            }
            // 对比每个单词和字母表的匹配情况
            for (int i = 0; i < ch.length; i++) {
                // 如果单词中的字母大于字母表中单词数量，则不能匹配成功
                if(temp[i]> ch[i]){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count += word.length();
            }
        }
        return count;
    }

    /**
     * 题解:
     *
     */
}
