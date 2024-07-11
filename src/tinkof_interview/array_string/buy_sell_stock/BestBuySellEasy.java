package tinkof_interview.array_string.buy_sell_stock;

import java.util.Arrays;

/**
 121. Best Time to Buy and Sell Stock

 Companies
 You are given an array prices where prices[i] is the price of a given stock on the ith day.

 You want to maximize your profit by choosing a single day to buy one stock
 and choosing a different day in the future to sell that stock.

 Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

 Example 1:
 Input: prices = [7,1,5,3,6,4]
 Output: 5
 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

 Example 2:
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transactions are done and the max profit = 0.
 */
public class BestBuySellEasy {
      public static void main(String[] args) {
            BestBuySellEasy bestBuySellEasy = new BestBuySellEasy();
            bestBuySellEasy.test1();
            bestBuySellEasy.test2();
      }
      /*
            Explanation:
            1. Create two variables
                  minBuy
                  maxProfit
            2. Go through arr
                  - every iteration
                  calculate min buy
                  calculate currProfit = currPrice - minBuy
                  calculate max profit from from currProfit and maxProfit
       */
      /*
            Greedy approach
            i: 0 1 2 3 4 5
               7 1 5 3 6 4

            minBuy = 7

            i:0
            curBuy = 7
            currProfit = 7 - 7 = 0
            i:1
            curBuy = 1 -> 1 < 7 -> minBuy = 1
            currProfit = 1 - 1 = 0
            i:2
            curBuy = 5
            currProfit = 1 - 5 = 4
            i:3
            curBuy = 3
            currProfit = 1 - 3 = 2
            i:4
            curBuy = 6
            currProfit = 1 - 6 = 5
            i:5
            curBuy = 4
            currProfit = 1 - 4 = 3
       */
      private void test1() {
            int[] prices = {7,1,5,3,6,4};
            int expected = 5;
            System.out.println(Arrays.toString(prices));
            int maxProfit = getMaxProfitByGreedyAlgorithm(prices);
            System.out.println("Max profit : " + maxProfit);
            System.out.println("Expected result : " + expected);
            System.out.println();
      }

      private void test2() {
            int[] prices = {7,6,4,3,1};
            int expected = 0;
            System.out.println(Arrays.toString(prices));
            int maxProfit = getMaxProfitByGreedyAlgorithm(prices);
            System.out.println("Max profit : " + maxProfit);
            System.out.println("Expected result : " + expected);
            System.out.println();
      }

      /**
       Time Complexity: O(N). Where N is the size of prices array.
       Auxiliary Space: O(1)
       */
      private int getMaxProfitByGreedyAlgorithm(int[] prices) {
            if (prices.length == 0 || prices==null  ) {
                  return 0;
            }
            int minBuy = prices[0];
            int maxProfit = 0;

            for (int i = 0; i < prices.length; i++) {
                  minBuy = Math.min(minBuy, prices[i]);

                  int sell = prices[i];
                  int currProfit = sell - minBuy;

                  maxProfit = Math.max(maxProfit, currProfit);
            }
           return maxProfit;
      }

}
