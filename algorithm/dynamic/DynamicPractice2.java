package algorithm.dynamic;

/**
 * 三角形的最大路径问题
 */
public class DynamicPractice2 {

    public static void main(String[] args) {
        int[][] matrix = {{5},{7,8},{2,3,4},{4,9,6,1},{2,7,9,4,5}};

        System.out.println(yanghuiTriangle(matrix));
    }

    public static int yanghuiTriangle(int[][] triangle){

        int[][] state = new int[triangle.length][triangle.length];
        // 初始化第一个元素
        state[0][0] = triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                // 这里对二维数组进行判断，
                if (j == 0){
                    state[i][j] = state[i-1][j] + triangle[i][i];
                }else if(j == triangle[i].length-1){
                    state[i][j]= state[i-1][j-1] + triangle[i][i];
                }else {
                    int top1 = state[i-1][j];
                    int top2 = state[i-1][j-1];

                    state[i][j] =  Math.min(top1,top2);
                }
            }
        }

        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            int distance = state[triangle.length - 1][i];
            if (distance < minDis) minDis = distance;
        }
        return minDis;

    }
}
/**
 *
 *               5
 *            7     8
 *         2     3     4
 *      4     9     6     1
 *   2     7     9     4     5
 *
 *
 *
 *
 *
 *
 */