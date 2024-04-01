package stream_api.beginners;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BeginnersStreamApi {
      public static void main(String[] args) {
            //findAllEven();
            //findAllStartFromZero();
            //findDuplicates();
            //findFirst();
            //findQtyInList();
            //findMaxBySort();
            firstFirstNonRepeatingCharacter();
      }
      /**
       1. Given a list of integers, find out all the even numbers that exist in the list using Stream functions?
       */
      private static void findAllEven() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
            List<Integer> allEven = list.stream()
                  .filter(num -> num % 2 == 0)
                  .toList();
            System.out.println(allEven);
      }
      /**
       * 2. Given a list of integers, find out all the numbers starting with 1 using Stream functions?
       */
      private static void findAllStartFromZero() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);
            List<Integer> allFromZero = list.stream()
                  .map(String::valueOf)
                  .filter(num -> num.startsWith("1"))
                  .map(Integer::parseInt)
                  .toList();
            System.out.println(allFromZero);
      }
      /**
       * 3. How to find duplicate elements in a given integers list in java using Stream functions?
       */
      private static void findDuplicates() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            Set<Integer> set = new HashSet<>();
            List<Integer> allNotUniques = list.stream()
                  .filter(integer -> set.add(integer) == false)
                  .toList();
            System.out.println(allNotUniques);
      }
      /**
       * 4. Given the list of integers, find the first element of the list using Stream functions?
       */
      private static void findFirst() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            list.stream()
                  .findFirst()
                  .ifPresent(System.out::println);
      }

      /**
       * 5. Given a list of integers, find the total number of elements present in the list using Stream functions?
       */
      private static void findQtyInList() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            long count = list.stream()
                  .count();
            System.out.println(count);
      }

      /**
       * 6. Given a list of integers, find the maximum value element present in it using Stream functions?
       */
      private static void findMaxBySort() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            list.stream()
                  .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                        .findFirst()
                              .ifPresent(System.out::println);

            list.stream()
                  .max(Comparator.comparingInt(Integer::intValue))
                  .ifPresent(System.out::println);
      }

      /**
       * 7. Given a String, find the first non-repeated character in it using Stream functions?
       */
      private static void firstFirstNonRepeatingCharacter() {
            String input = "Java articles are Awesome";

            Character result = input.chars() // Stream of String
                  .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() == 1L)
                  .map(entry -> entry.getKey())
                  .findFirst()
                  .get();
            System.out.println(result);
      }

}
