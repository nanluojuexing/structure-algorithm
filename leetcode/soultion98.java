package leetcode;

/**
 * 验证二叉树
 */
public class soultion98 {

    private Integer last  = null;

    public boolean isValidBST(TreeNode root) {

        if(root == null){
            return false;
        }
        // 遍历左边的节点
        if(root.left != null){
            boolean validBST = isValidBST(root.left);
            if(!validBST){
                return false;
            }
        }
        // 判断当前元素
        if(last!= null && last > root.val){
            return false;
        }
        last= root.val;

        if(root.right!=null){
            return isValidBST(root.right);
        }
        return true;
    }
}


class TreeNode98 {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode98(int x) {
        val = x;
    }
}
