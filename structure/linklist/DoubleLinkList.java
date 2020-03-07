package structure.linklist;

/**
 * @Author: mianba
 * @Date: 2019/11/8 15:51
 * @Description: 双向链表
 */
public class DoubleLinkList<T> {

    private class Node<T>{

        //元素
        private T val;

        //前置节点
        private Node<T> pre;

        // 后置节点
        private Node<T> next;

        public Node() {
        }

        public Node(T val, Node<T> pre, Node<T> next) {
            super();
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    //记录元素个数，链表长度
    private int size;

    // 头部节点
    private Node<T> head;

    //尾部节点
    private Node<T> tail;

    /**
     * 默认构造方法，初始化空链表
     */
    public DoubleLinkList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getSize(){
        return size;
    }

    /**
     * 链表是否为空
     * @return
     */
    public boolean isEmpty(){
        return  size==0;
    }

    /**
     * 通过下标位置获得链表中的节点
     * @param index
     * @return
     */
    public Node<T> getNode(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("get failed; index valid");
        }
        Node<T> cur;
        //对半查找，如果 index 小于链表长度的一般，从头部开始查
        if(index <= size/2){
            cur = head;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
        }else {
            //当索引值位于链表的后半段时，则从链表的另一端开始找是最快的
            cur = tail;
            for (int i = size-1; i >= index+1; i--) {
                cur = cur.pre;
            }
        }
        return cur;
    }

    /**
     * 获得当前节点的值
     * @param index
     * @return
     */
    public T getVal(int index){
        return getNode(index).val;
    }

    /**
     * 获得第一个节点的值
     * @return
     */
    public T getFirst(){
        return getNode(0).val;
    }

    /**
     * 获得最后一个节点的值
     * @return
     */
    public T getLast(){
        return getNode(size-1).val;
    }

    /**
     * 指定位置插入元素
     * @param index
     * @param val
     */
    public void add(int index, T val){

        if(index < 0 || index > size){
            throw new IllegalArgumentException("add failed ! index error");
        }
        // 判断是否为空
        if(head == null){
            head = new Node<>(val,null,null);
            tail = head;
        }else{
            // 头部位置插入元素
            if(index == 0){
                //头部插入，所有当前head节点为插入节点的next节点
                Node<T> newNode = new Node<>(val,null,head);
                //将head节点的前置指针指向 要插入的新节点
                head.pre= newNode;
                //将头部节点替换为新插入的节点
                head = newNode;
            }else if(index == size){
                //尾部插入，当前tail节点为插入节点的 pre 节点
                Node<T> newNode = new Node<>(val,tail,null);
                //将 tail 节点的 后置 指针指向 要插入的新节点
                tail.next= newNode;
                //将 尾部节点替换为新插入的节点
                tail=newNode;
            }else {
                // 创建新的节点
                Node<T> newNode = new Node<>(val,null,null);
                // 获得要插入位置的当前节点
                Node<T> cur = getNode(index);
                //将当前节点的前一个节点的后置指针指向要插入的节点
                cur.pre.next = newNode;
                // 将新插入节点的前置指针指向 当前节点前置节点
                newNode.pre = cur.pre;
                //当前节点的前置节点 指向 新的节点
                cur.pre = newNode;
                // 新节点的 next 节点为下一个节点
                newNode.next = cur;
            }
        }
        // 长度增加
        size++;
    }

    /**
     * 直接增加元素
     * @param val
     */
    public void addVal(T val){
        addLast(val);
    }

    /**
     * 头部位置添加元素
     * @param val
     */
    public void addFirst(T val){
        add(0,val);
    }

    /**
     * 尾部添加元素
     * @param val
     */
    public void addLast(T val){
        add(size,val);
    }

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    public T removeElement(int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("remove failed ! index valid");
        }
        T old ;
        if(index==0){
            old = head.val;
            head.next.pre=null;
            head = head.next;
        }else if(size-1 == index){
            old = tail.val;
            tail.pre.next = null;
            tail = tail.next;
        }else{
            //查到当前节点
            Node<T> curNode = getNode(index);
            old = curNode.val;
            curNode.pre.next = curNode.next;
            curNode.next.pre = curNode.pre;
        }
        size--;
        return old;
    }

    /**
     * 移除第一个元素
     * @return
     */
    public T removeFirst(){
        return removeElement(0);
    }

    /**
     * 移除最后一个元素
     * @return
     */
    public T removeLast(){
        return removeElement(size-1);
    }

    /**
     * 输出链表中的所有元素
     */
    public void printAll() {
        System.out.print(this.getClass().getSimpleName() + "：[");
        Node<T> current = head;
        while(current!=null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        DoubleLinkList<Integer> linked = new DoubleLinkList<>();
        linked.addVal(1);
        linked.addVal(2);
        linked.addVal(3);
        linked.addVal(4);
        linked.printAll();

        System.out.println("插入元素位置之前");

        linked.add(3, 6);
        System.out.println("插入元素位置之后-----");
        // 遍历
        linked.printAll();

        System.out.println("删除元素位置之前");
        linked.removeLast();

        System.out.println("删除元素位置之后");
        linked.printAll();

        System.out.println();

        System.out.println(linked.getVal(2).toString());
    }
}
