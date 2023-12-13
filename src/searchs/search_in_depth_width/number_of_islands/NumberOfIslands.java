package searchs.search_in_depth_width.number_of_islands;


import java.util.Arrays;

/**
       Given an m x n 2D binary grid grid which represents
       a map of '1's (land) and '0's (water), return the number of islands.

       An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
       You may assume all four edges of the grid are all surrounded by water.

       Example 1:

       Input: grid = [
       ["1","1","1","1","0"],
       ["1","1","0","1","0"],
       ["1","1","0","0","0"],
       ["0","0","0","0","0"]
       ]
       Output: 1

       Example 2:

       Input: grid = [
       ["1","1","0""0","0""0","0"],
       ["1","1","0""0","0""0","0"],
       ["0","0","0""1","0""0","0"],
       ["0","0","0""0","0""1","1"]
       ]
       Output: 3
 */

public class NumberOfIslands {
      public static void main(String[] args) {
            NumberOfIslands numberOfIslands = new NumberOfIslands();
            numberOfIslands.testOne();
            numberOfIslands.testTwo();
      }

       void testOne() {
             int[][] grid = {
                   {1, 1, 1, 1, 0},
                   {1, 1, 0, 1, 0},
                   {1, 1, 0, 0, 0},
                   {0, 0, 0, 0, 0}
             };
             printGrid(grid);

             int quantityOfIslands = getQuantityOfIslands(grid);
             System.out.println("Quantity : " + quantityOfIslands);
             System.out.println("Expected : 1");
             System.out.println();
       }

       void testTwo() {
             int[][] grid = {
                   {1,1,0,0,0,0,0},
                   {1,1,0,0,0,0,0},
                   {0,0,0,1,0,0,0},
                   {0,0,0,0,0,1,1}
             };
             printGrid(grid);

             int quantityOfIslands = getQuantityOfIslands(grid);
             System.out.println("Quantity : " + quantityOfIslands);
             System.out.println("Expected : 3");
             System.out.println();
       }

      void printGrid(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                  System.out.println(Arrays.toString(grid[i]));
            }
      }

      int getQuantityOfIslands(int[][] grid) {
            return 0;
      }
}
