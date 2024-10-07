package dynamic_programming.best_time_stock_1;

import java.util.Arrays;


/**
 * <a href="https://www.youtube.com/watch?v=E2-heUEnZKU&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=9&ab_channel=NikhilLohia">...</a>
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/">...</a>
 */
public class BestTimeStock1GreedyDP {

    public static void main(String[] args) {
        BestTimeStock1GreedyDP bestTimeStock1 = new BestTimeStock1GreedyDP();
        bestTimeStock1.test1();
        bestTimeStock1.test2();
    }

    public int maxProfit(int[] prices) {
        int[] memorization = new int[prices.length];

        memorization[0] = 0;
        int minBuy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            minBuy = Math.min(curr, minBuy);
            int profit = curr - minBuy;
            memorization[i] = Math.max(profit, memorization[i - 1]);
        }

        return memorization[memorization.length - 1];
    }

    public void test1() {
        int[] prices = {7,1,5,3,6,4};
        int expected = 5;
        System.out.println(Arrays.toString(prices));
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit : " + maxProfit);
        System.out.println("Expected result : " + expected);
        System.out.println();
    }

    public void test2() {
        int[] prices = {7,6,4,3,1};
        int expected = 0;
        System.out.println(Arrays.toString(prices));
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit : " + maxProfit);
        System.out.println("Expected result : " + expected);
        System.out.println();
    }

}
