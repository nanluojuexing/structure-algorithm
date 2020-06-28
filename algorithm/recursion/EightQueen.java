package algorithm.recursion;

/**
 * @Author: mianba
 * @Date: 2019-08-20 10:27
 * @Description: 回溯算法，八皇后问题
 */
public class EightQueen {

    /**
     * 下标表示有多少行，值表示 queen存储在那一列
     */
    int result[] = new int[8];

    /**
     * 计算八皇后
     * @param row
     */
    public void cal8Queens(int row){
        // 行数8的时候，8个棋子已经都放好了
        if(row == 8){
            printQueens(result);
            return;
        }

        // 这里每一行都有 8 中放法 这里 i 表示列
        for (int i = 0; i < 8; ++i) {
            // 判断是否放对位置，则将此位置的数组置为
            if(isOk(row,i)){
                result[row] = i;
                //继续下一行操作
                cal8Queens(row+1);
            }
        }
    }

    /**
     * 判断 row行 column列是否放置合适
     * @param row
     * @param cloumn
     * @return
     */
    public boolean isOk(int row,int cloumn){
        // 获取当前列的左边一列 和 右边一列
        int leftup = cloumn-1,rightup = cloumn +1;
        // 这里回溯，逐行往上考察每一行
        for (int i = row -1 ; i >=0 ; --i) {
            //判断第 i 行 column列是否有棋子
            if(result[i] == cloumn){
                return  false;
            }
            // 判断左对角线上是否有棋子
            if(leftup >= 0){
                if(result[i] == leftup){
                    return false;
                }
            }
            // 有对角线上是否有棋子
            if(rightup < 8){
                if(result[i]==rightup){
                    return false;
                }
            }
            --leftup;
            ++rightup;
        }
        return true;
    }

    /**
     * 打印二维矩阵
     */
    public void printQueens(int[] result){
        for (int i = 0; i < 8 ; ++i) {
            for (int j = 0; j < 8 ; ++j) {
                if(result[i]==j){
                    System.out.print(" Q ");
                }else {
                    System.out.print(" * ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new EightQueen().cal8Queens(0);
    }
}
