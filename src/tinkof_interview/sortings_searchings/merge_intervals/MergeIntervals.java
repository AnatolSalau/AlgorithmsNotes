package tinkof_interview.sortings_searchings.merge_intervals;

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
      }
      private void test1() {
            int[][] arrays = {{1,3},{2,6},{8,10},{15,18}};
            int[][] expectedResult = {{1,6},{8,10},{15,18}};
            int[][] nonOverlappingIntervals = merge(arrays);
            System.out.println("Non overlapping arrays : " + Arrays.deepToString(nonOverlappingIntervals));
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void test2() {
            int[][] arrays = {{1,4},{4,5}};
            int[][] expectedResult = {{1,5}};
            int[][] nonOverlappingIntervals = merge(arrays);
            System.out.println("Non overlapping arrays : " + Arrays.deepToString(nonOverlappingIntervals));
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }
      /*
            {2, 6}, {8, 9}, {8,10}, {9,11}, {15,18}, {2, 4},  {16, 17}, {1,  3}
            sort by first value in sub arr
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]

            i:0
             s  l    r  e
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(3) > r(2)
            i:0
             s          l    r  e
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(4) > r(2)
            i:0
             s                 le    r
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(6) < r(8)
                                     s  l    r   e
            [1, 3], [2, 4], [2, 6], [8, 9], [8, 10], [9, 11], [15, 18], [16, 17]
            l(6) < r(8)

       */

      public int[][] merge(int[][] intervals) {
            if (intervals.length == 1) {
                  return intervals;
            }
            List<List<Integer>> result = new LinkedList<>();
            int curr1 = intervals[0][0];
            int curr2 = intervals[0][1];

            for (int j = 1; j < intervals.length - 1; j++) {
                  int second1 = intervals[j][0];
                  int second2 = intervals[j][1];

                  if (curr2 >= second1) { //interval is overlapping
                       curr1 = curr1;
                       curr2 = second2;

                       List<Integer> interval = List.of(curr1, curr2);
                       result.add(interval);
                  } else {
                        List<Integer> interval = List.of(second1, second2);
                        result.add(interval);
                        curr1 = second1;
                        curr2 = second2;
                  }
            }


            int[][] overlappInterval = new int[result.size()][2];

            int i = 0;
            for (List<Integer> list : result) {
                  overlappInterval[i][0] = list.get(0);
                  overlappInterval[i][1] = list.get(1);
                  i++;
            }

            return overlappInterval;
      }
}
