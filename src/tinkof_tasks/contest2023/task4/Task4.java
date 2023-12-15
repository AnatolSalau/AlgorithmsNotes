package tinkof_tasks.contest2023.task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * У Кости есть бумажка, на которой написано n чисел.
 * Также у него есть возможность не больше, чем k раз,
 * взять любое число с бумажки, после чего закрасить одну из старых цифр,
 * а на ее месте написать новую произвольную цифру.
 * <p>
 * На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?
 * <p>
 * Обратите внимание, что ответ может превышать вместимость 32-битного типа данных.
 * <p>
 * Пример 1:
 * Ввод:
 * 5 2
 * 1 2 1 3 5
 * Вывод:
 * 16
 * <p>
 * Костя может изменить две единицы на две девятки, в результате чего сумма чисел увеличится на 16
 * <p>
 * Пример 2:
 * Ввод:
 * 3 1
 * 99 5 85
 * Вывод:
 * 10
 * <p>
 * Во втором примере Костя меняет число 85 на 95
 * <p>
 * Решение без перевода в числовой массив
 * Java:
 * int t = scanner.nextInt(); // число из входного массива в цикле обрабатываем по очереди
 * int weight = 1; // так как идем справа-начальный весовой коэф 1
 * while (t > 0) {
 * int digit = t % 10; // работаем с остатком от деления на 10
 * long gain = (9 - digit) * weight;
 * // здесь добавляете gain в удобный для вас класс-коллекцию,
 * // которую можно отсортировать и выбрать макс. k значений и суммировать
 * weight *= 10; // двигаемся на весовой разряд влево
 * t /= 10; // целоисчисленно отсекаем правую цифру
 * }
 * <p>
 * Пример 3:
 * Ввод:
 * 1 10
 * 9999
 * Вывод:
 * 0
 * <p>
 * В третьем примере можно ничего не менять
 */

/**
 *   Пример 1:
 *   Ввод:
 *   5 2
 *   1 2 1 3 5
 *   Вывод:
 *   16
 *
 *   Костя может изменить две единицы на две девятки, в результате чего сумма чисел увеличится на 16
 */

/**
 *   Пример 2:
 *   Ввод:
 *   3 1
 *   99 5 85
 *   Вывод:
 *   10
 *
 *   Во втором примере Костя меняет число 85 на 95
 */

/**
 * Решение без перевода в числовой массив
 * Java:
 * int t = scanner.nextInt(); // число из входного массива в цикле обрабатываем по очереди
 * int weight = 1; // так как идем справа-начальный весовой коэф 1
 *     while (t > 0) {
 *         int digit = t % 10; // работаем с остатком от деления на 10
 *         long gain = (9 - digit) * weight;
 *         // здесь добавляете gain в удобный для вас класс-коллекцию,
 *         // которую можно отсортировать и выбрать макс. k значений и суммировать
 *         weight *= 10; // двигаемся на весовой разряд влево
 *         t /= 10; // целоисчисленно отсекаем правую цифру
 *     }
 */

/**
 *   Пример 3:
 *   Ввод:
 *   1 10
 *   9999
 *   Вывод:
 *   0
 *
 *   В третьем примере можно ничего не менять
 */

/**
 *   Пример 4:
 *   Ввод:
 int k = 2;
 long[] mas = {97, 80, 85}; сумма = 262
 *   20
 *
 *   Меняем две цифры {97, 90, 95}; сумма = 282
 */
public class Task4 {
      public static void main(String[] args) {
            Task4 task4 = new Task4();
            //task4.testFour();
            //task4.testOne();
            task4.testTwo();

      }

      /*
            5 (всего чисел) 2 (сколько чисел можно поменять)
            1 2 1 3 5 - сумма = 12
            Ожидаемый результат
            9 2 9 3 5 - сумма = 28
            Разница между суммами - 16

            меняем две единицы потому что это даст максимальную выгоду
       */
      /*          *
           i:0    1 2 1 3 5
       */
      private void testOne() {
            List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 5));
            System.out.println("Nums : " + nums);
            int changesQty = 1;
            System.out.println("changesQty = " + changesQty);
            List<Integer> expectedNums = List.of(9, 2, 9, 3, 5);
            int expectedSumDifference = 16;
            int sumDifference = getSumDifference(nums, changesQty);
            System.out.println("After changing : " + nums);
            System.out.println("ExpectedNums : " + expectedNums);
            System.out.println("Sum difference : " + sumDifference);
            System.out.println("Expected sum difference : " + expectedSumDifference);
      }

      /*
            3 (всего чисел) 1 (сколько чисел можно поменять)
            99 5 85 - сумма = 189
            Ожидаемый результат
            99 5 95 - сумма = 199
            Разница между суммами - 10

            меняем первую цифру в числе 85 на 95 - так как это даст максимальную выгоду
       */
      private void testTwo() {
            List<Integer> nums = new ArrayList<>(Arrays.asList(99, 5, 85));
            System.out.println("Nums : " + nums);
            int changesQty = 1;
            System.out.println("changesQty = " + changesQty);
            List<Integer> expectedNums = List.of(99, 5, 95);
            int expectedSumDifference = 10;
            int sumDifference = getSumDifference(nums, changesQty);
            System.out.println("After changing : " + nums);
            System.out.println("ExpectedNums : " + expectedNums);
            System.out.println("Sum difference : " + sumDifference);
            System.out.println("Expected sum difference : " + expectedSumDifference);
      }

      /*
            97 80 85, k=2, -> 97, 90, 95 (максимально с двумя измененными числами)
                  i
            k:0   97 80 85
                  97 -> 97 - 97 = 0
                        7 - 9 = 2 -> profit = 2

                     i
            k:0   97 80 85
                  80 -> 90 - 80 = 10-> profit = 10 (First Max profit) -> change values in arr - > 97 90 85

                        i
            k:0   97 80 85
                  85 -> 95 - 85 = 10-> profit = 10

                  i
            k:1   97 90 85
                  97 -> 97 - 97 = 0
                        9 - 7 = 2 -> profit = 2

                     i
            k:1   97 90 85
                  90 -> 90 - 90 = 0
                        9 - 0 = 9 -> profit = 9

                        i
            k:1   97 90 85
                  85 -> 95 - 85 = 10 -> profit = 10 (First Max profit) -> change values in arr - > 97 90 95
       */
      private void testFour() {
            List<Integer> nums = new ArrayList<>(Arrays.asList(97, 80, 85));
            System.out.println("Nums : " + nums);
            int changesQty = 2;
            System.out.println("changesQty = " + changesQty);
            List<Integer> expectedNums = List.of(97, 90, 95);
            int expectedSumDifference = 20;
            int sumDifference = getSumDifference(nums, changesQty);
            System.out.println("After changing : " + nums);
            System.out.println("ExpectedNums : " + expectedNums);
            System.out.println("Sum difference : " + sumDifference);
            System.out.println("Expected sum difference : " + expectedSumDifference);
      }

      /**
       * Time complexity 0(n * k)
       * n - arr length - 1
       * k - count of changed nums
       */
      private int getSumDifference(List<Integer> nums, int changesQty) {
            int previousSum = calculateSumOfList(nums);
            //go through required quantity  of changes
            for (int i = 0; i < changesQty; i++) {
                  findFirstMaxProfitAndChangeNums(nums);
            }
            //sum after changing nums
            int nextSum = calculateSumOfList(nums);
            int difference = nextSum - previousSum;
            return difference;
      }

      private void findFirstMaxProfitAndChangeNums(List<Integer> nums) {
            int maxProfit = -1;
            int maxIndex = -1;
            for (int i = 0; i < nums.size(); i++) {
                  int number = nums.get(i);
                  int profit = calculateMaxProfitByChangingOneDigit(number);

                  if (profit > maxProfit) {
                        maxProfit = profit;
                        maxIndex = i;
                  }
            }
            //change number in list to max profit number
            Integer val = nums.get(maxIndex);
            val = val + maxProfit;
            nums.set(maxIndex,val);
      }
      /*
            82 -> 92

            leftHalf = 8
            rightHalf = 2;
            delimeter = 10;


       */
      private int calculateMaxProfitByChangingOneDigit(int number) {
            int delimiter = 1;
            // increase delimiter while he less than number
            while (delimiter < number) {
                  delimiter *= 10;
            }
            delimiter /= 10;

            while (delimiter > 0) {
                  int leftHalf = number / delimiter;
                  int lastDigitLeftHalf = leftHalf % 10;

                  int rigthHalf = number % delimiter;

                  if (lastDigitLeftHalf == 9) {
                        delimiter /= 10;
                  } else {
                        int numberAfterChange = (leftHalf - lastDigitLeftHalf) + (9 * delimiter) + rigthHalf;
                        int profit = numberAfterChange - number;
                        return profit;
                  }
            }

            return 0;
      }

      private int calculateSumOfList(List<Integer> nums) {
            if (nums == null) return -99;
            int sum = 0;
            for (int i = 0; i < nums.size(); i++) {
                  sum += nums.get(i);
            }
            return sum;
      }
}
