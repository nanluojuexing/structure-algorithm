package algorithm.kmp;

/**
 *
 */
public class rabinKarp {

    public static void main(String[] args) {
        String str = "aacdesadsdfer";
        String pattern = "adsd";

        System.out.println("第一次出现的位置是"+rabinKarp(str,pattern));
    }

    /**
     * 匹配算法
     * @param str 目标串
     * @param pattern 匹配串
     * @return 返回第一次出现的位置
     */
    public static int rabinKarp(String str,String pattern){
        // 获取目标串的长度
        int m = str.length();
        // 模式串的长度
        int n = pattern.length();
        //计算模式串的hash值
        int patternCode = hash(pattern);
        // 计算第一个与模式串对比的hash值
        int strCode = hash(str.substring(0,n));
        // 遍历主串，挨个匹配与模式串对比hash值
        for (int i = 0; i < m-n+1 ; i++) {
            // 这里出了hash值相同外，需要对比截取后串是否和模式串匹配，避免出现 adsd 或者 asdd 的情况，这里hash算法是针对字符求和
            if (strCode==patternCode && compareStr(i,str,pattern)){
                return i;
            }
            if(m-n > i){
                strCode = nextHash(str,strCode,i,n);
            }
        }
        return -1;
    }

    /**
     * 移动主串位置，重新计算字符和
     * @param str
     * @param hash
     * @param i
     * @param n
     * @return
     */
    private static int nextHash(String str, int hash, int i, int n) {
        hash -= str.charAt(i)-'a';
        hash += str.charAt(i+n)-'a';
        return hash;
    }

    /**
     * 对比模式串和截取后的串进行对比，如果相同就返回true
     * @param i
     * @param str
     * @param pattern
     * @return
     */
    private static boolean compareStr(int i,String str,String pattern) {
        String splitStr = str.substring(i, i + pattern.length());
        return splitStr.equals(pattern);
    }

    private static int hash(String pattern) {
        int hashcode =0;
        for (int i = 0; i < pattern.length(); i++) {
            hashcode += pattern.charAt(i)-'a';
        }
        return hashcode;
    }

}
