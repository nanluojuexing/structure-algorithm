package swordoffer;

import leetcode.listNode.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * 从尾到头打印链表
 *
 *
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 *
 *
 * 示例 1：
 *
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 */
public class ReversePrintListNode {


    @Test
    public void test(){
       ListNode listNode = new ListNode(new int[]{1,3,2});
       System.out.println(Arrays.toString(reversePrint(listNode)));
    }

    public int[] reversePrint(ListNode head) {

        // 计算链表长度
        int count =0;
        ListNode node = head;
        while(node != null){
            count++;
            node= node.next;
        }

        // 构建数组
        int[] result = new int[count];
        ListNode cur= head;
        // 倒序遍历数组，将链表值存放进去
        for (int i = count-1; i >=0 ; i--) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }
}
