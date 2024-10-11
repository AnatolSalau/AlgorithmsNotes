package leetcode_15_patterns.prefix_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class ContiguosSubArr {

    /**
     * <a href="https://www.youtube.com/watch?v=LLl9fG1ZvMg&ab_channel=DeveloperDocs">...</a>
     */
    public static void main(String[] args) {
        ContiguosSubArr obj = new ContiguosSubArr();
        obj.test1();
        obj.test2();
        obj.test3();
    }
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum--;
            }
            else {
                sum++;
            }
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            }
            else {
                map.put(sum, i);
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
        int[] nums = {0,0,0,1,0,1,0,1,0,0,1,1};
        int expected = 6;
        int actual = findMaxLength(nums);

        System.out.println("Test 3");
        System.out.println("nums : " + Arrays.toString(nums));
        System.out.println("expected : " + expected);
        System.out.println("actual : " + actual);
    }

}
