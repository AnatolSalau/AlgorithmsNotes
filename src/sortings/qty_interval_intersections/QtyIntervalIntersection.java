package sortings.qty_interval_intersections;

import java.util.Arrays;
import java.util.HashMap;
/**
       Дан массив каждый элемент массива это два числа первое число это день заезда
       второе день выезда нужно найти количество элементов у которых есть
       пересечения причем если одна пара 1-5 а вторая 5-1 то это не считается
       пересечением, а считается пересечением 1-5 и допустим 2-18.
 */
public class QtyIntervalIntersection {
      /**
       Делаем словари для быстроты

       Берём ключи заездов и отьездов

       Все в сет

       Повторы удаляеются

       Потом объединяем два сета

       Повторы удаляются

       Сортируем

       На выходе список
       */
      public static void main(String[] args) {
            testThree();
      }
      /*
            Explanation through sorting
            [1, 5], [2, 18], [18, 19], [18, 19], [20, 23], [20, 22]
                l    r                                               1
                         l    r
                                   l    r                            1
                                             l    r
                                                       l    r        1
       */
      /*
            Explanation through HashMap
            [1, 5], [2, 18], [18, 19], [18, 19], [20, 23], [20, 22]
            ключи заездов 1 2 18 20
            ключи отъездов 5 18 19 22 23
            объединяем
            1 2 5 18 19 22 23
       */
      static int getQtyIntersections(int[][] numbers) {
            HashMap<Integer, Integer> checkInFreqMap = new HashMap();
            HashMap<Integer, Integer> checkOutFreqMap = new HashMap();

            for (int i = 0; i < numbers.length; i++) {
                  int checkInDay = numbers[i][0];
                  int checkOutDay = numbers[i][1];

                  if (checkInFreqMap.containsKey(checkInDay)) {
                        Integer val = checkInFreqMap.get(checkInDay);
                        val++;
                        checkInFreqMap.put(checkInDay,val);
                  } else {
                        checkInFreqMap.put(checkInDay,1);
                  }

                  if (checkOutFreqMap.containsKey(checkOutDay)) {
                        Integer val = checkOutFreqMap.get(checkOutDay);
                        val++;
                        checkOutFreqMap.put(checkOutDay,val);
                  } else {
                        checkOutFreqMap.put(checkOutDay,1);
                  }
            }

            return 0;
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
}
