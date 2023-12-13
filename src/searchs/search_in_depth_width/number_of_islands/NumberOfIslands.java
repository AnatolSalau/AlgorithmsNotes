package searchs.search_in_depth_width.number_of_islands;


import java.util.Arrays;

/**
 * Given an m x n 2D binary grid grid which represents
 * a map of '1's (land) and '0's (water), return the number of islands.
 * <p>
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input: grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * Output: 1
 * <p>
 * Example 2:
 * <p>
 * Input: grid = [
 * ["1","1","0""0","0""0","0"],
 * ["1","1","0""0","0""0","0"],
 * ["0","0","0""1","0""0","0"],
 * ["0","0","0""0","0""1","1"]
 * ]
 * Output: 3
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
            printGrid(grid);
            System.out.println();
      }

      /*
                   {9,9,0,0,0,0,0}, count = 1
                   {9,9,0,0,0,0,0},
                   {0,0,0,1,0,0,0},
                   {0,0,0,0,0,1,1}

                   {9,9,0,0,0,0,0}, count = 2
                   {9,9,0,0,0,0,0},
                   {0,0,0,9,0,0,0},
                   {0,0,0,0,0,1,1}

                   {9,9,0,0,0,0,0}, count = 3
                   {9,9,0,0,0,0,0},
                   {0,0,0,9,0,0,0},
                   {0,0,0,0,0,9,9}
       */
      void testTwo() {
            int[][] grid = {
                  {1, 1, 0, 0, 0, 0, 0},
                  {1, 1, 0, 0, 0, 0, 0},
                  {0, 0, 0, 1, 0, 0, 0},
                  {0, 0, 0, 0, 0, 1, 1}
            };
            printGrid(grid);
            int quantityOfIslands = getQuantityOfIslands(grid);
            System.out.println("Quantity : " + quantityOfIslands);
            System.out.println("Expected : 3");
            printGrid(grid);
            System.out.println();
      }

      void printGrid(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                  System.out.println(Arrays.toString(grid[i]));
            }
      }

      int getQuantityOfIslands(int[][] grid) {
            int count = 0;
            for (int y = 0; y < grid.length; y++) {
                  int[] row = grid[y];
                  for (int x = 0; x < row.length; x++) {
                        int current = row[x];

                        if (current == 1) {
                              count += 1;
                              makeIslandPassable(grid,x,y);
                        }

                  }
            }
            return count;
      }

      void makeIslandPassable(int[][] grid, int x, int y) {
            int maxY = grid.length - 1;
            int maxX = grid[0].length - 1;

            int current = grid[y][x];

            if (current == 1) grid[y][x] = 9;
            /*
                  * c
             */
            if (x - 1 >= 0 && grid[y][x-1] != 9 && grid[y][x-1] !=0) makeIslandPassable(grid,x -1,y);
            /*    *
                    c
             */
            if (x - 1 >= 0 && y - 1 >= 0 &&  grid[y-1][x-1] != 9 &&  grid[y-1][x-1] != 0) makeIslandPassable(grid,x - 1,y - 1);
            /*    *
                  c
             */
            if (y - 1 >= 0 &&  grid[y-1][x] != 9 &&  grid[y-1][x] != 0) makeIslandPassable(grid,x,y - 1);
            /*      *
                  c
             */
            if (x + 1 <= maxX && y - 1 >= 0 && grid[y-1][x+1] != 9 && grid[y-1][x+1] != 0) makeIslandPassable(grid,x+1,y - 1);
            /*
                  c *
             */
            if (x + 1 <= maxX && grid[y][x+1] != 9 && grid[y][x+1] != 0) makeIslandPassable(grid,x+1,y);
            /*
                  c
                    *   */
            if (x + 1 <= maxX && y + 1<=maxY && grid[y+1][x+1] != 9 && grid[y+1][x+1] != 0) makeIslandPassable(grid,x+1,y + 1);
            /*
                  c
                  *     */
            if (y + 1 <= maxY && grid[y+1][x] != 9 && grid[y+1][x] != 0) makeIslandPassable(grid,x,y + 1);
            /*
                c
              *     */
            if (x - 1 >= 0 && y + 1 <= maxY && grid[y+1][x-1] != 9 && grid[y+1][x-1] != 0) makeIslandPassable(grid,x-1,y + 1);
      }
}
