package structure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉搜索树
 * @param <E>
 */
public class BST<E extends Comparable> {

    /**
     * 节点类
     */
    private class Node{
        private E e;
        private Node left;
        private Node right;

        public Node(E e){
            this.e=e;
            left=null;
            right=null;
        }
    }

    /**
     * 节点信息
     */
    private Node root;

    /**
     * 元素数量
     */
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    /**
     * 添加元素
     * @param e
     */
    public void add(E e){
        root = add(root,e);
    }

    /**
     * 以node为根的二分查找树中添加元素，递归算法
     * 返回插入新节点后二分搜索树的根
     * @param node
     * @param e
     */
    public Node add(Node node,E e){

        if(node == null){
            node = new Node(e);
            size++;
            return node;
        }

        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 插入元素，非递归方法
     * @param e
     */
    public void addV2(E e){

        if(root == null){
            root = new Node(e);
            size++;
            return;
        }
        Node cur = this.root;
        while(cur!= null){
            if(e.compareTo(cur.e) >0){
                if(cur.right == null){
                    cur.right = new Node(e);
                    size++;
                    return;
                }
                cur = cur.right;
            }else{
                if(cur.left == null){
                    cur.left = new Node(e);
                    size++;
                    return;
                }
                cur = cur.left;
            }
        }
    }

    /**
     * 查询对应的节点
     * @param e
     * @return
     */
    public Node find(E e){
        Node cur = root;
        while(cur!= null){
            // 当前元素小于节点元素的值
            if(e.compareTo(cur.e) < 0 ){
                cur = cur.left;
            }// 当前元素大于节点元素的值
            else if(e.compareTo(cur.e)>0){
                cur = cur.right;
            }else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 二分搜索树的遍历 (前序遍历 ：先访问当前节点，再依次递归访问左右子树)
     *
     * 深度优先遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    /**
     * 前序遍历，以node为根节点，先访问当前节点，再依次递归访问左右子树
     *
     * 深度优先遍历
     * @param node
     */
    public void preOrder(Node node){
        //确定递归的终止条件
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 二分搜素树，非递归前序遍历
     */
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

    /**
     * 二分搜索树，中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }

    /**
     * 二分搜索树 中序遍历，以node为根节点，先递归访问左子树，再访问自身，再递归访问右子树
     * @param node
     */
    public void inOrder(Node node){
        if(node==null){
            return ;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后序遍历
     *
     * 深度优先遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    /**
     * 后序遍历以node为根的二分搜索树, 递归算法
     * 先递归访问左右子树，最后再访问当前节点
     *
     * 深度优先遍历
     * @param node
     */
    public void postOrder(Node node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 层级遍历
     */
    public void levelOrderTraversal(){

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.e);
            if(node.left!= null){
                queue.offer(node.left);
            }
            if(node.right!= null){
                queue.offer(node.right);
            }
        }
    }

    /**
     * 删除指定元素，此方法只作为学习
     * @param e
     * @return
     */
    public void delete(E e){
        // 指向要删除的节点，初始化指向根节点
        Node p = root;
        // 记录 p 的父节点
        Node parent = null;
        // 查到要删除的节点
        while(p!= null && !p.e.equals(e)){
            parent = p;
            if(e.compareTo(p.e)>0){
                p = p.right;
            }else {
                p= p.left;
            }
        }
        // 未找到的话，直接结束
        if(p== null){
            return;
        }
        // 找到了要删除的节点，判断是否包含左右节点
        // 此时需要寻找右子树中最小的节点
        if(p.left!= null && p.right!= null){
            Node minP = p.right;
            // minPP 表示minP的父节点
            Node minPP = p;
            // 寻找到最小的节点
            while(minP.left != null){
                minPP = minP;
                minP = minPP.left;
            }
            p.e = minP.e;
            p = minP;
            parent = minPP;
        }
        // 删除节点是叶子节点或者建有一个子节点
        Node child;
        if(p.left!= null){
            child = p.left;
        }else if(p.right != null){
            child = p.right;
        }else {
            child = null;
        }
        // 删除的是跟根节点
        if(parent == null){
            root = child;
        }else if(parent.left == p){
            parent.left = p;
        }else {
            parent.right = p;
        }
    }

    /**
     * 移除最小的节点
     * @return
     */
    public E minimum(){
        if(size==0){
            throw  new IllegalArgumentException("bst tree is empty!");
        }
        return minimum(root).e;
    }

    /**
     * 二分搜索树的最小节点都在左子树，直递归左子树，直到元素不存在，或者左节点为null,即找到了最小节点
     * @param node
     * @return
     */
    public Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大节点元素
     */
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty!");
        return maximum(root).e;
    }
    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     */
    private Node maximum(Node node){
        if(node.right==null){
            return node;
        }
        return minimum(node.right);
    }

    /**
     * 移除二分搜索树的最小节点
     * @return
     */
    public E removeMin(){
        E val = minimum();
        removeMin(root);
        return val;
    }

    /**
     * 移除最小节点，当最小节点还有右节点的时候，需要将右节点变为根节点的左子树部分
     * @param node
     * @return
     */
    public Node removeMin(Node node){
        // 找到最小的节点，最小的节点有可能没有子节点，有可能只有右孩子节点
        if(node.left == null){
            Node right = node.right;
            // 当右孩子节点不为空的时候，需要将右孩子节点变为左子树部分
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大的元素
     */
    public E removeMax(){
        E ret = maximum();// 先获得最大的节点
        // 移除最大的节点
        root = removeMax(root);
        return ret;
    }

    /**
     * 删除掉以node为根的二分搜索树中的最大节点
     * 返回删除节点后新的二分搜索树的根
     * @param node
     * @return
     */
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除节点元素为e的节点
     * @param e
     */
    public void remove(E e){
        root = remove(root,e);
    }

    /**
     * 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
     * 返回删除节点后新的二分搜索树的根
     *
     *  移除任意节点和最大。最小节点的最大区别是，删除任意节点的左、右子树可能都有节点
     *
     *  在找到要删除的节点时候删除步骤:(只有左子节点或者只有右子节点的时候，使用以前的,确定左右都有节点的时候)
     *    1、找到右子节点的最小值,删除它。
     *    2、然后把这个删除的节点放到找到的这个节点位置。
     *      就是把找到的节点的右子节点和左子节点分别赋值给删除的这个节点.
     *    3、最后这个节点还应该赋值给删除的节点的父节点的正确的位置.
     * @param node
     * @param e
     * @return
     */
    public Node remove(Node node,E e){
        // 如果是空树的直接返回
        if(node == null){
            return null;
        }

        // 从根节点的一边去搜索
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left, e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right = remove(node.right, e);
            return node;
        }else {
            //要删除的节点的左子树为空,这里获取右孩子节点，返回作为node节点的右孩子节点
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            // 待删除节点的右子树为null，类似于删除最大值
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点，左右子树都不为空的
            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successorNode = new Node(minimum(node.right).e);
            //然后复用removeMin,去删除node,此时不要传入root节点，传入当前节点的右子节点，
            //这样就会去删除以当前节点右子节点为根的所有子树中最小的节点的值,返回传入的右子节点.
            //内部会将二叉树中的那个节点的索引置为null,但我们前面拿到新索引，也是指向那个地方的.
            //正好把这个右子节的根基诶单点赋值给找到的min的右子节点
            successorNode.right=removeMin(node.right);
            //然后还需要把已删除的节点的左子节点连接到找到的节点的左子节点。
            //此时node就是要删除的节点
            successorNode.left = node.left;
            node.left=node.right=null;
            //mCount--;
            //此时感觉会多减一个啊，在前面remove的时候减了找的那个最小的，那此时又减去当前节点
            //但是把找到的最小的节点连接到二叉搜所树中的时候没有mCount++;
            //mCount++;//索性就不--了呗。
            size--;
            return successorNode;
        }
    }

    /**
     * floor和ceil
     * floor和ceil函数不需要要查找的key存在，如果存在这两个函数的值就是返回的本身。
     * floor：不大于传入的key对应的值是
     * ceil：不小于传入的key对应的值是
     */

    /**
     * 根据传入的节点，来获取对应的floor操作后的节点的key
     *
     *
     * @return
     */
    public E floor(E e){
        // 如果二叉树的为空，或者小于最小值，则没有去前驱
        if(size==0 || e.compareTo(maximum())<0){
            return null;
        }
        return floor(root,e).e;
    }

    /**
     * 在以node为节点的二叉搜索树中，寻找key的floor值所处的节点
     * @param node
     * @param e
     * @return
     */
    private Node floor(Node node, E e){
        // 如果当前节点为null ，直接返回
        if(node==null){
            return null;
        }
        // 如果node的值和要寻找的key的值相等，那么node本身就是e的floor节点
        if(e.compareTo(node.e)==0){
            return node;
        }

        // 左子树中
        if(e.compareTo(node.e)<0){
            // 左子树中递归查找
            return floor(node.left,e);
        }
        // 走到此处的时候就是当前节点的key小于要查找的key.此时两种情况：
        //    1)、此时这个node就是key节点对应的floor
        //    2)、此时的node不是key节点对应的floor,因为在当前node的右节点中有比这个节点的key小的值。
        //       也就是存在比node->key大但是小于key的其余节点.
        // 需要尝试向node的右子树寻找一下,总的来说理解的还是不深，但是整体感觉应该用递归的思想
        // 只考虑当前节点的情况，不要试图去一层又一层的往内部进去考虑,只考虑当前时，就是去右节点再递归找找
        // 如果找到了那么就返回它，如果没找到。证明当前节点(比key小)就是对的。那么就返回当前节点

        Node rightNode = floor(node.right,e);
        if(rightNode!= null){
            return rightNode;
        }
        //走到此处的时候组恒明满足node.getKey() < key,并且在这个节点的右子树中不存在更小的了！
        return node;
    }


    /**
     *
     * @param e
     * @return
     */
    public E ceil(E e){
        // 如果二叉树的为空，或者小于最小值，则没有去前驱
        if(size==0 || e.compareTo(maximum())>0){
            return null;
        }
        return ceil(root,e).e;
    }
    /**
     *
     * @param node
     * @param e
     * @return
     */
    public Node ceil(Node node,E e){
        //当前节点为null的时候直接返回null.
        if(node == null){
            return null;
        }

        if(e.compareTo(node.e)==0){
            return node;
        }
        //  右子树查找
        if(e.compareTo(node.e)>0){
            ceil(node.right,e);
        }

        Node leftNode = ceil(node.left,e);
        if(leftNode!= null){
            return leftNode;
        }
        return node;
    }

    /*********************************************/


    /**
     * 查看二分搜索树中国是否包含元素e
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    public boolean contains(Node node,E e){
        // 二分搜索树为null
        if(node==null){
            return false;
        }
        if(e.compareTo(node.e) == 0){
            return true;
        }
        else if(e.compareTo(node.e)<0){ // 左侧子树遍历
            return contains(node.left,e);
        }else{  // e.compareTo(node.e)>0
            return contains(node.right,e);
        }
    }
    /**
     * 获取元素个数
     */
    public int size(){
        return size;
    }

    /**
     * 判断二叉树是否为空
     */
    public boolean isEmpty(){
        return size==0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root,0,res);
        return res.toString();
    }

    /**
     * 生成以node为根节点,深度为depth的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    public void generateBSTString(Node node,int depth,StringBuilder res){
        // 查看是否有元素
        if(node== null){
            res.append(generateDepthString(depth)+"null\n");
            return;
        }
        res.append(generateDepthString(depth)+node.e+"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(int num: nums)
            bst.add(num);

        bst.preOrder();
        System.out.println();

        //bst.remove(bst.root,3);

        //System.out.println();
        //bst.preOrder();

        System.out.println();
        bst.remove(bst.root ,6);
    }
}
