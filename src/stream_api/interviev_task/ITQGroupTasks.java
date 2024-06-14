package stream_api.interviev_task;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ITQGroupTasks {
      public static void main(String[] args) {
            List<String> animals = List.of("Tiger", "Lion", "Gorilla");
            String result1 = concatWithSemicolons1(animals);
            System.out.println("Result 1 : " + result1 ) ;
            String result2 = concatWithSemicolons2(animals);
            System.out.println("Result 2 : " + result2 ) ;
      }

      /*
       * @param animals list of animal names
       * @return a string with a list of animal names,
       * separated by semicolons and spaces, for example - Tiger; A lion; Gorilla.
       * The list on the line must end with a period.
       */
      private static String concatWithSemicolons1(List<String> list) {
            String joinBySemicolons = list.stream()
                  .collect(Collectors.joining("; "));
            return joinBySemicolons + ".";
      }

      private static String concatWithSemicolons2(List<String> list) {
            Stream<String> withoutLast =
                  list.stream()
                  .limit(list.size() - 1)
                        .map(s -> s + "; ");

            Stream<String> last = list.stream()
                  .skip(list.size() - 1)
                  .map(s -> s + ".");

            String result = Stream
                  .concat(withoutLast, last)
                  .reduce("", (String s1, String s2) -> s1.concat(s2));

            return result;
      }

      /*
      *
      */
}
