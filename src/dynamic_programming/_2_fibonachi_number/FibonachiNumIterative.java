package dynamic_programming._2_fibonachi_number;

/**
 * https://xn--80a2ac.xn--p1ai/%D0%BC%D0%B0%D1%82%D0%B5%D1%80%D0%B8%D0%B0%D0%BB%D1%8B/%D0%B4%D0%B8%D0%BD%D0%B0%D0%BC%D0%B8%D1%87%D0%B5%D1%81%D0%BA%D0%BE%D0%B5-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D0%B5/
 */
public class FibonachiNumIterative {
      public static void main(String[] args) {
            FibonachiNumIterative fibonachiNumber = new FibonachiNumIterative();
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
            int[] arrayOfPreviousFib = new int[n + 2]; // n + 0 + 1

            //add first two numbers in arr
            arrayOfPreviousFib[0] = 0;
            arrayOfPreviousFib[1] = 1;

            int sum = 1;

            for (int i = 2; i <= n; i++) {
                  arrayOfPreviousFib[i] = arrayOfPreviousFib[i - 1] + arrayOfPreviousFib[i -2];
                  sum += arrayOfPreviousFib[i];
            }

           return sum;
      }
}
