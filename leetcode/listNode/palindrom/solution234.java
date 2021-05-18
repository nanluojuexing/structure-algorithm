package leetcode.listNode.palindrom;

import leetcode.listNode.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * 判断链表是否为回文链表
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * @link https://leetcode-cn.com/problems/palindrome-linked-list/
 */
public class solution234 {

    @Test
    public void test(){

        ListNode listNode = new ListNode(new int[]{1,2,1});
        ListNode listNode1 = new ListNode(new int[]{1,2});
        ListNode listNode2 = new ListNode(new int[]{1,2,2,1});
        //System.out.println(isPalindromeReverseList(listNode));
        //System.out.println(isPalindromeReverseList(listNode1));
        System.out.println(isPalindromeReverseList(listNode2));
    }

    /**
     * 循环遍历解法 时间复杂度O(n),空间复杂度 O(n)
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        // 定义栈
        Stack<Integer> s = new Stack<>();
        // 循环遍历链表将元素一次入栈，例如链表元素是 1-》2-》3 入栈后栈中的元素是 3-》2-》1
        for (ListNode p = head ; p!= null ; p=p.next) {
            s.push(p.val);
        }
        // 然后遍历链表和栈中元素一次弹出对比
        for (ListNode p = head ; p!= null ; p=p.next) {
           if(p.val != s.pop()){
               return false;
           }
        }
        return true;
    }

    /**
     * 链表反转解法   时间复杂度O(n),空间复杂度 O(1)
     * @param head
     * @return
     */
    public boolean isPalindromeReverseList(ListNode head){
        // 遍历链表，获得链表长度
        int len=0;
        for (ListNode p = head ; p!= null ; p=p.next,++len);

        // 将链表拆分并将后半部分反转
        ListNode cur = head,pre=null;
        for (int i =0 ; i < len / 2 ; ++i){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur= next;
        }

        if(len%2 ==1) cur = cur.next;

        for (; pre != null && cur != null; pre = pre.next, cur = cur.next) {
            if (pre.val != cur.val) return false;
        }
        return true;
    }
}

