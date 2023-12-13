package tinkof_tasks.contest2023.task4;

public class Main {
      public static long calculateMaxDifference(long number) {
            long divisor = 1;
            while (divisor <= number) {
                  divisor *= 10;
            }
            divisor /= 10;
            while (divisor > 0){
                  long remainder = (number / divisor) % 10;
                  if (((remainder ) != 9)) {
                        long result = (9 - ( (number / divisor) % 10 )) * divisor;
                        return result;
                  }
                  divisor /= 10;
            }
            return 0;
      }

      public static long changeDigitWithMaxProfitAndCalculateProfit(long[] arr){
            int maxIndex = 0;
            long max = 0;
            for (int i = 0; i < arr.length; i++) {
                  long cur = arr[i];
                  long tmp = calculateMaxDifference(cur);
                  if (tmp > max ){
                        max = tmp;
                        maxIndex = i;
                  }
            }
            arr[maxIndex] += max;
            return max;
      }

      public static void main(String[] args){


            long sumDifference = 0;

            int k = 3;
            //long[] arr = {88, 80, 85};
            long[] arr = {97, 80, 85};

            for (int i = 0; i < k; i++) {
                  long max = changeDigitWithMaxProfitAndCalculateProfit(arr);
                  sumDifference += max;

            }
            System.out.println(sumDifference);
      }
}