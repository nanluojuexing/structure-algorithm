package structure.skip;

import java.util.Random;

/**
 * 跳跃表
 */
public class SkipList_2 {

    /**
     * 索引的作最大层数
     */
    private static final int MAX_LEVEL = 16;

    /**
     * 当前索引的层数
     */
    private int levelCount = 1;

    /**
     * 跳表头结点。
     * 类似链表里的带头链表，哨兵结点，本身不存储数据，下一跳指向各层索引的头结点。
     */
    private Node head ;  // 带头链表

    /**
     * 用于生成随机数，避免链表中结点过多，导致性能下降。
     */
    private Random r ;

    public SkipList_2() {
        head = new Node();
        r = new Random();
    }

    public Node find(int value){
        Node p = head;
        // 从最上层开始查找，如果下一跳的节点值大于等于要查找的值，切换到下一层继续查找，知直到第0层
        for (int i = levelCount-1 ; i>=0 ; --i){
            while(p.forwards[i] != null && p.forwards[i].data < value){
                p = p.forwards[i];
            }
        }
        // 第 0 层存储了所有结点，如果找到要查找的值，返回该结点，否则返回 null
        if(p.forwards[0] !=null && p.forwards[0].data == value){
            return p.forwards[0];
        }else {
            return null;
        }
    }

    /**
     * 往跳表中插入一跳数据
     */
    public void insert(int value){
        // 获取层数，通过随机数确定
        int level = randomLevel();
        // 定义新的节点
        Node newNode = new Node();
        newNode.data= value;
        // 制定节点的层级
        newNode.maxLevel = level;

        // 用以存储新节点所有层数上，各自的前一个节点的信息
        Node[] update = new Node[level];
        for (int i = level-1; i >=0 ; i--) {
            update[i]= head;
        }

        // record every level largest value which smaller than insert value in update[]
        // 记录每一层最大的value值，该最大值小于插入 update[]的值
        // 从头节点开始寻找插入节点
        Node p = head;
        // 从最高层级开始找
        for (int i = level-1; i >=0 ; i--) {
            // 找到第 i 层索引的插入位置，将插入位置前面的结点保存到 update 数组
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        // in search path node next node become new node forwords(next)
        // 在搜索路径节点中，下一个节点成为新的节点forwords（下一个）
        for (int i = level - 1; i >= 0; i--) {
            // 更新各层的 forwards 结点
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // 更新当前索引总层数
        if (levelCount < level) {
            levelCount = level;
        }
    }

    /**
     * 删除节点
     */
    public void delete(int value){
        Node[] update = new Node[levelCount];
        Node p = head;
        // 按照层级遍历，寻找节点层级
        for (int i = levelCount-1; i >=0 ; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }
        // 遍历当前层级
        if (p.forwards[0] != null && p.forwards[0].data == value) {
            // 遍历更新节点的下一个节点信息
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }

    }

    /**
     * 生成随机数 level = [1, MAX_LEVEL]。
     * 将结点添加到第 0 层到第 level-1 层索引中。
     */
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; i++) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }
        return level;
    }

    /**
     * 打印每一层所有数据。
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SkipList Level Count = ").append(levelCount).append("\n");
        for (int i = levelCount - 1; i >= 0; i--) {
            sb.append("level ").append(i).append(" --> ");
            for (Node p = head; p.forwards[i] != null; p = p.forwards[i]) {
                sb.append(p.forwards[i].data);
                if (p.forwards[i].forwards[i] != null) {
                    sb.append(",").append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }


    public class Node {
        // 节点数据
        private int data = -1;

        /**
         * 保存当前结点的所有下一跳结点。用以存储该节点所有层的下一个节点的信息
         * forwards[i] 表示当前结点在第 i 层索引的下一跳结点，i in [0, maxLevel-1]
         */
        private Node forwards[] = new Node[MAX_LEVEL];
        /**
         * 当前索引总层数
         * 索引从 0 开始计数，到 maxLevel-1 为止。
         * 第 0 层为原始链表，从下往上依次建立索引，最上层为第 maxLevel-1 层索引。
         *
         * 当所有节点的最大层级变量maxlevel=1的时候，跳表退化成一个普通链表
         */
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SkipList Node ").append(data);
            sb.append(", maxLevel = ").append(maxLevel).append("\n");
            for (int i = maxLevel - 1; i >= 0; i--) {
                sb.append("level ").append(i).append(" --> ");
                if (forwards[i] == null) {
                    sb.append("null");
                } else {
                    sb.append(forwards[i].data);
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
}
