package yandex_internet._12_qty_interval_intersections;

import java.util.*;

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
            System.out.println("Test 1");
            int[][] numbers = {{20, 23}, {20,22}, {18,19}, {1,5}, {2,18}, {18,19} };
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testTwo() {
            System.out.println("Test 2");
            int[][] numbers = {{1, 5}, {2,18}};
            int expectedResult = 2;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }

      static void testThree() {
            System.out.println("Test 3");
            int[][] numbers = {{1, 2}, {1, 3}, {2, 4}, {2, 3}};
            int expectedResult = 3;
            System.out.println(Arrays.deepToString(numbers));
            int qtyIntersections = getQtyIntersections(numbers);
            System.out.println(Arrays.deepToString(numbers));
            System.out.println("Result : " + qtyIntersections);
            System.out.println("ExpectedResult : " + expectedResult);
      }
      /*
            guest = {{1, 2}, {1, 3}, {2, 4}, {2, 3}};
            expectedResult = 3;
            0. Create count maxQtyInHostel
            1. Map with arriving
                  day of arrive -> count of people in that day
                  "arriving": {
                        "1": 2,
                        "2": 2
                        }
            2. Map with leaving
                  day of leave -> count of people in that day
                  "leaving": {
                        "2": 1,
                        "3": 2,
                        "4": 1
                        },
            3. TreeSet with all days (all days in sorted order)
            4. Run loop through guests # O(n)
                  calculate arriving and leaving
                          arriving[guest[0]] += 1
                           leaving[guest[1]] += 1
                  add arriving day and leaving day to allDaySet
            5. Create count curr (current qty in hostel)
            6. Go through all day map
                  if day in arriving
                        plus to curr
                  if day in leaving
                       minus from curr
                  add Max from curr and maxQty to maxQty
            7. return maxQtyInHostel

       */
      static int getQtyIntersections(int[][] guests) {
            int maxQty = 0;
            Map<Integer, Integer> arrivingMap = new HashMap<>();
            Map<Integer, Integer> leavingMap = new HashMap<>();

            Set<Integer> allDays = new TreeSet<>();

            for (int[] guest : guests) {                                      //O(n)
                  if (arrivingMap.containsKey(guest[0])) {
                        Integer qty = arrivingMap.get(guest[0]);
                        qty++;
                        arrivingMap.put(guest[0], qty);
                  } else {
                        arrivingMap.put(guest[0], 1);
                  }
                  if (leavingMap.containsKey(guest[1])) {
                        Integer qty = leavingMap.get(guest[1]);
                        qty++;
                        leavingMap.put(guest[1], qty);
                  } else {
                        leavingMap.put(guest[1], 1);
                  }

                  allDays.add(guest[0]);
                  allDays.add(guest[1]);
            }

            int currQty = 0;

            for (int day : allDays) {                                         //O(n)
                  if (leavingMap.containsKey(day)) {
                        currQty -= leavingMap.get(day);
                  }

                  if (arrivingMap.containsKey(day)) {
                        currQty += arrivingMap.get(day);
                  }

                  if (currQty > maxQty) {
                        maxQty = currQty;
                  }
            }

            return maxQty;                                                    //Time: O(n) + Memory: O(n)
      }

}
