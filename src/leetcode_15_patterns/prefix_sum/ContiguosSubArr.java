package leetcode_15_patterns.prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ContiguosSubArr {

    /**
     * <a href="https://leetcode.com/problems/contiguous-array/description/">...</a>
     * <a href="https://www.youtube.com/watch?v=LLl9fG1ZvMg&ab_channel=DeveloperDocs">...</a>
     * <a href="https://algo.monster/liteproblems/525">...</a>
     */
    public static void main(String[] args) {
        ContiguosSubArr obj = new ContiguosSubArr();
        obj.test1();
        obj.test2();
        obj.test3();
        obj.test4();
    }

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int j = 0; j < nums.length; j++) {
            int curr = nums[j];

            if (curr == 0) sum--;
            else sum ++;

            if (sumIndexMap.containsKey(sum)) {
                int i = sumIndexMap.get(sum);
                maxLength = Math.max(maxLength, j - (i));
            } else {
                sumIndexMap.put(sum, j);
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
    /*
     * 0, 1, 0, 1, 1, 0, 0
     * i  j = 0
     * i     j = -1 -> check next = 0
     * i        j = 0
     * i           j = 1 -> check next = 0
     * i              j = 0
     * i                 j = -1 -> check next = end of arr -> return length
     */
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
