package dynamic_programming._7_house_robber;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/description/
 */
public class HouseRobberO1 {
    public static void main(String[] args) {
        HouseRobberO1 houseRobber = new HouseRobberO1();
        houseRobber.test1();
        houseRobber.test2();
        houseRobber.test3();
    }
    public int rob(int[] nums) {
        if (nums == null) return -1;
        if (nums.length == 1) return nums[0];

        int memorizationNotAdjustment = nums[0];
        int memorizationAdjustment = Math.max(nums[0], nums[1]);

        if (nums.length == 2) return memorizationAdjustment;

        for (int i = 2; i < nums.length; i++) { //start loop from third element
            int curr = nums[i];
            int maxProfitIfRobThisHouse = memorizationNotAdjustment + curr;
            int maxProfitIfNotRobThisHouse = memorizationAdjustment;
            int max = Math.max(maxProfitIfNotRobThisHouse, maxProfitIfRobThisHouse);
            memorizationNotAdjustment = memorizationAdjustment;
            memorizationAdjustment = max;
        }
        int result = memorizationAdjustment;
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
