package algorithm.lru;

import org.junit.Test;

import java.util.HashMap;

/**
 * lru算法，淘汰最近最少使用的数据 基于自定义链表+hashMap实现
 */
public class LRUCache {

    /**
     * 节点信息
     */
    class Node{
        private Node pre;
        private Node next;
        private String key;
        private String value;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    /**
     * 头节点
     */
    private Node head;

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 缓存存储的上限
     */
    private int limit;

    /**
     * 记录key和节点的映射关系
     */
    private HashMap<String,Node> hashMap;

    public LRUCache(int limit) {
        this.limit = limit;
        this.hashMap = new HashMap<>();
    }

    public String get(String key){
        final Node node = hashMap.get(key);
        if(node == null){
            return null;
        }
        // 每次获取元素都要更新访问的频率
        refreshNode(node);
        return node.value;
    }

    /**
     * 存储元素
     * @param key
     * @param value
     */
    public void put(String key,String value){
        //先获取元素
        Node node = hashMap.get(key);
        if(node == null){
            //如果key不存在，则插入 key-value
            if(hashMap.size() >=limit){
                String oldKey = removeNode(head);
                hashMap.remove(oldKey);
            }
            node = new Node(key, value);
            addNode(node);
            hashMap.put(key,node);
        }else{
            node.value= value;
            refreshNode(node);
        }
    }

    public void remove(String key){
        Node node = hashMap.get(key);
        removeNode(node);
        hashMap.remove(key);
    }

    /**
     * 刷新节点信息
     * @param node
     */
    private void refreshNode(Node node){
        // 如果访问的是尾节点，则无序移动
        if(node==tail){
            return;
        }
        removeNode(node);
        addNode(node);
    }

    private String removeNode(Node node){
        // 判断是否只有一个节点
        if(node==head && node==tail){
            head=null;
            tail=null;
        }else if(node==tail){
            tail = tail.pre;
            tail.next= null;
        }else if(node==head){
            head= head.next;
        }else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public void addNode(Node node){
        if(tail!=null){
            tail.next= node;
            node.pre = tail;
            node.next = null;
        }
        tail = node;
        if(head== null){
            head= node;
        }
    }

    @Test
    public void test1(){
        LRUCache lruCache = new LRUCache(5);
        lruCache.put("001","用户信息1");
        lruCache.put("002","用户信息2");
        lruCache.put("003","用户信息3");
        lruCache.put("004","用户信息4");
        lruCache.put("005","用户信息5");

        lruCache.get("002");
        lruCache.put("004","用户信息更新");
    }
}
