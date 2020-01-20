package algorithm.recall;

/**
 * 背包问题
 */
public class KnapsackProblem {

    /**
     * 表示存储背包的最大重量
     */
    private int max = Integer.MIN_VALUE;

    /**
     * @param i     表示物品，指当前考察到哪一个物品了
     * @param cw    表示当前背包的重量（已经装进去的物品重量和）
     * @param items 表示每个物品的重量
     * @param n     w 物品个数
     * @param w     背包重量
     *              <p>
     *              假设背包可承受重量 100，物品个数 10，物品重量存储在数组a中，则函数调用为 find(0,0,a,10,100)
     */
    public void find(int i, int cw, int[] items, int n, int w) {

        // 判断物品是否已经满了
        if (cw == w || i == n) {
            if (cw >= max) {
                max = cw;
            }
            return;
        }

        find(i + 1, cw, items, n, w);
        // 已经超过可以承受的背包重量的时候，就可以不在装了
        if (cw + items[i] <= w) {
            find(i + 1, cw + items[i], items, n, w);
        }
    }

    public static void main(String[] args) {

        int[] items = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        KnapsackProblem knapsackProblem = new KnapsackProblem();
        knapsackProblem.find(0, 0, items, 10, 100);
        System.out.println(knapsackProblem.max);

    }

}
