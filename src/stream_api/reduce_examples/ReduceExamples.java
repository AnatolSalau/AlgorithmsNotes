package stream_api.reduce_examples;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReduceExamples {
      public static void main(String[] args) {

            //sumElementsTest(List.of(1,2,3));
            //joinStringsTest(generateStringList(100_000));
            //toUpperCase(List.of("one", "two", "three"));
            //sumParallel(List.of(1,2,3));
            //sumUserAges(List.of(new User("John", 30), new User("Julie", 35)));
            joinStringsStringBuilderByComma(generateStringList(1_000_000));

      }
      /*
       * Sum elements by reducing them
       */
      public static void sumElements(List<Integer> numbers) {
            System.out.println("Numbers : " + numbers);
            int result = numbers.stream()
                  //.reduce(0, Integer::sum);
                  .reduce(0, (subtotal, element) -> subtotal + element);
            System.out.println(result);
            System.out.println();
      }
      public static void sumElementsTest(List<Integer> numbers) {
            Integer reduce = numbers.stream()
                    .reduce(0, (prev, curr) -> prev + curr);
            //.reduce(0, Integer::sum);
            System.out.println(reduce);
      }
      /*
       * Join strings by reducing them
       */
      public static void joinStrings(List<String> stringList) {
            System.out.println("Strings : " + stringList);
            String result = stringList.stream()
                  //.reduce("", String::concat)
                  .reduce("", (subtotal, element) -> subtotal + element);
            System.out.println(result);
            System.out.println();
      }
      public static void joinStringsTest(List<String> stringList) {
            long start = System.currentTimeMillis();
            String reduce = stringList.stream()
                    .reduce("", (prev, curr) -> prev.concat(curr));
            //.reduce("", String::concat);
            long end = System.currentTimeMillis();
            System.out.println("joinStringsTest");
            System.out.println("time : " + (end - start));
      }

      /*
            Join string using reduce and StringBuilder
       */
      public static void joinStringsStringBuilder(List<String> stringList) {
            long start = System.currentTimeMillis();
            String reduce = stringList.stream()
                    //(acc, str) -> acc.append(str.charAt(0)),
                    //                (sb1, sb2) -> sb1.append(sb2));
                    .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                    .toString();
            long end = System.currentTimeMillis();
            System.out.println("joinStringsStringBuilder");
            System.out.println("time : " + (end - start));
            System.out.println(reduce);
      }

      /*
            Join string using reduce and StringBuilder and separate words by comma
      */
      public static void joinStringsStringBuilderByComma(List<String> stringList) {
            long start = System.currentTimeMillis();
            String reduce = stringList.stream()
                    //(acc, str) -> acc.append(str.charAt(0)),
                    //                (sb1, sb2) -> sb1.append(sb2));
                    .reduce(new StringBuilder(), (prev, curr) -> prev.append(curr).append(", "), StringBuilder::append)
                    .toString();
            long end = System.currentTimeMillis();
            System.out.println("joinStringsStringBuilder");
            System.out.println("time : " + (end - start));
            System.out.println(reduce);
      }


      public static void toUpperCase(List<String> stringList) {
            System.out.println("Strings : " + stringList);
            String result = stringList.stream()
                  .reduce("", (subtotal, element) -> subtotal.toUpperCase() + element.toUpperCase());
            System.out.println(result);
            System.out.println();
      }


      public static void sumParallel(List<Integer> numbers) {
            System.out.println("Numbers : " + numbers);
            int result = numbers
                  .parallelStream()
                  .reduce(0, (a, b) -> a + b, Integer::sum);
            System.out.println(result);
            System.out.println();
      }

      public static record User(String name, Integer age){};

      public static void sumUserAges(List<User> users) {
            Integer result = users.stream()
                  .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.age(),
                        Integer::sum);
            System.out.println("Numbers : " + users);
            System.out.println(result);
            System.out.println();
      }

      public static List<String> generateStringList(int amount) {
            ArrayList<String> collect = IntStream.range(0, amount)
                    .mapToObj(index -> "Str" + index)
                    .collect(Collectors.toCollection(ArrayList::new));
            return collect;
      }

}
