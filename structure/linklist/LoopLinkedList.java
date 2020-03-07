package structure.linklist;

/**
 * 单向循环链表
 */
public class LoopLinkedList<E> {

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
    private Node head;

    /**
     * 位置节点
     */
    private Node pos;
    /**
     * 链表中元素的个数
     */
    private int size;

    //空参构造
    public LoopLinkedList(){
        // 创建空节点
        head = new Node();
        // 空节点的下一个节点也是头节点，此时只有一个节点
        head.next = head;
        // 定义 一个位置记录节点
        pos = head;
        size =0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return  size==0;
    }

    /**
     * 直接添加元素，添加在末尾
     * @param e
     */
    public void add(E e){
        //创建节点
        Node newNode = new Node(e);
        //如果只有头节点，直接将新的添加到头节点的next指针，并将新节点的next指针指向头节点
        if(head.next == head){
            head.next= newNode;
            newNode.next = head;
        }else{
            // 寻找位置节点
            pos = head;
            while(pos.next!= head){
                pos= pos.next;
            }
            pos.next = newNode;
            newNode.next = head;
        }
        size++;
    }

    /**
     * 指定位置插入元素
     * @param index
     * @param e
     */
    public void add(int index ,E e){
        if(index< 0 || index>size){
            throw new IllegalArgumentException("add failed, index valid!");
        }
        int i =0;
        pos = head;
        Node newNode = new Node(e);
        //遍历查找index位置的节点，实际找到的是index位置的前一个节点
        while(pos.next!= head && i<index){
            pos = pos.next;
            i++;
        }
        newNode.next= pos.next;
        pos.next= newNode;
        size++;
    }

    /**
     * 移除指定位置的元素
     * @param index
     * @return
     */
    public E remove(int index){
        if(index< 0 || index>size){
            throw new IllegalArgumentException("remove failed, index valid!");
        }
        int i =0;
        pos = head;
        //遍历查找index位置的节点，实际找到的是index位置的前一个节点
        while(pos.next!= head && i<index){
            pos = pos.next;
            i++;
        }
        E val = pos.next.e;
        // 移除index位置节点，所有pos的指针指向下下一个节点
        pos.next = pos.next.next;
        size --;
        return val;
    }

    /**
     * 替换指定索引位置的元素
     * @param index
     * @param e
     * @return
     */
    public E set(int index,E e){

        if(index< 0 || index>size){
            throw new IllegalArgumentException("set failed, index valid!");
        }
        int i =0;
        pos = head;
        //遍历查找index位置的节点，实际找到的是index位置的前一个节点
        while(pos.next!= head && i<index){
            pos = pos.next;
            i++;
        }
        // 获取旧的值
        E val = pos.next.e;
        // 将新值付给原来的节点
        pos.next.e = e;

        return val;
    }

    /**
     * 根据索引位置获取元素
     * @param index
     * @return
     */
    public E get(int index){

        if(index< 0 || index>size){
            throw new IllegalArgumentException("get failed, index valid!");
        }
        int i =0;
        pos = head;
        //遍历查找index位置的节点，实际找到的是index位置的前一个节点
        while(pos.next!= head && i<index){
            pos = pos.next;
            i++;
        }
        return pos.next.e;
    }

    /**
     * 查询元素的索引位置
     * @param e
     * @return
     */
    public int indexOf(E e){
        int i = 0;
        pos = head;
        while(pos.next!= head){
           pos = pos.next;
           if(pos.e.equals(e)){
               return i;
           }
           i++;
        }
        return 1;
    }

    /**
     * 查询元素的索引位置
     * @param e
     * @return
     */
    public boolean contains(E e){
        pos = head;
        while(pos.next!= head){
            pos = pos.next;
            if(pos.e.equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * 打印链表
     */
    public void show() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.get(i) + "-->");
        }
    }

    public static void main(String[] args) {
        LoopLinkedList<Integer> linkedList = new LoopLinkedList<>();
        for(int i = 0 ; i < 5 ; i ++){
            linkedList.add(i);
        }

        linkedList.show();
        System.out.println();

        linkedList.add(2, 666);
        linkedList.show();

        System.out.println();

        linkedList.remove(2);
        linkedList.show();
    }

}
