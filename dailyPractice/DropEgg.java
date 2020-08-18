package dailyPractice;

/**
 * 丢鸡蛋 动态规划
 *
 * 有一个n层的建筑。如果一个鸡蛋从第k层及以上落下，它会碎掉。如果从低于这一层的任意层落下，都不会碎。
 *
 * 有m个鸡蛋，用最坏的情况下实验次数最少的方法去找到k, 返回最坏情况下所需的实验次数。
 *
 * 在线评测地址: LintCode 领扣
 *
 * Example 1:
 *
 * Input: m = 2, n = 100
 * Output: 14
 * Example 2:
 *
 * Input: m = 2, n = 36
 * Output: 8
 *
 * 参考解题思路: https://zhuanlan.zhihu.com/p/92288604
 *
 * @author mianba
 */
public class DropEgg {

    public static void main(String[] args) {

        System.out.println(dropEggs2(2,100));
    }

    /**
     *
     * 动态规划。
     * dp[i][j]代表从有i个鸡蛋在第j层需要的最少次数。
     * 转移方程为
     * dp[i][j]=min(dp[i][j],max(dp[i - 1][k - 1], dp[i][j - k]))
     * 即每次在第k层碎了所转移到的状态，以及第k层没碎所转移到的状态
     *
     * @param m 鸡蛋个数
     * @param n 楼层数
     * @return
     */
    public static int dropEgg(int m,int n){

        // 第一步 定义备忘录，即状态转矩阵
        int[][] dp = new int[m + 1][n + 1];

        // 第二步，处理边界情况
        // 考虑楼层的边界
        for (int i = 1; i <= m; ++i) {
            // 楼层= 0的情况
            dp[i][0] = 0;
            // 楼层= 0的情况
            dp[i][1] = 1;
        }

        // 处理鸡蛋的边界
        for (int j = 1; j <= n; ++j) {
            // 如果鸡蛋为0
            dp[0][j] = 0;
            // 鸡蛋为1的话，一层层的往上实验
            dp[1][j] = j;
        }

        // 第三步，状态方程
        //找递推过程中的两个紧邻步骤之间的关系，如何由子结果得到母结果
        //首先，鸡蛋要从2个开始算，因为0个和1个情况你已经考虑完了
        for (int i = 2; i <= m; ++i) {
            //楼层有多高要从2层起步，因为0层和1层的情况你也考虑完了
            for (int j = 2; j <= n; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 1; k <= j; ++k) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[i - 1][k - 1], dp[i][j - k]));
                }
            }
        }
        return dp[m][n];
    }

    public static int dropEggs2(int eggs, int floors) {
        //第一步永远是创建动态规划的备忘录,也叫状态转移矩阵
        //记住：二维数组里的length是0-start的，又因为包含层数为0或鸡蛋为0的情况，所以定义行高和列宽的时候自然要加1
        int[][] state = new int[eggs + 1][floors + 1];

        //第二步永远是考虑边界，也就是初始化动态规划的备忘录
        //先考虑eggs的边界
        for (int i=0;i<=floors;i++) {
            //首先是eggs=0的情况
            state[0][i] = 0;
            //然后是eggs=1的情况
            //eggs=1的时候，肯定是从第0层一直往上实验
            state[1][i] = i;
        }
        //再考虑floors的边界
        for (int i=1;i<=eggs;i++) {
            //首先是floors=0的情况
            state[i][0] = 0;
            //然后是floors=1的情况
            state[i][1] = 1;
        }

        //第三步就是状态方程了
        //找递推过程中的两个紧邻步骤之间的关系，如何由子结果得到母结果
        //首先，鸡蛋要从2个开始算，因为0个和1个情况你已经考虑完了
        for (int egg=2;egg<=eggs;egg++) {
            //楼层有多高要从2层起步，因为0层和1层的情况你也考虑完了
            for (int floor=2;floor<=floors;floor++) {
                //看这里！这里就是你还有egg个鸡蛋，一共有floor层的子问题！
                //这里定义一个变量来存储最终结果，找到在哪层扔能达到所扔次数最少的目标，扔鸡蛋次数多了胳膊会酸！
                int result = Integer.MAX_VALUE;
                for (int drop=1;drop<=floor;drop++) {
                    //这里！就是在当前子问题中，你从第drop层扔鸡蛋的情况！
                    //第一种情况，哎呀~碎了！那么剩下的问题就转化成了如何在drop-1层，用egg-1个鸡蛋寻找最优解
                    int broken = state[egg - 1][drop - 1];
                    //第二种请看，卧槽~没碎！问题就转化成了如果再floos-drop层，用egg个鸡蛋寻找最优解
                    int unbroken = state[egg][floor - drop];
                    //两种情况我肯定要取最大值，因为我根本不确定鸡蛋会不会碎，我特么又不是先知！
                    int condition = Math.max(broken, unbroken) + 1;
                    //不断的和上一次的结果做比较，只为得到最优的结果，最少的扔鸡蛋次数！
                    result = Math.min(condition, result);
                }
                //当前子问题（当我有egg个鸡蛋，一共有floor层时）已经for循环完了！撒花~~接下来，就是把结果存到我们的结果矩阵里了！
                state[egg][floor] = result;
            }
        }

        //以上的步骤在不断的往状态矩阵（我把它称作装满结果的大盘子！）填充结果！到这里已经都填充完毕，我们自然就可以取到我们想要的结果啦！
        return state[eggs][floors];
    }
}
