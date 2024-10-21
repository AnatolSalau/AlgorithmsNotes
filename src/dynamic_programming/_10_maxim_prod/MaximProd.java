package dynamic_programming._10_maxim_prod;

import java.util.Arrays;


public class MaximProd {
    /**<a href="https://leetcode.com/problems/maximum-product-subarray/description">...</a> */
    public static void main(String[] args) {
        MaximProd obj = new MaximProd();
        obj.test1();
        obj.test2();
        obj.test3();
        obj.test4();
    }

    public int maxProduct(int[] nums) {
        return 0;
    }

    public void test1() {
        int[] nums = new int[]{2, 3, -2, 4};
        int expected = 6;
        int actual = maxProduct(nums);

        System.out.println("Test 1");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test2() {
        int[] nums = new int[]{-2, 0, -1};
        int expected = 0;
        int actual = maxProduct(nums);

        System.out.println("Test 2");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test3() {
        int[] nums = new int[]{0, 2};
        int expected = 2;
        int actual = maxProduct(nums);

        System.out.println("Test 3");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test4() {
        int[] nums = new int[]{2, 3, -2, 4};
        int expected = 6;
        int actual = maxProduct(nums);

        System.out.println("Test 4");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }
}
