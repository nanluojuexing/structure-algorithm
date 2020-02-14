package leetcode;

/**
 *  路径总和 III
 *给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 */
public class solution437 {

    public static void main(String[] args) {

    }


    public int pathSum(TreeNode root, int sum) {

        if(root == null)
            return 0;

        return pathSum(root.left,sum) + pathSum(root.right,sum) + calculate(root,sum);
    }

    public int calculate(TreeNode node, int sum){
        if(node == null){
            return 0;
        }
        int count =0;
        if(node.val == sum){
            count = 1 ;
        }
        return count + calculate(node.left,sum-node.val) + calculate(node.right,sum-node.val);
    }

    /**
     * 题解：
     *
     * 动窗口是数组/字符串问题中常用的抽象概念。 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i, j)[i,j)（左闭，右开）
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。例如，我们将 [i, j)[i,j) 向右滑动 11 个元素，则它将变为 [i+1, j+1)[i+1,j+1)（左闭，右开）。
     *
     * 回到我们的问题，我们使用 HashSet 将字符存储在当前窗口 [i, j)[i,j)（最初 j = ij=i）中。 然后我们向右侧滑动索引 jj
     * 如果它不在 HashSet 中，我们会继续滑动 jj。直到 s[j] 已经存在于 HashSet 中。此时，我们找到的没有重复字符的最长子字符串将会以索引 ii 开头。如果我们对所有的 ii 这样做，就可以得到答案
     *
     */
}
