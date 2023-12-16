package tinkof_tasks.contest2023.task5;

/**
 * Во время разработки некоторой задачи Саша решил сгенерировать несколько новых тестов.
 * Каждый тест Саши должен представлять собой натуральное число, не меньшее
 * l и не большее r.
 * Кроме того, натуральное число в тесте обязательно должно состоять из одинаковых цифр.
 * <p>
 * Например, число
 * 999
 * подходит под это требование, а число
 * 1231 — нет.
 * Какое максимальное число различных тестов сможет создать Саша?
 * <p>
 * Формат входных данных
 * В единственной строке вводятся два натуральных числа l и r — ограничения на тесты Саши.
 * Формат выходных данных
 * Выведите одно число — количество тестов, которое может сделать Саша.
 * <p>
 * Пример 1
 * Ввод: 4  7
 * Вывод: 4
 * Саше подходят номера 4 5 6 7
 **/
/**
 * Пример 1
 * Ввод: 4  7
 * Вывод: 4
 * Саше подходят номера 4 5 6 7
 **/

import java.util.Arrays;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Пример 2
 * Ввод: 10  100
 * Вывод: 9
 * Саше подходят номера: 11 22 33 44 55 66 77 88 99 - 9 штук
 **/
public class Task5 {
      public static void main(String[] args) {
            Task5 task5 = new Task5();
            task5.testOne();
            //task5.testTwo();
      }

      private void testOne() {
            int from = 4;
            int to = 7;
            int expectedResult = 4;
            int[] expectedNumbers = {4, 5, 6, 7};

            System.out.println("Test 1");
            System.out.println("From " + from + " to " + to);
            System.out.println("Expected result " + expectedResult);
            System.out.println("Expected numbers : " + Arrays.toString(expectedNumbers));
            List<Integer> testQty = getTestQty(from, to);
            System.out.println(testQty);
            System.out.println();
      }

      private void testTwo() {
            int from = 90;
            int to = 1000;
            int expectedResult = 9;
            int[] expectedNumbers = {11, 22, 33, 44, 55, 66, 77, 88, 99};

            System.out.println("Test 2");
            System.out.println("From " + from + " to " + to);
            System.out.println("Expected result " + expectedResult);
            System.out.println("Expected numbers : " + Arrays.toString(expectedNumbers));
            List<Integer> testQty = getTestQty(from, to);
            System.out.println(testQty);
            System.out.println();
      }

      private List<Integer> getTestQty(int from, int to) {
            List<Integer> result = new LinkedList<>();
            int length = 1;
            // from 1 to 9
            for (int i = from; i <= to && i < 10 ; i++) {
                  int repDigit = getRepDigit(i, length);
                  result.add(repDigit);
            }

            return result;
      }
            /*       B^y - 1
       repDog =  x --------------
                     B - 1
             */
      private int getRepDigit (int digit, int length) {
           int repDigit =  digit * ( (int)(Math.pow(10, length) ) - 1 ) / ( 10 - 1 );
           return repDigit;
      }

}
