package leetcode.string.palindromeString;

/**
 *
 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

 说明：本题中，我们将空字符串定义为有效的回文串。

 示例 1:

 输入: "A man, a plan, a canal: Panama"
 输出: true
 示例 2:

 输入: "race a car"
 输出: false
 @link https://leetcode-cn.com/problems/valid-palindrome/
 */
public class solution125 {

    public boolean isAllphanumeric(char c){
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
}
