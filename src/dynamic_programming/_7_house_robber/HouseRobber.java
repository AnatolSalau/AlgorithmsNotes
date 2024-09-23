package dynamic_programming._7_house_robber;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobber {
    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.test1();
        houseRobber.test2();
    }
    public int rob(int[] nums) {
        return 0;
    }
    /*
        Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
        Total amount you can rob = 1 + 3 = 4.
     */
    public void test1() {
        int[] nums = new int[]{1, 2, 3, 1};
        int expect = 4;
        int result = rob(nums);

        System.out.println("Test 1");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }
    /*
        Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
        Total amount you can rob = 2 + 9 + 1 = 12.
     */
    public void test2() {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        int expect = 12;
        int result = rob(nums);

        System.out.println("Test 2");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }
}
