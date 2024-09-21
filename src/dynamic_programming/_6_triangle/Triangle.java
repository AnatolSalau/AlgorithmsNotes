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
        return 0;
    }

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
