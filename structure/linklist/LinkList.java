package structure.linklist;

import java.util.LinkedList;

/**
 * 单向链表
 */
public class LinkList<E> {

    /**
     * 链表节点
     */
    private class Node{
        // 元素
        private E e;
        // 指针，指向下一个节点
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    /*
     * 定一个一节虚拟的头节点
     */
    private Node dummyHead;
    /**
     * 链表中元素的个数
     */
    private int size;

    //空参构造
    public LinkList(){
        dummyHead = new Node();
        size =0;
    }

    /**
     * 获得元素个数
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
        return size==0;
    }

    /**
     * 链表头添加元素
     */
    public void addFirst(E e){
        add(0,e);
    }

    /**
     *   拆入元素，就是遍历到制定位置的索引，获取当前位置的下一个元素
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index < 0 && index > size){
            throw new IllegalArgumentException("add failed, illegal index !");
        }
        // 插入位置的元素设置为头节点
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            // 获取插入位置的前一个元素
            pre = pre.next;
            System.out.println(pre+"《-----");
        }
        //将要添加的节点设置为下一个节点
        // 这里其实三步操作 的合并
        // Node node = new Node(e);//1
        // node.next=prev.next;// 2
        // prev.next=node;// 3
        pre.next=new Node(e,pre.next);
        size++;
    }

    /**
     * 尾部添加元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 获得指定位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if( index < 0 || index > size ){
            throw  new IllegalArgumentException("get fail,index valid");
        }
        // 遍历获得index的节点信息
        Node curNode = dummyHead;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        return curNode.e;
    }

    /**
     * 获得头部位置元素
     * @return
     */
    public E getFirst(){
        return get(0);
    }

    /**
     * 获得尾部位置元素
     * @return
     */
    public E getLast(){
        return get(size-1);
    }

    /**
     * 修改指定位置的元素
     * @param index
     * @param e
     */
    public void set(int index ,E e){
        if( index < 0 || index > size ){
            throw  new IllegalArgumentException("set fail,index valid");
        }
        // 遍历获得index的节点信息
        Node curNode = dummyHead;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        curNode.e = e;
    }

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if( index < 0 || index > size ){
            throw  new IllegalArgumentException("remove fail,index valid");
        }
        // 遍历获得index的前一个节点信息
        Node curNode = dummyHead;
        for (int i = 0; i < index; i++) {
            curNode = curNode.next;
        }
        // 获得 index位置的节点
        Node node = curNode.next;
        //将前一个几点的next节点指向node节点的next节点
        curNode.next = node.next;
        // 这里需要释放引用，方便 gc
        node.next=null;
        size--;

        return node.e;
    }

    /**
     * 删除链表头部元素
     * @return
     */
    public E removeFirst(){
        return remove(0);
    }

    /**
     * 删除链表头部元素
     * @return
     */
    public E removeLast(){
        return remove(size-1);
    }

    /**
     * 删除指定元素
     * @return
     */
    public void removeElement(E e){
        // 设置pre为头节点
        Node pre = dummyHead;
        //遍历找到元素值为e的节点，这里找到的是e的上一个极点
        while(pre.next!= null){
            if(pre.next.e.equals(e)){
                break;
            }
            pre = pre.next;
        }
        // 当前元素的next节点不为空的时候，才存在要删除的元素，存在节点next指针的变化
        if(pre.next != null){
            // 获得要删除的节点
            Node delNode = pre.next;
            pre.next = delNode.next;
            //释放要删除的节点
            delNode = null;
        }
    }

    /**
     * 判断是否包含某个元素
     * @param e
     * @return
     */
    public boolean isContains(E e ){
        Node currNode = dummyHead.next;
        while(currNode!=null){
            if(currNode.e.equals(e)){
                return true;
            }
            currNode = currNode.next;
        }
        return  false;
    }

    /**
     * 遍历
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node curNode = dummyHead.next;
        while(curNode!= null) {
            res.append(curNode+">");
            curNode=curNode.next;
        }
        res.append("NULL");

        return res.toString();
    }

    public static void main(String[] args) {
        LinkList<Integer> linkedList = new LinkList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
