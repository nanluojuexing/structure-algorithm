package algorithm.self;

/**
 * 给定字符串str，写一个函数，去除str中连续重复的字符。
 * 例如：str="aaabbcdeaa"，返回"abcdea"
 */
public class solution_self {

    public static void main(String[] args) {
        System.out.println(distinct("aaabbcdeaa"));
    }

    public static String distinct(String string){
        //定义接受的字符串
        String newstring = "";
        //定义移动的指针
        //记录不重复元素的位置
        int i = 0;
        int j = i+1;
        // 将第一个位置的字符先让添加到字符串中
        newstring = newstring + string.charAt(i);
        // 循环遍历
        while( j < string.length()){
            // 如果重复，指针j 向后移动
            if( string.charAt(i) == string.charAt(j)){
                j++;
            }else{ // 不重复的话，交互指针 i=j，同时j 向后移动一位
                i = j;
                j = i+1;
                newstring = newstring + string.charAt(i);
            }
        }
        return newstring;
    }

}
