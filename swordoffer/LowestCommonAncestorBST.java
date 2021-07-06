package swordoffer;

import leetcode.tree.TreeNode;
import org.junit.Test;

/**
 * 二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestorBST {

    @Test
    public void test(){

    }

    /**
     * 递归对比遍历
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }
        // 如果两个值都小于根节点，说明都在左子树
        if(root.val>p.val && root.val>q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        // 如果两个值都小于根节点，说明都在右子树
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    /**
     * 题解：
     * 二叉搜索树的任意节点大于左子树所有节点的值，小于右子树所有节点的值
     *
     * 所以如果 p,q 分数不同的子树，则最近的公共节点就是根节点
     * 如果 p，q 小于 根节点的值，则都为左子树，则递归遍历左子树寻找最近公共节点
     * 同理 p、q 大于 根节点的值，则都在右子树，则递归遍历右子树寻找最近公共节点
     */
}
