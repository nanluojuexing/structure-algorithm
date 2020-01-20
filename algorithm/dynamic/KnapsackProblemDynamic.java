package algorithm.dynamic;

/**
 * 背包问题，动态规划 之 备忘录计算法
 */
public class KnapsackProblemDynamic {

    /**
     * 表示存储背包的最大重量
     */
    private  int max = Integer.MIN_VALUE;

    /**
     * 备忘录，默认值为false
     */
    private boolean[][] men = new boolean[5][10];

    public static void main(String[] args) {
        // 物品重量
        int[] items = {2,2,4,6,3};
        //物品个数
        int n = 5;
        // 背包能承受的最大重量
        int w = 9;

        //new KnapsackProblemDynamic().find(0,0,items,n,w);
        new KnapsackProblemDynamic().knapsack(items,n,w);
    }

    /**
     *
     * @param i
     * @param cw
     * @param n
     * @param w
     * @return
     */
    public void find(int i,int cw,int[] items,int n,int w){
        // 如果已经到最大重量或者遍历完了所有的元素，则结束
        if(cw == w || i==n ){
            if(cw > max){
                max=cw;
                System.out.println(cw);
            }
            return ;
        }
        // 判断是否为重复状态，如果为重复状态则直接结束
        if(men[i][cw]){
            return;
        }
        // 记录每一次的状态
        men[i][cw]= true;
        // 递归调用
        find(i+1,cw,items,n,w);
        // 判断是否达到最大的重量，如果没有继续遍历
        if(cw+items[i] <= w){
            find(i+1,cw+items[i],items,n,w);
        }
    }

    /**
     * 动态规划版  二维数组记录 每次的状态变化
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int knapsack(int[] items, int n, int w) {
        // 定义接受状态的二维数组
        boolean[][] states = new boolean[n][w + 1];
        //首行数据特殊处理
        states[0][0] = true;

        if (items[0] <= w) {
            states[0][items[0]] = true;
        }
        //动态规划转移
        for (int i = 1; i < n; ++i) {
            // 不把第 i 个物品放入背包
            for (int j = 0; j <= w; ++j) {
                if (states[i - 1][j] == true) {
                    states[i][j] = states[i - 1][j];
                }
            }
            // 把第 i 个物品放入背包
            for (int k = 0; k <= w - items[i]; ++k) {
                if (states[i - 1][k] == true) {
                    states[i][k + items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[n - 1][i] == true) {
                System.out.println(i);
                return i;
            }
        }
        return 0;
    }

    /**
     * 空间优化版，一维数组记录状态，
     *   这里必须倒序出林，避免重复
     * @param items
     * @param n
     * @param w
     * @return
     */
    public int knapsack2(int[] items,int n,int w){
        // 默认值为 false
        boolean[] states = new boolean[w+1];
        // 首行数据需要初始化
        states[0]= true;
        for (int i = 1 ; i < n ; ++i) {
            for (int j = w-items[i]; j >= 0 ; --j) {
                if (states[j]==true) {
                    states[j+items[i]] = true;
                }
            }
        }
        for (int i = w; i >= 0; --i) {
            if (states[i]== true) {
                System.out.println(i);
                return i;
            }
        }
        return 0;
    }
}
