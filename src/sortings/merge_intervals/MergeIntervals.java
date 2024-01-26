package sortings.merge_intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
       Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
       and return an array of the non-overlapping intervals that cover all the intervals in the input.

       Example 1:
       Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
       Output: [[1,6],[8,10],[15,18]]
       Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

       Example 2:
       Input: intervals = [[1,4],[4,5]]
       Output: [[1,5]]
       Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {
      public static void main(String[] args) {
            MergeIntervals mergeIntervals = new MergeIntervals();
            mergeIntervals.test1();
            mergeIntervals.test2();
            mergeIntervals.test3();
      }
      private void test1() {
            int[][] arrays = {{1,3},{2,6},{8,10},{15,18}};
            int[][] expectedResult = {{1,6},{8,10},{15,18}};
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            sortIntervalsByFirstValueInSubArrQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void test2() {
            int[][] arrays = {{1,4},{4,5}};
            int[][] expectedResult = {{1,5}};
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            sortIntervalsByFirstValueInSubArrQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }
      /*
            {2, 6}, {8, 9}, {8,10}, {9,11}, {15,18}, {2, 4},  {16, 17}, {1,  3}
            sort by first value in sub arr
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]

            i:0
                l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(3) > r(2)                                                           [1 4]
            i:1
                        l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(4) > r(2)
                                                                                   [1 6]
            i:2
                                l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(6) < r(8)                                                           [1 6] [8,9]

            i:3
                                        l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(9) > r(8)                                                           [1 6] [8,10]

            i:4
                                                 l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(10) > r(9)                                                           [1 6] [8,11]

            i:5
                                                          l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(11) < r(15)                                                           [1 6] [8,11] [15, 18]

            i:6
                                                                    l    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(18) < r(16)                                                           [1 6] [8,11] [15, 18]
       */
      private void test3() {
            int[][] arrays = {{2,6},{8,9},{8,10},{9,11},{15,18},{2,4},{16, 17},{1,3}};
            int[][] expectedResult = {{1,6}, {8,11}, {15,18}};
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            sortIntervalsByFirstValueInSubArrBubble(arrays);
            //sortIntervalsByFirstValueInSubArrQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private List<List<Integer>> getNonOverlappingIntervals(int[][] arrays) {
            List<List<Integer>> intervalsWithoutOverlapping = new LinkedList<>();

            for (int i = 0; i + 1 < arrays.length; i++) {
                  int left = arrays[i][1];
                  int right = arrays[i + 1][0];

                  if (intervalsWithoutOverlapping.size() == 0) { // initialize first overlapping
                        if (left >= right) {
                              List<Integer> interval = new ArrayList<>(2);
                        }
                  }
            }
            return null;
      }


      private void sortIntervalsByFirstValueInSubArrQuick(int[][] arrays, int i, int i1) {
      }

      private void sortIntervalsByFirstValueInSubArrBubble(int[][] arrays) {
            for (int i = 0; i < arrays.length - 1; i++) {
                  for (int j = i + 1; j < arrays.length; j++) {
                        int first = arrays[i][0];
                        int second = arrays[j][0];

                        if (first > second) {
                              int temp0 = arrays[i][0];
                              int temp1 = arrays[i][1];
                              arrays[i][0] = arrays[j][0];
                              arrays[i][1] = arrays[j][1];
                              arrays[j][0] = temp0;
                              arrays[j][1] = temp1;
                        }
                  }
            }
      }
}
