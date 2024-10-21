package leetcode_15_patterns.prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ContiguosSubArrTwoPointer {

    /**
     * <a href="https://leetcode.com/problems/contiguous-array/description/">...</a>
     * <a href="https://www.youtube.com/watch?v=LLl9fG1ZvMg&ab_channel=DeveloperDocs">...</a>
     * <a href="https://algo.monster/liteproblems/525">...</a>
     */
    public static void main(String[] args) {
        ContiguosSubArrTwoPointer obj = new ContiguosSubArrTwoPointer();
        obj.test1();
        obj.test2();
        obj.test3();
        obj.test4();
    }
    /*
     * 0, 1, 0, 1, 1, 0, 0
     * i  j = 0
     * i     j = -1 -> check next = 0
     * i        j = 0
     * i           j = 1 -> check next = 0
     * i              j = 0
     * i                 j = -1 -> check next = end of arr -> return length
     */
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        for (int left = 0; left < nums.length; left++) {
            int count0 = 0, count1 = 0;
            for (int right = left; right < nums.length; right++) {
                // Count 0s and 1s
                if (nums[right] == 0) {
                    count0++;
                } else {
                    count1++;
                }

                // If we have equal number of 0s and 1s, update the max length
                if (count0 == count1) {
                    maxLength = Math.max(maxLength, right - left + 1);
                }
            }
        }
        return maxLength;
    }


    public void test1() {
        int[] nums = {0,1,0};
        int expected = 2;
        int actual = findMaxLength(nums);

        System.out.println("Test 1");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test2() {
        int[] nums = {0,1,0,1};
        int expected = 4;
        int actual = findMaxLength(nums);

        System.out.println("Test 2");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test3() {
        int[] nums = {1,0,0,1,0,1,1};
        int expected = 6;
        int actual = findMaxLength(nums);

        System.out.println("Test 3");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

    public void test4() {
        int[] nums = {0, 1, 0, 1, 1, 0, 0};
        int expected = 6;
        int actual = findMaxLength(nums);

        System.out.println("Test 4");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

}
