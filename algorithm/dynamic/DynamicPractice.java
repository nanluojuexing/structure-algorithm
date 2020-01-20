package algorithm.dynamic;

/**
 * @Author: mianba
 * @Date: 2019/9/10 15:31
 * @Description:
 *
 * 促销活动 如 满 200 减 50 ,假设购物车中有n个商品（n>100）,再满足满减的情况下，选出来的商品价格总和最大程度的接近 满减条件
 */
public class DynamicPractice {

    public static void main(String[] args) {

        // 物品重量
        int[] items = {2,2,4,6,3};
        //物品个数
        int n = 5;
        // 背包能承受的最大重量
        int w = 9;

        double11advance(items,n,w);
    }

    /**
     * 计算可获取的最大值
     * @param items 商品价格
     * @param n 商品个数
     * @param w 满减条件 比如 200
     */
    public static void double11advance(int[] items, int n, int w) {
        boolean[][] states = new boolean[n][3*w+1];// 超过 3 倍就没有薅羊毛的价值了
        states[0][0] = true;  // 第一行的数据要特殊处理
        if (items[0] <= 3*w) {
            states[0][items[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = 0; j <= 3*w; ++j) {// 不购买第 i 个商品
                if (states[i-1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
            }
            for (int j = 0; j <= 3*w-items[i]; ++j) {// 购买第 i 个商品
                if (states[i-1][j]==true) {
                    states[i][j+items[i]] = true;
                }
            }
        }

        int j;
        for (j = w; j < 3*w+1; ++j) {
            if (states[n-1][j] == true) {
                break; // 输出结果大于等于 w 的最小值
            }
        }
        if (j == 3*w+1) return; // 没有可行解
        for (int i = n-1; i >= 1; --i) { // i 表示二维数组中的行，j 表示列
            if(j-items[i] >= 0 && states[i-1][j-items[i]] == true) {
                System.out.println(items[i] + " "); // 购买这个商品
                j = j - items[i];
            } // else 没有购买这个商品，j 不变。
        }
        if (j != 0) {
            System.out.println(items[0]);
        }
    }
}
