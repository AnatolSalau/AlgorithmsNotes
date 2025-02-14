package leetcode._56_merge_intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
class SolutionTest {
    public int[][] merge(int[][] intervals) {
       return null;
    }

    // Bubble Sort for sorting the intervals by the start time
    public void bubbleSortMultipleArr(int[][] numbers) {

    }

    // Main function to test the implementation
    public static void main(String[] args) {
        SolutionTest solution = new SolutionTest();
        
        int[][] intervals = {
            {1, 3}, {2, 6}, {8, 10}, {15, 18}
        };

        int[][] mergedIntervals = solution.merge(intervals);

        // Print result
        for (int[] interval : mergedIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}