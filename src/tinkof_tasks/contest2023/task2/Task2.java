package tinkof_tasks.contest2023.task2;

/**
       * Ваня принес рулет и хочет порезать его на N равных частей.
       * Рулет можно разрезать только поперек.
       * Следовательно Костя сделает только N-1 разрезов
       *
       * Вася задумался - можно ли сделать меньше разрезов.
       * Если нож бесконечно - длинный.
       *
       * Оказывается можно: чтобы получить 4 куска - нужно сделать всего 2 разреза.
       * В начале на 2 половинки, а потом эти две половинки - одним разрезом на 4 куска.
       *
       * Вам дано число N. Каким минимальным числом можно обойтись?
       *
       * Ввод:
       * N - количество кусков
       *
       * Вывод:
       * одно число - минимальное число разрезов.
       *
       * Пример 1:
       * 6 частей требуется
       * 3 разреза надо
       *
       * Пример 2:
       * 5 частей требуется
       * 3 разреза надо
 */
public class Task2 {
      public static void main(String[] args) {
            Task2 task2 = new Task2();
            task2.testTask2By5Pieces();
            task2.testTask2By9Pieces();
            task2.testTask2By21Pieces();
      }

      private void testTask2By5Pieces() {
            int countOfSlices = 5;
            System.out.println("Pieces : " + countOfSlices);
            System.out.println("Count of slices : " + getCountOfSlices(countOfSlices));
            System.out.println("Expected result : 3 \n");
      }

      private void testTask2By9Pieces() {
            int countOfSlices = 9;
            System.out.println("Pieces : " + countOfSlices);
            System.out.println("Count of slices : " + getCountOfSlices(countOfSlices));
            System.out.println("Expected result : 4 \n");
      }

      private void testTask2By21Pieces() {
            int countOfSlices = 21;
            System.out.println("Pieces : " + countOfSlices);
            System.out.println("Count of slices : " + getCountOfSlices(countOfSlices));
            System.out.println("Expected result : 5 \n");
      }

      private int getCountOfSlices(int countOfPieces) {
            // exit from recursion if maxHalf is 1
            if (countOfPieces <= 1) {
                  return 0;
            }
            // remainder of mathematical division
            int remainder = countOfPieces % 2;
            int maxHalf = 0;

            if (remainder == 0) {
                  // even remainder
                  maxHalf = countOfPieces / 2;
            } else {
                  // odd remainder
                  maxHalf = countOfPieces / 2 + 1;
            }
            int previousCountOfPieces = getCountOfSlices(maxHalf);

            return previousCountOfPieces + 1;
      }
}
