package leetcode;

/**
 * @Author: mianba
 * @Date: 2019-08-04 21:37
 * @Description: 二叉树的最大深度
 */
public class solution104 {

    public static void main(String[] args) {

    }

    public static int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int  result = Math.max( maxDepth(root.left),maxDepth(root.right) )+1;
        return result;
    }
}

