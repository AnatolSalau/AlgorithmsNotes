package alex_adam._2_task_scheduler;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 * You are given an array of CPU tasks, each represented by letters A to Z,
 * and a cooling time, n. Each cycle or interval allows the completion of one task.
 * Tasks can be completed in any order, but there's a constraint:
 * identical tasks must be separated by at least n intervals due to cooling time.
 * <p>
 * !!! Return the minimum number of intervals required to complete all tasks.
 * <p>
 * Example 1:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 * After completing task A, you must wait two cycles before doing A again.
 * The same applies to task B.
 * In the 3rd interval, neither A nor B can be done, so you idle. B
 * y the 4th cycle, you can do A again as 2 intervals have passed.
 * <p>
 * Example 2:
 * Input: tasks = ["A","C","A","B","D","B"], n = 1
 * Output: 6
 * Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 * With a cooling interval of 1, you can repeat a task after just one other task.
 * <p>
 * Example 3:
 * Input: tasks = ["A","A","A", "B","B","B"], n = 3
 * Output: 10
 * Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 * There are only two types of tasks, A and B, which need to be separated by 3 intervals.
 * This leads to idling twice between repetitions of these tasks.
 */
public class TaskScheduler {
      public static void main(String[] args) {
            TaskScheduler taskScheduler = new TaskScheduler();
            taskScheduler.test1();
            taskScheduler.test2();
            taskScheduler.test3();
            taskScheduler.test4();
            taskScheduler.test5();
            taskScheduler.test6();
            taskScheduler.test7();
            taskScheduler.test8();
      }

      public int leastInterval(char[] tasks, int n) {

            return 0;
      }

      public void test1() {
            char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B' };
            int n = 2;
            int expect = 8;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 1");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);

            System.out.println("Expected : " + "[A, B, _, A, B, _, A, B]");
            System.out.println();
      }

      public void test2() {
            char[] tasks = {'A', 'C', 'A', 'B', 'D', 'B' };
            int n = 1;
            int expect = 6;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 2");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println();
      }

      public void test3() {
            char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B' };
            int n = 3;
            int expect = 10;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 3");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println();
      }

      public void test4() {
            char[] tasks = {'A', 'B', 'A' };
            int n = 2;
            int expect = 4;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 4");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println();
      }

      public void test5() {
            char[] tasks = {'A','B','C','D','E','A','B','C','D','E' };
            int n = 4;
            int expect = 10;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 5");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println("Expected : " + Arrays.toString(tasks));
            System.out.println();
      }

      public void test6() {
            char[] tasks = {'A','A','A','A','A','A','B','C','D','E','F','G' };
            int n = 1;
            int expect = 12;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 6");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println("Expected : " + Arrays.toString(tasks));
            System.out.println();
      }

      public void test7() {
            char[] tasks = {'A','A','A','B','B','B', 'C','C','C', 'D', 'D', 'E'};
            int n = 2;
            int expect = 12;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 7");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println("Expected : " + "[A, B, C, A, B, C, A, B, C, D, E, D]");
            System.out.println();
      }

      public void test8() {
            char[] tasks = {'A','A','A'};
            int n = 1;
            int expect = 5;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 8");
            System.out.println(Arrays.toString(tasks));
            System.out.println("n = " + n);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
            System.out.println("Expected : " + "[A, B, C, A, B, C, A, B, C, D, E, D]");
            System.out.println();
      }
}
