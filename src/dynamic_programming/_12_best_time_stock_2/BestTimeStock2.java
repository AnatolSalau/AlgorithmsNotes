package dynamic_programming._12_best_time_stock_2;

import java.util.Arrays;


public class BestTimeStock2 {

    /**
     * <a href="https://www.youtube.com/watch?v=acAoNHbJhB4&t=1s&ab_channel=Joey%27sTech">...</a>
     * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/">...</a>
     */
    public static void main(String[] args) {
        BestTimeStock2 obj = new BestTimeStock2();
        obj.test1();
        obj.test2();
        obj.test3();
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] memorization = new int[prices.length];
        memorization[0] = 0;

        for (int j = 1; j < prices.length; j++) {
            int max = 0;
            int curr = prices[j];
            for (int i = 0; i < j; i ++) {
                int prev = prices[i];
                int remainder = curr - prev;
                int prevProfit = memorization[i];
                int profit = remainder + prevProfit;
                max = Math.max(max, profit);
            }
            memorization[j] = Math.max(memorization[j - 1], max);
        }
        return memorization[memorization.length - 1];
    }

    public void test1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        System.out.println("Test 1");
        System.out.println(Arrays.toString(prices));
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit : " + maxProfit);
        System.out.println("Expected result : " + expected);
        System.out.println();
    }

    public void test2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;
        System.out.println("Test 2");
        System.out.println(Arrays.toString(prices));
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit : " + maxProfit);
        System.out.println("Expected result : " + expected);
        System.out.println();
    }

    public void test3() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        System.out.println("Test 3");
        System.out.println(Arrays.toString(prices));
        int maxProfit = maxProfit(prices);
        System.out.println("Max profit : " + maxProfit);
        System.out.println("Expected result : " + expected);
        System.out.println();
    }
}
