package yandex_contest.task_d;

/**
 * An integer n is given.
 * It is required to print all correct bracket sequences of length 2 ⋅ n,
 * ordered lexicographically (see https://ru.wikipedia.org/wiki/Lexicographic_order).
 *
 * The problem uses only parentheses.
 *
 * It is advisable to get a solution that works in time,
 * proportional to the total number of correct bracket sequences in the answer,
 * and at the same time uses a memory volume proportional to n.
 */
public class TaskD {
      public static void main(String[] args) {
            TaskD taskD = new TaskD();
            taskD.test1();
      }

      private void test1() {
            int size = 4;
            int open = 0;
            int close = 0;

            printBalancedBracketRecursive("", size, open, close);
      }
      /*
            "", size=3, open=0, close=0
((()))
(()())
(())()
()(())
()()()
            "(", size=3, open=1, close=0
            "((", size=3, open=2, close=0
            "(((", size=3, open=3, close=0
            "((()", size=3, open=3, close=1
            "((())", size=3, open=3, close=2
            "((()))", size=3, open=3, close=3
            close = size -> print
       */
      private void printBalancedBracketRecursive(String result, int size, int open, int close) {
            if (close == size) {
                  System.out.println(result);
                  return;
            }

            if (open < size) {
                  printBalancedBracketRecursive(result + "(", size, open +1, close);
            }

            if(open > close) {
                  printBalancedBracketRecursive(result + ")", size, open , close+1);
            }
      }
}
