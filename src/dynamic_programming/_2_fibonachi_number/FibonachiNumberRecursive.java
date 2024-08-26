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

      public int fib(int n) {
            if (n == 0)
                  return 0;
            if (n == 1)
                  return 1;
            return fib(n-1) + fib(n-2) + 1;
      }
}
