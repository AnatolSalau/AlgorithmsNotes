package sliding_window.sliding_window_median;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
       The median is the middle value in an ordered integer list.
       If the size of the list is even, there is no middle value.
       So the median is the mean of the two middle values.

       For examples, if arr = [2,3,4], the median is 3.
       For examples, if arr = [1,2,3,4], the median is (2 + 3) / 2 = 2.5.
       You are given an integer array nums and an integer k.
       There is a sliding window of size k
       which is moving from the very left of the array to the very right.
       You can only see the k numbers in the window.
       Each time the sliding window moves right by one position.

       Return the median array for each window in the original array.
       Answers within 10^-5 of the actual value will be accepted.

       Example 1:
       Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
       Output: [1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000]
       Explanation:
       Window position                Median
       ---------------                -----
       [1  3  -1] -3  5  3  6  7       1
       1 [3  -1  -3] 5  3  6  7       -1
       1  3 [-1  -3  5] 3  6  7       -1
       1  3  -1 [-3  5  3] 6  7        3
       1  3  -1  -3 [5  3  6] 7        5
       1  3  -1  -3  5 [3  6  7]       6

       Example 2:
       Input: nums = [1,2,3,4,2,3,1,4,2], k = 3
       Output: [2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000]
 */
final class SlidingWindowMedianPower {
      public static void main(String[] args) {
            SlidingWindowMedianPower slidingWindowMedianPower = new SlidingWindowMedianPower();
            slidingWindowMedianPower.testOne();
            slidingWindowMedianPower.testTwo();
            slidingWindowMedianPower.testThree();
      }
      /*
            2 3 3 5 7 10 - 4 (even length (3+5)/2 = median is 4

            1,3,-1,-3,5,3,6,7   k=3

            1 3 -1  sort->  -1 1 3 (median is 1)
            3  -1  -3 sort-> -3 -1 3 (median is -1)
            -1  -3  5 sort-> -3 -1 5 (median is -1)
            -3  5  3 sort-> -3 3 5 (median is 3)
            5  3  6 sort-> 3 5 6 (median is 5)
            3  6  7 sort-> 3 6 7 (median is 6)
      */
      private void testOne() {
            int[] numbers = {1,2,3,4,2,3,1,4,2};
            double[] expected = {2.00000,3.00000,3.00000,3.00000,2.00000,3.00000,2.00000};
            int k = 3;
            System.out.println("K = " + k);
            System.out.println(Arrays.toString(numbers));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Result   : " + medians);
            System.out.println();
      }

      private void testTwo() {
            int[] numbers = {1,3,-1,-3,5,3,6,7};
            double[] expected = {1.00000,-1.00000,-1.00000,3.00000,5.00000,6.00000};
            int k = 3;
            System.out.println("K = " + k);
            System.out.println(Arrays.toString(numbers));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Result   : " + medians);
            System.out.println();
      }

      private void testThree() {
            int[] numbers = {-1, 5, 13, 8, 2, 3, 3, 1};
            double[] expected = {6.5, 6.5, 5.5, 3.0, 2.5};
            int k = 4;
            System.out.println("K = " + k);
            System.out.println(Arrays.toString(numbers));
            List<Double> medians = getMedians(numbers, k);
            System.out.println("Expected : " + Arrays.toString(expected));
            System.out.println("Result   : " + medians);
            System.out.println();
      }

      /*
            1 2 3 length = 3, k = 3
            l = 0
            r = l + k = 3

            1 2 3 4 5 length = 5, k = 4
            l = 0
            r = l + k = 0 + 4 = 4
       */
      private static List<Double> getMedians(int[] numbers, int k) {
            List<Double> medians = new LinkedList<>();

            if (k > numbers.length) return null;

            for ( int l = 0,  r = l + k; r <= numbers.length ; l++, r++) {
                  int[] window = getWindowArr(numbers, l, r, k);
                  System.out.println("window : " + Arrays.toString(window));
                  Arrays.sort(window);
                  double median = getMedianFromWindow(window);
                  medians.add(median);
            }
            return medians;
      }
/*                      0 1 2 3
            length = 4 (1 2 3 4)

                        0 1 2
            length = 3 (1 2 3)
       */
      private static double getMedianFromWindow(int[] window) {
            int length = window.length;

            if (length % 2 == 0) {
                  //even length
                  int l = length / 2 - 1;
                  int r = length / 2;
                  double median = ((double) window[l] + (double) window[r]) / 2;
                  return median;
            } else {
                  //odd length
                  int i = length / 2;
                  double median = window[i];
                  return median;
            }
      }

      private static int[] getWindowArr(int[] numbers, int from, int to, int length) {
            int[] window = new int [length];
            for (int i = from, j = 0; i < to; i++, j++) {
                  window[j] = numbers[i];
            }
            return window;
      }


}
