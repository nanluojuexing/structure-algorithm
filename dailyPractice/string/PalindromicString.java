package dailyPractice.string;

import org.junit.Test;

/**
 * 给你一个字符串，你要判断它是否是回文字符串。字符串里只考虑字母和数字，其它的字符可以无视。另外，对于字母，可以忽略大小写
 *
 * 比如说，给你的字符串是：
 *
 * " race a E-car "
 *
 * 只考虑字母数字并且忽略大小写，它是一个回文字符串，因此返回 true。再比如说，给你的字符串是
 *
 * " race a car "
 *
 * 对比到最后，中间的 e 和 a 不相等，因此不是一个回文字符串，返回 false
 */
public class PalindromicString {

    @Test
    public void test1(){

        String s = " race a E-car ";
        String s1 = " race a car ";

        System.out.println(isPalindrome(s));
        System.out.println(isPalindrome(s1));
    }

    /**
     * 判断字符是不是字符活着数字
     * @param s
     * @return
     */
    private boolean isAllphanumeric(char c){

        return (c >='a' && c<='z') || (c >='A' && c<='Z') || (c >='0' && c<='9') ;
    }

    /**
     * 忽略大小写，对比两个字符是否相等
     * @param a
     * @param b
     * @return
     */
    private boolean isEqualIgnoreCase(char a,char b){
        if(a>='A' && a <='Z') a+=32;
        if(b>='A' && b <='Z') b+=32;

        return a == b;
    }

    public boolean isPalindrome(String s){

        // 校验字符串
        if(s == null || s.length()==0){
            return true;
        }

        // 遍历字符串，定义两个指针
        int i = 0 , j = s.length()-1;
        for ( ; i < j ; ++i,--j ){
            // 如果不是数字或字符继续移动
            while(i<j && !isAllphanumeric(s.charAt(i))) ++i;
            while(i<j && !isAllphanumeric(s.charAt(j))) --j;
            // 如果是不想等，直接结束对比
            if(i < j && !isEqualIgnoreCase(s.charAt(i),s.charAt(j))){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * 题解：
     * 定义开始，和尾部指针，回文字串，字符前后对比都是一样的
     *
     * i指针 0,向后遍历，如果不是数字或字符跳过继续 ++i
     * j指针为 length-1 ，向前遍历，如果不是数字或字符跳过继续 --j
     *
     * 每次移动都对比字符是否相等，如果不想等，则直接结束，如果相等，继续遍历
     */
}
