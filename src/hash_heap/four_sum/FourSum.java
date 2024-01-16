package hash_heap.four_sum;
import java.util.*;

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
            fourSum.test2();
            fourSum.test3();
            fourSum.test4();
      }
      /*
           1. Get Map All Sum Pair Indexes

            5 -> [1, 2]
            6 -> [1, 3]
            7 -> [1, 4, 2, 3]
            8 -> [2, 4]
            9 -> [1, 6, 3, 4]
            10 -> [1, 7, 2, 6]
            11 -> [1, 5, 2, 7, 3, 6]
            12 -> [0, 1, 2, 5, 3, 7, 4, 6]
            13 -> [0, 2, 3, 5, 4, 7]
            14 -> [0, 3, 4, 5]
            15 -> [0, 4, 6, 7]
            16 -> [5, 6]
            17 -> [0, 6, 5, 7]
            18 -> [0, 7]
            19 -> [0, 5]

            2. Get Quadruplets Is Equal Target


       */
      void test1() {
            int [] arr = {1,0,-1,0,-2,2};
            int target = 0;
            String expected = """
            [-2,-1,1,2]
            [-2,0,0,2]
            [-1,0,0,1]
            """;
            Map<Integer, ArrayList<Integer>> allSumPairIndexes = getMapAllSumIndexesPair(arr);

            System.out.println(Arrays.toString(arr));
            System.out.println("Sum map with indexes : ");
            printMap(allSumPairIndexes);
            System.out.println();

            Set<Set<Integer>> quadrupletsIndexesIsEqualTarget = getQuadrupletsIndexesIsEqualTarget(allSumPairIndexes, arr, target);

            System.out.println("Quadruplets indexes with sum =  " + target);
            printSet(quadrupletsIndexesIsEqualTarget, arr);

            System.out.println("Expected:");
            System.out.println(expected);
            System.out.println();
      }

      void test2() {
            int [] arr = {2,2,2,2,2};
            int target = 8;
            String expected = "2 2 2 2";
            Map<Integer, ArrayList<Integer>> allSumPairIndexes = getMapAllSumIndexesPair(arr);

            System.out.println(Arrays.toString(arr));
            System.out.println("Sum map with indexes : ");
            printMap(allSumPairIndexes);
            System.out.println();

            Set<Set<Integer>> quadrupletsIndexesIsEqualTarget = getQuadrupletsIndexesIsEqualTarget(allSumPairIndexes, arr, target);

            System.out.println("Quadruplets indexes with sum =  " + target);
            printSet(quadrupletsIndexesIsEqualTarget, arr);

            System.out.println("Expected = " + expected);
            System.out.println();
      }

      void test3() {
            int [] arr = {10, 2, 3, 4, 5, 9, 7, 8};
            int target = 23;
            String expected = "3 5 7 8";
            Map<Integer, ArrayList<Integer>> allSumPairIndexes = getMapAllSumIndexesPair(arr);

            System.out.println(Arrays.toString(arr));
            System.out.println("Sum map with indexes : ");
            printMap(allSumPairIndexes);
            System.out.println();

            Set<Set<Integer>> quadrupletsIndexesIsEqualTarget = getQuadrupletsIndexesIsEqualTarget(allSumPairIndexes, arr, target);

            System.out.println("Quadruplets indexes with sum =  " + target);
            printSet(quadrupletsIndexesIsEqualTarget, arr);

            System.out.println("Expected = " + expected);
            System.out.println();
      }

      void test4() {
            int [] arr = {1, 2, 3, 4, 5, 9, 7, 8};
            int target = 16;
            String expected = "1 3 5 7";
            Map<Integer, ArrayList<Integer>> allSumPairIndexes = getMapAllSumIndexesPair(arr);

            System.out.println(Arrays.toString(arr));
            System.out.println("Sum map with indexes : ");
            printMap(allSumPairIndexes);
            System.out.println();

            Set<Set<Integer>> quadrupletsIndexesIsEqualTarget = getQuadrupletsIndexesIsEqualTarget(allSumPairIndexes, arr, target);

            System.out.println("Quadruplets indexes with sum =  " + target);
            printSet(quadrupletsIndexesIsEqualTarget, arr);

            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private Set<Set<Integer>> getQuadrupletsIndexesIsEqualTarget(Map<Integer, ArrayList<Integer>> allSumPairIndexesMap, int[] arr, int target) {
            Set<Set<Integer>> quadrupletsMap = new HashSet<>();
            for (Map.Entry<Integer, ArrayList<Integer>> entry : allSumPairIndexesMap.entrySet()) {
                  Integer sum = entry.getKey();

                  int remainder = target - sum;

                  ArrayList<Integer> sumIndexesPairs = entry.getValue();

                  if (allSumPairIndexesMap.containsKey(remainder)) {

                        ArrayList<Integer> remainderIndexesPair = allSumPairIndexesMap.get(remainder);

                        for (int i = 0; i < sumIndexesPairs.size(); i+= 2) {
                              for (int j = 0; j < remainderIndexesPair.size(); j+=2) {

                                    Set<Integer> quadrupletIndexes = new HashSet<>();

                                    quadrupletIndexes.add(sumIndexesPairs.get(i));
                                    quadrupletIndexes.add(sumIndexesPairs.get(i + 1));
                                    quadrupletIndexes.add(remainderIndexesPair.get(j));
                                    quadrupletIndexes.add(remainderIndexesPair.get(j+1));
                                    if (quadrupletIndexes.size() >= 4)
                                          quadrupletsMap.add(quadrupletIndexes);

                              }
                        }

                  }
            }
            return quadrupletsMap;
      }

      private Map<Integer, ArrayList<Integer>> getMapAllSumIndexesPair(int[] arr) {
            Map<Integer, ArrayList<Integer>> allSumPairIndexesMap = new HashMap<>();

            for (int i = 0; i < arr.length - 1; i++) {
                  for (int j = i + 1; j < arr.length; j++) {
                        int currSum = arr[i] + arr[j];

                        if (allSumPairIndexesMap.containsKey(currSum)) {
                              ArrayList<Integer> currIndexesArr = allSumPairIndexesMap.get(currSum);
                              currIndexesArr.add(i);
                              currIndexesArr.add(j);
                              allSumPairIndexesMap.put(currSum,currIndexesArr);

                        } else {
                              ArrayList<Integer> newIndexesArr = new ArrayList<Integer>();
                              newIndexesArr.add(i);
                              newIndexesArr.add(j);
                              allSumPairIndexesMap.put(currSum,newIndexesArr);
                        }
                  }
            }
            return allSumPairIndexesMap;
      }

      void printMap(Map<Integer, ArrayList<Integer>> mapAllSumPairIndexes) {
            mapAllSumPairIndexes.entrySet().forEach(
                  (entry) -> {
                        System.out.println(entry.getKey() + " -> " + entry.getValue());
                  }
            );
      }
      private void printSet(Set<Set<Integer>> quadrupletsIsEqualTarget, int[] arr) {
            quadrupletsIsEqualTarget.forEach(
                  ( list -> {
                        int sum = 0;
                        int[] values = new int[4];
                        int i = 0;
                        for (int index : list) {
                              sum += arr[index];
                              values[i] = arr[index];
                              i++;
                        }
                        System.out.println(sum + " values:" + Arrays.toString(values) + " -> indexes:" + list);
                  })
            );
      }
}
