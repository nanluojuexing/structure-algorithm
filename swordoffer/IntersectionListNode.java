package swordoffer;

import leetcode.listNode.ListNode;
import org.junit.Test;

/**
 * 两个链表的交点
 */
public class IntersectionListNode {

    @Test
    public void test(){
        ListNode l1 = new ListNode(new int[]{4,1,8,4,5});
        ListNode l2 = new ListNode(new int[]{5,0,1,8,4,5});
        ListNode node = getIntersectionNode(l1, l2);
        System.out.println(node.val);
    }


    /**
     * 获得链表的交点
     *
     * 设交集链表长c,链表1除交集的长度为a，链表2除交集的长度为b，有
     * a + c + b = b + c + a
     * 若无交集，则a + b = b + a
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}
