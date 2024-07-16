package tinkof_interview.graphs.game_of_life;

import java.util.Arrays;

public class GameOfLife {
      public static void main(String[] args) {
            GameOfLife gameOfLife = new GameOfLife();
            gameOfLife.test1();
            gameOfLife.test2();
      }
      public void gameOfLife(int[][] board) {

      }

      public void test1() {
            int[][] board = {
                  {0,1,0},
                  {0,0,1},
                  {1,1,1},
                  {0,0,0}
            };
            int[][] output = {
                  {0,0,0},
                  {1,0,1},
                  {0,1,1},
                  {0,1,0}
            };

            System.out.println("Test 1");
            System.out.println("Before game");
            System.out.println(Arrays.deepToString(board));
            gameOfLife(board);
            System.out.println("After game");
            System.out.println(Arrays.deepToString(board));
            System.out.println("Expected output");
            System.out.println(Arrays.deepToString(output));
            System.out.println();
      }

      public void test2() {
            int[][] board = {
                  {1,1},
                  {1,0}
            };
            int[][] output = {
                  {1,1},
                  {1,1}
            };

            System.out.println("Test 1");
            System.out.println("Before game");
            System.out.println(Arrays.deepToString(board));
            gameOfLife(board);
            System.out.println("After game");
            System.out.println(Arrays.deepToString(board));
            System.out.println("Expected output");
            System.out.println(Arrays.deepToString(output));
            System.out.println();
      }
}
