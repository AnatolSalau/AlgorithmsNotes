package sortings.qty_interval_intersections;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class QtyIntervalIntersectionStream {
      /**
       * Дан массив каждый элемент массива это два числа первое число это день заезда
       * второе день выезда нужно найти количество элементов у которых есть
       * пересечения причем если одна пара 1-5 а вторая 5-1 то это не считается
       * пересечением, а считается пересечением 1-5 и допустим 2-18.
       */

      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
      }

      static void testOne() {
            int[][] numbers = {{20, 23}, {20, 22}, {18, 19}, {1, 5}, {2, 18}, {18, 19}};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersectionsByStream(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testTwo() {
            int[][] numbers = {{1, 5}, {2, 18}};
            int expectedResult = 1;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersectionsByStream(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testThree() {
            int[][] numbers = {{1, 2}, {1, 3}, {2, 4}, {2, 3},};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersectionsByStream(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      /*
            [1, 5], [2, 18], [18, 19], [18, 19], [20, 23], [20, 22]
                l    r                                               1
                         l    r
                                   l    r                            1
                                             l    r
                                                       l    r        1
       */
      static int getQtyIntersectionsByStream(int[][] numbers) {
            System.out.println("Before sort : " + Arrays.deepToString(numbers));

            // 1. sort array
            int[][] sorted = Arrays.stream(numbers)
                  .sorted((range2, range1) -> Integer.compare(range2[0], range1[0]))
                  //.sorted(Comparator.comparingInt(range2 -> range2[0])) - new way to sort array
                  .toArray(int[][]::new);
            // 2. Initialize mad day of wth first day of
            AtomicInteger maxCurrDayOf = new AtomicInteger(sorted[0][1]);
            // 3. Initialize count for intersections day in and day of
            AtomicInteger count = new AtomicInteger(0);
            // 4/ Go through arr by stream with index
            IntStream.range(0, sorted.length - 1)
                  .forEach(i -> {
                        if ( maxCurrDayOf.get() > sorted[i + 1][0]) { // increment count
                              count.incrementAndGet();
                        }
                        maxCurrDayOf.set(Math.max(sorted[i][1], sorted[i + 1][1])); // set new max current day of
                  });
            return count.get();
      }

      static void bubbleSortMultipleArr(int[][] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                  for (int j = i; j < numbers.length; j++) {
                        if (numbers[i][0] > numbers[j][0]) {
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

      static void quickSortMultipleArr(int[][] numbers, int startIndex, int endIndex) {
            if (startIndex >= endIndex) return;

            int pivotIndex = partition(numbers, startIndex, endIndex);

            quickSortMultipleArr(numbers, startIndex, pivotIndex - 1);
            quickSortMultipleArr(numbers, pivotIndex + 1, endIndex);
      }

      static int partition(int[][] numbers, int startIndex, int endIndex) {
            int i = startIndex - 1;

            int pivot = numbers[endIndex][0];

            for (int j = startIndex; j <= endIndex - 1; j++) {

                  if (numbers[j][0] < pivot) {
                        i++;
                        int temp0 = numbers[i][0];
                        int temp1 = numbers[i][1];
                        numbers[i][0] = numbers[j][0];
                        numbers[i][1] = numbers[j][1];
                        numbers[j][0] = temp0;
                        numbers[j][1] = temp1;
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
