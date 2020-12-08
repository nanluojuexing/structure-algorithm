package algorithm.kmp;

public class bm {

    public static void main(String[] args) {
        String str     =  "GTTATAGCTGGTAGCGGCGAA";
        String pattern = "GTAGCGGCG";

        System.out.println("第一次出现的位置是"+boyerMore(str,pattern));
    }

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
            // 从后向前遍历
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

}
