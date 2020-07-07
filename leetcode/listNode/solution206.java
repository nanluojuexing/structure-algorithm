package leetcode.listNode;

/**
 * 单链表反转
 */
public class solution206 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode206 head = new ListNode206(nums);
        System.out.println(head);

        System.out.println(reverseList(head));
    }

    public static ListNode206 reverseList(ListNode206 head){
        // 当前节点
        ListNode206 first = head;
        // 虚拟头节点
        ListNode206 dummyHead = null;
        // 每次循环，都需要将当前节点指向它的pre节点，然后当前节点和 pre节点后移
        while(first != null){
            // 临时节点，接受当前节点的下一个节点
            ListNode206 node = first.next;
            // 将当前节点指向它前面的节点
            first.next = dummyHead;
            //前指针后移
            dummyHead = first;
            first = node;
        }

        return dummyHead;
    }
}

class ListNode206 {
    int val;
    ListNode206 next;

    ListNode206(int x){
        val = x ;
    }

    public ListNode206(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode206 cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode206(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode206 cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
