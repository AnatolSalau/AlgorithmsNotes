package yandex_internet._12_qty_interval_intersections;

import java.util.Arrays;

public class QtyIntervalIntersectionHashMap {
      /**
             Дан массив каждый элемент массива это два числа первое число это день заезда
       второе день выезда нужно найти количество элементов у которых есть
       пересечения причем если одна пара 1-5 а вторая 5-1 то это не считается
       пересечением, а считается пересечением 1-5 и допустим 2-18.

       */

      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
      }

      static void testOne() {
            int[][] numbers = {{20, 23}, {20,22}, {18,19}, {1,5}, {2,18}, {18,19} };
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testTwo() {
            int[][] numbers = {{1, 5}, {2,18}};
            int expectedResult = 1;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testThree() {
            int[][] numbers = {{1, 2}, {1, 3}, {2, 4}, {2, 3}};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }
      /*
            {{1, 2}, {1, 3}, {2, 4}, {2, 3}};
            expectedResult = 3;


       */
      static int getQtyIntersections(int[][] numbers) {
            return 0;
      }




}
