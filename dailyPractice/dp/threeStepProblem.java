package dailyPractice.dp;

/**
 * 三步问题
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 示例2:
 *  输入：n = 5
 *  输出：13
 *
 */
public class threeStepProblem {

    public static void main(String[] args) {
        System.out.println(waysToStep(5));
    }

    public static int waysToStep(int n) {

        if(n==1){
            return 1;
        }
        // 2; 1,1 两种方法
        if(n==2){
            return 2;
        }
        // 1,1,1; 1,2; 2,1; 3 这4中台阶方法
        if(n==3){
            return 4;
        }
        long[] dp = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // 初始化数据，记录不同的上楼梯的方法
        for (int i = 4; i < n+1; i++) {
            dp[i] = (dp[i-1]+dp[i-2]+dp[i-3]) % 1000000007;
        }
        return (int)dp[n];
    }
}
