package stream_api.functional_interfaces;

import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {
      public static void main(String[] args) {
            Predicate<String> startWithA = str -> str.startsWith("A");
            //BiPredicate<String, Integer> startWithNumber = (s, i) ->  s.startsWith(i.toString());
            BiPredicate<String, Integer> startWithNumber = PredicateExample::startWithNumberMeth;

            String name = "Anatoly";
            System.out.println(startWithA.test(name));
            String name2 = "1Anatoly";
            System.out.println(startWithNumber.test(name2,1));

            List<String> names = List.of("One", "Two", "Three", "Four");

            Predicate<String> startPredicate = str -> str.startsWith("O");
            Predicate<String> lengthPredicate = str -> str.length() <= 3;

            List<String> strings = names.stream()
                  .filter(startPredicate.and(lengthPredicate))
                  .toList();
            System.out.println(strings);

      }

      private static Boolean startWithNumberMeth(String s, Integer i) {
            return s.startsWith(i.toString());
      }

}
