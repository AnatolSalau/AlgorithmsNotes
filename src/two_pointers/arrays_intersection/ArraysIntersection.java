package two_pointers.arrays_intersection;

import java.util.Arrays;

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
      /*
            Explanation
            1. Sort arrays in increasing order
            2. Create three pointers
                  i - first array pointer
                  j - second array pointer
                  k - result array pointer
            3. Create result arr with length equal to the most large arr
            4. Go throught all our arrays (first, second)
                  - Compare current element from first and second arr every iteration
                        1. If elements are equal
                              -> copy element to result
                              -> move all pointers forward
                        2. Else (If elements are not equal)
                              -> If element from firs arr more than from second -> move j forward
                              -> Else (element from second arr more than from first) -> move i forward
            5. We have k pointer -> (this pointer - 1) -> show last filled index (none zero)
                  - go throught result and cut all zero values in tail of array
       */
      public int[] getIntersection(int[] nums1, int[] nums2) {
            //1. Sort arrays in increasing order
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            /*
            2. Create three pointers i - first array pointer, j - second array pointer, k - result array pointer
             */
            int i = 0;
            int j = 0;
            int k = 0;
            //3. Create result arr with length equal to the most large arr
            int maxLength = Math.max(nums1.length, nums2.length);
            int[] intermediateResult = new int[maxLength];
            //4. Go throught all our arrays (first, second)
            while (i< nums1.length && j < nums2.length) {
                  int el1 = nums1[i];
                  int el2 = nums2[j];
                  if (el1 == el2) {//Compare current element from first and second arr
                        intermediateResult[k] = el1; //-> copy element to result
                        i++; // move all pointers forward
                        j++;
                        k++;
                  } else { //If elements are not equal
                        if (el1 > el2) {//If element from firs arr more than from second -> move i forward
                              j++;
                        } else {  // element from second arr more than from first) -> move j forward
                              i++;
                        }
                  }
            }
            //5. We have k pointer -> this (pointer - 1) -> show last filled index (none zero)
            int[] result = new int[k];
          System.arraycopy(intermediateResult, 0, result, 0, k);
            return result;
      }

      /*
            1,2,2,1     -> 1 1 2 2
            2,2         -> 2 2

            i
            1 1 2 2 ->  i(1) < j(2) -> i++
            j
            2 2
            k
            0 0 0 0

              i
            1 1 2 2 ->  i(1) < j(2) -> i++
            j
            2 2
            k
            0 0 0 0

                i                         k
            1 1 2 2 ->  i(2) == j(2) -> 2 0 0 0, i++, j++, k++
            j
            2 2
            k
            0 0 0 0

                  i             i                         k
            1 1 2 2 ->  i(2) == j(2) -> 2 2 0 0, i++, j++, k++
              j
            2 2
              k
            2 0 0 0
       */
      static void test1() {
            ArraysIntersection twoPointer = new ArraysIntersection();

            int[]nums1 = {1,2,2,1};
            int[]nums2 = {2,2};
            System.out.println("Test 1");
            String expectedResult = "[2,2]";
            System.out.println(Arrays.toString(twoPointer.getIntersection(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
            System.out.println();
      }

      /*
            4,9,5       -> 4 5 9
            9,4,9,8,4   -> 4 4 8 9 9
            i
            4 5 9       -> i(4) == j(4) -> to answer
            j
            4 4 8 9 9
            k
            4 0 0 0 0

              i
            4 5 9       -> i(5) > j(4) -> j++
              j
            4 4 8 9 9
              k
            4 0 0 0 0

              i
            4 5 9       -> i(5) < j(8) -> i++
                j
            4 4 8 9 9
              k
            4 0 0 0 0

                i
            4 5 9       -> i(9) > j(8) -> j++
                j
            4 4 8 9 9
              k
            4 0 0 0 0

                i
            4 5 9       -> i(9) = j(9) -> add to ans
                  j
            4 4 8 9 9
              k
            4 0 0 0 0

       */
      static void test2() {
            ArraysIntersection twoPointer = new ArraysIntersection();
            int[]nums1 = {4,9,5};
            int[]nums2 = {9,4,9,8,4};
            System.out.println("Test 2");
            String expectedResult = "[4,9]";
            System.out.println(Arrays.toString(twoPointer.getIntersection(nums1,nums2 )));
            System.out.println("Exp : " + expectedResult);
            System.out.println();
      }
}
