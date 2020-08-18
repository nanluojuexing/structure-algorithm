package leetcode.listNode;

/**
 * 求两个链表的交点
 */
public class solution160 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(new int[]{4,1,8,4,5});
        ListNode l2 = new ListNode(new int[]{5,0,1,8,4,5});

        System.out.println(getIntersectionNode(l1,l2).val);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA,b = headB;
        while (a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }
}

/**
 * 题解：
 *
 *
 *
 */
