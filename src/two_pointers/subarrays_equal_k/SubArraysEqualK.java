package two_pointers.subarrays_equal_k;

import java.util.*;

/**
       Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

       A subarray is a contiguous non-empty sequence of elements within an array.

       Example 1:

       Input: nums = [1,1,1], k = 2
       Output: 2
       Example 2:

       Input: nums = [1,2,3], k = 3
       Output: 2
 */
public class SubArraysEqualK {


      public static void main(String[] args) {
            SubArraysEqualK subArraysEqualK = new SubArraysEqualK();
            subArraysEqualK.test1();
            subArraysEqualK.test2();
            subArraysEqualK.test3();
      }

      private void test1() {
            int[] nums1 = {1,2,3};
            int k1 = 3;
            System.out.println("Test 1");
            System.out.println(Arrays.toString(nums1));
            System.out.println("k = " + k1);
            System.out.println("Expected result : 2");
            System.out.println("Result : " + bruteForceApproach(nums1,k1));
            System.out.println();
      }

      private void test2() {
            int[] nums2 = {1,1,1};
            int k2 = 2;
            System.out.println("Test 2");
            System.out.println(Arrays.toString(nums2));
            System.out.println("k = " + k2);
            System.out.println("Expected result : 2");
            System.out.println("Result : " + bruteForceApproach(nums2,k2));
            System.out.println();
      }
      /*
            Brute force approach

            1 2 2 3 2, k = 5

           ij
            1 2 2 3 2
            i j
            1 2 2 3 2
            i   j
            1 2 2 3 2
            i     j
            1 2 2 3 2
            1 2 2 3 2
            i       j
            1 2 2 3 2
             ij
            1 2 2 3 2
              i j
            1 2 2 3 2
              i   j
            1 2 2 3 2
       */
      /*
            Prefix HashTable approach


            1 2 2 3 2 5, k = 5

            i
            1 2 2 3 2 5
            1 -> 0
            1 - 5 = -4

              i
            1 2 2 3 2 5
            1 -> 0
            3 -> 1
            3 - 5 = -2

                i
            1 2 2 3 2 5
            1 -> 0
            3 -> 1
            5 -> 2
            5 - 5 = 0 - > 0 isContained in map from (i:0 to i:2)

                  i
            1 2 2 3 2 5
            1 -> 0
            3 -> 1
            5 -> 2
            8 -> 3
            8 - 5 = 3 - > 3 isContained in map from (i:2 to i:3)

                    i
            1 2 2 3 2 5
            1 -> 0
            3 -> 1
            5 -> 2
            8 -> 3
            10 -> 4
            10 - 5 = 5 - > 5 isContained in map from (i:3 to i:4)

                      i
            1 2 2 3 2 5
            1 -> 0
            3 -> 1
            5 -> 2
            8 -> 3
            10 -> 4
            15 -> 5
            15 - 5 = 10 - > 10 isContained in map from (i:5 to i:5)

       */
      private void test3() {
            int[] nums3 = {1,2,2,3,2,5};
            int k3 = 5;
            System.out.println("Test 3");
            System.out.println(Arrays.toString(nums3));
            System.out.println("k = " + k3);
            System.out.println("Expected result : 4");
            System.out.println("Result : " + hashMapApproach(nums3,k3).size());
            System.out.println();
      }

      private int bruteForceApproach(int[] nums, int k) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                  int sumSubArr = 0;
                  for (int j = i; j < nums.length ; j++) {
                        sumSubArr += nums[j];
                        if (sumSubArr == k ) count++;
                  }
            }
            return count;
      }

      List<List<Integer>> hashMapApproach(int arr[], int k)
      {
            HashMap<Integer, Integer> prefSum = new HashMap<>(); // prefix sum map

            List<List<Integer>> res = new LinkedList<>();

            int currSum = 0;

            for (int i = 0; i < arr.length; i++) {
                  int curr = arr[i];
                  currSum += curr;

                  if (currSum == k) { // check when currSUm equal k
                        List<Integer> list = new ArrayList<>();
                        list.add(0);
                        list.add(i);
                        res.add(list);
                  }
                  int remainder = currSum - k;

                  if (prefSum.containsKey(remainder)) {
                        List<Integer> list = new ArrayList<>();
                        Integer index = prefSum.get(remainder);
                        list.add(index + 1); // add next index after prefix
                        list.add(i);
                        res.add(list);
                  }
                  prefSum.put(currSum,i); // update prefSum
            }
            return res;
      }

}


