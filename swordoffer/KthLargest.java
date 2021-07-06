package swordoffer;

import leetcode.tree.TreeNode;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树的第k大节点
 */
public class KthLargest {

    @Test
    public void test(){

    }


    /**
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        //定义集合存储二叉树的元素
        List<Integer> results = new LinkedList<>();
        // 因为是二叉搜索树 中序递归遍历
        inOrder(root,results);
        // 对集合进行排序
        return results.get(results.size()-k);
    }

    /**
     * 遍历二叉树 中序遍历
     * 二叉搜索数 每个节点的值都大于左节点的值，都小于右节点的值，存储的元素具有可比较性，所以中序遍历为 左根右
     * @param root
     * @param results
     */
    public void inOrder(TreeNode root, List<Integer> results) {

        if(root==null){
            return;
        }
        inOrder(root.left,results);
        results.add(root.val);
        inOrder(root.right,results);
    }
}
