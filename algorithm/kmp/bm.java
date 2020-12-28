package algorithm.kmp;

public class bm {

    public static void main(String[] args) {
        String str     =  "GTTATAGCTGGTAGCGGCGAA";
        String pattern = "GTAGCGGCG";

        System.out.println("第一次出现的位置是"+boyerMore(str,pattern));
    }

    /**
     * 基于坏字符规则，移送的实现
     * @param str
     * @param pattern
     * @return
     */
    private static int boyerMore(String str, String pattern) {
        // 主串长度
        int m = str.length();
        // 模式串长度
        int n = pattern.length();

        // 定义模式串的起始位置
        int start =0;
        while (start <= m - n ){
            // 定义变量
            int i;
            // 模式串从后向前遍历
            for (i = n-1;i>=0;i--) {
                // 从后向前遍历，校验坏字符
                if (str.charAt(start + i) != pattern.charAt(i)) {
                    // 如果出现坏字符，跳出比较
                    break;
                }
            }
            // 如果i =0,说明字符匹配成功
            if(i<0){
                return start;
            }
            // 寻找坏字符在模式中的对应
            int charIndex = findPosition(pattern,str.charAt(start+i),i);
            int backOffset = charIndex >= 0 ? i-charIndex : i+1;
            start += backOffset;
        }
        return -1;
    }

    /**
     *
     * @param pattern
     * @param charAt
     * @param i
     * @return
     */
    private static int findPosition(String pattern, char charAt, int i) {
        for (int j = i-1; j >=0 ; j--) {
            if(pattern.charAt(j) == charAt){
                return j;
            }
        }
        return -1;
    }

    // 全局变量或成员变量
    private static final int SIZE = 256;

    /**
     * 基于后缀优化的实现
     * @param a 主串的字符数组
     * @param n 主串长度
     * @param b 模式串字符数组
     * @param m 模式串长度
     * @return
     */
    private int bm(char[] a,int n, char[] b,int m){
        // 记录模式串每个字符最后出现的位置
        int[] bc = new int[SIZE];
        generateBC(b,m,bc);
        int[] suffix = new int[m];
        boolean[] prefix = new boolean[m];
        generateGS(b,m,suffix,prefix);
        // i表示主串与模式串对齐的第一个字符
        int i =0;
        while(i<=n-m){
            int j ;
            // 模式串从后往前匹配
            for (j = m-1; j >=0 ; j--) {
                // 坏字符对应模式串中的下标是j
                if(a[i+j] != b[j]){
                    break;
                }
            }
            // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            if (j < 0) {
                return i;
            }
            int x = j - bc[(int)a[i+j]];
            int y = 0;
            if(j<m-1){
                y = moveByGS(j,m,suffix,prefix);
            }
            i = i + Math.max(x,y);
        }

        return -1;
    }

    private int moveByGS(int j, int m, int[] suffix, boolean[] prefix) {
        // 好后缀长度
        int k = m - 1 - j;
        if (suffix[k] != -1)
            return j - suffix[k] +1;

        for (int r = j+2; r <= m-1; ++r) {
            if (prefix[m-r] == true) {
                return r;
            }
        }
        return m;
    }

    /**
     * 匹配坏字符
     * @param b 模式串 字符数组
     * @param m 模式串长度
     * @param bc 散列表，统计字符在模式串中出现的位置，相同的记录最后一个
     */
    private void generateBC(char[] b,int m ,int[] bc){
        for (int i = 0; i < SIZE; ++i) {
            // 初始化bc
            bc[i] = -1;
        }
        for (int i = 0; i < m; ++i) {
            // 计算b[i]的ASCII值 bc[ascii] = i;
            int ascii = (int)b[i];
        }
    }

    /**
     *
     * @param b
     * @param m 模式串长度
     * @param suffix
     * @param prefix
     */
    private void generateGS(char[] b, int m, int[] suffix, boolean[] prefix) {
        for (int i = 0; i < m; ++i) {
            suffix[i] = -1;
            prefix[i] = false;
        }
        // b[0, i]
        for (int i = 0; i < m - 1; ++i) {
            int j = i;
            // 公共后缀子串长度
            int k = 0;
            // 与b[0, m-1]求公共后缀子串
            while (j >= 0 && b[j] == b[m-1-k]) {
                --j;
                ++k;
                //j+1表示公共后缀子串在b[0, i]中的起始下标
                suffix[k] = j+1;
            }
            //如果公共后缀子串也是模式串的前缀子串
            if (j == -1) prefix[k] = true;
        }
    }

}
