package dynamic_programming._7_house_robber;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobberOn {
    public static void main(String[] args) {
        HouseRobberOn houseRobber = new HouseRobberOn();
        houseRobber.test1();
        houseRobber.test2();
        houseRobber.test3();
    }
    public int rob(int[] nums) {
        int[] memorization = new int[nums.length];
        memorization[0] = nums[0];
        memorization[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) { //start loop from third element
            int curr = nums[i];
            int maxProfitIfRobThisHouse = memorization[i - 2] + curr;
            int maxProfitIfNotRobThisHouse = memorization[i - 1];
            int max = Math.max(maxProfitIfNotRobThisHouse, maxProfitIfRobThisHouse);
            memorization[i] = max;
        }
        int result = memorization[memorization.length - 1];
        return result;
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
    /*
        Total amount you can rob = 7 + 4 + 8 = 19.
        10；47

    */
    public void test3() {
        int[] nums = new int[]{2,7,3,1,4,2,1,8};
        int expect = 19;
        int result = rob(nums);

        System.out.println("Test 2");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }
}
