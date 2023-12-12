package tinkof_tasks.contest2023.task4;

import java.util.Scanner;

public class Main {
      public static long changeDigitSum(long number) {
            long divisor = 1;
            while (divisor <= number) {
                  divisor *= 10;
            }
            divisor /= 10;
            while (divisor > 0){
                  if ((((number / divisor) % 10 ) != 9))
                        return (9 - ( (number / divisor) % 10 )) * divisor;
                  divisor /= 10;
            }
            return 0;
      }

      public static long changeNumber(long[] arr){
            int maxIndex = 0; // n <= 1000
            long max = 0; // max <= 9e10
            for (int i = 0; i < arr.length; i++) {
                  long tmp = changeDigitSum(arr[i]); // tmp <= 9e10
                  if (tmp > max ){
                        max = tmp;
                        maxIndex = i;
                  }

            }
            arr[maxIndex] += max;
            return max;
      }

      public static void main(String[] args){
            //  taking input

            Scanner sc = new Scanner(System.in);
            long sumDifference = 0;
            int n = 3;  // n <= 1000
            int k = 1; // k <= 1e5
            long[] mas = {99, 5, 85};
/*            for ( int i = 0; i < n; i++ )
                  mas[i] = sc.nextInt(); // input <= 1e10*/

            // processing

            for (int i = 0; i < k; i++) { // k times
                  sumDifference += changeNumber(mas);

            }
            System.out.println(sumDifference);

      }
}