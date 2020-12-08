package leetcode.listNode;

import org.junit.Test;

/**
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *
 * 如果链表中存在环，则返回 true 。 否则，返回 false
 *
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle
 */
public class solution141 {

    @Test
    public void test1(){
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(8);
        ListNode node7 = new ListNode(1);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next= node6;
        node6.next= node7;
        node7.next=node4;
        // 判断链表是否有环
        System.out.println(hasCycle(node1));
    }

    /**
     * 定义双指针,p1每次移动一位，p2每次移动两位，如果存在环型，p2将再次追到p1
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null &&p2.next!= null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                return true;
            }
        }
        return false;
    }
}
