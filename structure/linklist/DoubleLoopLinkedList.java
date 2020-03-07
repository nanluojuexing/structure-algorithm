package structure.linklist;

/**
 * 双向循环列表
 */
public class DoubleLoopLinkedList<T> {

    private class Node<T>{

        //元素
        private T val;

        //前置节点
        private Node<T> pre;

        // 后置节点
        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }

     // 头部节点
    private Node<T> head;

    //尾部节点
    private Node<T> tail;

    private int size;

    /**
     *  初始化的时候，只有一个空节点，所有头节点的指针都是自己，尾节点的前置节点也是head;
     */
    public DoubleLoopLinkedList() {
        this.head = new Node<>(null);
        head.next = head;
        head.pre = head;
        tail = head.pre;
        size=0;
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 判断是否为空
     * @return
     */
    public boolean isEmpty(){
        if(head.next == head){
            return true;
        }
        return false;
    }

    /**
     * 直接往尾部添加元素
     * @param val
     */
    public void add(T val){

        Node newNode = new Node<>(val);
        //链表为空
        if(isEmpty()){
            newNode.pre = head;
            newNode.next = head;
            head.next = newNode;
            head.pre = newNode;
            //尾部节点为新添加的节点
            tail = newNode;
        }else{
            newNode.pre = tail;
            // 添加到尾部的，所以next指针应该指向头节点
            newNode.next = head;
            head.pre = newNode;
            tail.next = newNode;
            // 最后将新的节点职位尾节点
            tail = newNode;
        }
        size++;
    }

    /**
     * 指定索引位置添加元素
     * @param index
     * @param val
     */
    public void add(int index,T val){

        if(index < 0 || index>size){
            throw new IllegalArgumentException("add failed,index valid!");
        }
        Node newNode = new Node<>(val);
        //判断是否为空
        if(head.next == head){
            add(val);
        }else{
            int i =0;
            // 定义位置记录几点，从头节点开始
            Node pos = head;
            // 判断i的索引位置，并且不是尾部节点
            while( pos.next!= tail && i < index){
                pos = pos.next;
                i++;
            }

            // 插入新的节点 ,指针变化
            newNode.next = pos.next;
            newNode.pre = pos;
            pos.next.pre = newNode;
            pos.next = newNode;

            size++;
        }
    }

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    public T remove(int index){
        if(index<0 || index > size-1){
            throw new IllegalArgumentException("remove failed,index valid!");
        }
        //判断是不是空链表
        if(head.next == head){
            throw new IllegalArgumentException("链表为空");

        }
        int i =0;
        Node pos = head;
        while( pos.next!= tail && i < index){
            pos = pos.next;
            i++;
        }
        T oldval = (T) pos.next.val;
        pos.next.next.pre = pos;
        pos.next = pos.next.next;
        size --;

        return oldval;
    }

    /**
     * 获得指定索引位置的元素
     * @param index
     * @return
     */
    public T getIndex(int index){
        if(index<0 || index > size-1){
            throw new IllegalArgumentException("get failed,index valid!");
        }
        //判断是不是空链表
        if( head.next == head ){
            throw new IllegalArgumentException("链表为空");
        }
        int i =0;
        Node pos = head;
        while( pos.next!= tail && i < index){
            pos = pos.next;
            i++;
        }
        return (T) pos.next.val;
    }

    /**
     * 判断是否包含元素
     * @param val
     * @return
     */
    public boolean contains(T val) {
        Node pos = head;
        while (pos.next != tail) {
            pos = pos.next;
            if (pos.val.equals(val)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取指定元素所在的索引
     *
     * @param data
     * @return
     */
    public int indexOf(Object data) {
        Node pos = head;
        int i = 0;
        while (pos.next != tail) {
            pos = pos.next;
            if (pos.val.equals(data)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /**
     * 打印链表的所有元素
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(getIndex(i) + "-->");
        }
    }

    public static void main(String[] args) {
        DoubleLoopLinkedList<Integer> linked = new DoubleLoopLinkedList<>();
        linked.add(1);
        linked.add(2);
        linked.add(3);
        linked.add(4);

        linked.show();

        System.out.println();
        linked.add(3, 6);
        linked.show();

        System.out.println("删除元素位置之前");
        linked.remove(2);
        System.out.println("删除元素位置之后");
       linked.show();

        System.out.println();

        System.out.println(linked.getIndex(2).toString());
    }
}
