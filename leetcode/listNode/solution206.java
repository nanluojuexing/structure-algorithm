package leetcode.listNode;

/**
 * 单链表反转
 */
public class solution206 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(reverseList(head));
    }

    public static ListNode reverseList(ListNode head){
        // 当前节点
        ListNode first = head;
        // 虚拟头节点
        ListNode dummyHead = null;
        // 每次循环，都需要将当前节点指向它的pre节点，然后当前节点和 pre节点后移
        while(first != null){
            // 临时节点，接受当前节点的下一个节点
            ListNode node = first.next;
            // 将当前节点指向它前面的节点
            first.next = dummyHead;
            //前指针后移
            dummyHead = first;
            first = node;
        }

        return dummyHead;
    }
}
