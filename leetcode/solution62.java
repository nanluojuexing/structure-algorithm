package leetcode;

import java.util.LinkedList;

/**
 * 约瑟夫环
 */
public class solution62 {

    public static void main(String[] args) {

        System.out.println(lastRemaining2(10,17));
    }


    /**
     *
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        // 全部加进去
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        // 只要链表长度不为 1，就不断循环
        while (list.size() != 1) {
            for (int i = 0; i < m; i++) {
                Integer pre = list.pollFirst();
                if (i != m - 1) {
                    list.add(pre);
                }
            }
        }
        return list.pollFirst();
    }

    /**
     * 递归处理
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining2(int n,int m){
        if(n==1){
            return 0;
        }

        if(n==2){
            if( m % 2 == 0){
                return 0;
            }else {
                return 1;
            }
        }else{
            return (lastRemaining2(n-1 , m ) + m ) % n;
        }
    }
}
