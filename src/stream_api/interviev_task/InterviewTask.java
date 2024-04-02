package stream_api.interviev_task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InterviewTask {
      public static void main(String[] args) {

            _1_removeDuplicates();
            _2_removeEvenNums();
            _3_removeEvenIndexes();
            _4_animals();
      }

      /**
       * 1. Remove duplicates
       */
      public static void _1_removeDuplicates() {
            ArrayList<Integer> data = new ArrayList<>();
            Collections.addAll(data, 1, 2, 2, 3, 4);
            // remove all even nums from list
            ArrayList<Integer> finalData = data;
            data = data.stream()
                  .filter(s -> Collections.frequency(finalData, s) > 1)
                  .collect(Collectors.toCollection(ArrayList::new));
            System.out.println(data);
      }

      /**
       * 2. Remove even
       */
      public static void _2_removeEvenNums() {
            ArrayList<Integer> data = new ArrayList<>();
            Collections.addAll(data, 1, 2, 2, 3, 4);
            // remove all even nums from list
            data = data.stream()
                  .filter(s -> s % 2 > 0)
                  .collect(Collectors.toCollection(ArrayList::new));
            System.out.println(data);
      }

      /**
       * 3. Remove all with even index
       */
      public static void _3_removeEvenIndexes() {
            ArrayList<String> data = new ArrayList<>();
            Collections.addAll(data, "A", "B", "A", "C", "C");
            // remove all even nums from list
            data = IntStream
                  .range(0, data.size())
                  .filter(index -> index % 2 == 0)
                  .mapToObj(data::get)
                  .collect(Collectors.toCollection(ArrayList::new));

            System.out.println("Result : " + data);
            System.out.println("Expect : " + "[A, A, C]");
      }

      /**
       * 4. Тест на работу со строками.
       */
      public static void _4_animals() {
            List<String> animals = new ArrayList<>(List.of("Тигр", "Лев", "Горилла"));
            String result = concatAnimalNamesByConcat1(animals);
            String result2 = concatAnimalNamesByJoining(animals);
            System.out.println("Result 1 : " + result ) ;
            System.out.println("Result 1 : " + result2 ) ;
            System.out.println("Expect : " + "Тигр; Лев; Горилла." ) ;
      }
      /**
       * @param animals список названий животных
       * @return строка со списком названий животных, разделёнными точкой с запятой и пробелами, например - Тигр; Лев; Горилла.
       * Список в строчке должен заканчиваться точкой.
       */
      public static String concatAnimalNamesByConcat1(List<String> animals) {
            String collect = animals
                  .stream()
                  .collect(Collectors.joining(", "))
                  +".";
            return collect;
      }

      public static String concatAnimalNamesByJoining(List<String> animals) {
            String result = IntStream.range(0, animals.size())
                  .peek(index -> {
                        if (index == animals.size() - 1) {
                              animals.add(index, animals.get(index) + ".");
                        } else {
                              animals.add(index, animals.get(index) + ", ");
                        }
                  })
                  .mapToObj(index -> animals.get(index))
                  .collect(Collectors.joining());
            return result;
      }

}
