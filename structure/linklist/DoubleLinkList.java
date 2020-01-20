package structure.linklist;

/**
 * @Author: mianba
 * @Date: 2019/11/8 15:51
 * @Description:
 */
public class DoubleLinkList {

    // 头结点
    private Node first;
    //尾结点
    private Node last;

    public DoubleLinkList() {
        first = null;
        last = null;
    }
    /**
     * 插入数据
     *
     * @param value
     */
    public void insertFirst(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            last = newNode;
        } else {
            first.pre = newNode;
            //把first节点往下移动
            newNode.next = first;
        }
        //把插入的节点作为新的节点
        first = newNode;
    }

    /**
     * 插入数据
     *
     * @param value
     */
    public void insertLast(int value) {
        Node newNode = new Node(value);
        if (first == null) {
            first = newNode;
        } else {
            last.next = newNode;
            //first.previous = newNode;
            newNode.pre = last;
        }
        //把最后个节点设置为最新的节点
        last = newNode;
    }

    public boolean isEmpty() {
        return first == null;
    }

    /**
     * 删除头节点时要去除两个指针,一个指向下个的next ,一个是next的previous指向前面的
     * @return
     */
    public Node deleteFirst() {
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
        }
        Node temp = first;
        if (first.next == null) {
            last = null;
        } else {
            first.next.pre = null;
        }
        first = temp.next;
        return temp;
    }

    /**
     * 删除头节点时要去除两个指针,一个指向下个的next ,一个是next的previous指向前面的
     * @return
     */
    public Node deleteLast() {
        if (first == null) {
            throw new RuntimeException("链表数据不存在");
        }

        Node temp = last;
        if (first.next == null) {
            last = null;
            //把第一个删除
            first = null;
        } else {
            last.pre.next = null;
        }
        last = temp.pre;
        return temp;
    }

    /**
     * 删除
     *
     * @param key
     * @return
     */
    public Node deleteByKey(int key) {
        Node current = first;
        while (current.value != key) {
            if (current.next == null) {
                System.out.println("没找到节点");
                return null;
            }
            current = current.next;
        }
        if (current == first) {
            //return deleteFirst();
            //指向下个就表示删除第一个
            first = first.next;
        } else {
            current.pre.next = current.next;
        }
        return current;
    }

    /**
     * 查找节点1
     *
     * @param value
     * @return
     */
    public Node findByValue(int value) {
        Node current = first;
        while (current != null) {
            if (current.value != value) {
                current = current.next;
            } else {
                break;
            }
        }
        if (current == null) {
            System.out.println("没找到");
            return null;
        }
        return current;
    }

    /**
     * 查找节点2
     *
     * @param key
     * @return
     */
    public Node findByKey(int key) {
        Node current = first;
        while (current.value != key) {
            if (current.next == null) {
                System.out.println("没找到");
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 根据索引查找对应的值
     *
     * @param position
     * @return
     */
    public Node findByPosition(int position) {
        Node current = first;
        //为什么是position - 1，因为要使用遍历，让current指向下一个， 所以position - 1的下个node就是要找的值
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        return current;
    }
}
