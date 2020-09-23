package leetcode.dp.shares;

import org.junit.Test;

/**
 * 股票问题
 *
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
 *
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 *
 * 返回获得利润的最大值。
 *
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 *
 * 示例 1:
 *
 * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出: 8
 * 解释: 能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 *
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
 */
public class solution714 {

    @Test
    public void test1(){
       int[] prices = {1, 3, 2, 8, 4, 9};
       int fee = 2;

        System.out.println(maxProfit(prices,fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int cash = 0;
        int hold = - prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return Math.max(cash,hold);
    }

    /**
     * 这里需要维护两个变量
     *  cash 当前不持有股票的时候最大利润
     *  hold  持有股票时候的最大利润
     *
     *  第 i天 需要根据第 i-1  天的状态来更新 cash 和 hold 值，对于 cash
     *  cash = max(cash，hold+price[i]-price[i-1])
     *
     *  hold 可以保持不变 ,或者买入这一天的股票，状态转移方程为
     *  hold = max(hold,cash-price[i])
     *
     *  第i-1天卖出最大收益 vs 第i-1天买入最大收益+当天股价-手续费
     *
     *  第i-1天买入的最大收益 vs 第i-1天卖出的最大收益+当天股价
     *
     *
     *  https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/solution/si-chong-shi-xian-tu-jie-714-mai-mai-gu-piao-de-zu/
     */
}
