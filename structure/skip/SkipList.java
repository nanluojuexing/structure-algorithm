package structure.skip;

import java.util.Random;

/**
 * 基于 java 实现的跳跃表
 */
public class SkipList {

    /**
     * 长度
     */
    public int n;

    /**
     * 高度
     */
    public int h;

    /**
     * 表头
     */
    private SkipListEntry head;

    /**
     * 表尾
     */
    private SkipListEntry tail;

    /**
     * 生成randomLevel用到的概率值
     */
    private Random r;

    public SkipList() {
        head = new SkipListEntry(Integer.MIN_VALUE, Integer.MIN_VALUE);
        tail = new SkipListEntry(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.n = 0;
        this.h = 0;
        this.head.right = tail;
        this.tail.left = head;
        this.r = new Random();
    }

    /**
     * 查找一个节点
     * @param key
     * @return
     */
    public Integer get(int key) {
        SkipListEntry p;
        p = findEntry(key);
        if(p.key ==key) {
            return p.value;
        } else {
            return null;
        }
    }

    /**
     * 1. 从head出发，因为head指向最顶层（top level）链表的开始节点，相当于从顶层开始查找
     * 2. 移动到当前节点的右指针（right）指向的节点，直到右节点的key值大于要查找的key值时停止
     * 3. 如果还有更低层次的链表，则移动到当前节点的下一层节点（down），如果已经处于最底层，则退出
     * 4. 重复2 、3 步骤，直到查找到key值所在的节点，或者不存在而退出查找；
     * @param key
     * @return
     */
    public SkipListEntry findEntry(Integer key){
        SkipListEntry p;
        //从头节点开始找
        p = head;
        while(true){
            while(p.right.key != Integer.MAX_VALUE && p.right.key<key){
                p = p.right;
            }
            if(p.down!= null){
                p= p.down;
            }else {
                break;
            }
        }
        return p;
    }

    /**
     * 新增元素
     *
     * 如果put的key值在跳跃表中存在，则进行修改操作；
     * 如果put的key值在跳跃表中不存在，则需要进行新增节点的操作，并且需要由random随机数决定新加入的节点的高度（最大level）；
     * 当新添加的节点高度达到跳跃表的最大level，需要添加一个空白层（除了-oo和+oo没有别的节点）
     *
     * @param key
     * @param value
     * @return
     */
    public void put(int key,int value){
        // 定义两个临时节点 : q为新增节点，p 为存在的节点
        SkipListEntry p , q;
        int i =0;
        // 查看适合插入的位置
        p = findEntry(key);
        // 如果跳跃表中存在对应的key,则直接修改对应的值就行了
        if(p.key == key){
            p.value = value;
            return ;
        }
        // 如果跳跃表中不存在含有key值的节点，则进行新增操作，将节点插入 p节点的前面
        q = new SkipListEntry(key,value);
                /* --------------------------------------------------------------
        Insert q into the lowest level after SkipListEntry p:
                         p   put q here           p        q
                         |     |                  |        |
	 	                 V     V                  V        V        V
        Lower level:    [ ] <------> [ ]    ==>  [ ] <--> [ ] <--> [ ]
        --------------------------------------------------------------- */
        q.left = p;
        q.right = p.right;
        p.right.left = q;
        p.right = q;

        //本层操作完毕，看更高层操作
        //抛硬币随机决定是否上层插入
        while(r.nextDouble() < 0.5 ){
            // 已经已经是最高层，需要新建一个顶层
            if(i >= h){
                addEmptyLevel();
            }
            // 将P移动到上一层
            while ( p.up == null ) {
                p = p.left;
            }

            p = p.up;
	/* ---------------------------------------------------
          Add one more (k,*) to the column
	   Schema for making the linkage:
               p <--> e(k,*) <--> p.right
                         ^
		          |
		          v
		          q
	   ---------------------------------------------------- */
            SkipListEntry e;
            // 这里需要注意的是除底层节点之外的节点对象是不需要value值的
            e = new SkipListEntry(key,null);
            e.left = p;
            e.right = p.right;
            e.down = q;

            p.right.left = e;
            p.right = e;
            q.up = e;

            //把q执行新插入的节点：
            q = e;
            // level增加
            i = i + 1;
        }
        // 更新链表长度
        n = n+1;
    }

    private void addEmptyLevel() {
        SkipListEntry p1, p2;
        p1 = new SkipListEntry(Integer.MIN_VALUE, null);
        p2 = new SkipListEntry(Integer.MAX_VALUE, null);

        p1.right = p2;
        p1.down = head;
        p2.left = p1;
        p2.down = tail;

        head.up = p1;
        tail.up = p2;
        head = p1;
        tail = p2;

        h = h + 1;
    }

    public Integer remove(int key) {

        SkipListEntry p, q;
        p = findEntry(key);
        if(!p.key.equals(key)) {
            return null;
        }
        Integer oldValue = p.value;
        while(p != null) {
            q = p.up;
            p.left.right = p.right;
            p.right.left = p.left;
            p = q;
        }
        return oldValue;
    }

    public void printHorizontal() {
        String s = "";
        int i;

        SkipListEntry p;
	     /* ----------------------------------
		Record the position of each entry
		---------------------------------- */
        p = head;

        while ( p.down != null ) {
            p = p.down;
        }

        i = 0;
        while ( p != null ) {
            p.pos = i++;
            p = p.right;
        }
	     /* -------------------
		Print...
		------------------- */
        p = head;

        while ( p != null ) {
            s = getOneRow( p );
            System.out.println(s);

            p = p.down;
        }
    }

    public String getOneRow( SkipListEntry p ) {
        String s;
        int a, b, i;

        a = 0;

        s = "" + p.key;
        p = p.right;


        while ( p != null ) {
            SkipListEntry q;

            q = p;
            while (q.down != null)
                q = q.down;
            b = q.pos;

            s = s + " <-";


            for (i = a+1; i < b; i++)
                s = s + "--------";

            s = s + "> " + p.key;
            a = b;
            p = p.right;
        }
        return(s);
    }

    public static void main(String[] args) {

        SkipList l = new SkipList();
        Random r = new Random();
        for (int i = 0; i < 10; i++ ) {
            int tmp = r.nextInt(100);
            System.out.println("add:"+tmp);
            l.put( tmp,  tmp );
            l.printHorizontal();
        }

        System.out.println("over");
    }
}


class SkipListEntry{

    Integer key;
    Integer value;
    SkipListEntry right;
    SkipListEntry left;
    SkipListEntry down;
    SkipListEntry up;

    public SkipListEntry(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
    public int pos;//与数据结构无关，只为输出方便

}