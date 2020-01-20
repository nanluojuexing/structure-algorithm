package algorithm.dynamic;

/**
 * 背包问题升级版：
 *
 *  对于一组不同重量，不同价值，不可分割的物品，选择将m，木屑物品装入背包，再满足背包的最大重量的限制下，背包可装入物品的总价值最大是多少
 */
public class KnapsackProblemUp {

    public static void main(String[] args) {

        // 物品重量
        int[] items = {2,2,4,6,3};
        // 物品价值
        int[] values = {3,4,8,9,6};
        //物品个数
        int n = 5;
        // 背包能承受的最大重量
        int w = 9;

        System.out.println(knapsack(items,values,n,w));
    }

    public static int knapsack(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化 states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { // 动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第 i 个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第 i 个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }

}
