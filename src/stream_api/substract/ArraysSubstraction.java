package stream_api.substract;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ArraysSubstraction {
      /**
       * Given two integer arrays nums1 and nums2, return an array of their subtraction.
       * <p>
       * Example 1:
       * Input: nums1 = [1,2,2,1], nums2 = [2,2]
       * Output: [1,1]
       * <p>
       * Example 2:
       * Input: nums1 = [9,4,9,8,4], nums2 = [4,9,5]
       * Output: [8]
       */
      public static void main(String[] args) {
            test1();
            test2();
      }

      public int[] substract(int[] nums1, int[] nums2) {
            Set<Integer> set2 = Arrays.stream(nums2)
                  .boxed()
                  .collect(Collectors.toSet());

            int[] subtraction = Arrays.stream(nums1)
                  .filter(e -> !set2.contains(e))
                  .toArray();

            return subtraction;
      }

      static void test1() {
            ArraysSubstraction task14HashMap = new ArraysSubstraction();

            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            String expectedResult = "[1,1]";
            System.out.println(Arrays.toString(task14HashMap.substract(nums1, nums2)));
            System.out.println("Exp : " + expectedResult);
      }

      static void test2() {
            ArraysSubstraction task14HashMap = new ArraysSubstraction();
            int[] nums1 = {4, 9, 5};
            int[] nums2 = {9, 4, 9, 8, 4};
            String expectedResult = "[5]";
            System.out.println(Arrays.toString(task14HashMap.substract(nums1, nums2)));
            System.out.println("Exp : " + expectedResult);
      }
}
