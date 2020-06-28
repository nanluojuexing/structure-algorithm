package algorithm.recursion;

/**
 * @Author: mianba
 * @Date: 2019/9/10 14:51
 * @Description: 背包问题
 *
 *
 *
 * 对于一组不同重量，不同价值，不可分割的物品，选择将m，木屑物品装入背包，再满足背包的最大重量的限制下，背包可装入物品的总价值最大是多少
 */
public class knapsack2 {

    /**
     * 接受结果的最大价值
     */
    private int maxV = Integer.MIN_VALUE;

    // 物品重量
    private int[] items = {2,2,4,6,3};
    // 物品价值
    private int[] values = {3,4,8,9,6};
    //物品个数
    private int n = 5;
    // 背包能承受的最大重量
    private int w = 9;

    public static void main(String[] args) {


        knapsack2 knapsack2 = new knapsack2();
        knapsack2.knapsack(0,0,0);
        System.out.println(knapsack2.maxV);
    }

    public void knapsack(int i,int cw,int cv){

        if(cw == w || i== n){
            if(cv > maxV){
                maxV= cv;
            }
            return ;
        }
        knapsack(i+1,cw,cv);
        if(cw+items[i] <= w){
            knapsack(i+1,cw+items[i],cv+values[i]);
        }
    }
}
