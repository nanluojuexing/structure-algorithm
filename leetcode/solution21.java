package leetcode;

/**
 * @Author: mianba
 * @Date: 2019-08-26 15:27
 * @Description: 合并两个有序链表
 */
public class solution21 {
    public static void main(String[] args) {

        ListNode21 l1 = new ListNode21(new int[]{1,2,4});
        ListNode21 l2 = new ListNode21(new int[]{1,3,4});

        System.out.println(mergeTwoLists(l1,l2).toString());
    }

    public static ListNode21 mergeTwoLists(ListNode21 l1, ListNode21 l2) {

        ListNode21 head = new ListNode21(-1);

        ListNode21 pre = head;
        while(l1 != null && l2 != null){

            if(l1.val <= l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next =l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1==null ? l2 : l1;

        return head.next;
    }
}


class ListNode21{

    int val;

    ListNode21 next;

    ListNode21(int x){
        val = x;
    }

    public ListNode21(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode21 cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode21(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode21 cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}
