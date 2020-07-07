package leetcode.listNode;

import leetcode.listNode.ListNode;

/**
 * 删除有序链表的重复节点
 */
public class solution83 {

    public static void main(String[] args) {

        ListNode head = new ListNode(new int[]{1,1,2,2,3,3});

        System.out.println(deleteDuplicates(head).toString());
    }

    public static ListNode deleteDuplicates(ListNode head) {

        // 获得当前节点
        ListNode curr = head;
        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                ListNode node = curr.next;
                curr.next = node.next;
                //释放指针
                node = null;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

}
