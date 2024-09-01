package dynamic_programming._2_fibonachi_number;


public class FibonachiNumberRecursive {
      public static void main(String[] args) {
            FibonachiNumberRecursive fibonachiNumber = new FibonachiNumberRecursive();
            System.out.println("Fibonachi sum from 0 to 4( 5 numbers) = 7");
            System.out.println(fibonachiNumber.fib(4));
            System.out.println();

            System.out.println("Fibonachi sum from 0 to 3( 4 numbers) = 4");
            System.out.println(fibonachiNumber.fib(3));
            System.out.println();
            /* 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 */
            /*    0
                  1 -> 1
                  2 -> 1 (1 + 0)
                  3 -> 2 (1 + 1)
                  4 -> 3 (2 + 1)
                  5 -> 5 (2 + 3)
                  6 -> 8 (5 + 3)
                  7 -> 13(5 + 8)
             */
            /*
                  2 - 1
                  9 - 34
             */
            System.out.println("Fibonachi sum from 0 to 7( 8 numbers) = 33");
            System.out.println(fibonachiNumber.fib(7));
            System.out.println();
      }

      /**
       * Calculates the nth Fibonacci number recursively.
       *
       * The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones, usually starting with 0 and 1. This method calculates the nth number in the sequence by recursively calling itself with the n-1 and n-2 values.
       *
       * @param n the index of the Fibonacci number to calculate, where 0 represents the first number in the sequence (0)
       * @return the nth Fibonacci number
       */
      public int fib(int n) {
            if (n == 0)
                  return 0;
            if (n == 1)
                  return 1;
            return fib(n-1) + fib(n-2) + 1;
      }
}
