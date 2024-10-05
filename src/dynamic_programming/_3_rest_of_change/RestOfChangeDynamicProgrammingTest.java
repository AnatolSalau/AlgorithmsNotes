package dynamic_programming._3_rest_of_change;

import java.util.Arrays;


/**
 * <a href="https://leetcode.com/problems/coin-change/description/">...</a>
 * <a href="https://www.youtube.com/watch?v=-apNZkl_yPI&list=PLUfHxBkkFMScK6mOOWp5s6LgbzmtfwmYQ&index=7">...</a> Theory
 * <a href="https://www.youtube.com/watch?v=NNcN5X1wsaw">...</a> Java
 */
public class RestOfChangeDynamicProgrammingTest {

    public static void main(String[] args) {
        RestOfChangeDynamicProgrammingTest restOfChangeGreedyApproach = new RestOfChangeDynamicProgrammingTest();
        restOfChangeGreedyApproach.test1();
        restOfChangeGreedyApproach.test2();
        restOfChangeGreedyApproach.test3();
        restOfChangeGreedyApproach.test4();
        restOfChangeGreedyApproach.test5();
        restOfChangeGreedyApproach.test6();

    }

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (amount <= 0) {
            return 0;
        }
        if (amount == 1) {
            if (coins[0] > amount) return -1;
            return 1;
        }
        int[] memorization = new int[amount + 1];
        memorization[1] = 1;
        memorization[2] = 2;

        for (int curr = 1; curr <= amount; curr++) {
            memorization[curr] = Integer.MAX_VALUE;

            for (int coin : coins) {
                int remainder = curr - coin;
                if (coin <= curr &&  memorization[remainder] != Integer.MAX_VALUE) {
                    memorization[curr] = Math.min(memorization[curr], memorization[curr - coin] + 1);
                }
            }

        }
        if (memorization[amount] == Integer.MAX_VALUE) {
            return -1;
        }
        return memorization[amount];
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

    public void test3() {
        System.out.println("Test 3");
        int[] coins = {2};
        int amount = 3;
        int expect = -1;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    public void test4() {
        System.out.println("Test 4");
        int[] coins = {186, 419, 83, 408};
        int amount = 6249;
        int expect = 20;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    public void test5() {
        System.out.println("Test 5");
        int[] coins = {431, 62, 88, 428};
        int amount = 9084;
        int expect = 26;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    public void test6() {
        System.out.println("Test 6");
        int[] coins = {1, 5, 6, 9};
        int amount = 11;
        int expect = 2;
        int result = coinChange(coins, amount);
        System.out.println("Coins : " + Arrays.toString(coins));
        System.out.println("Amount : " + amount);
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

}
