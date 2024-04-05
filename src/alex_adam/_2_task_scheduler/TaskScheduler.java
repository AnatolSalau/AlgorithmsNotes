package alex_adam._2_task_scheduler;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://leetcode.com/problems/task-scheduler/description/
 You are given an array of CPU tasks, each represented by letters A to Z,
 and a cooling time, n. Each cycle or interval allows the completion of one task.
 Tasks can be completed in any order, but there's a constraint:
 identical tasks must be separated by at least n intervals due to cooling time.

 !!! Return the minimum number of intervals required to complete all tasks.

 Example 1:
 Input: tasks = ["A","A","A","B","B","B"], n = 2
 Output: 8
 Explanation: A possible sequence is: A -> B -> idle -> A -> B -> idle -> A -> B.
 After completing task A, you must wait two cycles before doing A again.
 The same applies to task B.
 In the 3rd interval, neither A nor B can be done, so you idle. B
 y the 4th cycle, you can do A again as 2 intervals have passed.

 Example 2:
 Input: tasks = ["A","C","A","B","D","B"], n = 1
 Output: 6
 Explanation: A possible sequence is: A -> B -> C -> D -> A -> B.
 With a cooling interval of 1, you can repeat a task after just one other task.

 Example 3:
 Input: tasks = ["A","A","A", "B","B","B"], n = 3
 Output: 10
 Explanation: A possible sequence is: A -> B -> idle -> idle -> A -> B -> idle -> idle -> A -> B.
 There are only two types of tasks, A and B, which need to be separated by 3 intervals.
 This leads to idling twice between repetitions of these tasks.
 */
public class TaskScheduler {
      public static void main(String[] args) {
            TaskScheduler taskScheduler = new TaskScheduler();
            //taskScheduler.test1();
            //taskScheduler.test2();
            taskScheduler.test3();
            //taskScheduler.test4();
      }
      public int leastInterval(char[] tasks, int n) {
            Map<Character, Integer> freqMap = IntStream
                  .range(0, tasks.length)
                  .mapToObj(i -> tasks[i])
                  .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                  ));
            List<Map.Entry<Character, Integer>> entries = new ArrayList<>(freqMap.entrySet());

            Collections.sort(entries,  (entry1, entry2) -> entry2.getValue() - entry1.getValue());
            //Collections.sort(entries, (entry1, entry2) -> entry1.getValue() - entry2.getValue());

            List<Character> result = new LinkedList<>();

            while (!entries.isEmpty()) {
                  int steps = 0;
                  for (int i = 0; i < entries.size(); i++) {
                        Map.Entry<Character, Integer> curr = entries.get(i);

                        result.add(curr.getKey());

                        Integer newCount = curr.getValue() - 1;

                        if (newCount == 0) {
                              entries.remove(i);
                        }
                        else {
                              curr.setValue(newCount);
                        }
                        steps++;
                  }
                  Character nextCharacter = null;
                  if(!entries.isEmpty()) {
                        nextCharacter = entries.get(0).getKey();

                              if (steps != 0 && (nextCharacter != result.get(result.size() - 1)) ) {
                                    while (steps <= n) {
                                          result.add('_');
                                          steps++;
                                    }
                              }

                  }

            }

            System.out.println("Result" + result);
            return result.size();
      }

      public  void test1() {
            char[] tasks = {'A','A','A', 'B','B','B'};
            int n = 2;
            int expect = 8;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 1");
            System.out.println(Arrays.toString(tasks));
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
      }

      public  void test2() {
            char[] tasks = {'A','C','A', 'B','D','B'};
            int n = 1;
            int expect = 6;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 2");
            System.out.println(Arrays.toString(tasks));
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
      }

      public  void test3() {
            char[] tasks = {'A','A','A', 'B','B','B'};
            int n = 3;
            int expect = 10;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 3");
            System.out.println(Arrays.toString(tasks));
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
      }

      public  void test4() {
            char[] tasks = {'A','B','A'};
            int n = 2;
            int expect = 4;
            int result = this.leastInterval(tasks, n);
            System.out.println("Test 4");
            System.out.println(Arrays.toString(tasks));
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expect);
      }
}
