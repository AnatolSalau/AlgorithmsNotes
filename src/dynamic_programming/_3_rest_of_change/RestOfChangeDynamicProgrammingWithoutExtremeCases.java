package dynamic_programming._3_rest_of_change;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">...</a>
 *
 * <a href="https://www.youtube.com/watch?v=-apNZkl_yPI&list=PLUfHxBkkFMScK6mOOWp5s6LgbzmtfwmYQ&index=7">...</a> Theory
 *
 * <a href="https://www.youtube.com/watch?v=NNcN5X1wsaw">...</a> Java
 */
public class RestOfChangeDynamicProgrammingWithoutExtremeCases {
    public static void main(String[] args) {
        RestOfChangeDynamicProgrammingWithoutExtremeCases restOfChangeGreedyApproach = new RestOfChangeDynamicProgrammingWithoutExtremeCases();
        restOfChangeGreedyApproach.test1();
        restOfChangeGreedyApproach.test2();
    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount == 0) return 0;
        if (amount == 1) return 1;
        if (amount == coins[coins.length - 1]) {
            return 1;
        }
        //create progression for all amounts before our amount
        int[] dynamic = new int[amount + 1];
        dynamic[0] = 0;
        dynamic[1] = 1;

        for (int i = 2; i < dynamic.length; i++) {
            int curAmount = i;

            PriorityQueue<Integer> allCoinQtyForCurrAmountHeap = new PriorityQueue<>();
            int[] allCoinsThatEqualOrLessCurrAmount = getAllCoinsThatEqualOrLessCurrAmount(coins, curAmount);

            for (int j = 0; j < allCoinsThatEqualOrLessCurrAmount.length; j++) {
                int currCoin = allCoinsThatEqualOrLessCurrAmount[j];
                int currQty = getCoinQtyForCurrAmount(currCoin, curAmount, dynamic);
                allCoinQtyForCurrAmountHeap.add(currQty);
            }
            int minQtyForCurrAmount = allCoinQtyForCurrAmountHeap.poll();
            dynamic[curAmount] = minQtyForCurrAmount;

        }
        System.out.println();
        int result = dynamic[amount];
        return result;
    }

    private int[] getAllCoinsThatEqualOrLessCurrAmount(int[] coins, int currAmount) {
        int lastIndexThatLessOrEqualAmount = -1;

        for (int i = 0; i < coins.length; i++) {
            int curr = coins[i];
            if (curr <= currAmount) {
                lastIndexThatLessOrEqualAmount++;
            }
        }
        int[] result = new int[lastIndexThatLessOrEqualAmount + 1];

        for (int i = 0; i < result.length; i++) {
            int curr = coins[i];
            result[i] = curr;
        }
        return result;
    }

    private int getCoinQtyForCurrAmount(int coin, int currAmount, int[] dynamic) {
        if (coin == currAmount) return 1;

        int remainder = 0;
        int qty = 0;
        while (remainder > -1) {
            remainder = currAmount - coin;
            qty++;
            if (remainder < dynamic.length && remainder >= 0) {
                int qtyFromDynamic = dynamic[remainder];
                return qtyFromDynamic + qty;
            }
        }
        return qty;
    }


    public void test1() {
        System.out.println("Test 1");
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expect = 3;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("11 = 5 + 5 + 1");
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    public void test2() {
        System.out.println("Test 2");
        int[] coins = {1, 5, 6, 9};
        int amount = 11;
        int expect = 2;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("11 = 5 + 6");
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

}
