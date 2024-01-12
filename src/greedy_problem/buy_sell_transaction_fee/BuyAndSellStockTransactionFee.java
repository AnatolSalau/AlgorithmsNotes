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
            buyAndSellStockTransactionFee.testTwo();
            buyAndSellStockTransactionFee.testThree();
      }

      /*
            3 1 2 8 4 9
            i: 3
            min buy = 3
            1 - 3 - 2 = -4

            i: 1
            min buy = 1
            1 - 1 - 2 = -2

            i: 2
            min buy = 1
            2 - 1 - 2 = -1

            i: 8
            min buy = 1
            8 - 1 - 2 = 5 -> 5 > 0 so sell stock (add to answer) and buy new

            i: 4
            min buy = 4
            4 - 4 - 2 = -2

            i: 9
            min buy = 4
            9 - 4 - 2 = 3 -> 3 > 0 so sell stock (add to answer) and buy new

            as result,  we have ( 3 + 5 ) = 8,
            but also we have to check another opportunity  (max sell (9) - min buy (1) - 2) = 6
            and return Math.max(8,6) = 8
       */
      void testOne() {
            int[] prices = {3, 1, 2, 8, 4, 9};
            int fee = 2;
            int expected = 8;
            System.out.println(Arrays.toString(prices));
            System.out.println("Fee: " + fee);
            int maxProfit = getMaxProfit(prices, fee);
            System.out.println("Result : " + maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      /*
       */
      void testTwo() {
            int[] prices = {3, 1, 7, 5, 10, 3};
            int fee = 3;
            int expected = 6;
            System.out.println(Arrays.toString(prices));
            System.out.println("Fee: " + fee);
            int maxProfit = getMaxProfit(prices, fee);
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
            int maxProfit = getMaxProfit(prices, fee);
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
            int minBuy = prices[0];
            int minPrice = prices[0];
            int maxPrice = prices[0];
            int profitFromManyTransaction = 0;
            int result = 0;
            for (int currPrice : prices) {
                  minBuy = Math.min(currPrice, minBuy);
                  minPrice = Math.min(currPrice, minPrice);
                  maxPrice = Math.max(maxPrice, currPrice);
                  int currProfit = currPrice - minBuy - fee;
                  if (currProfit > 0) {
                        profitFromManyTransaction += currProfit;
                        minBuy = currPrice;
                  }
                  int maxProfitFromOneTransaction = maxPrice - minPrice - fee;
                  if (maxProfitFromOneTransaction > profitFromManyTransaction) {
                        result = maxProfitFromOneTransaction;
                        profitFromManyTransaction = maxProfitFromOneTransaction;
                        minPrice = currPrice;
                  }

            }
            return Math.max(profitFromManyTransaction, result);
      }
}