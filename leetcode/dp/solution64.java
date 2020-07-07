package leetcode.dp;

/**
 * 最小路径和 动态规划
 *
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小
 *
 */
public class solution64 {

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

    /**
     *
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        if (m < 0 || n < 0) {
            return 0;
        }

        // 第一步 定义备忘录
        int[][] dp = new int[m][n];
        // 初始化
        dp[0][0] = grid[0][0];

        // 第二步，处理边界条件
        // 初始化左边的列
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        // 初始化最上面的行
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 推导出dp[i][j]
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

}
