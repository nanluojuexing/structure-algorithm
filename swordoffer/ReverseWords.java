package swordoffer;

import org.junit.Test;

public class ReverseWords {

    @Test
    public void test(){

        //System.out.println(reverseWords("the sky is blue"));
        System.out.println(reverseWords(" hello world! "));
    }


    public String reverseWords(String s) {

        String[] s1 = s.trim().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int  i= s1.length-1; i >= 0; i--) {
            if(!s1[i].equals("")){
                if(i==0){
                    builder.append(s1[i]);
                }else {
                    builder.append(s1[i].trim());
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
}
