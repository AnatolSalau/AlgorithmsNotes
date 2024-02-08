package two_pointers.container_most_amount_water;

import java.util.Arrays;

/**
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints
 * of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container,
 * such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Example 1:
 * Notice that you may not slant the container.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 */
public class ContainerMostAmountWater {
      public static void main(String[] args) {
            ContainerMostAmountWater containerMostAmountWater = new ContainerMostAmountWater();
            containerMostAmountWater.arrayWithNineValuesTest();
            containerMostAmountWater.arrayWithTwoValuesTest();
            containerMostAmountWater.voidArrayTest();

      }
      /*    0 1 2 3 4 5 6 7 8
            1,8,6,2,5,4,8,3,7 LENGTH = 9
            L   R WIDTH = 2 - 0 = 2
              L             R width = 8 - 1 = 7

       */
      private int maximumWater(int[] heights) {
            int l = 0;
            int r = heights.length - 1;
            int maxSquare = 0;

            while (l < r) {
                  int left = heights[l];
                  int right = heights[r];

                  int height = Math.min(left, right);
                  int width = r - l;

                  int currSquare = height * width;
                  maxSquare = Math.max(currSquare, maxSquare);

                  if (right < left) {//move right pointer if right value less than left
                        r --;
                  } else {//default -> move left point forward
                        l ++;
                  }
            }

            return maxSquare;
      }

      /*          0 1 2 3 4 5 6 7 8
            1,8,6,2,5,4,8,3,7
     i:0    l               r    1*7= 7
     i:1      l             r    7*7= 49
     i:2      l           r      3*6= 18
     i:3      l         r        8*5= 40
     i:4        l     r          4*3= 12
     i:5        l   r            5*2= 10
     i:6        l r              2*1= 2
      */
      private void arrayWithNineValuesTest() {
            System.out.println("Test 1");
            int[] heights = {1,8,6,2,5,4,8,3,7};
            int square = maximumWater(heights);
            int expected = 49;
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
            System.out.println("Expected: " + expected);
            System.out.println();
      }

      private void arrayWithTwoValuesTest() {
            System.out.println("Test 2");
            int[] heights = {1,1};
            int square = maximumWater(heights);
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
            System.out.println("Expected: " + 1);
            System.out.println();
      }

      private void voidArrayTest() {
            System.out.println("Test 3");
            int[] heights = new int[10];
            int square = maximumWater(heights);
            System.out.println("Array : " + Arrays.toString(heights));
            System.out.println("Square : " + square);
            System.out.println();
      }
}
