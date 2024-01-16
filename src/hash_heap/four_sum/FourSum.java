package hash_heap.four_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
       Given an array nums of n integers, return an array of all the unique quadruplets
       nums[a], nums[b], nums[c], nums[d]] such that:

       0 <= a, b, c, d < n
       a, b, c, and d are distinct (indexes of elements are different).

       nums[a] + nums[b] + nums[c] + nums[d] == target

       You may return the answer in any order.

       Example 1:
       Input: nums = [1,0,-1,0,-2,2], target = 0
       Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

       Example 2:
       Input: nums = [2,2,2,2,2], target = 8
       Output: [[2,2,2,2]]

       Example 3:
       Input: array = {10, 2, 3, 4, 5, 9, 7, 8}, X = 23
       Output: 3 5 7 8
       Explanation: Sum of output is equal to 23, i.e. 3 + 5 + 7 + 8 = 23.

       Example 4:
       Input: array = {1, 2, 3, 4, 5, 9, 7, 8}, X = 16
       Output: 1 3 5 7
       Explanation: Sum of output is equal to 16, i.e. 1 + 3 + 5 + 7 = 16.
 */
public class FourSum {
      public static void main(String[] args) {
            FourSum fourSum = new FourSum();
            fourSum.test1();
      }
      /*
           Get Map All Sum Pair Indexes

       */
      void test1() {
            int [] arr1 = {10, 2, 3, 4, 5, 9, 7, 8};
            int target = 23;
            Map<Integer, ArrayList<Integer>> integerArrayListMap = getMapAllSumPairIndexes(arr1);
            printMap(integerArrayListMap);
/*            List<List<Integer>> quadrupletsIsEqualTarget = getQuadrupletsIsEqualTarget(arr1, integerArrayListMap, target);
            Set<List<Integer>> quadrupletsWithoutDublucates = removeAllArrWithDublicates(quadrupletsIsEqualTarget);
            System.out.println("quadrupletsWithoutDublucates : ");*/
      }

      private Map<Integer, ArrayList<Integer>> getMapAllSumPairIndexes(int[] arr) {
            return null;
      }

      void printMap(Map<Integer, ArrayList<Integer>> mapAllSumPairIndexes) {
            mapAllSumPairIndexes.entrySet().forEach(
                  (entry) -> {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                  }
            );
      }
}
