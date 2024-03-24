package greedy_problem.best_buy_sell_medium;

/**
 You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

 On each day, you may decide to buy and/or sell the stock.
 You can only hold at most one share of the stock at any time.
 However, you can buy it then immediately sell it on the same day.

 Find and return the maximum profit you can achieve.

 Example 1:

 Input: prices = [7,1,5,3,6,4]
 Output: 7
 Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 Total profit is 4 + 3 = 7.

 Example 2:

 Input: prices = [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Total profit is 4.

 Example 3:
 Input: prices = [7,6,4,3,1]
 Output: 0
 Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

 */
public class BestBuySellMedium {

      public static void main(String[] args) {
            BestBuySellMedium bestBuySellMedium = new BestBuySellMedium();
            bestBuySellMedium.testOne();
            bestBuySellMedium.testTwo();
            bestBuySellMedium.testThree();
      }
      /*
            Explanation
            1. Create minBay var
            2. Create profit var
            3. Go through arr
                  1. change minBuy
                  2. calculate curr profit
                  3. add curr profit to profit
            4. Return profit
       */
      /*
            i:    0 1 2 3 4 5
                  7 1 5 3 6 4
            minBuy = 7
            maxProfit = 0
            i:0
            cur = 7
            minBuy = Math.min(7,7) = 7
            curProfit = 7 - 7 = 0
            i:1
            cur = 1
            minBuy = Math.min(1,7) = 1
            curProfit = 1 - 1 = 0
            i:2
            cur = 5
            minBuy = Math.min(1,5) = 1
            curProfit = 5 - 1 = 4 ->
                  result = 4
                  minBuy = 5
            i:3
            cur = 3
            minBuy = Math.min(5,3) = 3
            curProfit = 3 - 3 = 0
            i:4
            cur = 6
            minBuy = Math.min(6,3) = 3
            curProfit = 6 - 3 = 3 ->
                  result = 4 + 3 = 7
                  minBuy = 6
            i:5
            cur = 4
            minBuy = Math.min(4,6) = 4
            curProfit = 4 - 4 = 0
       */
      private void testOne() {
            int[] prices = {7,1,5,3,6,4};
            int expected = 7;
            int maxProfit = getMaxProfit(prices);
            System.out.println(maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      private void testTwo() {
            int[] prices = {1,2,3,4,5};
            int expected = 4;
            int maxProfit = getMaxProfit(prices);
            System.out.println(maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      private void testThree() {
            int[] prices = {7,6,4,3,1};
            int expected = 0;
            int maxProfit = getMaxProfit(prices);
            System.out.println(maxProfit);
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      private int getMaxProfit(int[] prices) {
            int minBuy = prices[0];
            int result = 0;

            for (int i = 0; i < prices.length; i++) {
                  int curPrice = prices[i];

                  minBuy = Math.min(curPrice,minBuy);

                  int curProfit = curPrice - minBuy;

                  result += curProfit;
                  minBuy = curPrice;
            }
            return result;
      }
}
