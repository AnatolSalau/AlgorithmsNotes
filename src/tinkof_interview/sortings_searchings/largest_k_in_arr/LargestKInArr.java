package tinkof_interview.sortings_searchings.largest_k_in_arr;

import java.util.Arrays;
/*
      `https://leetcode.com/problems/kth-largest-element-in-an-array/description/
 */
public class LargestKInArr {
      public static void main(String[] args) {
            LargestKInArr largestKInArr = new LargestKInArr();
            largestKInArr.test1();
            largestKInArr.test2();
      }

      public int findKthLargest(int[] nums, int k) {
            return -1;
      }

      public void test1() {
            System.out.println("Test 1");
            int[] nums = {3,2,1,5,6,4};
            int k = 2;
            System.out.println(Arrays.toString(nums));
            System.out.println("k = " + k);
            System.out.println("Expect : " + 5);
            int kthLargest = findKthLargest(nums, k);
            System.out.println("Result : " + kthLargest);
            System.out.println();
      }

      public void test2() {
            System.out.println("Test 2");
            int[] nums = {3,2,3,1,2,4,5,5,6};
            int k = 4;
            System.out.println(Arrays.toString(nums));
            System.out.println("k = " + k);
            System.out.println("Expect : " + 4);
            int kthLargest = findKthLargest(nums, k);
            System.out.println("Result : " + kthLargest);
            System.out.println();
      }
}
