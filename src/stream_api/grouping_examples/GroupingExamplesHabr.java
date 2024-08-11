package stream_api.grouping_examples;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://habr.com/ru/articles/348536/
 */
public class GroupingExamplesHabr {
      static class Worker {
            private String name;
            private int age;
            private int salary;
            private String position;

            public Worker(String name, int age, int salary, String position) {
                  this.name = name;
                  this.age = age;
                  this.salary = salary;
                  this.position = position;
            }

            public String getName() {
                  return name;
            }

            public int getAge() {
                  return age;
            }

            public int getSalary() {
                  return salary;
            }

            public String getPosition() {
                  return position;
            }

            @Override
            public String toString() {
                  return "Worker{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        ", salary=" + salary +
                        ", position='" + position + '\'' +
                        '}';
            }
      }

      static List<Worker> workerList = List.of(
            new Worker("name1", 1, 200, "engineer"),
            new Worker("name1", 19, 200, "engineer"),
            new Worker("name2", 19, 200, "engineer"),
            new Worker("name3", 20, 500, "engineer"),
            new Worker("name4", 20, 500, "cleaner"),
            new Worker("name5", 20, 200, "hr"),
            new Worker("name6", 30, 500, "teamlead"),
            new Worker("name7", 30, 500, "worker"),
            new Worker("name8", 30, 200, "worker"),
            new Worker("name9", 30, 200, "vicedirector"),
            new Worker("name10", 50, 200, "director")
      );

      public static void main(String[] args) {
            GroupingExamplesHabr grouping = new GroupingExamplesHabr();
/*            Map<String, List<Worker>> groupByPosition = grouping.groupByPosition(workerList);
            Map<String, Set<Worker>> groupByPositionBySet = grouping.groupByPositionBySet(workerList);
            Map<String, Long> countingByPositionLong = grouping.countingByPositionLong(workerList);
            Map<String, Integer> countingByPositionInteger = grouping.countingByPositionInteger(workerList);
            Map<String, Set<String>> groupNamesByPosition = grouping.groupNamesByPosition(workerList);
            Map<String, Double> calculatePositionsWithAverageSalary = grouping.calculatePositionsWithAverageSalary(workerList);
            Map<String, String> groupingPositionsBySingleString = grouping.groupingPositionsBySingleString(workerList);
            Map<String, Map<Integer, List<Worker>>> groupingByPositionAndAge = grouping.groupingByPositionAndAge(workerList);
            */
            //Map<String, Integer> groupByProfessionWithMaxSalary = grouping.groupByProfessionWithMaxSalary(workerList);
            //Map<String, Integer> stringIntegerMap = grouping.groupByProfessionWithMaxSalaryByGrouping(workerList);

            //Map<String, List<Worker>> stringListMap = grouping.groupByPositionTest(workerList);
            //Map<String, Set<Worker>> stringSetMap = grouping.groupByPositionBySetTest(workerList);
            //Map<String, Long> positionCountMap = grouping.countingByPositionLongTest(workerList);
            //Map<String, Integer> stringIntegerMap = grouping.countingByPositionIntegerTest(workerList);
            //Map<String, Set<String>> stringIntegerMap2 = grouping.groupNamesByPositionTest(workerList);
            Map<String, String> posBySingleStr = grouping.groupingPositionsBySingleStringTest(workerList);

      }

      /**
       * 1. Группировка списка рабочих по их должности position (деление на списки)
       */
      Map<String, List<Worker>> groupByPosition(List<Worker> workerList) {
            Map<String, List<Worker>> result = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition));
            System.out.println(result);
            return result;
      }

      Map<String, List<Worker>> groupByPositionTest(List<Worker> workerList) {

            return null;
      }

      /**
       * 2. Группировка списка рабочих по их должности (деление на множества)
       */
      Map<String, Set<Worker>> groupByPositionBySet(List<Worker> workerList) {
            Map<String, Set<Worker>> result = workerList.stream()
                  .collect(
                        Collectors.groupingBy(Worker::getPosition, Collectors.toSet())
                  );
            System.out.println(result);
            return result;
      }

      Map<String, Set<Worker>> groupByPositionBySetTest(List<Worker> workerList) {
            return null;
      }

      /**
       * 3. Подсчет количества рабочих, занимаемых конкретную должность Long
       */
      Map<String, Long> countingByPositionLong(List<Worker> workerList) {
            Map<String, Long> result = workerList.stream()
                  .collect(
                        Collectors.groupingBy(Worker::getPosition,
                              Collectors.counting())
                  );
            System.out.println(result);
            return result;
      }

      Map<String, Long> countingByPositionLongTest(List<Worker> workerList) {
            Map<String, Long> collect = workerList.stream()
                  .collect(
                        Collectors.groupingBy(Worker::getPosition, Collectors.counting())
                  );
            return null;
      }

      /**
       * 3.1. Подсчет количества рабочих, занимаемых конкретную должность Integer
       */
      Map<String, Integer> countingByPositionInteger(List<Worker> workerList) {
            Map<String, Integer> result = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                              Collectors
                                    .collectingAndThen(Collectors.counting(), Long::intValue)
                        )
                  );
            System.out.println(result);
            return result;
      }

      Map<String, Integer> countingByPositionIntegerTest(List<Worker> workerList) {
            Map<String, Integer> collect = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                              Collectors.collectingAndThen(
                                    Collectors.counting(), Long::intValue
                              )
                        )
                  );
            return null;
      }

      /**
       * 4. Группировка списка рабочих по их должности, при этом нас интересуют только имена
       */
      Map<String, Set<String>> groupNamesByPosition(List<Worker> workerList) {
            Map<String, Set<String>> collect = workerList.stream()
                  .collect(Collectors.groupingBy(
                        Worker::getPosition, Collectors.mapping(
                              Worker::getName, Collectors.toSet()
                        )
                  ));
            System.out.println(collect);
            return collect;
      }

      Map<String, Set<String>> groupNamesByPositionTest(List<Worker> workerList) {
            Map<String, Set<String>> collect = workerList.stream()
                  .collect(
                        Collectors.groupingBy(Worker::getPosition,
                              Collectors.mapping(Worker::getName, Collectors.toSet())

                        ));
            return collect;
      }

      /**
       * 5. Расчет средней зарплаты для данной должности
       */
      Map<String, Double> calculatePositionsWithAverageSalary(List<Worker> workerList) {
            Map<String, Double> collect = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.averagingInt(Worker::getSalary)));
            System.out.println(collect);
            return collect;
      }

      Map<String, Double> calculatePositionsWithAverageSalaryTest(List<Worker> workerList) {
            HashMap<String, Double> collect = workerList
                  .stream()
                  .collect(
                        Collectors.groupingBy(
                              Worker::getPosition,
                              HashMap::new,
                              Collectors.averagingDouble(Worker::getSalary)
                        )
                  );
            return collect;
      }

      /**
       * 6. Группировка списка рабочих по их должности, рабочие представлены только именами единой строкой
       */
      Map<String, String> groupingPositionsBySingleString(List<Worker> workerList) {
            Map<String, String> collect = workerList.stream()
                  .collect(Collectors.groupingBy(
                        Worker::getPosition, Collectors.mapping(
                              Worker::getName, Collectors.joining(", ", "{", "}")
                        )
                  ));
            return collect;
      }

      Map<String, String> groupingPositionsBySingleStringTest(List<Worker> workerList) {
            Map<String, String> collect = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.mapping(Worker::getName, Collectors.joining(", "))
                  ));
            return collect;
      }

      /**
       * 7. Группировка списка рабочих по их должности и по возрасту.
       */
      Map<String, Map<Integer, List<Worker>>> groupingByPositionAndAge(List<Worker> workerList) {
            Map<String, Map<Integer, List<Worker>>> collect = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.groupingBy(Worker::getAge))
                  );
            return collect;
      }

      Map<String, Map<Integer, List<Worker>>> groupingByPositionAndAgeTest(List<Worker> workerList) {
            return workerList.stream()
                  .collect(
                        Collectors.groupingBy(
                              Worker::getPosition, Collectors.groupingBy(Worker::getAge)
                        )
                  );
      }

      /**
       * 8. Сгруппировать рабочих по профессиям и вывести максимальную заработную плату
       */
      Map<String, Integer> groupByProfessionWithMaxSalary(List<Worker> workerList) {
            Map<String, Optional<Worker>> collectOptionals = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.maxBy(Comparator.comparingInt(Worker::getSalary))
                  ));


            HashMap<String, Integer> result = collectOptionals.entrySet().stream()
                  .map(entry -> {
                        return new AbstractMap.SimpleEntry(entry.getKey(), entry.getValue().get().salary);
                  })
                  .collect(Collectors
                        .toMap(Map.Entry<String, Integer>::getKey, Map.Entry<String, Integer>::getValue,
                              (oldValue, newValue) -> oldValue, HashMap<String, Integer>::new));

            System.out.println(result);
            return result;
      }

      Map<String, Integer> groupByProfessionWithMaxSalaryTest(List<Worker> workerList) {
            Map<String, Optional<Worker>> collectWorkerWithMaxSalary = workerList.stream()
                  .collect(Collectors.groupingBy(
                        Worker::getPosition,
                        Collectors
                              .maxBy(Comparator.comparingInt(Worker::getSalary))
                        )
                  );
            HashMap<String, Integer> result = collectWorkerWithMaxSalary.entrySet().stream()
                  .collect(Collectors.toMap(
                        key -> key.getKey(), value -> value.getValue().get().salary,
                        (oldVal, newVal) -> oldVal, HashMap::new
                  ));

            return result;

      }

      /**
       * 8.1 Сгруппировать рабочих по профессиям и вывести максимальную заработную плату с помощью GroupingBy
       */
      Map<String, Integer> groupByProfessionWithMaxSalaryByGrouping(List<Worker> workerList) {
            Map<String, Optional<Worker>> collectOptionals = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition,
                        Collectors.maxBy(Comparator.comparingInt(Worker::getSalary))
                  ));


            Map<String, Integer> result = collectOptionals.entrySet().stream()
                  .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue().get().salary
                  ));

            System.out.println(result);
            return result;
      }

      Map<String, Integer> groupByProfessionWithMaxSalaryByGroupingTest(List<Worker> workerList) {
            Map<String, Optional<Worker>> collectPositionMaxSalaryWorker = workerList.stream()
                  .collect(Collectors.groupingBy(Worker::getPosition, Collectors.maxBy(
                        Comparator.comparingInt(Worker::getSalary)
                  )));

            Map<String, Integer> result = collectPositionMaxSalaryWorker.entrySet().stream()
                  .collect(Collectors.toMap(entry -> entry.getKey(), entry ->
                        entry.getValue().get().salary
                  ));
            return result;
      }
}
