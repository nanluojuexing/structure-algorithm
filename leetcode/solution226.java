package leetcode;

/**
 * @Author: mianba
 * @Date: 2019-08-04 23:25
 * @Description:
 */
public class solution226 {


    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {
        //判断是否为空
        if(root== null){
            return null;
        }
        TreeNode tempNode = root.left;
        root.left = root.right;

        root.right = tempNode;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
