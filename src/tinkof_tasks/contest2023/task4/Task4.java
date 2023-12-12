package tinkof_tasks.contest2023.task4;

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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
      /*
            99 5 85
                   *
            i:0   99 5 85 -> sum = 189, countChanges = 1
                  *
                  99 5 85 -> sum = 189, countChanges = 1
                     *
            i:1   99 9 85 -> sum = 193, countChanges = 1
                        *
            i:2   99 5 89 -> sum = 193, countChanges = 1
                       *
            i:3   99 5 95 -> sum = 199, countChanges = 1
       */
      private void testTwo() {
            List<Integer> nums = new ArrayList<>(Arrays.asList(99, 5, 85)); ;
            int changesQty = 1;
            List<Integer> expectedNums = List.of(99, 5, 95);
            int expectedSumDifference = 10;
            getSumDifference(nums,changesQty);
      }
      
      private int getSumDifference(List<Integer> nums, int changesQty) {
            //calculate sum
            int sum = calculateSumOfList(nums);

            //sort list in reverse order;
            nums.sort(Collections.reverseOrder());

            for (int i = 0; i < nums.size(); i++) {
                  System.out.println(nums.get(i));

            }

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
