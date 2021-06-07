package swordoffer;

import leetcode.listNode.ListNode;
import org.junit.Test;

public class DeleteNode {

    @Test
    public void test(){

        ListNode listNode = new ListNode(new int[]{4,5,1,9});

        System.out.println(deleteNode(listNode,4));

    }


    public ListNode deleteNode(ListNode head, int val) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = dummy;
        // 依次遍历，获取值相等元素
        while (cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
