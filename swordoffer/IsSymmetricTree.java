package swordoffer;

import leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * 判断二叉树是否为对称二叉树
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 *   1
 *  / \
 *  2  2
 * / \ / \
 * 3 4 4 3
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *   1
 *  / \
 *  2  2
 *  \   \
 *  3   3

 *
 * 示例 1：
 *
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 *
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *
 *
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 */
public class IsSymmetricTree {

    @Test
    public void test(){

    }

    public boolean isSymmetric(TreeNode root) {
        // 如果树为空，直接返回true
        if(root==null){
            return true;
        }
        return check(root.left,root.right);
    }

    /**
     * 对比每个元素
     * @param left
     * @param right
     * @return
     */
    private boolean check(TreeNode left, TreeNode right) {
        // 子树是否为空
        if(left==null && right==null){
            return true;
        }
        // 一个为空，另一个不为空，则不满足对称条件
        if(left==null || right==null){
            return false;
        }
        // 递归对比元素值是否相等
        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);
    }
}
