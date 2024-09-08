package dynamic_programming._3_rest_of_change;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <a href="https://leetcode.com/problems/coin-change/description/">...</a>
 *
 * <a href="https://www.youtube.com/watch?v=-apNZkl_yPI&list=PLUfHxBkkFMScK6mOOWp5s6LgbzmtfwmYQ&index=7">...</a> Theory
 *
 * <a href="https://www.youtube.com/watch?v=NNcN5X1wsaw">...</a> Java
 */
public class RestOfChangeGreedyApproach {
    public static void main(String[] args) {
        RestOfChangeGreedyApproach restOfChangeGreedyApproach = new RestOfChangeGreedyApproach();
        //restOfChangeGreedyApproach.test1();
        restOfChangeGreedyApproach.test2();
    }

    /*

     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);// sort arr
        PriorityQueue<Integer> qtyCoinsQueue = new PriorityQueue<>(
                Comparator.comparingInt(Integer::intValue)
        );
        if (coins[coins.length - 1] == amount) return 1; // if max coin equal to amount


        for (int i = coins.length - 1; i >= 0; i--) {
            int nominal = coins[i]; // curr coin (max coin)
            int qtyCoins = 1; // curr qty coins for change
            int remainder = amount - nominal;
            if (remainder >= nominal) {
                while (remainder >= nominal) { // increase qty coins
                    remainder = remainder - nominal;
                    qtyCoins += 1;
                }
            }

            if (qtyCoins > 1) qtyCoinsQueue.add(qtyCoins);// add to qtyCoinsQueue curr qty coins
        }
        if (!qtyCoinsQueue.isEmpty()) {
            return qtyCoinsQueue.peek();
        } else {
            return -1;
        }
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
