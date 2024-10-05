package tinkof_interview.graphs.game_of_life;

import java.util.Arrays;

public class GameOfLife {
      public static void main(String[] args) {
            GameOfLife gameOfLife = new GameOfLife();
            gameOfLife.test1();
            gameOfLife.test2();
      }
      public void gameOfLife(int[][] board) {
            if (board == null || board[0] == null) throw new RuntimeException("Board is wrong");
            int[][] newBoard = new int[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                  if (board[i] == null || board[i].length == 0) throw new RuntimeException("Wrong row");

                  for (int j = 0; j < board[i].length; j++) {
                        int state = getStateOfCellByNeighbours(board, i, j);
                        newBoard[i][j] = state;
                  }
            }

            for (int i = 0; i < board.length; i++) {
                System.arraycopy(newBoard[i], 0, board[i], 0, board[i].length);
            }
      }

      public int getStateOfCellByNeighbours(int[][] board, int i, int j) {

            int numberOfLiving = getNumberOfLiving( board,  i,  j);

            if (board[i][j] == 1) { // life cell
                  if (numberOfLiving < 2) return 0;
                  if (numberOfLiving == 2 || numberOfLiving == 3) return 1;
                  if (numberOfLiving > 3) return 0;
            }
            else if (board[i][j] == 0) {//dead cell
                  if (numberOfLiving == 3) return 1;
            }

            return board[i][j];
      }
      /* -1;-1 -1;0 -1;+1
          0;-1  0;0  0;+1
         +1;-1 +1;0 +1:+1
       */
      private int getNumberOfLiving(int[][] board, int i, int j) {
            int[] iSteps = {-1,-1,-1,0,0,0,1,1,1};
            int[] jSteps = {-1,0,1,-1,0,1,-1,0,1};
            int count = 0;
            for (int k = 0; k < iSteps.length; k++) {
                  int changedI = i + iSteps[k];
                  int changedJ = j + jSteps[k];

                  if (changedI < 0 || changedI >= board.length) continue;
                  if (changedJ < 0 || changedJ >= board[0].length) continue;
                  if (changedI == i && changedJ == j) continue;

                  int state = board[changedI][changedJ];

                  if (state > 0) count++;
            }
            return count;
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
