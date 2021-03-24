package leetcode.listNode.reverse;

import leetcode.listNode.ListNode;
import org.junit.Test;

/**
 * 反转链表
 * 给你单链表的头指针 head 和两个整数left 和 right ，其中left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 *
 * 示例 1：
 *
 *
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 *
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 *
 * 提示：
 *
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 */
public class solution92 {

    @Test
    public void test(){

        ListNode head = new ListNode(new int[]{1,2,3,4,5});

        System.out.println(reverseBetween(head,2,4).toString());
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 定义临时节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode pre = dummyHead;
        // 遍历截取链表 只保留 m 到尾部的元素
        for (int i = 0; i < m-1; i++) {
            pre= pre.next;
        }

        ListNode right = pre;
        // 在 pre 的基础上 遍历向右移动  n-m+1位，获得最终需要反转的链表
        for (int i = 0; i < n-m+1 ; i++) {
            right = right.next;
        }

        // 切断链表
        ListNode left = pre.next ;
        ListNode curr = right.next;
        pre.next = null;
        right.next = null;

        reverseListNode(left);

        // 第 5 步：接回到原来的链表中
        pre.next = right;
        left.next = curr;
        return dummyHead.next;
    }

    public ListNode reverseListNode(ListNode head){
        // 定义当前节点
        ListNode first = head;
        // 虚拟头节点
        ListNode dummyHead = null;

        // 循环遍历
        while(first != null ){
            // 当前节点的下一个节点
            ListNode node = first.next;
            first.next = dummyHead;
            // 将当前节点执行赋值
            dummyHead = first;
            first = node;
        }
        return dummyHead;
    }

    /**
     * 区间 反转链表解法2
     * @param head
     * @param m 左区间
     * @param n
     * @return
     */
    public ListNode reverseBetween2(ListNode head, int m, int n){
        // 定义临时节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next= head;
        ListNode pre = dummyHead;

        for (int i = 0; i < m-1 ; i++) {
            pre=pre.next;
        }
        // 获取当前链表
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < n-m; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyHead.next;
    }
}
