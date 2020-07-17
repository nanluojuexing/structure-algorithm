package leetcode.array;

/**
 * @Author: mianba
 * @Date: 2019-08-01 15:03
 * @Description: 岛屿问题 1，表示陆地，0表示 海洋
 */
public class solution463 {


    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        // 定义统计周长
        int count =0;
        //遍历二维数组
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 如果都为1 则记录4条边
                if( grid[i][j] == 1 ){
                    count += 4;
                }
                // 当前位置为1，但是左边不为0，则减去两条边
                if(grid[i][j]==1 && i-1 >= 0 && grid[i-1][j] >0 ){
                    count -= 2;
                }
                if(grid[i][j]==1 && j-1 >= 0 && grid[i][j-1] >0 ){
                    count -= 2;
                }
            }
        }
        return count;
    }
}
