package yandex_internet._11_merge_intervals;

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
            mergeIntervals.testQuickSort();
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
      private void test3() {
            int[][] arrays = {{2,6},{8,9},{8,10},{9,11},{15,18},{2,4},{16, 17},{1,3}};
            int[][] expectedResult = {{1,6}, {8,11}, {15,18}};
            System.out.println("Interfals before sort : " + Arrays.deepToString(arrays));
            sortIntervalsByFirstValueInSubArrQuick(arrays, 0, arrays.length - 1);
            //sortIntervalsByFirstValueInSubArrQuick(arrays,0,arrays.length - 1);
            System.out.println("Interfals after sort : " + Arrays.deepToString(arrays));
            List<List<Integer>> nonOverlappingIntervals = getNonOverlappingIntervals(arrays);
            System.out.println("Non overlapping arrays : " + nonOverlappingIntervals);
            System.out.println("Expected : " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void testQuickSort() {
            System.out.println("\nTest quick sort");
            int[][] arrays = {{4,0},{3,0},{2,0},{1,0}};
            System.out.println("Before sort : " + Arrays.deepToString(arrays));
            sortIntervalsByFirstValueInSubArrQuick(arrays,0,arrays.length - 1);
            System.out.println("After sort : " + Arrays.deepToString(arrays));
      }

      private List<List<Integer>> getNonOverlappingIntervals(int[][] arrays) {
            List<List<Integer>> overLappingIntervals = new LinkedList<>();

            int start = arrays[0][0]; //start value overlapping interval
            int end = arrays[0][1]; // end value overlapping interval
            for (int l = 0, r =  l+ 1; r < arrays.length; l++, r++) {
                  int left = arrays[l][1]; //curr left value
                  int right = arrays[r][0]; // curr right value
                  if (left >= right) { // if interval overlapping -> move the end index
                        end = Math.max(arrays[l][1], arrays[r][1]); //write in end max value from left and right intervals
                  } else {// interval is not overlapping
                        List<Integer> interval = new ArrayList<>(2);
                        interval.add(0,start);
                        interval.add(1,end);
                        overLappingIntervals.add(interval);

                        start = arrays[r][0];// write in start first value from right interval (this will be left in new iteration)
                        end = Math.max(arrays[l][1], arrays[r][1]);//write in end max value from left and right intervals
                  }
                  if (r + 1 >= arrays.length) {//handle edge case when we find the end of array
                        List<Integer>interval = new ArrayList<>(2);
                        interval.add(0,start);
                        interval.add(1,end);
                        overLappingIntervals.add(interval);
                  }
            }
            return overLappingIntervals;
      }


      private void sortIntervalsByFirstValueInSubArrQuick(int[][] arrays, int startIndex, int endIndex) {
            if (startIndex >= endIndex) return;

            int pivotIndex = particion(arrays, startIndex, endIndex);

            sortIntervalsByFirstValueInSubArrQuick(arrays,startIndex,pivotIndex - 1);
            sortIntervalsByFirstValueInSubArrQuick(arrays,pivotIndex + 1, endIndex);
      }

      private int particion(int[][] arrays, int startIndex, int endIndex) {
            int i = startIndex - 1;
            int pivot = arrays[endIndex][0];

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if (arrays[j][0] < pivot) {
                        i++;
                        int temp0 = arrays[j][0];
                        int temp1 = arrays[j][1];
                        arrays[j][0] = arrays[i][0];
                        arrays[j][1] = arrays[i][1];
                        arrays[i][0] = temp0;
                        arrays[i][1] = temp1;
                  }
            }

            i++;
            int temp0 = arrays[i][0];
            int temp1 = arrays[i][1];
            arrays[i][0] = arrays[endIndex][0];
            arrays[i][1] = arrays[endIndex][1];
            arrays[endIndex][0] = temp0;
            arrays[endIndex][1] = temp1;

            return i;
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
