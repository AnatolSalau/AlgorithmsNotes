package dynamic_programming._6_triangle;

import java.util.List;

/**
 * https://www.youtube.com/watch?v=9kcZE8esf7Q&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=4&ab_channel=NikhilLohia
 * https://leetcode.com/problems/triangle/description/
 */
public class Triangle {
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        triangle.testOne();
        triangle.testTwo();
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] memorization = new int[triangle.size()][triangle.size()];

        //set bottom floor in memorization
        List<Integer> lastLevelTriangle = triangle.get(triangle.size() - 1);
        int[] lastLevelMemorization = memorization[memorization.length - 1];

        for (int j = 0; j < lastLevelTriangle.size(); j++) {
            lastLevelMemorization[j] = lastLevelTriangle.get(j);
        }
        //fill memo
        for (int level = triangle.size() - 2; level >= 0; level--) { // - 2 start from 2 level
            List<Integer> topFloor = triangle.get(level);
            int[] bottomFloor = memorization[level + 1];
            for (int i = 0; i < topFloor.size(); i++) {
                int curr = topFloor.get(i);
                int leftBottom = bottomFloor[i];
                int rightBottom = bottomFloor[i + 1];
                int leftSum = curr + leftBottom;
                int rightSum = curr + rightBottom;
                int minSum = Math.min(leftSum, rightSum);

                memorization[level][i] = minSum;
            }
        }
        return memorization[0][0];
    }
    /* condition
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * expected = 11 (2 + 3 + 5 + 1 = 11)
     * memorization (bottom -> top)
     * 11           0
     * 9  10         1
     * 7  6  10      2 -start level (-2)
     * 4  1  8  3      3
     */
    public void testOne() {
        List<List<Integer>> triangle = List.of(List.of(2), List.of(3, 4), List.of(6, 5, 7), List.of(4, 1, 8, 3));
        int result = minimumTotal(triangle);
        System.out.println("Test 1");
        System.out.println("result = " + result);
        System.out.println("Expected = " + 11);
        System.out.println();
    }

    public void testTwo() {
        List<List<Integer>> triangle = List.of(List.of(-10));
        int result = minimumTotal(triangle);
        System.out.println("Test 2");
        System.out.println("result = " + result);
        System.out.println("Expected = " + -10);
        System.out.println();
    }
}
