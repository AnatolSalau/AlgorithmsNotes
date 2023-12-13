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
 *
 * На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?
 *
 * Обратите внимание, что ответ может превышать вместимость 32-битного типа данных.
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
            List<Integer> nums = new ArrayList<>(Arrays.asList(99, 5, 85)); ;
            int changesQty = 1;
            List<Integer> expectedNums = List.of(99, 5, 95);
            int expectedSumDifference = 10;
            getSumDifference(nums,changesQty);
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
                        9 - 0 = 9
                        i
            k:0   97 80 85
                  85 -> 95 - 85 = 10-> profit = 10
                        9 - 5 = 4
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
                        9 - 5 = 4 ->
       */

      private void testFour() {
            List<Integer> nums = new ArrayList<>(Arrays.asList(97, 80, 85)); ;
            int changesQty = 2;
            List<Integer> expectedNums = List.of(97, 90, 95);
            int expectedSumDifference = 20;
            getSumDifference(nums,changesQty);
      }

      /**
       * Time complexity 0(n * k)
       * n - arr length - 1
       * k - count of changed nums
       */
      private int getSumDifference(List<Integer> nums, int changesQty) {


            return 0;
      }

      private int calculateSumOfList(List<Integer> nums) {
            if (nums == null) return - 99;
            int sum = 0;
            for (int i = 0; i < nums.size() - 1; i++) {
                  sum += nums.get(i);
            }
            return sum;
      }
}
