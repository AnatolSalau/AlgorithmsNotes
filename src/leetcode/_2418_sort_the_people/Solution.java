package leetcode._2418_sort_the_people;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sort-the-people/
 */
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Map<Integer, String> heap = new TreeMap();
        for(int i = 0; i < names.length; i++) {
            heap.put(heights[i], names[i]);
        }
        String[] answer = new String[names.length];
        int i = names.length;
        for(Map.Entry<Integer, String> entry : heap.entrySet()) {
                answer[i-1] = entry.getValue();
                i--;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        String[] names1 = {"Alice", "Bob", "Charlie"};
        int[] heights1 = {155, 185, 150};
        System.out.println("Test Case 1: " + Arrays.toString(solution.sortPeople(names1, heights1)));
        // Expected Output: ["Bob", "Alice", "Charlie"]

        // Test case 2
        String[] names2 = {"John", "Doe", "Jane"};
        int[] heights2 = {180, 160, 170};
        System.out.println("Test Case 2: " + Arrays.toString(solution.sortPeople(names2, heights2)));
        // Expected Output: ["John", "Jane", "Doe"]

        // Test case 3 - Single Person
        String[] names3 = {"Emma"};
        int[] heights3 = {165};
        System.out.println("Test Case 3: " + Arrays.toString(solution.sortPeople(names3, heights3)));
        // Expected Output: ["Emma"]

        // Test case 4 - Already Sorted
        String[] names4 = {"Zoe", "Liam", "Mia"};
        int[] heights4 = {190, 180, 170};
        System.out.println("Test Case 4: " + Arrays.toString(solution.sortPeople(names4, heights4)));
        // Expected Output: ["Zoe", "Liam", "Mia"]
    }
}