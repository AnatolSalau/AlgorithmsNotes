package yandex_internet._16_single_number;

import java.util.Arrays;

/**
      https://leetcode.com/problems/single-number/description/?envType=study-plan-v2&envId=leetcode-75
       Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

       You must implement a solution with a linear runtime complexity and use only constant extra space.

       Example 1:
       Input: nums = [2,2,1]
       Output: 1

       Example 2:
       Input: nums = [4,1,2,1,2]
       Output: 4

       Example 3:
       Input: nums = [1]
       Output: 1
 */
public class SingleNumberByXoR {
      public static void main(String[] args) {

            SingleNumberByXoR singleNumber = new SingleNumberByXoR();
            singleNumber.test1();
            singleNumber.test2();
            singleNumber.test3();
      }

      private void test1() {
            int[] nums1 = {2,2,1};
            System.out.println(Arrays.toString(nums1));
            System.out.println("single number = " + getUnRepeatableEl(nums1));
            System.out.println("Expected : " + 1);
            System.out.println();
      }

      private void test2() {
            int[] nums2 = {4,1,2,1,2};
            System.out.println(Arrays.toString(nums2));
            System.out.println("single number = " + getUnRepeatableEl(nums2));
            System.out.println("Expected : " + 4);
            System.out.println();
      }

      private void test3() {
            int[] nums2 = {9,1,2,7,5,1,7,9,2};
            System.out.println(Arrays.toString(nums2));
            System.out.println("single number = " + getUnRepeatableEl(nums2));
            System.out.println("Expected : " + 5);
            System.out.println();
      }

      private int getUnRepeatableEl(int[] nums) {
            int first = nums[0];
            for (int i = 1; i < nums.length; i++) {
                  int second = nums[i];
                  first = (first | second) & (~first | ~second); // XoR Using other bitwise operators
                  //first = (x + y) - 2 * (x & y); //XoR Using XOR & SUM
            }
            return first;                    //Time  O(n) + O(n) = O(n * 2) + Memory O(n)
      }

}
