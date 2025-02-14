package leetcode._2418_sort_the_people;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * https://leetcode.com/problems/sort-the-people/
 */
class SolutionTest {
    public String[] sortPeople(String[] names, int[] heights) {
        return null;
    }

    public static void main(String[] args) {
        SolutionTest solution = new SolutionTest();

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