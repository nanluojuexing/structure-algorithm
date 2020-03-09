package structure.queue;

/**
 * 基于链表实现的队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    public  class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head,tail;
    private int size;

    // 空参构造
    public LinkedListQueue() {
        head= null;
        tail=null;
        size=0;
    }
    // 队列中的元素个数
    @Override
    public int getSize() {
        return size;
    }

    //判断队列是否为空
    @Override
    public boolean isEmpty() {
        return size==0;
    }

    // 入队操作 队列是先入先出
    // 链表为线性结构
    @Override
    public void enqueue(E e) {
        if(tail==null) {
            tail = new Node(e);
            head=tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    //出队操作
    @Override
    public E dequeue() {
        //先判断队列是否为空
        if(isEmpty()) {
            throw new IllegalArgumentException("cannot dequeue from an empty queue");
        }
        // 先入先出，所以出队是移除头部节点
        Node retNode= head;
        head=head.next; // 头节点的下一个节点元素设置为新的头节点
        retNode.next= null; // 移除节点的下一个元素也为null;
        // 避免只有一个元素的情况
        if(head==null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    // 获取头位置元素
    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    // 遍历打印队列
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args){

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
