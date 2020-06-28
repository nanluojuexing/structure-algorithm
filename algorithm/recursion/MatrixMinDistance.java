package algorithm.recursion;

/**
 * 矩阵的最短距离，回溯算法
 */
public class MatrixMinDistance {

    /**
     * 定义接受最小距离的值
     */
    public int minDis = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] matrix = {{5,7,8},{2,3,4},{9,6,1}};

        MatrixMinDistance matrixMinDistance = new MatrixMinDistance();
        matrixMinDistance.minDisBT(0,0,0,matrix,2);
        // 打印最终的路径长度
        System.out.println(matrixMinDistance.minDis);
    }

    /**
     *
     * @param i
     * @param j
     * @param dist
     * @param w
     * @param n
     */
    public void minDisBT(int i,int j,int dist,int[][] w,int n){
        // 当i，j都等于 n 的时候，说明应走完所有的路径
        if(i==n && j==n){
            if(dist < minDis){
                minDis=dist;
            }
        }

        // i < n;继续往下走，i+1,j
        if(i < n){
            minDisBT(i+1,j,dist+w[i][j],w,n);
        }
        // j < n 继续 ;继续往下走 i,j+1
        if(j < n){
            minDisBT(i,j+1,dist+w[i][j],w,n);
        }
    }
}
