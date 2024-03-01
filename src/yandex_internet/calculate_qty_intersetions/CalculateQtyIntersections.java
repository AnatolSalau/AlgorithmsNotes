package yandex_internet.calculate_qty_intersetions;

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
      static int getQtyIntersections(int[][] numbers) {
            quickSortMultipleArr(numbers, 0, numbers.length - 1);
            int intersectionQty = 0;
            int l = 0; // pointer to left line segment
            int r = 1; // pointer to right line segment
            int maxLeft = numbers[0][1]; // max left value in current line segment

            while (r < numbers.length) {
                  if (maxLeft > numbers[r][0]) {//compare max left with right0
                        intersectionQty ++;
                  }
                  maxLeft = Math.max(numbers[r][1], maxLeft);
                  l++;
                  r++;
            }
            return intersectionQty;
      }
      static void quickSortMultipleArr(int[][] numbers, int startIndex, int endIndex) {
            if(startIndex >= endIndex) return; //exit from recursion

            int pivotIndex = partition(numbers, startIndex, endIndex);

            quickSortMultipleArr(numbers,startIndex,pivotIndex - 1);
            quickSortMultipleArr(numbers,pivotIndex + 1,endIndex);
      }

      static void bubbleSortMultipleArr(int[][] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                  for (int j = i; j < numbers.length; j++) {
                        if (numbers[i][0] > numbers[j][0]) {//compare first numbers in line segments
                              int temp0 = numbers[j][0];
                              int temp1 = numbers[j][1];

                              numbers[j][0] = numbers[i][0];
                              numbers[j][1] = numbers[i][1];

                              numbers[i][0] = temp0;
                              numbers[i][1] = temp1;
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
