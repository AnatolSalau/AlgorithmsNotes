package stream_api.reduce_examples;

import java.util.List;

public class ReduceExamples {
      public static void main(String[] args) {

            sumElements(List.of(1,2,3));
            joinStrings(List.of("one", "two", "three"));
            toUpperCase(List.of("one", "two", "three"));
            sumParallel(List.of(1,2,3));
            sumUserAges(List.of(new User("John", 30), new User("Julie", 35)));
      }

      public static void sumElements(List<Integer> numbers) {
            System.out.println("Numbers : " + numbers);
            int result = numbers.stream()
                  //.reduce(0, Integer::sum);
                  .reduce(0, (subtotal, element) -> subtotal + element);
            System.out.println(result);
            System.out.println();
      }

      public static void joinStrings(List<String> stringList) {
            System.out.println("Strings : " + stringList);
            String result = stringList.stream()
                  //.reduce("", String::concat)
                  .reduce("", (subtotal, element) -> subtotal + element);
            System.out.println(result);
            System.out.println();
      }

      public static void toUpperCase(List<String> stringList) {
            System.out.println("Strings : " + stringList);
            String result = stringList.stream()
                  //.reduce("", String::concat)
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

      static record User(String name, Integer age){};

      public static void sumUserAges(List<User> users) {
            Integer result = users.stream()
                  .reduce(0, (partialAgeResult, user) -> partialAgeResult + user.age(),
                        Integer::sum);
            System.out.println("Numbers : " + users);
            System.out.println(result);
            System.out.println();
      }
}
