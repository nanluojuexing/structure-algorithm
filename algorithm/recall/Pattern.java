package algorithm.recall;

/**
 * @Author: mianba
 * @Date: 2019-08-20 10:27
 * @Description: 回溯算法，正则匹配问题
 */
public class Pattern {

    /**
     * 标记是否匹配
     */
    private boolean matched = false;

    /**
     * 正则表达式
     */
    private char[] pattern;
    /**
     * 正则表达式长度
     */
    private int len;

    public Pattern(char[] pattern, int len) {
        this.pattern = pattern;
        this.len = len;
    }

    /**
     * 匹配字符串
     * @param text
     * @param len
     * @return
     */
    public boolean match(char[] text,int len){
        matched=false;
        rmatch(0,0,text,len);
        System.out.println(text);
        return matched;
    }

    /**
     *
     * @param ti
     * @param pj
     * @param text
     * @param len
     */
    public void rmatch(int ti,int pj,char[] text,int len){
        // 已经完成匹配
        if(matched){
            return;
        }
        // 如果 正则表达式到末尾，，文本串到末位停止递归
        if( pj == len){
            if(ti ==len){
                matched=true;
            }
            return;
        }
        //匹配 任意个字符
        if(pattern[pj] == '*'){
            for (int i = 0; i < len-ti; ++i) {
                rmatch(ti+1,pj+1,text,len);
            }
        }else if (pattern[pj] == '?') { // ? 匹配 0 个或者 1 个字符
            rmatch(ti, pj+1, text, len);
            rmatch(ti+1, pj+1, text, len);
        } else if (ti < len && pattern[pj] == text[ti]) { // 纯字符匹配才行
            rmatch(ti+1, pj+1, text, len);
        }
    }

    public static void main(String[] args) {
        char[] chars= {'*','?'};
        Pattern pattern = new Pattern(chars, 2);
    }
}
