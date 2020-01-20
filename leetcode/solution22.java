package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成对应数量的括号
 */
public class solution22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2).toString());
    }

    public static List<String> generateParenthesis(int n){
        ArrayList<String> result = new ArrayList<>();
        String s = new String();
        generate(result,s,n,n);
        return result;
    }

    public static  void generate(List<String> result,String s,int a,int b){
        if(a > b){
            return;
        }
        if(a > 0){
            generate(result,s+"(",a-1,b);
        }

        if(b > 0){
            generate(result,s+")",a,b-1);
        }
        if(a==0 && b==0){
            result.add(s);
            return;
        }
    }
}
