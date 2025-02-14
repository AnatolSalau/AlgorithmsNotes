package leetcode._56_merge_intervals;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: Sort the intervals based on the start time using Bubble Sort
        bubbleSortMultipleArr(intervals);

        // Step 2: Merging the intervals
        List<int[]> merged = new ArrayList<>();

        // Add the first interval to start merging
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // Check for overlap
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge intervals (update the end time)
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, move to the next interval
                currentInterval = nextInterval;
                merged.add(currentInterval);
            }
        }

        // Convert List<int[]> to int[][]
        return merged.toArray(new int[merged.size()][]);
    }

    // Bubble Sort for sorting the intervals by the start time
    public void bubbleSortMultipleArr(int[][] numbers) {
        int n = numbers.length;

        // Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Compare first elements of each pair
                if (numbers[j][0] > numbers[j + 1][0]) {
                    // Swap intervals[j] and intervals[j + 1]
                    int[] temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        Solution solution = new Solution();
        
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