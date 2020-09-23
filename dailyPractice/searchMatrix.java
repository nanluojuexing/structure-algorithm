package dailyPractice;

import org.junit.Test;

/**
 * 在m*n矩阵中判断目标值是否存在的算法
 *
 * 请写出一个高效的在m*n矩阵中判断目标值是否存在的算法，矩阵具有如下特征：
 *
 * 每一行的数字都从左到右排序
 *
 * 每一行的第一个数字都比上一行最后一个数字大
 *
 * 例如：
 *
 * 输入:
 *
 * matrix = [
 *
 *   [1,   3,  5,  7],
 *
 *   [10, 11, 16, 20],
 *
 *   [23, 30, 34, 50]
 *
 * ]
 *
 * target = 3
 *
 * 输出: true
 */
public class searchMatrix {

    @Test
    public void test(){
        int[][] matrix ={{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        System.out.println(searchMatrix(matrix,3));
    }

    /**
     * 在矩阵中寻找目标值,因为目标二位数组是顺序递增的，其实可以理解为以为数组，用二分法进行查找，每次获取中间元素位置进行比较
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix,int target){

        // 获取行数
        int m = matrix.length;
        if(m==0) return false;
        // 获取列数
        int n = matrix[0].length;
        // 定义左边的其实位置
        int left =0;
        int right = m*n-1;
        // 定义中间节点
        int mid;
        // 定义元素接收值
        int num=0;
        // 循环遍历数组，通过二分法查找
        while(left <= right){
            // 确定中间元素的位置
            mid = left+(right-left)/2;
            //确定下标为mid在二维数组的位置
            num = matrix[mid/n][mid%m];
            if(num == target){
                return true;
            }else if(num<target){
                left = mid+1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }
}
