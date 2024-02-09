package two_pointers.find_all_pairs_with_sum;

import java.util.*;

/**
 * Given a sorted array A {2, 3, 5, 8, 9, 10, 11 } return indexes elements which sum equals target.
 * target = 17
 */
public class FindAllPairsWithSum {
      public static void main(String[] args) {
            FindAllPairsWithSum findPairIsEqualTarget = new FindAllPairsWithSum();
            findPairIsEqualTarget.testTwoPointersApproach();
            findPairIsEqualTarget.testHashApproach();
      }
      /*
           0  1  2  3  4  5  6   7
           2, 3, 5, 7, 8, 9, 10, 11
       */
      private void testTwoPointersApproach() {
            int[] arr = {2, 3, 5, 7, 8, 9, 10, 11};
            int target = 17;
            List<Integer> indexes = findIndexesByTwoPointers(arr, target);
            System.out.println("Two pointers approach");
            System.out.println(Arrays.toString(arr));
            System.out.println("Target : " + target);
            System.out.println(indexes);
            System.out.println("Expected result (indexes) : " + "[3, 6, 4, 5]");
            System.out.println("Expected result (numbers) : " + "(7+10=17), (8+9=17)");
            System.out.println();
      }

      private void testHashApproach() {
            int[] arr = {2, 3, 5, 7, 8, 9, 10, 11};
            int target = 17;
            List<Integer> indexes = findIndexesByHashing(arr, target);
            System.out.println("Hashing approach");
            System.out.println(Arrays.toString(arr));
            System.out.println("Target : " + target);
            System.out.println(indexes);
            System.out.println("Expected result (indexes) : " + "[3, 6, 4, 5]");
            System.out.println("Expected result (numbers) : " + "(7+10=17), (8+9=17)");
      }

      /*
      2 3 5 8 9 10 11 target = 17
      l            r  curr = 13
      2 3 5 8 9 10 11 target = 17
        l          r  curr = 14
      2 3 5 8 9 10 11 target = 17
          l         r curr = 16
      2 3 5 8 9 10 11 target = 17
            l       r curr = 19
      2 3 5 8 9 10 11 target = 17
            l    r    curr = 18
      2 3 5 8 9 10 11 target = 17
            l r       curr = 17
     */
      private List<Integer> findIndexesByTwoPointers(int[] arr, int target) {
            List<Integer> rightIndexes = new LinkedList<>();

            int l = 0;
            int r = arr.length - 1;

            while (l < r) {
                  int left = arr[l];
                  int right = arr[r];
                  int currSum = left + right;

                  if (currSum == target) {
                        rightIndexes.add(l);
                        rightIndexes.add(r);
                  }

                  if (currSum > target) { // decrease right pointer
                        r --;
                  } else { // increase left pointer
                        l ++;
                  }
            }

            return rightIndexes;
      }

      /*
            int[] arr = {2, 3, 5, 7, 8, 9, 10, 11};
            int target = 17;
            expected : (7+10=17), (8+9=17)

            curr = 2
            remained = 17 - 2 = 15
            [15 -> 0]

            curr = 3
            remained = 17 - 3 = 14
            [15 -> 0]
            [14 -> 1]

            curr = 5
            remained = 17 - 5 = 12
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]

            curr = 7
            remained = 17 - 7 = 10
            [10 -> 7]
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]

            curr = 8
            remained = 17 - 8 = 9
            [9 ->  4]
            [10 -> 3]
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]

            curr = 9 -> 9 is exist in hash map so add to result indexes this numbers
            remained = 17 - 9 = 8
            [8  -> 5]
            [9  -> 4]
            [10 -> 3]
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]

            curr = 10 -> 10 is exist in hash map so add to result indexes this numbers
            remained = 17 - 10 = 7
            [7 -> 6 ]
            [8  -> 5]
            [9  -> 4]
            [10 -> 3]
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]

            curr = 11
            remained = 17 - 11 = 6
            [6 -> 7 ]
            [7 -> 6 ]
            [8  -> 5]
            [9  -> 4]
            [10 -> 3]
            [12 -> 2]
            [15 -> 0]
            [14 -> 1]
       */
      private List<Integer> findIndexesByHashing(int[] arr, int target) {
            List<Integer> rightIndexes = new LinkedList<>();

            Map<Integer, Integer> remainderIndexMap = new HashMap(); //

            for(int i = 0; i < arr.length; i++) {
                  int curr = arr[i];
                  int remainder = target - curr;

                  if (remainderIndexMap.containsKey(curr)) {
                        rightIndexes.add(remainderIndexMap.get(curr));
                        rightIndexes.add(i);
                  }
                  remainderIndexMap.put(remainder, i);

            }
            return rightIndexes;
      }
}
