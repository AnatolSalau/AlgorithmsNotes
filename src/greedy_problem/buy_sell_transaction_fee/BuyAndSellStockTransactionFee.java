package greedy_problem.buy_sell_transaction_fee;

import java.util.Arrays;

/**
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day,
 * and an integer fee representing a transaction fee.

 * Find the maximum profit you can achieve.
 * You may complete as many transactions as you like,
 * but you need to pay the transaction fee for each transaction.

 * Note:
 * You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.

 * Example 1:
 * Input: prices = [1,3,2,8,4,9], fee = 2
 * Output: 8
 * Explanation: The maximum profit can be achieved by:
 * - Buying at prices[0] = 1
 * - Selling at prices[3] = 8
 * - Buying at prices[4] = 4
 * - Selling at prices[5] = 9
 * The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
 * but (9-1-2 = 6)

 * Example 2:
 * Input: prices = [1,3,7,5,10,3], fee = 3
 * Explanation: (7-1-3 = 3) + (10 - 5 - 3 = 2) = 5 but (10 - 1 - 3 = 6)
 * Output: 6
 *
 * Example 3:
 * Input: prices = [1,3,7,5,10,3,8], fee = 3
 * Explanation: (10 - 1 - 3 = 6) + (8 - 3 - 3 = 2) = 8
 */
public class BuyAndSellStockTransactionFee {
      public static void main(String[] args) {
            BuyAndSellStockTransactionFee buyAndSellStockTransactionFee = new BuyAndSellStockTransactionFee();
            buyAndSellStockTransactionFee.testOne();
            //buyAndSellStockTransactionFee.testTwo();
            //buyAndSellStockTransactionFee.testThree();
      }
      /*

       */
      void testOne() {
            int[] prices = {3, 1, 2, 8, 4, 9};
            int fee = 2;
            int expected = 8;
            System.out.println(Arrays.toString(prices));
            System.out.println("Fee: " + fee);
            int maxProfit = maxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }


      void testTwo() {
            int[] prices = {3, 1, 7, 5, 10, 3};
            int fee = 3;
            int expected = 6;
            System.out.println(Arrays.toString(prices));
            System.out.println("Fee: " + fee);
            int maxProfit = maxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      void testThree() {
            int[] prices = {3, 1, 7, 5, 10, 3, 8};
            int fee = 3;
            int expected = 8;
            System.out.println(Arrays.toString(prices));
            System.out.println("Fee: " + fee);
            int maxProfit = maxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      /*
      int getMaxProfit(int[] prices, int fee) {
            // Initialize cash (f0) to represent max profit with 0 stocks on hand
            // Initialize hold (f1) to represent max profit with 1 stock on hand - bought on the first day
            int cash = 0, hold = -prices[0];

            for (int i = 1; i < prices.length; ++i) {
                  // Calculate the new cash by selling the stock held today, if it's a better option than holding cash
                  int newCash = Math.max(cash, hold + prices[i] - fee);
                  // Calculate the new hold by buying the stock today, if it's a better option than holding the current stock
                  hold = Math.max(hold, cash - prices[i]);
                  // Update cash to the newly calculated max profit with 0 stocks
                  cash = newCash;
            }

            // Finally, return the cash, which represents the maximum profit with 0 stocks on hand after all transactions
            return cash;
      }
      */

      int getMaxProfit(int[] prices, int fee) {
            int profit = 0;
            int minBuyPrice = prices[0];

            for (int i = 0; i < prices.length; i++) {
                  int currPrice = prices[i];
                  int currProfit = currPrice - minBuyPrice - fee;
                  if (currProfit > profit) {
                        profit = currProfit;
                  }
                  int currBuyPrice = currPrice - profit;
                  if (currBuyPrice < minBuyPrice) {
                        minBuyPrice = currBuyPrice;
                  }
            }

            return  profit ;
      }

      public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length == 0) {return 0;}

            int len = prices.length;
            int[] hold = new int[len + 1];
            int[] nothold = new int[len + 1];

            hold[0] = -0x3f3f3f3f;

            for (int i = 1; i <= len; i++) {
                  hold[i] = Math.max(hold[i - 1], nothold[i - 1] - prices[i - 1]);
                  nothold[i] = Math.max(nothold[i - 1], hold[i - 1] + prices[i - 1] - fee);
            }

            return nothold[len];
      }
}