package hash_heap.single_number;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
public class SingleNumber {
      public static void main(String[] args) {

            SingleNumber singleNumber = new SingleNumber();
            singleNumber.test1();
            singleNumber.test2();
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

      private int getUnRepeatableEl(int[] nums2) {
            Map<Integer, Integer> freqMap= new HashMap<>();
            for (int key : nums2) {
                  if (freqMap.containsKey(key)) {
                        Integer count = freqMap.get(key);
                        count ++;
                        freqMap.put(key,count);
                  } else {
                        freqMap.put(key,1);
                  }
            }
            Set<Map.Entry<Integer, Integer>> entries = freqMap.entrySet();

            for (Map.Entry<Integer, Integer> en : entries) {
                  if (en.getValue() == 1) return en.getKey();
            }

            return -1;
      }

}
