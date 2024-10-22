package dynamic_programming._13_max_prod_sub;

import java.util.Arrays;


public class MaxProdSubArr {

    /**
     * <a href="https://www.youtube.com/watch?v=Y6B-7ZctiW8&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=10&ab_channel=NikhilLohia">...</a>
     * <a href="https://leetcode.com/problems/maximum-product-subarray/description/">...</a>
     */
    public static void main(String[] args) {
        MaxProdSubArr maxProdSubArr = new MaxProdSubArr();
        maxProdSubArr.test1();
        maxProdSubArr.test2();
        maxProdSubArr.test3();
        maxProdSubArr.test4();
        maxProdSubArr.test5();
    }
    /*
        1 1 1 1 1 1
        r         l
     */
    public int maxProduct(int[] nums) {

        int maxLeft = nums[0];
        int maxRight = nums[nums.length - 1];

        int N = nums.length;

        int leftPrefix = 1;
        int rightPrefix = 1;

        for (int l = 0; l < N; l++ ) {
            int r = N - l - 1;
            int left = nums[l];
            int right = nums[r];
            leftPrefix = leftPrefix *  left;
            rightPrefix = rightPrefix * right;



            maxLeft = Math.max(maxLeft, leftPrefix);
            maxRight = Math.max(maxRight, rightPrefix);

            if (leftPrefix == 0) {
                leftPrefix = 1;
            }
            if (rightPrefix == 0) {
                rightPrefix = 1;
            }

        }
        int result = Math.max(maxLeft, maxRight);
        return result;
    }

    public void test1() {
        System.out.println("Test 1");

        int[] nums = {2, 3, -2, 4};
        int expected = 6;
        int actual = maxProduct(nums);

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
        System.out.println();
    }

    public void test2() {
        System.out.println("Test 2");

        int[] nums = {-2, 0, -1};
        int expected = 0;
        int actual = maxProduct(nums);

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
        System.out.println();
    }

    public void test3() {
        System.out.println("Test 3");

        int[] nums = {2,3,-2,-5,6,-1,4};
        int expected = 360;
        int actual = maxProduct(nums);

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected + " -> 2,3,-2,-5, 6");
        System.out.println("actual : " + actual);
        System.out.println();
    }

    public void test4() {
        System.out.println("Test 4");

        int[] nums = {-2, 0, 1};
        int expected = 1;
        int actual = maxProduct(nums);

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
        System.out.println();
    }

    public void test5() {
        System.out.println("Test 5");

        int[] nums = {2, 3, 0, -5, 6, -1, 4};
        int expected = 6;
        int actual = maxProduct(nums);

        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
        System.out.println();
    }

}
