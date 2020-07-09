package leetcode.dp;

/**
 * leetcode  1025 除数博弈
 *
 *
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * 示例 2：
 *
 * 输入：3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作
 *
 * 链接：https://leetcode-cn.com/problems/divisor-game
 */
public class solution1025 {

    public static void main(String[] args) {

//        System.out.println(divisorGame2(2));
//        System.out.println(divisorGame(3));
        System.out.println(divisorGame(5));
    }

    /**
     * 动态规划解法
     * @param n
     * @return
     */
    public static boolean divisorGame(int n) {

        if(n ==1){
            return false;
        }
        // 定义dp[] 记录 第i个数的时候，玩家获胜的情况
        boolean[] dp = new boolean[n];

        // 初始化值
        dp[0] = false;
        dp[1] = true;
        for (int i = 2; i < n; i++) {
            // 先讲dp[i]设置为false，当符合条件是才设置为true
            dp[i] = false;
            // 从1开始寻找符合条件的数
            // 即玩家开始操作数后,当玩家操作到i时，即i-j的数，尽可能是对手输 即dp[i-x] 为false;
            // 所以遍历 j  从 1 到i-x, 寻找x的约数，使得dp[i-x]=false，那么dp[i]=true即当前操作数为i的玩家能获胜
            for (int j = 1; j < i ; j++) {
                if(i%j ==0 && !dp[i-1]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n-1];
    }

    public static boolean divisorGame2(int n) {
        return n % 2 == 0 ? true:false;
    }


    /**
     *  a 1  b 1  a 1  b 1
     *   5    4    3    2
     *
     *   此时a 不能选择了
     *
     *   a 1  b 2   a 1
     *    5    4     2
     *
     * 假设 N = 1，爱丽丝没得选择，直接失败，即 鲍勃获胜；
     * 假设 N = 2，爱丽丝有选择，她可以选择 x = 1，鲍勃面对的就是 N = 2 - 1 = 1，无法操作，爱丽丝获胜；
     * 假设 N = 3，爱丽丝只能选择 x = 1，因为选 x = 2 不满足 3 % 2 = 0，鲍勃面对的就是 N = 3 - 1 = 2，参考上面 N = 2 的情形，此时鲍勃为 N = 2 的先手，鲍勃获胜；
     * 假设 N = 4，爱丽丝可以选择 x = 1 来使鲍勃遇到 N = 3 的情况，爱丽丝获胜
     *
     * 假设 N = 5, a 只能选择 x = 1 , bod 面对的就是 n = 5 - 1 = 4 ;此时bod选择 x = 2,
     *
     */

}
