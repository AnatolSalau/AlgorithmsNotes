package functional_interfaces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionExample {
      public static void main(String[] args) {
            /* Example 1: Map in stream*/
            List<String> names = Arrays.asList("Smith", "Gourav", "John", "Catania");
            Function<String, Integer> nameMappingFunction = String::length;
            List<Integer> nameLength = names.stream()
                  //.map(nameMappingFunction)
                  .map(FunctionExample::strLength)
                  .collect(Collectors.toList());
            System.out.println(nameLength);

            /* Compute if absent in Map */
            Map<String, Integer> nameMap = new HashMap<>();
            Integer value = nameMap.computeIfAbsent("John", s -> strLength(s));
            System.out.println(nameMap);

            /*Compose functions*/

            Function<Integer, String> intToString = Object::toString;
            Function<String, String> quote = s -> "'" + s + "'";

            Function<Integer, String> quoteIntToString = quote.compose(intToString);
            String result = quoteIntToString.apply(5);
            System.out.println(result);

            BiFunction<Integer, Integer, String> concatIntegersInQuotedStr = (i1, i2) -> "'" + i1 + "" + i2 + "'";
            String result2 = concatIntegersInQuotedStr.apply(1, 0);
            System.out.println(result2);

            Map<String, Integer> salaries = new HashMap<>();
            salaries.put("John", 40000);
            salaries.put("Freddy", 30000);
            salaries.put("Samuel", 50000);

            salaries.replaceAll((name, oldValue) ->
                  name.equals("Freddy") ? oldValue : oldValue + 10000);
            System.out.println(salaries);
      }

      private static Integer strLength(String str) {
            return str.length();
      }

}
