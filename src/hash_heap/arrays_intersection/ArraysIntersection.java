package hash_heap.arrays_intersection;

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
            HashMap<Integer, Integer> nums1QtyMap = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                  int curr = nums1[i];
                  if (nums1QtyMap.containsKey(curr)) {
                        int val = nums1QtyMap.get(curr);
                        val++;
                        nums1QtyMap.put(curr,val);
                  } else {
                        nums1QtyMap.put(curr,1);
                  }
            }
            HashMap<Integer, Integer> nums2QtyMap = new HashMap<>();
            for (int i = 0; i < nums2.length; i++) {
                  int curr = nums2[i];
                  if (nums2QtyMap.containsKey(curr)) {
                        int val = nums2QtyMap.get(curr);
                        val++;
                        nums2QtyMap.put(curr,val);
                  } else {
                        nums2QtyMap.put(curr,1);
                  }
            }

            Set<Map.Entry<Integer, Integer>> entriesMap1 = nums1QtyMap.entrySet();
            List<Integer> result = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : entriesMap1) {
                  Integer keyMap1 = entry.getKey();
                  Integer valueMap1 = entry.getValue();

                  if (nums2QtyMap.containsKey(keyMap1)) {
                        Integer valueMap2 = nums2QtyMap.get(keyMap1);
                        int minVal = valueMap1 < valueMap2 ? valueMap1 : valueMap2;
                        for (int i = 0; i < minVal; i++) {
                              result.add(keyMap1);
                        }
                  }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();

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
