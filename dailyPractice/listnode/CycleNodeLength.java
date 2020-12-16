package dailyPractice.listnode;

import org.junit.Test;

/**
 * 1. 环型链表环的长度'
 *
 * 2. 环型链表 入环节点
 */
public class CycleNodeLength {

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
        System.out.println(getCycleLength(node1));
        System.out.println(getCycleNodeValue(node1));
    }

    /**
     * 环型链表，环的长度
     * @param head
     * @return
     */
    public int getCycleLength(ListNode head){

        if(head == null){
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 先判断链表是否能存在环
        while (fast!= null && fast.next!= null){
            fast= fast.next.next;
            slow= slow.next;
            //当快指针和慢指针相等的时候，说明链表存在环
            if(fast == slow){
                // 从环位置开始，每次移动一个指针就可以，循环一边，当到达起始位置的时候，就可以获得链表环型的长度
                fast = fast.next;
                // 定义常量，记录起始位置
                int len = 1;
                // 当节点不想等的时候累加
                while(slow != fast){
                    len++;
                    // 移动指针
                    fast=fast.next;
                }
                return len;
            }
        }
        return 0;
    }

    /**
     *
     * @param head
     * @return
     */
    public int getCycleNodeValue(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        // 先判断链表是否能存在环
        while (fast!= null && fast.next!= null){
            fast= fast.next.next;
            slow= slow.next;
            //当快指针和慢指针相等的时候，说明链表存在环
            if(fast == slow){
                fast = head;
                while (slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow.val;
            }
        }
        return 0;
    }
}
