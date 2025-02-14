package yandex_internet._1_calculate_qty_intersetions;

import java.util.Arrays;
/**
 * Calculate quantity intersections line segments
 */
public class CalculateQtyIntersections {

      public static void main(String[] args) {
            testThree();
      }

      static void testThree() {
            int[][] numbers = { {2, 4}, {2, 3},{5, 6},{1, 2}, {1, 3}, {5,7} };
            int expectedResult = 4;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }
      /*
            [[1, 2], [1, 3], [2, 4], [2, 3], [5, 6], [5, 7]]
            maxLeft = 2 - initialize with 2 in first segment

            [[1, 2], [1, 3], [2, 4], [2, 3], [5, 6], [5, 7]]
             l0 l1   r0 r1 -> 2 > 1 -> intersection ++
                                          maxLeft = Math.max(3, maxLeft) = 3
                     l0 l1   r0 r1 -> 3 > 2 -> intersection ++
                                                maxLeft = Math.max(4, maxLeft) = 4
                              l0 l1   r0 r1 -> 4 > 2 -> intersection ++
                                                       maxLeft = Math.max(3, maxLeft) = 4
                                     l0 l1   r0 r1 -> 4 < 5 -> is not intersection
                                                            maxLeft = Math.max(6, maxLeft) = 6
                                              l0 l1   r0 r1 -> 6 > 5 -> intersection ++
                                                                  maxLeft = Math.max(7, maxLeft) = 7
       */

      static int[][] sort(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
            return intervals;
      }

      static int getQtyIntersections(int[][] numbers) {
            //quickSortMultipleArr(numbers, 0, numbers.length - 1);
            bubbleSortMultipleArr(numbers);
            //O(nlog(n))
            int intersectionQty = 0;
            int l = 0; // pointer to left line segment
            int r = 1; // pointer to right line segment
            int maxLeft = numbers[0][1]; // max left value in current line segment

            while (r < numbers.length) {                                                      //O(n)
                  if (maxLeft > numbers[r][0]) {//compare max left with right0
                        intersectionQty ++;
                  }
                  maxLeft = Math.max(numbers[r][1], maxLeft);
                  l++;
                  r++;
            }
            return intersectionQty;         // O(nlog(n)) + O(n) = O(n)
      }
      /*
            O(log(n))
       */
      static void quickSortMultipleArr(int[][] numbers, int startIndex, int endIndex) {
            if(startIndex >= endIndex) return; //exit from recursion

            int pivotIndex = partition(numbers, startIndex, endIndex);

            quickSortMultipleArr(numbers,startIndex,pivotIndex - 1);
            quickSortMultipleArr(numbers,pivotIndex + 1,endIndex);
      }

      /*
            O(n^2)
       */
      static void bubbleSortMultipleArr(int[][] numbers) {
            int n = numbers.length;

            // Bubble Sort
            for (int i = 0; i < n - 1; i++) {
                  for (int j = 0; j < n - i - 1; j++) {
                        // Compare first elements of each pair
                        if (numbers[j][0] > numbers[j + 1][0]) {
                              // Swap intervals[j] and intervals[j + 1]
                              int[] temp = numbers[j];
                              numbers[j] = numbers[j + 1];
                              numbers[j + 1] = temp;
                        }
                  }
            }
      }

      static int partition(int[][] numbers, int startIndex, int endIndex) {
            int i = startIndex - 1;
            int pivot = numbers[endIndex][0];

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if (numbers[j][0] < pivot) {
                        i++;
                        int temp0 = numbers[j][0];
                        int temp1 = numbers[j][1];
                        numbers[j][0] = numbers[i][0];
                        numbers[j][1] = numbers[i][1];
                        numbers[i][0] = temp0;
                        numbers[i][1] = temp1;
                  }
            }
            i++;
            int temp0 = numbers[endIndex][0];
            int temp1 = numbers[endIndex][1];
            numbers[endIndex][0] = numbers[i][0];
            numbers[endIndex][1] = numbers[i][1];
            numbers[i][0] = temp0;
            numbers[i][1] = temp1;
            return i;
      }
}
