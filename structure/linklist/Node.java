package structure.linklist;

/**
 * @Author: mianba
 * @Date: 2019/11/8 15:52
 * @Description:
 */
public class Node {

    public int value;
    /**
     * 前置节点
     */
    public Node pre;
    /**
     * 后置节点
     */
    public Node next;


    public Node(int value) {
        this.value = value;
    }
}
