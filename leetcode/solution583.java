package leetcode;

/**
 * 两个字符串的删除操作
 */
public class solution583 {
    public static void main(String[] args) {
        System.out.println(minDistance2("sea","eat"));
    }

    /**
     * 太慢
     * @param word1
     * @param word2
     * @return
     */
    public static int minDistance(String word1,String word2){
        return word1.length()+word2.length()-2*commonStr(word1,word2,word1.length(),word2.length());
    }

    public static int commonStr(String word1,String word2,int m,int n){
        // 不存在公共字符串
        if(m==0 || n==0){
            return 0;
        }
        // 判断单个字符是否相等，相等记录
        if(word1.charAt(m-1) == word2.charAt(n-1)){
            return 1 + commonStr(word1,word2,m-1,n-1);
        }else{
            // 不想等的话，需要移动，word1,或者word2的字符位置，并且取两者中最大的为结果
            return Math.max(commonStr(word1,word2,m,n-1),commonStr(word1,word2,m-1,n));
        }
    }


    /**
     * 解法2
     * @param s1
     * @param s2
     * @return
     */
    public static int minDistance2(String s1,String s2){
        int[][] common = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {

                if(i==0 || j==0 )
                    continue;
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    common[i][j] = 1 + common[i-1][j-1];
                    System.out.println(i+"--"+j+"="+common[i][j]);
                }else{
                    common[i][j] = Math.max(common[i-1][j],common[i][j-1]);
                    System.out.println(i+"--"+j+"="+common[i][j]);
                }
            }
        }
        System.out.println(common[s1.length()][s2.length()]);
        return s1.length()+ s2.length() - 2 * common[s1.length()][s2.length()];
    }

    /**
     * 解题思路
     *
     * common[i][j],表示 word1，前i 个字符 和 word2 前j个字符中最长公共子序列
     */
}
