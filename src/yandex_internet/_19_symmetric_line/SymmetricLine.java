package yandex_internet._19_symmetric_line;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SymmetricLine {
      /**
             Дан массив точек с целочисленными координатами (x, y). Определить,
             существует ли
             вертикальная прямая, делящая все точки, не лежащие на ней, на 2
             симметричных
             относительно этой прямой множества.
       */
      /**
       Вариант: N * log N
             Будем для простоты рассматривать симметрию относительно вертикальной оси.
             1. Сортируем список точек по x , в порядке возрастания x. O(N*log N)
                  Если нужна ось симметрии по Y - сортируем по Y
             2. Возьмем первую и последнюю точки в отсортированном массиве, т.е. самую левую и самую правую точку.
                  По ним вычислим ось симметрии.
             3. Просмотрим все точки в массиве. Для каждой точки пытаемся найти симметричную ей точку (ось симметрии известна).
                  Поиск в отсортированном массиве log N. На проверку всех точек надо O(N * log N)

             Итого: O(N * log N)
       */
      /**
             Ищешь минимум и максимум, отсюда получаешь центр симметрии.
             Далее заталкиваешь в хешмеп все точки, лежащие по одну сторону от плоскости симметрии.
             Далее пробегаешься по точкам по вторую сторону плоскости и проверяешь,
             что их зеркальное отображение есть в хешмепе.
       Итого: O(N * log N)
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      static void testOne() {
            int[][] coordinates = {
                  {1,3},{3,3},{1,2},{3,2},{1,1},{3,1}, {3,4}
            };
            boolean isSymmetric = haveVerticalSymmetric(coordinates);
            System.out.println(isSymmetric);
            System.out.println("Expected result = false");
      }
      static void testTwo() {
            int[][] coordinates = {
                  {1,3},{3,3},{1,2},{3,2},{1,1},{3,1}
            };
            boolean isSymmetric = haveVerticalSymmetric(coordinates);
            System.out.println(isSymmetric);
            System.out.println("Expected result = true");
      }
      /*
            [[1, 1], [1, 3], [1, 2], [3, 1], [3, 2], [3, 3]]
            middle = 2


       */
      static boolean haveVerticalSymmetric(int[][] coordinates) {
            quickSortMultiple(coordinates,0, coordinates.length - 1);//sort arr by x
            int leftX = coordinates[0][0];//min x
            int rightX = coordinates[coordinates.length - 1][0];//max x

            int middleX = (leftX + rightX) / 2; // middle value

            //[1, 1], [1, 3], [1, 2]
            Set<List<Integer>> leftHalfCoordinates = new HashSet<>();//set with left half of points

            for (int i = 0; i < coordinates.length; i++) { // go through arr
                  int currX = coordinates[i][0];
                  int currY = coordinates[i][1];
                  List<Integer> xy = new ArrayList<>(2); //current point

                  if (currX < middleX) { // if we on the left of middle line
                        xy.add(currX);
                        xy.add(currY);
                        leftHalfCoordinates.add(xy);//just fill set with coordinates
                  } else {
                        //(rightX - middleX) * 2 -> distance to left symmetric point
                        int mirrorX = rightX - ((rightX - middleX) * 2); // calculate coordinates for mirror x
                        xy.add(mirrorX);
                        xy.add(currY);
                       if (!leftHalfCoordinates.contains(xy)) return false; // if set don't have the same point
                  }
            }

            return true;
      }

      private static void quickSortMultiple(int[][] array, int startIndex, int endIndex) {
            if(endIndex<= startIndex) return; //base case

            int pivotIndex = partitionMultiple(array,startIndex, endIndex);

            quickSortMultiple(array,startIndex,pivotIndex - 1);
            quickSortMultiple(array,pivotIndex +1,endIndex);
      }

      private static int partitionMultiple(int[][] array, int startIndex, int endIndex) {
            int pivot = array[endIndex][0];
            int i = startIndex - 1;

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if(array[j][0] < pivot) {
                        i++;
                        int temp0 = array[i][0];
                        int temp1 = array[i][1];
                        array[i][0] = array[j][0];
                        array[i][1] = array[j][1];
                        array[j][0] = temp0;
                        array[j][1] = temp1;
                  }
            }
            i++;
            int temp0 = array[i][0];
            int temp1 = array[i][1];
            array[i][0] = array[endIndex][0];
            array[i][1] = array[endIndex][1];
            array[endIndex][0] = temp0;
            array[endIndex][1] = temp1;
            return i;
      }
}
