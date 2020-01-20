package leetcode;

/**
 * 删除链表中的节点
 */
public class solution237 {
    public static void main(String[] args) {

        ListNode head = new ListNode(new int[]{4,1,5,9});
        ListNode node = new ListNode(5);

        deleteNode(node);

        System.out.println(head.toString());
    }

    /**
     * 题解：
     *
     * @param node
     */
    public static void deleteNode(ListNode node) {
        node.val =  node.next.val;
        node.next = node.next.next;
    }

    /**
     * 删除链表中的元素
     */
    public static void removeNode(ListNode node) {
        node.val =  node.next.val;
        node.next = node.next.next;
    }
}
