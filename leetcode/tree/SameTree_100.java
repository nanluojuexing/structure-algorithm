package leetcode.tree;

import org.junit.Test;

import java.util.Stack;

/**
 * 判断二叉树是否相同
 * 给你两个二叉树，你要判断它们是否相同。这里所谓相同，指的是两棵树结构相同，并且相应节点上的数值相等
 *
 * 比如说，给你的两棵二叉树都是：
 *
 *    1          1
 *   / \        / \
 *  2   4      2   4
 *
 * 它们的结构相同，相应节点上的值也相等，因此返回 true。 如果另一棵树是：
 *
 *    1
 *   / \
 *  2   5
 *
 * 或
 *
 *     1
 *    /
 *   2
 *  /
 * 4
 *
 * 两棵树则不相同，返回 false
 *
 */
public class SameTree_100 {

    @Test
    public void test1(){

    }

    /**
     * 递归判断
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeRecursive(TreeNode p,TreeNode q){
        // 如果都为空，说明两颗树相等
        if(p == null && q == null){
            return true;
        }
        //
        if(p == null || q == null ){
            return false;
        }
        return p.val == q.val && isSameTreeIterative(p.left,q.left) && isSameTreeIterative(p.right,q.right);
    }

    /**
     * 栈解法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTreeIterative(TreeNode p,TreeNode q){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(p);
        stack.push(q);
        while (!stack.isEmpty()){
            TreeNode s = stack.pop();
            TreeNode t = stack.pop();
            if(s==null && t == null){
                continue;
            }
            if(s==null || t == null){
                return false;
            }
            if(s.val != t.val){
                return false;
            }
            stack.push(s.left);
            stack.push(t.left);
            stack.push(s.right);
            stack.push(t.right);
        }

        return true;
    }
}
