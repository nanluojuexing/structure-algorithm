package leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 这个题目说的是，给你一个二叉树，你要判断它是否沿中轴线对称。
 *
 * 比如说，给你的二叉树是：
 *
 *      1
 *    /   \
 *   2     2
 *  / \   / \
 * 4   8 8   4
 *
 * 这棵二叉树是沿中轴线对称的，因此要返回 true。如果我去掉最后这个 4：
 *
 *      1
 *    /   \
 *   2     2
 *  / \   /
 * 4   8 8
 *
 * 就不对称了，这时就要返回 false。
 */

public class SymmetryTree_101 {


    @Test
    public void test1(){

    }


    /**
     * 解法1，递归对比 终止条件 左子树为null,右子树为null
     * @param root
     * @return
     */
    public boolean isSymmetricTreeRecursive(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }

    private boolean isSymmetric(TreeNode s,TreeNode t){
        if(s != null && t != null)
            return s.val == t.val && isSymmetric(s.left,t.right) && isSymmetric(s.right,t.left);
        else
            return s == null && t == null;
    }


    /**
     * 解法2：利用栈进行对比
     *
     * @param root
     * @return
     */
    public boolean isSymmetricTreeIterative(TreeNode root){
        if(root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        // 将根左右节点添加到栈中
        stack.push(root.left);
        stack.push(root.right);

        while (!stack.isEmpty()){
            TreeNode s = stack.pop();
            TreeNode t = stack.pop();
            if(s == null && t == null){
                continue;
            }
            // 其中一颗为空，则不是对称
            if(s == null || t == null){
                return false;
            }
            if(s.val != t.val){
                return false;
            }
            // 将左右子树，对称节点分别存入栈中
            stack.push(s.left);
            stack.push(t.right);
            stack.push(s.right);
            stack.push(s.left);

        }
        return true;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
