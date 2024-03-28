package yandex_internet._19_symmetric_line;

import java.util.*;

public class SymmetricLineTwo {
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
            Point[] coordinates = {
                  new Point(1,3),new Point(3,3),new Point(1,2),new Point(3,2),new Point(1,1),new Point(3,1), new Point(3,4)
            };
            boolean isSymmetric = haveVerticalSymmetric(coordinates);
            System.out.println(isSymmetric);
            System.out.println("Expected result = false");
      }
      static void testTwo() {
            Point[] coordinates = {
                  new Point(1,3),new Point(3,3),new Point(1,2),new Point(3,2),new Point(1,1),new Point(3,1)
            };
            boolean isSymmetric = haveVerticalSymmetric(coordinates);
            System.out.println(isSymmetric);
            System.out.println("Expected result = true");
      }
      /*
            [[1, 1], [1, 3], [1, 2], [3, 1], [3, 2], [3, 3]]
            middle = 2


       */
      static boolean haveVerticalSymmetric(Point[] points) {
            int sumX = 0; // sum all x
            Set<Point> pointSet = new HashSet<>();

            for (Point point : points) { //go through all points
                  sumX += point.x;
                  pointSet.add(point);
            }

            //double avgX = 1.0 * sumX / points.length;
            int avgX = sumX / points.length;

            for (Point point : points) {//go through all points
                  int newX = (int) (2 * avgX - point.x);
                  if (!pointSet.contains(new Point(newX, point.y))) {
                        return false;
                  }
            }
            return true;
      }
}
class Point {

      int x;
      int y;

      Point(int x, int y) {
            this.x = x;
            this.y = y;
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;

      }

      @Override
      public int hashCode() {
            return Objects.hash(x, y);

      }
}
