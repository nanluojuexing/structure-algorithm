package swordoffer;

import leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * 例如，给出
 *
 * 前序遍历 preorder =[3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 */
public class BuildTree {

    @Test
    public void test(){
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};

        final TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode);

    }

    /**
     * 二叉树的前序遍历: 先遍历根结点，然后递归遍历左子树，最后遍历右子树
     * 二叉树的中序遍历: 先递归遍历左子树，遍历根结点，最后递归遍历左子树
     *
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 获取数据的长度
        int n = preorder.length;
        Map<Integer,Integer> indexMap = new HashMap<>();
        // key 具体的值，value是索引位置
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i],i);
        }
        return mybuild(indexMap,preorder,inorder,0,n-1,0,n-1);
    }

    /**
     *
     * @param preorder
     * @param inorder
     * @param preorder_left
     * @param preorder_right
     * @param inorder_left
     * @param inorder_right
     * @return
     */
    private TreeNode mybuild(Map<Integer,Integer> indexMap,int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right) {

        if(preorder_left > preorder_right){
            return null;
        }
        // 前序遍历的第一个节点就是根结点
        int preorder_root = preorder_left;
        // 在中序遍历中定位根节点
        int inorder_root = indexMap.get(preorder[preorder_root]);
        // 构建根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        // 得到左子树的节点数量
        int size_left_sub = inorder_root - inorder_left;
        // 遍历构造左子树
        root.left = mybuild(indexMap,preorder,inorder,preorder_left+1,preorder_left+size_left_sub,inorder_left,inorder_root-1);
        // 遍历构造右子树
        root.right = mybuild(indexMap,preorder,inorder,preorder_left+size_left_sub+1,preorder_right,inorder_root+1,inorder_right);

        return root;

    }
}
