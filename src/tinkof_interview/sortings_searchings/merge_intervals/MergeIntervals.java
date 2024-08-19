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
            if (intervals.length <= 2) return intervals;

            List<int[]> result = new LinkedList<>();

            int[] previousInterval = new int[2];
            int first = intervals[0][0];
            int second = intervals[0][1];
            previousInterval[0] = first;
            previousInterval[1] = second;
            result.add(previousInterval);

            for (int[] currInterval : intervals) {
                  if (previousInterval[1] >= currInterval[0]) {//we have intersection

                       previousInterval[1] = Math.max(currInterval[1], second);
                  } else {
                        int[] newInterval = new int[2];
                        newInterval[0] = currInterval[0];
                        newInterval[1] = currInterval[1];
                        result.add(newInterval);
                        first = currInterval[0];
                        second = currInterval[1];
                  }
            }

            return result.toArray(new int[result.size()][]);
      }
}
