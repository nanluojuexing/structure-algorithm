package leetcode;

/**
 * 查找字符串数组中的最长公共前缀,不存在公共前缀，返回空字符串 ""
 */
public class solution14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};

        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static String longestCommonPrefix2(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for (int i = 0; i < strs.length; i++) {
           while (strs[i].indexOf(str) != 0){
                str = str.substring(0,str.length()-1);
                if(str.isEmpty()){
                    return "";
                }
           }
        }
        return str;
    }
}
