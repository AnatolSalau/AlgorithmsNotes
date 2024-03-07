package hash_heap.find_sub_arr_equal_k;

import java.util.*;

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
      /*
            1. Create hash map that will contain sum and index for all values before this index (sumIndexMap)
                  - this will be our prefix
            2. Create variable - currSum
            3. Go through arr
                  1. calculate current sum
                  2. save this sum in sumIndexMap
                  3. check if currSum is equal to target -> if equal return 0 and current index as segment's borders
                  4. calculate remainder from taking away of curr sum target (curSum - target = remainder)
                        this remainder is our prefix
                        remainder + target = currSum
                  5. if remainder is exist in sumIndexMap -> return next index after end of prefix and curr index
       */
      static List<Integer> getLongestSubArray(int[] array, int k) {
            int startIndex = 0;
            int endIndex = 0;
            List<Integer> result = new ArrayList<>();
            HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
            int currSum = 0;

            for (int i = 0; i < array.length; i++) {
                  currSum = currSum + array[i]; // 1. calculate current sum
                  sumIndexMap.put(currSum,i); // 2. save this sum in sumIndexMap
                  if ( currSum == k) { // 3. check if currSum is equal to target
                        startIndex = 0;//-> if equal return 0 and current index as segment's borders
                        endIndex = 0;
                  }
                  int remainderPrefix = currSum - k;//calculate remainder from taking away of curr sum target (curSum - target = remainder)

                  if (sumIndexMap.containsKey(remainderPrefix)) {//if remainder is exist in sumIndexMap
                        Integer endPrefixIndex = sumIndexMap.get(remainderPrefix);// return next index after end of prefix and curr index
                        startIndex = endPrefixIndex + 1;
                        endIndex = i;
                  }
            }
            //fill result
            for (int i = startIndex; i <= endIndex; i++) {
                  result.add(array[i]);
            }
            return result;
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
            System.out.println("Expect: " + Arrays.toString(expectedResult2));
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
