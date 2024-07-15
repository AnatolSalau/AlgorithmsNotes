package tinkof_interview.priority_queue.profit_maximisation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class ProfitMaximization {
      public static void main(String[] args) {
            ProfitMaximization profitMaximization = new ProfitMaximization();
            profitMaximization.test1();
            profitMaximization.test2();
      }

      public int solve(ArrayList<Integer> A, int B) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            queue.addAll(A);
            int profit = 0;
            for (int i = 0; i < B; i++) {
                  if (!queue.isEmpty()) {
                        int currMax = queue.poll();
                        profit = profit + currMax;
                        currMax = currMax - 1;

                        if (currMax > 0) {
                              queue.add(currMax);
                        }
                  }
            }
            return profit;
      }
      /*
            * * * -> ** -> *   -> *
             * *     **    * *    *
                  3      2     2
       */
      public void test1() {
            ArrayList<Integer> A= new ArrayList<>(List.of(2,3));
            int B = 3;
            int expected = 7;

            System.out.println("Test 1");
            System.out.println("Result : " + solve(A, B));
            System.out.println("Expected : " + expected);
            System.out.println();
      }
      /*
            **** -> *** -> **
            *    4  *    3  *
       */
      public void test2() {
            ArrayList<Integer> A= new ArrayList<>(List.of(1,4));
            int B = 2;
            int expected = 7;

            System.out.println("Test 2");
            System.out.println("Result : " + solve(A, B));
            System.out.println("Expected : " + expected);
            System.out.println();
      }
}
