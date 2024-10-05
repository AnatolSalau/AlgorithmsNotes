package sliding_window.sliding_window_median;

import java.util.*;

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
final class SlidingWindowMedianTwoHeap {
      public static void main(String[] args) {
            SlidingWindowMedianTwoHeap slidingWindowMedianPower = new SlidingWindowMedianTwoHeap();
            slidingWindowMedianPower.testOne();
            slidingWindowMedianPower.testTwo();
            slidingWindowMedianPower.testThree();
      }

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

      /*
            1  3  -1  -3  5  3  6  7, k = 3

            1  3  -1
            leftPriorityQueue(-1 1)  rightPriorityQueue(3)      -> leftPriorityQueue(-1 1).last = 1

               3  -1  -3
            leftPriorityQueue(-3 -1)  rightPriorityQueue(3)      -> leftPriorityQueue(-3 -1).last = -1

                  -1  -3  5
            leftPriorityQueue(-3 -1)  rightPriorityQueue(5)      -> leftPriorityQueue(-3 -1).last = -1

                      -3  5  3
            leftPriorityQueue(-3 3)  rightPriorityQueue(5)      -> leftPriorityQueue(-3 -1).last = 3

                         5  3  6
            leftPriorityQueue(3 5)  rightPriorityQueue(6)      -> leftPriorityQueue(3 5).last = 5

                            3  6  7
            leftPriorityQueue(3 6)  rightPriorityQueue(7)      -> leftPriorityQueue(3 5).last = 6

       */
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
            1 2 3 4 length = 3
              1 + 3 - 1 = 3
       */
      private List<Double> getMedians(int[] numbers, int k) {
            if (k > numbers.length) return null;

            List<Double> allMedians = new LinkedList<>();

            int[] window = initializeSortedWindow(numbers,k);
            PriorityQueue<Integer> leftQueue = initializeLeftQueue(window);
            PriorityQueue<Integer> rightQueue = initializeRightQueue(window);

            final int leftCapacity = leftQueue.size();
            final int rightCapacity = rightQueue.size();

            for (int l = 0, r = l + k - 1; r < numbers.length; l++, r++) {

                  double median = getMedian(leftQueue, rightQueue, k);
                  allMedians.add(median);

                  printStatisticCMD(median, leftQueue, rightQueue);

                  int willDelete = numbers[l];
                  deleteFromQueues(willDelete, leftQueue, rightQueue);


                  if (r + 1 < numbers.length) {
                        int willAdd = numbers[r + 1];
                        addToQueues(willAdd, leftQueue, rightQueue);
                  }

                  // update queues function
                  updateQueues(leftCapacity,rightCapacity,leftQueue, rightQueue);
            }
            return allMedians;
      }

      /*
            length = 3
            leftQueue length = 3/2 + 1 = 2
            length = 5
            leftQueue length = 5/2 + 1 = 3

       */
      int[] initializeSortedWindow(int[] numbers, int k) {
            int[] window = new int[k];

          System.arraycopy(numbers, 0, window, 0, k);
            Arrays.sort(window);
            return window;
      }

      PriorityQueue<Integer> initializeLeftQueue(int[] window) {
            int length = window.length;
            int queueSize = 0;
            if (length % 2 == 0) {
                  //even length
                  queueSize = length / 2;

            } else {
                  //odd length
                  queueSize = length / 2;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(queueSize, Collections.reverseOrder());
            for (int i = 0; i < queueSize; i++) {
                  priorityQueue.add(window[i]);
            }
            return priorityQueue;
      }

      PriorityQueue<Integer> initializeRightQueue(int[] windows) {
            int startIndex = 0;
            int length = windows.length;
            if (length % 2 == 0) {
                  //even length
                  startIndex = length / 2;

            } else {
                  //odd length
                  startIndex = length / 2;
            }
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(startIndex);
            for (int i = startIndex; i < length; i++) {
                  priorityQueue.add(windows[i]);
            }
            return priorityQueue;
      }

      private double getMedian(PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue, int k) {
            if (k % 2 == 0) {
                  // if window length is even (leftMax + rightMin) / 2
                  double leftMax = leftQueue.peek();
                  double rightMin = rightQueue.peek();
                  return (leftMax + rightMin) / 2;
            } else {
                  // if window length is odd get right min
                  double rightMin = rightQueue.peek();
                  return rightMin;
            }
      }

      private void deleteFromQueues(int willDelete, PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue) {
            int minRight = rightQueue.peek();
            // delete
            if (willDelete < minRight) {
                  //delete from left
                  leftQueue.remove(willDelete);
            } else {
                  //delete from right
            }      rightQueue.remove(willDelete);
      }

      private void addToQueues(int willAdd, PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue) {
            int minRight = rightQueue.peek();
            //add
            if (willAdd < minRight) {
                  //add to left
                  leftQueue.add(willAdd);
            } else {
                  //add to right
                  rightQueue.add(willAdd);
            }
      }

      private void updateQueues(int leftCapacity, int rightCapacity, PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue ) {
            //balance leftQueue
            if (leftQueue.size() > leftCapacity) {
                  int maxInLeftQueue = leftQueue.poll();
                  rightQueue.add(maxInLeftQueue);
            }

            // balanced rightQueu
            if (rightQueue.size() > rightCapacity) {
                  int minRightQueue = rightQueue.poll();
                  leftQueue.add(minRightQueue);
            }
      }

      private void printStatisticCMD(double median, PriorityQueue<Integer> leftQueue, PriorityQueue<Integer> rightQueue) {
            System.out.print(leftQueue);
            System.out.print("+");
            System.out.print(rightQueue);
            System.out.println();
            System.out.println(median);
            System.out.println();
      }
}
