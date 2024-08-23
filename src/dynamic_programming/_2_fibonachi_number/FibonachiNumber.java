package dynamic_programming._2_fibonachi_number;

public class FibonachiNumber {
      public static void main(String[] args) {
            FibonachiNumber fibonachiNumber = new FibonachiNumber();
            System.out.println("Fibonachi from 4 = 3");
            System.out.println(fibonachiNumber.fib(4));
            System.out.println();

            System.out.println("Fibonachi from 3 = 2");
            System.out.println(fibonachiNumber.fib(3));
            System.out.println();

            /*    0
                  1 -> 1
                  2 -> 1 (1 + 0)
                  3 -> 2 (1 + 1)
                  4 -> 3 (2 + 1)
                  5 -> 5 (2 + 3)
                  6 -> 8 (5 + 3)
                  7 -> 13(5 + 8)
             */
            System.out.println("Fibonachi from 5 = 3");
            System.out.println(fibonachiNumber.fib(2));
            System.out.println();
      }

      public int fib(int n) {
            if (n < 2) return 0;
            //            7 -
            return fib(n - fib(n));
      }
}
