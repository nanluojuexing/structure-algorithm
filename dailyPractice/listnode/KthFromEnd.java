package dailyPractice.listnode;

/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点
 *
 * 链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 */
public class KthFromEnd {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        ListNode end = getKthFromEnd(new ListNode(nums),7);
        System.out.println(end.toString());
    }

    /**
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd(ListNode head, int k) {

        if(head==null || k ==0){
            return null;
        }
        // 初始化两个移动指针,都指向头节点
        ListNode former = head,latter = head;
        for (int i = 0; i < k ; i++) {
            // 处理临界条件
            if(former == null){
                return null;
            }
            former = former.next;
        }

        while(former != null){
            former = former.next;
            latter=latter.next;
        }
        return latter;
    }

    /**
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {

        if(head==null || k ==0){
            return null;
        }
        // 初始化两个移动指针,都指向头节点
        ListNode former = head,latter = head;
        for (int i = 0; i < k ; i++) {
            former = former.next;
        }

        while(former != null){
            former = former.next;
            latter=latter.next;
        }
        return latter;
    }
}
