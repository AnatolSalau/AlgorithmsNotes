package yandex_internet.fing_subarr_equal_k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Дан список интов и число-цель. Нужно найти такой range, чтобы сумма его элементов давала число-цель.
 * elements = [1, -3, 4, 5]
 * target = 9
 * result = range(4, 5) # because elements[3] + elements[4] == target
 */
/*
      0 ->  1
      1 -> -2
      2 ->  2
      3 ->  7

      [1, -3, 4, 5]
              ____ -> 9
       _____ -> -2
      ____________ -> 7 - 9 = -2
 */
public class FindSubArrEqualK {
      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      /*    k = 9
          i:0   1  2  3
            1, -3, 4, 5
            *                   1 -> 0
            sum = 1, sum - k(1 - 9) = -8

          i:1   1  2  3
            1, -3, 4, 5         1 -> 0
                *              -2 -> 1
            sum = -2, sum - k (-2 - 9) = -11

          i:2   1  2  3
            1, -3, 4, 5         1 -> 0
                   *           -2 -> 1
                                2 -> 2
            sum = 2, sum - k (2 - 9) = -7

          i:3   1  2  3
            1, -3, 4, 5         1 -> 0
                      *        -2 -> 1
                                2 -> 2
            sum = 7, sum - k (7 - 9) = -2, -2 is exist in map -> so result is -> from i: 2 to i:3

       */
      private static void testOne() {
            int[] elements = {1, -3, 4, 5};
            int k = 9;
            int[] expectedResult = {4, 5};

            System.out.println("Test 1");
            System.out.println(Arrays.toString(elements));
            System.out.println("k = " + k);
            System.out.println(Arrays.toString(getSubArrByPrefixMap(elements, k)));
            System.out.println();
      }

      private static void testTwo() {
            int[] elements = {4, 1, -5, 8, -14, 2, 4, 3};
            int k = 6;
            int[] expectedResult = {2, 4};
            System.out.println("Test 2");
            System.out.println(Arrays.toString(elements));
            System.out.println("k = " + k);
            System.out.println(Arrays.toString(getSubArrByPrefixMap(elements, k)));
            System.out.println();
      }

      /*
            0  1  2  3   4   5  6  7
            4, 1,-5, 8, -14, 2, 4, 3
            k = 6
            expected result = 2 - 4 i(5) - i(6)
            Solution by prefix sum map
           1. Go through arr
                  - calculate sum every iteration
                  - add to map sum elements with cur index
                        sum -> index
           2. Like example
            0  1  2  3   4   5  6  7
            4, 1,-5, 8, -14, 2, 4, 3, k=6
                                *
                                4->0
                                5->1
                                0->2
                                8->3
                               -6->4
                               -4->5
                                0->6
            curr sum = 0
            currSum - k = 0 - 6 = - 6 -> -6 is exist in map
            so. we have
         range         curr sum = 0 -> from i(0) to i(6)
                _____________________
         prefix       -6 -> from i(0) to i(4)
                _______________
                4, 1,-5, 8, -14, 2, 4, 3
                                _____
         suffix                  k = 6 because -> 0 - 6 = -6 -
       */
      private static int[] getSubArrByPrefixMap(int[] elem, int target) {
            HashMap<Integer, Integer> sumIndexPrefixMap = new HashMap<>();
            List<Integer> result = new ArrayList<>();

            int sum = 0;
            for (int i = 0; i < elem.length; i++) { // iterate through arr                            //O(n)
                  int curr = elem[i];
                  sum = sum + curr;//update sum with curr value

                  sumIndexPrefixMap.put(sum,i); //update map with curr  (sum -> index)                //O(1)

                  if (sum == target) { // if current range equal k - just return curr index
                        result.add(elem[0]);//add start value
                        result.add(elem[i]);//add end
                        return result.stream().mapToInt(Integer::intValue).toArray();         //O(2)
                  }

                  int prefix = sum - target;

                  if (sumIndexPrefixMap.containsKey(prefix)) { // if map contains prefix        //O(1)
                        Integer endPrefixIndex = sumIndexPrefixMap.get(prefix); // get prefix end index
                        result.add(elem[endPrefixIndex + 1]);// add start value
                        result.add(elem[i]);
                        return result.stream().mapToInt(Integer::intValue).toArray();        //O(n)
                  }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();// result O(n)
      }


}
