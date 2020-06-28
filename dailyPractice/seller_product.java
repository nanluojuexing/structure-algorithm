package dailyPractice;

import java.util.Arrays;
import java.util.Stack;

/**
 * 题目描述
 * 一位店主需要完成一项销售任务，他将要出售的物品排成一排。
 * 从左侧开始，店主以其全价减去位于该物品右侧的第一个价格较低或价格相同的商品的价格。
 * 如果右侧没有价格低于或等于当前商品价格的商品，则以全价出售当前商品。
 * 你需要返回每一个物品实际售出价格
 *
 * 示例1
 * 输入:
 * Prices = [2, 3, 1, 2, 4, 2]
 * 输出: [1, 2, 1, 0, 2, 2]
 * 解释：第0个和第1个物品右边第一个更低的价格都是1，所以实际售价需要在全价上减去1， 第3个物品右边第一个更低的价格是2，所以实际售价要在全价上面减去2
 *
 * 示例2:
 * 输入:
 * Prices = [1, 2, 3, 4, 5]
 * 输出: [1, 2, 3, 4, 5]
 * 解释: 每一个物品都保持原价，他们的右边都没有等于或者更低价格的物品
 */
public class seller_product {

    public static void main(String[] args) {

        int[] prices = {2, 3, 1, 2, 4, 2};
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(FinalDiscountedPrice(prices)));
    }

    public static int[] FinalDiscountedPrice(int[] prices) {
        // 定义数组接收结果
        int[] res = new int[prices.length];
        // 存储对比的元素，记录对比的元素索引位置，记录价高的
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            res[i] = prices[i];
        }

        for (int i = 0; i < prices.length; i++) {
            // 第一个元素会直接入栈，后续的元素弹出，获取差值，res接收
            while (!s.isEmpty() && prices[s.peek()] >= prices[i]){
                int index = s.pop();
                res[index] = prices[index]-prices[i];
            }
            s.push(i);
        }

        return res;
    }
}
