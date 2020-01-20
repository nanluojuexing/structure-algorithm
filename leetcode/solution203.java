package leetcode;

/**
 * 删除链表中等于给定值的元素
 */
public class solution203 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode203 head = new ListNode203(nums);
        System.out.println(head);

        ListNode203 res = removeElement(head,6);
        System.out.println(res);
    }

    public static ListNode203 removeElement(ListNode203 head, int val){

        //处理头节点，移除后的头节点还是等于移除额元素，所以需要循环处理
        while(head!=null && head.val==val){
            head=head.next;
        }
        //可能所有的头节点都为要移除的元素，所以此时链表已经为空
        if(head==null)
            return head;

        // 移除位置在中间位置的指定元素
        ListNode203 prev = head;// 循环遍历头节点的下一个元素
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

class ListNode203 {
    int val;
    ListNode203 next;

    ListNode203(int x){
        val = x ;
    }

    public ListNode203(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode203 cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode203(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode203 cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
