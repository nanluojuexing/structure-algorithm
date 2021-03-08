package leetcode.listNode;

/**
 * 删除链表中等于给定值的元素
 */
public class solution203 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = removeElement(head,6);
        System.out.println(res);
    }

    public static ListNode removeElement(ListNode head, int val){

        //处理头节点，移除后的头节点还是等于移除额元素，所以需要循环处理
        while(head!=null && head.val==val){
            head=head.next;
        }
        //可能所有的头节点都为要移除的元素，所以此时链表已经为空
        if(head==null)
            return head;

        // 移除位置在中间位置的指定元素
        ListNode prev = head;// 循环遍历头节点的下一个元素
        while(prev.next!=null){
            if(prev.next.val == val){
                prev.next=prev.next.next;
            }else{
                prev=prev.next;
            }
        }
        return head;
    }

}
