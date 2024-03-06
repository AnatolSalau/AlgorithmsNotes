package hash_heap.find_sub_arr_equal_k;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LongestSubarrayWithSumKNegative {
      /**
       * Дан массив целых чисел и число target.
       * Нужно найти непустой подотрезок (непрерывную подпоследовательность) с
       * заданной суммой target, либо сказать, что это невозможно.
       * Если такие отрезки есть, то надо вернуть любой отрезок (как индексы концов,
       * включительно).
       * Если нет, то (-1,-1)
       */
      public static void main(String[] args) {

            testOne();
            testTwo();
      }

      /*    i:    *
                  0  1  2  3    4  5  6  7
                  4, 1,-5, 8, -14, 2, 4, 3    k = -5, expected result = -5, 8, -14, 2, 4
            sum:  4
            i:    *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3      4 -(- 5) = 9
            sum:  4
            i:       *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3      5 -(- 5) = 10                       5 -> 1
            sum:     5
            i:          *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3      0 -(- 5) = 5                        5 -> 1      5 is exist. so 2 - 1 = 1 [2,2]
            sum:        0                                                           0 -> 2
            i:             *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3      8 -(- 5) = 13                       5 -> 1
            sum:           8                                                        0 -> 2
                                                                                    8 -> 3
            i:                  *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3      -6 -(- 5) = -1                      5 -> 1
            sum:               -6                                                   0 -> 2
                                                                                    8 -> 3
                                                                                   -6 -> 4
            i:                     *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3     -4 -(- 5) = 1                        5 -> 1
            sum:                  -4                                                0 -> 2
                                                                                    8 -> 3
                                                                                   -6 -> 4
                                                                                   -4 -> 5
            i:                        *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3     0 -(- 5) = 5                         5 -> 1      5 is exist so 6 - 1 = 5 [2,6]
            sum:                      0                                             0 -> 6
                                                                                    8 -> 3
                                                                                   -6 -> 4
                                                                                   -4 -> 5
            i:                           *
                  0  1  2  3    4  5  6  7                                          4 -> 0
                  4, 1,-5, 8, -14, 2, 4, 3     3 -(- 5) = 8                         5 -> 1
            sum:                         3                                          0 -> 6
                                                                                    8 -> 3      8 is exist so 7 - 3 = 4 [4,7] (-14, 2, 4, 3)
                                                                                   -6 -> 4
                                                                                   -4 -> 5
                                                                                    3 -> 7
       */
      static List<Integer> getLongestSubArray(int[] array, int k) {
            return null;
      }

      static void testOne() {
            int[] nums = {4, 1, -5, 8, -14, 2, 4, 3};
            int k = -5;
            int expectedLength1 = 5;
            int[] expectedResult1 = {-5, 8, -14, 2, 4};
            int expectedLength2 = 4;
            int[] expectedResult2 = {-14, 2, 4, 3};
            System.out.println("Test1");
            System.out.println("Arr: " + Arrays.toString(nums));
            System.out.println("K = " + k);
            System.out.println("Expect: " + Arrays.toString(expectedResult1));
            List<Integer> result = getLongestSubArray(nums, k);
            System.out.println("Result: " + result);
            System.out.println();
      }

      static void testTwo() {
            int[] nums = {1, 2, 1, 0, 1};
            int k = 4;
            int expectedLength1 = 4;
            List<Integer> result = getLongestSubArray(nums, k);
            System.out.println("Test1");
            System.out.println("Arr: " + Arrays.toString(nums));
            System.out.println("K = " + k);
            System.out.println("Expect: " + "[1, 2, 1, 0]");
            System.out.println("Result: " + result);
            System.out.println();
      }
}
