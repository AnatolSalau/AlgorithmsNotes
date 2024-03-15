package stream_api.intersection;

import java.util.*;

public class ArraysIntersection {
      /**
             Given two integer arrays nums1 and nums2, return an array of their intersection.
             Each element in the result must appear as many times as it shows in both arrays
             and you may return the result in any order.

             Example 1:
             Input: nums1 = [1,2,2,1], nums2 = [2,2]
             Output: [2,2]

             Example 2:
             Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
             Output: [4,9]
             Explanation: [9,4] is also accepted.
       */
      public static void main(String[] args) {
            test1();
            test2();
      }

      public int[] intersect(int[] nums1, int[] nums2) {
          return null;

      }

      static void test1() {
            ArraysIntersection task14HashMap = new ArraysIntersection();

            int[]nums1 = {1,2,2,1};
            int[]nums2 = {2,2};
            String expectedResult = "[2,2]";
            System.out.println(Arrays.toString(task14HashMap.intersect(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
      }

      static void test2() {
            ArraysIntersection task14HashMap = new ArraysIntersection();
            int[]nums1 = {4,9,5};
            int[]nums2 = {9,4,9,8,4};
            String expectedResult = "[4,9]";
            System.out.println(Arrays.toString(task14HashMap.intersect(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
      }
}
