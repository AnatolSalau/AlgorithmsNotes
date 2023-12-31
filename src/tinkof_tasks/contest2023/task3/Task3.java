package tinkof_tasks.contest2023.task3;

import java.util.Arrays;

/**
       У Кати насыщенный день на работе. Ей надо передать n разных договоров коллегам.
       Все встречи происходят на разных этажах, а между этажами можно перемещаться только по лестничным пролетам
       — считается, что это улучшает физическую форму сотрудников. Прохождение каждого пролета занимает ровнo 1 минуту.

       Сейчас Катя на парковочном этаже, планирует свой маршрут. Коллег можно посетить в любом порядке,
       но один из них покинет офис через t минут. С парковочного этажа лестницы нет — только лифт,
       на котором можно подняться на любой этаж.

       В итоге план Кати следующий:

       1. Подняться на лифте на произвольный этаж. Считается, что лифт поднимается на любой этаж за 0 минут.
       2. Передать всем коллегам договоры, перемещаясь между этажами по лестнице. Считается, что договоры на этаже передаются мгновенно.
       3. В первые t минут передать договор тому коллеге, который планирует уйти.
       4. Пройти минимальное количество лестничных пролетов.

       Помогите Кате выполнить все пункты ее плана.

       Формат входных данных:

       В первой строке вводятся целые положительные числа
       n
       t
       (2 ≤ n, t ≤ 100)
       (2≤n,t≤100) — количество сотрудников и время, когда один из сотрудников покинет офис (в минутах).
       В следующей строке n чисел — номера этажей, на которых находятся сотрудники.
       Все числа различны и по абсолютной величине не превосходят 100.
       Номера этажей даны в порядке возрастания.
       В следующей строке записан номер сотрудника, который уйдет через t минут.

       Формат выходных данных:

       Выведите одно число — минимально возможное число лестничных пролетов, которое понадобится пройти Кате.

       Пример 1:
       Ввод:
       5 (кол-во сотрудников)  5 (ближайшее время когда сотрудник покинет офис)
       1  4  9  16  25 (этажи с сотрудниками)
       2 (номер сотрудника который уйдет через t минут)
       Вывод:
       24

       Пример 2:
       Ввод:
       6 (кол-во сотрудников) 4 (ближайшее время когда сотрудник покинет офис)
       1  2  3  6  8  25 (этажи с сотрудниками)
       5 (номер сотрудника который уйдет через t минут)
       Вывод:
       31

       Замечания:
       В первом примере времени достаточно, чтобы Катя поднялась по этажам по порядку.

       Во втором примере Кате понадобится подняться к уходящему сотруднику,
       а потом пройти всех остальных — например, в порядке
       {1,2,3,4,6}
 */
/*
      Решение (Подсказка)
      Найдем максимум и минимум во входных данных.
      Мы знаем, что ответ не меньше чем max − min. Если нельзя успеть пройти всех сотрудников
      за это время, то это значит, что сотрудник успеет уйти. Тогда выгоднее всего сразу доехать до его
      этажа, а потом сделать одну из двух операций — либо подняться на самый верх, а потом спуститься
      вниз, либо спуститься на самый низ, а потом подняться наверх. Если уезжающий сотрудник был
      на этаже x, то получившимися формулами будет max − min + max − x и max − min + x − min
      соответственно, осталось только найти минимум из этих двух величин.
 */
public class Task3 {
      public static void main(String[] args) {
            Task3 task3 = new Task3();
            task3.test6Employee();
            //task3.test5Employee();
      }

      /*
            Ожидаемое время 24 минуты
            Этажи       Номера сотрудников
            25          5
            16          4
            9           3
            4           2 (уйдет через 5 минут)
            1           1

            1.    Выходим на первом этаже
            2.    Идем с низу в верх - 24 минуты.
       */
      private void test5Employee() {
            int employeeQty = 5;
            int shortestTime = 5;
            int[] floorsWithEmployee = {1, 4, 9, 16,  25};
            int numberEmployeeWithShortestTime = 2;
            int minutes = getMinutes(employeeQty, shortestTime, floorsWithEmployee, numberEmployeeWithShortestTime);

            System.out.println("EmployeeQty : " + employeeQty + ", shortestTime : " + shortestTime);
            System.out.println("Floors with employee : " + Arrays.toString(floorsWithEmployee));
            System.out.println("NumberEmployeeWithShortestTime : " + numberEmployeeWithShortestTime);
            System.out.println("Time : " + minutes);
            System.out.println("Expected result : " + 24);
            System.out.println();
      }
      /*    Ожидаемое время 31 минуты
            Этажи       Номера сотрудников
            25          6
            8           5 (уйдет через 4 минуты)
            6           4
            3           3
            2           2
            1           1


            1.    Едем на 8 этаж к сотруднику который уходит (0 минут)
                  Считаем что до 25 этажа идти 25 - 8 = 17 этажей - 17 минут
                  Считаем что до 1 этажа идти 8 - 1 = 7 этажей - 7 минут
            2.    Идем в низ. (7 минут)
            3.    Подымаемся на верх (24 минут)
            Ответ 7 минут + 24 минуты = 31 минута
       */
      private void test6Employee() {
            int employeeQty = 6;
            int shortestTime = 4;
            int[] floorsWithEmployee = {1, 2, 3, 6, 8, 25};
            int numberEmployeeWithShortestTime = 5;
            int minutes = getMinutes(employeeQty, shortestTime, floorsWithEmployee, numberEmployeeWithShortestTime);

            System.out.println("EmployeeQty : " + employeeQty + ", shortestTime : " + shortestTime);
            System.out.println("Floors with employee : " + Arrays.toString(floorsWithEmployee));
            System.out.println("NumberEmployeeWithShortestTime : " + numberEmployeeWithShortestTime);
            System.out.println("Time : " + minutes);
            System.out.println("Expected result : " + 31);
            System.out.println();
      }

      private int getMinutes(int employeeQty, int shortestTime, int[] floorsWithEmployee, int numberWithShortestTimeEmployee) {
            int minFloor = floorsWithEmployee[0];
            int maxFloor = floorsWithEmployee[floorsWithEmployee.length - 1];
            int floorWithShortestTimeEmployee = floorsWithEmployee[numberWithShortestTimeEmployee -1];

            int minutesToTop = maxFloor - floorWithShortestTimeEmployee;
            int minutesToBottom = floorWithShortestTimeEmployee - minFloor;
            int allMinutes = maxFloor - 1;

            if (shortestTime < minutesToBottom && shortestTime < minutesToTop) {
                  // run through building from floor with employee with minimum time
                  if (minutesToBottom <= minutesToTop) {
                        // run through building from bottom
                        return allMinutes + minutesToBottom;
                  } {
                        // run through building from top
                        return allMinutes + minutesToTop;
                  }
            } else {
                  // run through all building from bottom
                  return allMinutes;
            }
      }
}
