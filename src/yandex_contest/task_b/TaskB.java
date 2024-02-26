package yandex_contest.task_b;
/**
 * Требуется найти в бинарном векторе самую длинную последовательность единиц и вывести её длину.
 * Желательно получить решение, работающее за линейное время и при этом проходящее по входному массиву только один раз.
 */
public class TaskB {
      public static void main(String[] args) {
            TaskB taskB = new TaskB();
            taskB.test1();
            taskB.test2();
      }

      private int getMaxOneLength(int[] arr) {
            int maxCount = 0;
            int count = 0;
            for (int curr : arr) {
                  if (curr == 1) {
                        count++;
                  } else {
                        count = 0;
                  }
                  maxCount = Math.max(count, maxCount);
            }
            return maxCount;
      }
      /*
            0 1 1 1 1 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 0 0 0 1 1 1 1 0 0 0 0
            maxCount = 0
            i
i -> 0, count = 0,, maxCount = Math.max(count, maxCount) = 0
              i
i -> 1, count = 1, maxCount = Math.max(count, maxCount) = 1
                i
i -> 1, count = 2, maxCount = Math.max(count, maxCount) = 2
                  i
i -> 1, count = 3, maxCount = Math.max(count, maxCount) = 3
                    i
i -> 1, count = 4, maxCount = Math.max(count, maxCount) = 4
                      i
i -> 0, count = 0, maxCount = Math.max(count, maxCount) = 4
...
                                i
i -> 0, count = 0, maxCount = Math.max(count, maxCount) = 4
                                 i
i -> 1, count = 1, maxCount = Math.max(count, maxCount) = 4
...
                                                  i
i -> 1, count = 9, maxCount = Math.max(count, maxCount) = 9
                                                   i
i -> 0, count = 0, maxCount = Math.max(count, maxCount) = 9
...
                                                         i
i -> 1, count = 1, maxCount = Math.max(count, maxCount) = 9
...
                                                               i
i -> 1, count = 4, maxCount = Math.max(count, maxCount) = 9
                                                                 i
i -> 0, count = 0, maxCount = Math.max(count, maxCount) = 9
...
                                                                     i
i -> 0, count = 0, maxCount = Math.max(count, maxCount) = 9
return maxCount = 9
       */
      private void test1() {
            System.out.println("Test 1");
            int[] arr = {0,1,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1,0,0,0,0};
            int expectedResult = 9;
            int maxOneLength = getMaxOneLength(arr);
            System.out.println("Result : " + maxOneLength);
            System.out.println("Expected : " + expectedResult);
            System.out.println();
      }

      private void test2() {
            System.out.println("Test 2");
            int[] arr = {0,0,0,0,0,0,0};
            int expectedResult = 0;
            int maxOneLength = getMaxOneLength(arr);
            System.out.println("Result : " + maxOneLength);
            System.out.println("Expected : " + expectedResult);
            System.out.println();
      }
}
