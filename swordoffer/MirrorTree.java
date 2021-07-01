package swordoffer;

import leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 镜像二叉树
 *
 */
public class MirrorTree {

    @Test
    public void test(){

        // 构建二叉树
        TreeNode treeNode = new TreeNode(4);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(7);
        treeNode.left =left;
        treeNode.right =right;
        // 打印二叉树
        levelOrder(treeNode);

        System.out.println("----------------");
        // 打印镜像后的二叉树
        levelOrder(mirrorTree(treeNode));
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null){
            return null;
        }
         TreeNode left = mirrorTree(root.left);
         TreeNode right = mirrorTree(root.right);
         root.left = right;
         root.right = left;

         return root;
    }

    /**
     * 层序遍历
     * @param root
     */
    public void levelOrder(TreeNode root){
         Queue<TreeNode> queue = new LinkedList<>();
         queue.add(root);
         while (!queue.isEmpty()){
             final TreeNode cur = queue.remove();
             System.out.println(cur.val);
             if(cur.left!= null){
                 queue.add(root.left);
             }
             if(cur.right!= null){
                 queue.add(root.right);
             }
         }
    }
}
