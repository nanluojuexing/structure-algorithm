package leetcode.array;

/**
 * @Author: mianba
 * @Date: 2019/12/17 09:23
 * @Description:  到最近的人的最大距离（电影院选座问题）
 */
public class solution849 {
    public static void main(String[] args) {
        int[] seats ={1,0,0,0,1,0,1};
        System.out.println(maxDistToClosest(seats));
    }

    public static int maxDistToClosest(int[] seats) {
        int ans = 1, preOne = -1;
        for(int i = 0; i < seats.length; i++){
            if(seats[i] == 1){
                if(preOne == -1){
                    ans = Math.max(ans, i);
                }else{
                    ans = Math.max(ans, (i-preOne)/2);
                }
                preOne = i;
            }
        }
        return Math.max(ans, seats.length-1-preOne);
    }



    /**
     * 题解
     */
}
