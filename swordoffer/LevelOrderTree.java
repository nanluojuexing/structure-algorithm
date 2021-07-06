package swordoffer;

import leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印二叉树 二叉树的层序遍历
 *
 * 同一层的节点按从左到右的顺序打印，每一层打印到一行
 *
 *
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class LevelOrderTree {

    public List<List<Integer>> levelOrder(TreeNode root) {

        // 定义集合存储遍历的元素
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return new LinkedList<>();
        }
        List<List<Integer>> result = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> temp = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
