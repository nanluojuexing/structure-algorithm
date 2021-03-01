package leetcode.math;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果 可以变为  1，那么这个数就是快乐数。
 * 如果 n 是快乐数就返回 true ；不是，则返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：19
 * 输出：true
 * 解释：
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/problems/happy-number
 */
public class HappyNumber_202 {

    @Test
    public void test1(){
        System.out.println(isHappy(19));
    }

    @Test
    public void test2(){
        System.out.println(isHappy(2));
    }

    public boolean isHappy(int n) {
        // 定义集合存储已经得到的元素
        Set<Integer> seen = new HashSet<>();
        while( n != 1 && !seen.contains( n) ){
            seen.add(n);
            n = getNext(n);
        }
        return n==1;
    }

    public int getNext(int n){
        int result = 0;
        while ( n > 0 ){
            int a = n % 10;
            n = n / 10;
            result += a * a ;
        }
        return result;
    }
}
