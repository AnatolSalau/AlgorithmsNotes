package sortings.merge_intervals;

import java.util.Arrays;
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
            sortIntervalsQuick(arrays,0,arrays.length - 1);
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
            sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void test3() {
            int[][] arrays = {{2,6},{8,10},{8,9},{9,11},{15,18},{2,4},{16, 17},{1,3}};
            int[][] expectedResult = {{1,6}, {8,11}, {15,18}};
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            sortIntervalsQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private List<List<Integer>> getNonOverlappingIntervals(int[][] arrays) {
            return null;
      }


      private void sortIntervalsQuick(int[][] arrays, int i, int i1) {
      }
}
