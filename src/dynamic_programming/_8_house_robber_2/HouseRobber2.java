package dynamic_programming._8_house_robber_2;

import java.util.Arrays;

/**
 * <a href="https://www.youtube.com/watch?v=ucmqYGVGQK8&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=7&ab_channel=NikhilLohia">...</a>
 * <a href="https://leetcode.com/problems/house-robber-ii/description/">...</a>
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 houseRobber = new HouseRobber2();
        houseRobber.test1();
        houseRobber.test2();
        houseRobber.test3();
    }
    public int rob(int[] nums) {
        int[] fromFirstToMinus1 = new int[nums.length - 1];
        int[] fromSecondToEnd = new int[nums.length - 1];
        //fill arrays

        fromFirstToMinus1[0] = nums[0];
        fromSecondToEnd[fromSecondToEnd.length-1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length-1; i++) {
            fromFirstToMinus1[i] = nums[i];
            fromSecondToEnd[i-1] = nums[i];
        }
        int firstMax = get_max(fromFirstToMinus1);
        int secondMax = get_max(fromSecondToEnd);
        int result = Math.max(firstMax, secondMax);

        return result;
    }

    public int get_max(int[] nums) {
        if (nums.length == 1) return nums[0];

        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] memorization = new int[nums.length];
        memorization[0] = nums[0];
        memorization[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < memorization.length ; i++) {
            int curr = nums[i];
            int robCurr = memorization[i - 2] + curr;
            int robPrev = memorization[i - 1];
            memorization[i] = Math.max(robCurr, robPrev);
        }
        return memorization[memorization.length - 1];
    }

    public void test1() {
        int[] nums = new int[] { 2, 3, 2 };
        int expect = 3;
        int result = rob(nums);

        System.out.println("Test 1");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    /*
            2
        1       3
            1
     */
    public void test2() {
        int[] nums = new int[] { 1, 2, 3, 1 };
        int expect = 4;
        int result = rob(nums);

        System.out.println("Test 2");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }

    public void test3() {
        int[] nums = new int[] { 1, 2, 3 };
        int expect = 3;
        int result = rob(nums);

        System.out.println("Test 3");
        System.out.println("Arr: " + Arrays.toString(nums));
        System.out.println("Result : " + result);
        System.out.println("Expect : " + expect);
        System.out.println();
    }
}
