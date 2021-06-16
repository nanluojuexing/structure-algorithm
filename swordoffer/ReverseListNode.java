package swordoffer;

import leetcode.listNode.ListNode;
import org.junit.Test;

/**
 * 反转链表
 */
public class ReverseListNode {

    @Test
    public void test(){
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(reverseList(head));
    }


    public ListNode reverseList(ListNode head) {
        // 当前节点
        ListNode first = head;

        // 定义虚拟头节点
        ListNode dummy = null;
        //遍历节点
        while ( first !=null ){
            // 先获取后面的节点
            ListNode node = first.next;
            // 将first的next节点指向dummy
            first.next = dummy;
            dummy = first;
            first = node;
        }
        return dummy;
    }
}
