package leetcode.listNode;

import leetcode.listNode.ListNode;

/**
 * 合并K个排序链表
 */
public class solution23 {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(new int[]{1,4,5});
        lists[1] = new ListNode(new int[]{1,3,4});
        lists[2] = new ListNode(new int[]{2,6});

        System.out.println(mergeKLists(lists).toString());
    }
    public static ListNode mergeKLists(ListNode[] lists){
        // 判断处理临界条件,处理为空的情况
        if(lists == null || lists.length ==0){
            return null;
        }
        if(lists.length==1){
            return lists[0];
        }
        return mergeSort(lists,0,lists.length-1);
    }

    /**
     * 归并合并处理
     * @param lists
     * @return
     */
    public static ListNode mergeSort(ListNode[] lists,int start,int end){
        // 定义起始位置和终止位置
        if(start < end){
            //获取中间位置，进行分治处理
            int mid = (start + end ) / 2;
            ListNode list1 = mergeSort(lists, start, mid);
            ListNode list2= mergeSort(lists, mid +1, end);

           return merge(list1,list2);
        }else if(start == end){
            return lists[start];
        }else{
            return null;
        }
    }

    public static ListNode merge(ListNode list1,ListNode list2){
        // 处理临界条件
        if(list1 == null && list2 ==null){
            return null;
        }

        if(list1 ==null){
            return  list2;
        }
        if(list2 == null){
            return list1;
        }
        // 如果都不为空，定义开始的节点位置，定义为当前节点
        ListNode dummyNode = new ListNode(-1);
        ListNode curr = dummyNode;
        while(list1 != null && list2 != null){
            // 判断节点值的大小
            if(list1.val < list2.val){
                // 将节点1的放置在当前节点的后面
                curr.next=list1;
                // 将当前节点设置为 listNode1;
                curr=list1;
                //
                list1 = list1.next;
            }else{
                curr.next= list2;
                curr = list2;
                list2 = list2.next;
            }
        }

        if(list1 != null){
            curr.next = list1;
        }

        if(list2 != null){
            curr.next = list2;
        }

        return  dummyNode.next;
    }



}

