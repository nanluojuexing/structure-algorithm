package swordoffer;

import leetcode.listNode.ListNode;
import org.junit.Test;

public class MergeTwoListNode {

    @Test
    public void test(){

        ListNode l1 = new ListNode(new int[]{1,2,4});
        ListNode l2 = new ListNode(new int[]{1,3,4});

        System.out.println(mergeTwoLists(l1,l2).toString());
    }



    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(-1);
        ListNode pre = head;

        while (l1 != null && l2 != null){
            if(l1.val<= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
