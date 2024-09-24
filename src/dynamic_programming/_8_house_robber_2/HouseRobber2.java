package dynamic_programming._8_house_robber_2;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 houseRobber = new HouseRobber2();
        houseRobber.test1();
        houseRobber.test2();
        houseRobber.test3();
    }
    public int rob(int[] nums) {
        return 0;
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
