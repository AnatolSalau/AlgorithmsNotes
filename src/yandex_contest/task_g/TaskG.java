package yandex_contest.task_g;

import java.util.*;

public class TaskG {
      /**
       * Не секрет, что некоторые программисты очень любят путешествовать.
       * Хорошо всем известный программист Петя тоже очень любит путешествовать,
       * посещать музеи и осматривать достопримечательности других городов.
       * Для перемещений между из города в город он предпочитает использовать машину.
       * При этом он заправляется только на станциях в городах, но не на станциях по пути.
       * Поэтому он очень аккуратно выбирает маршруты, чтобы машина не заглохла в дороге.
       * А ещё Петя очень важный член команды, поэтому он не может себе позволить путешествовать слишком долго.
       * Он решил написать программу, которая поможет ему с выбором очередного путешествия.
       * Но так как сейчас у него слишком много других задач, он попросил вас помочь ему.
       * Расстояние между двумя городами считается как сумма модулей разности по каждой из координат.
       * Дороги есть между всеми парами городов.
       *
       * Формат ввода
       * В первой строке входных данных записано количество городов n
       *  (2≤n≤1000). В следующих n строках даны два целых числа: координаты каждого города,
       * не превосходящие по модулю миллиарда. Все города пронумерованы числами от 1 до n
       * в порядке записи во входных данных.
       * В следующей строке записано целое положительное число k, не превосходящее двух миллиардов,
       * — максимальное расстояние между городами, которое Петя может преодолеть без дозаправки машины.
       * В последней строке записаны два различных числа — номер города, откуда едет Петя, и номер города, куда он едет.
       *
       * Формат вывода
       * Если существуют пути, удовлетворяющие описанным выше условиям, то выведите минимальное количество дорог,
       * которое нужно проехать, чтобы попасть из начальной точки маршрута в конечную. Если пути не существует, выведите -1.
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      static int[][] generateMatrixOfDistanceBetweenCities(Map<Integer, List<Integer>> citiesCoordinates) {
            int[][] result = new int[citiesCoordinates.size() + 1][citiesCoordinates.size() + 1];
            for (int i = 1; i < result.length ; i++) {
                  for (int j = 1; j < result.length; j++) {
                        Integer x1 = citiesCoordinates.get(i).get(0);
                        Integer y1 = citiesCoordinates.get(i).get(1);
                        Integer x2 = citiesCoordinates.get(j).get(0);
                        Integer y2 = citiesCoordinates.get(j).get(1);
                        result[i][j] = calculateDistance(x1,y1,x2,y2);
                  }
            }
            printMatrix(result);
            return result;
      }

      static int searchInWidthPathBetweenCities(int[][] matrixGraph, int startCity, int endCity, int maxDistance) {
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            //System.out.println("Search Start from city = " + startCity);
            queue.offer(startCity);

            while (!queue.isEmpty()) {
                  Integer currentCity = queue.poll();

                  System.out.println("search in city = " + currentCity);

                  if(currentCity == endCity) {
                        System.out.println("City  number " + currentCity + " was founded");
                        System.out.println("Visited cities :  " +visited);
                        System.out.println("");
                        return visited.size();
                  }
                  visited.add(currentCity);
                  int[] distancesFromCurrentCityToAnother = matrixGraph[currentCity];
                  System.out.println("distances to another cities : " + Arrays.toString(distancesFromCurrentCityToAnother));
                  for (int i = 1; i < distancesFromCurrentCityToAnother.length; i++) {
                        int currentDistance = distancesFromCurrentCityToAnother[i];
                        System.out.println(currentDistance);
                        if (!visited.contains(i)) {
                              if (currentDistance > 0 && currentDistance <= maxDistance) {
                                    queue.add(i);
                                    visited.add(i);
                              }
                        }
                  }
            }
            System.out.println("Citi didn't found : ");
            System.out.println(visited);
            return visited.size();
      }

      static void printMatrix(int[][] matrix) {
            System.out.println("Numbers :  1  2  3  4  5  6  7");
            for (int i = 1; i < matrix.length; i++) {

                  int[] ints = Arrays.copyOfRange(matrix[i], 1, matrix.length);
                  System.out.println("City N" + i +" : " +  Arrays.toString(ints));
            }
      }

      static void printDistance(Map<Integer,List<Integer>> citiesCoordinates, int numberCiti1, int numberCiti2) {
            Integer x1 = citiesCoordinates.get(numberCiti1).get(0);
            Integer y1 = citiesCoordinates.get(numberCiti1).get(1);
            Integer x2 = citiesCoordinates.get(numberCiti2).get(0);
            Integer y2 = citiesCoordinates.get(numberCiti2).get(1);
            int distance = calculateDistance(x1,y1,x2,y2);
            System.out.println("Distance between cities : " + numberCiti1 + " and " + numberCiti2);
            System.out.println("x"+ numberCiti1 +" = " + x1 + ", y"+ numberCiti1 +"= " + y1);
            System.out.println("x"+ numberCiti2 +" = " + x2 + ", y"+ numberCiti2 +" = " + y2);
            System.out.println("Distance = " + distance);
      }
      static int calculateDistance(int x1, int y1, int x2, int y2) {
            int distance = Math.abs(x1 - x2) + Math.abs(y1 - y2);
            return distance;
      }

      static void test1() {
            Map<Integer,List<Integer>> citiesCoordinates = new HashMap<>();
            citiesCoordinates.put(1, Arrays.asList(0, 0));
            citiesCoordinates.put(2, Arrays.asList(0, 2));
            citiesCoordinates.put(3, Arrays.asList(2, 2));
            citiesCoordinates.put(4, Arrays.asList(0, -2));
            citiesCoordinates.put(5, Arrays.asList(2, -2));
            citiesCoordinates.put(6, Arrays.asList(2, -1));
            citiesCoordinates.put(7, Arrays.asList(2, 1));
            int maxDistance = 2;
            int startCity = 1;
            int endCity = 3;
            System.out.println();
            System.out.println("Test 1:");
            System.out.println("from :" + startCity + " to " + endCity);
            System.out.println("Max distance = " + maxDistance);
            int[][] matrixGraph = generateMatrixOfDistanceBetweenCities(citiesCoordinates);
            searchInWidthPathBetweenCities(matrixGraph, startCity, endCity, maxDistance);
      }

      static void test2() {
            Map<Integer,List<Integer>> citiesCoordinates = new HashMap<>();
            citiesCoordinates.put(1, Arrays.asList(0, 0));
            citiesCoordinates.put(2, Arrays.asList(1, 0));
            citiesCoordinates.put(3, Arrays.asList(0, 3));
            citiesCoordinates.put(4, Arrays.asList(1, 1));
            int maxDistance = 2;
            int startCity = 1;
            int endCity = 3;
            System.out.println();
            System.out.println("Test 2:");
            System.out.println("from :" + startCity + " to " + endCity);
            System.out.println("Max distance = " + maxDistance);
            int[][] matrixGraph = generateMatrixOfDistanceBetweenCities(citiesCoordinates);
            searchInWidthPathBetweenCities(matrixGraph, startCity, endCity, maxDistance);

      }

      static void test3() {
            Map<Integer,List<Integer>> citiesCoordinates = new HashMap<>();
            citiesCoordinates.put(1, Arrays.asList(0, 0));
            citiesCoordinates.put(2, Arrays.asList(2, 0));
            citiesCoordinates.put(3, Arrays.asList(0, 2));
            citiesCoordinates.put(4, Arrays.asList(2, 2));
            int maxDistance = 1;
            int startCity = 1;
            int endCity = 4;
            System.out.println();
            System.out.println("Test 3:");
            System.out.println("from :" + startCity + " to " + endCity);
            System.out.println("Max distance = " + maxDistance);
            int[][] matrixGraph = generateMatrixOfDistanceBetweenCities(citiesCoordinates);
            searchInWidthPathBetweenCities(matrixGraph, startCity, endCity, maxDistance);

      }
}
