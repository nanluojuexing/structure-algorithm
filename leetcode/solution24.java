package leetcode;

/**
 * @Author: mianba
 * @Date: 2019-08-26 15:25
 * @Description: 24. 两两交换链表中的节点
 */
public class solution24 {
    public static void main(String[] args) {

        ListNode l1 = new ListNode(new int[]{1,2,3,4});

        System.out.println(swapPairs(l1).toString());
    }

    public static ListNode swapPairs(ListNode head) {

        if(head == null){
            return head;
        }
        ListNode pre = new ListNode(-1);
        ListNode curr = head;// 当前节点
        pre.next = head;
        if( curr.next != null){
            // 把 当前节点的下一个节点置为头节点
            head = curr.next;// 有两个节点的就可以交换
            while(curr != null && curr.next != null){
                // pre.next指向交换节点之后呃第二个节点
                pre.next = curr.next;
                // 保存下一个节点de开始节点
                ListNode next = curr.next.next;
                // 交换节点
                curr.next.next= curr;
                curr.next=next;
                // 交换完毕
                pre = curr;
                curr = next;
            }
        }
        return head;
    }
}

