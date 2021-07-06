package swordoffer;

import leetcode.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最大深度
 */
public class MaxDepthTree {

    /**
     * 递归遍历取值
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    // 层序遍历
    public int maxDepth2(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return 0;
        }
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()){
            final int size = queue.size();
            for (int s = 0; s < size; s++) {
                final TreeNode node = queue.poll();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
