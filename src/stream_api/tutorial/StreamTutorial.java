package stream_api.tutorial;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062
 */
public class StreamTutorial {
      public static void main(String[] args) {
            //findAllEven();
            //findAllStartFromZero();
            //findDuplicates();
            //findFirst();
            //findQtyInList();
            //findMaxBySort();
            //firstFirstNonRepeatingCharacter();
            //firstFirstRepeatingCharacter();
            //sortArrDecreasing();
            //isEveryDistinct();
            //concatStreams();
            //sortArrReturnStream();
            //toUppercase();
            //listObjToMap();
            //listToMapWithCount();
            //findDuplicateByFrequency();
            //checkNotEmptyByOptional();
            findCountOfChars();
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
                  .peek(System.out::println)
                  .filter(entry -> entry.getValue() == 1L)
                  .map(entry -> entry.getKey())
                  .findFirst()
                  .get();
            System.out.println(result);
      }

      /**
       8. Given a String, find the first repeated character in it using Stream functions?
       */
      private static void firstFirstRepeatingCharacter() {
            String input = "Java Articles are Awesome";

            Character result = input.chars() // Stream of String
                  .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase
                  .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                  .entrySet()
                  .stream()
                  .filter(entry -> entry.getValue() > 1L)
                  .map(entry -> entry.getKey())
                  .findFirst()
                  .get();
            System.out.println(result);
      }

      /**
       * 9. Given a list of integers, sort all the values present in it using Stream functions?
       */
      private static void sortArr() {
            int[] arr = {10,15,8,49,25,98,98,32,15};
            Arrays.stream(arr)
                  .sorted()
                  .forEach(System.out::println);
      }

      /**
       * 10. Given a list of integers, sort all the values present in it in descending order using Stream functions?
       */
      private static void sortArrDecreasing() {
            int[] arr = {10,15,8,49,25,98,98,32,15};
            IntStream stream = Arrays.stream(arr);
            int[] ints = stream
                  .boxed()
                  .sorted(Collections.reverseOrder())
                  .mapToInt(Integer::intValue)
                  .toArray();
            System.out.println(Arrays.toString(ints));
      }
      /**
       * 11. Given an integer array nums, return true if any value appears at least twice in the array,
       * and return false if every element is distinct.
       */
      private static void isEveryDistinct() {
            int[] arr = {10,15,8,49,25,98,98,32,15};
            IntStream stream = Arrays.stream(arr);
            LinkedHashMap<Integer, Long> freqMap = stream
                  .boxed()
                  .collect(
                        Collectors.groupingBy(
                              Function.identity(), LinkedHashMap::new, Collectors.counting()
                        )
                  );
            System.out.println(freqMap);
            boolean isDistinct = freqMap.entrySet().stream()
                  .noneMatch(entry -> entry.getValue() > 1);
            System.out.println(isDistinct);
      }

      /**
       * 12. How will you get the current date and time using Java 8 Date and Time API?
       */
      private static void getCurrentDateTime() {
            System.out.println("Current Local Date: " + java.time.LocalDate.now());
            //Used LocalDate API to get the date
            System.out.println("Current Local Time: " + java.time.LocalTime.now());
            //Used LocalTime API to get the time
            System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
            //Used LocalDateTime API to get both date and time
      }
      /**
       * 13. Write a Java 8 program to concatenate two Streams?
       */
      private static void concatStreams() {
            List<String> list1 = Arrays.asList("Java", "8");
            List<String> list2 = Arrays.asList("explained", "through", "programs");

            Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

            concatStream.forEach(str -> System.out.print(str + " "));

      }

      /**
       * 14. Java 8 program to perform cube on list elements and filter numbers greater than 50.
       */
      private static void cubeElements() {
            List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);
            List<Integer> integerList1 = integerList.stream()
                  .map(i -> i * i * i)
                  .filter(i -> i > 50)
                  .toList();
            System.out.println(integerList);
      }

      /**
       15. Write a Java 8 program to sort an array and then convert the sorted array into Stream?
       */
      private static void sortArrReturnStream() {
            int arr[] = { 99, 55, 203, 99, 4, 91 };
            IntStream parallelSorted = Arrays.stream(arr)
                  .parallel()
                  .sorted();

            System.out.println(parallelSorted.isParallel());

            IntStream sequentialSorted = parallelSorted.sequential();
            System.out.println(sequentialSorted.isParallel());
      }

      /**
       * 16. How to use map to convert object into Uppercase in Java 8?
       */
      private static void toUppercase() {
            List<String> names = List.of("one", "two", "three");
            List<String> nameLst = names.stream()
                  .map(String::toUpperCase)
                  .collect(Collectors.toList());
            System.out.println(nameLst);
      }

      /**
       * 17. How to convert a List of objects into a Map by considering duplicated keys and store them in sorted order?
       */
      private record Notes (Long tagId, String tagName, Integer number){};

      private static void listObjToMap() {
            List<Notes> noteLst = new ArrayList<>();
            noteLst.add(new Notes(1L, "note1", 11));
            noteLst.add(new Notes(2L, "note2", 22));
            noteLst.add(new Notes(3L, "note3", 33));
            noteLst.add(new Notes(4L, "note4", 44));
            noteLst.add(new Notes(5L, "note5", 55));
            noteLst.add(new Notes(6L, "note4", 66));

            Map<String, Long> notesRecords = noteLst.stream()
                  .sorted(Comparator
                        .comparingLong(Notes::tagId)
                        .reversed()) // sorting is based on TagId 55,44,33,22,11
                  .collect(Collectors.toMap
                        (Notes::tagName, Notes::tagId,
                              (oldValue, newValue) -> oldValue,LinkedHashMap::new));
            System.out.println("Notes : " + notesRecords);
      }

      /**
       * 18. How to count each element/word from the String ArrayList in Java8?
       */
      private static void listToMapWithCount() {
            List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
            Map<String,Long> namesCount = names
                  .stream()
                  .collect(
                        Collectors.groupingBy(
                              Function.identity()
                              , Collectors.counting()
                        ));
            System.out.println(namesCount);
      }
      /**
       * 19. How to find only duplicate elements with its count from the String ArrayList in Java8?
       */
      private static void findDuplicateByFrequency() {
            List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
            Map<String,Long> namesCount = names
                  .stream()
                  .filter(x->Collections.frequency(names, x) > 1)
                  .collect(Collectors.groupingBy
                        (Function.identity(), Collectors.counting()));
            System.out.println(namesCount);
      }

      /**
       * 20. How to check if list is empty in Java 8 using Optional, if not null iterate through the list and print the object?
       */
      private static void checkNotEmptyByOptional() {
            List<Notes> noteLst = new ArrayList<>();
            noteLst.add(new Notes(1L, "note1", 11));
            noteLst.add(new Notes(2L, "note2", 22));
            noteLst.add(new Notes(3L, "note3", 33));
            noteLst.add(new Notes(4L, "note4", 44));
            noteLst.add(new Notes(5L, "note5", 55));
            noteLst.add(new Notes(6L, "note4", 66));
            Optional.ofNullable(noteLst)
                  .orElseGet(Collections::emptyList) // creates empty immutable list: [] in case noteLst is null
                  .stream().filter(Objects::nonNull) //loop throgh each object and consider non null objects
                  .map(note -> note.tagName) // method reference, consider only tag name
                  .forEach(System.out::println); // it will print tag names
      }

      /**
       * 21. Write a Program to find the Maximum element in an array?
       */
      private static void findMaxElement() {
            int[] arr = {12,19,20,88,00,9};
            int asInt = Arrays.stream(arr).max().getAsInt();
            System.out.println(asInt);
      }
      /**
       * 22. Write a program to print the count of each character in a String?
       */
      private static void findCountOfChars() {
            String s = "Hello world";
            Map<String, Long> map = Arrays.stream(s.split(""))
                  .map(String::toLowerCase)
                  .collect(Collectors
                        .groupingBy(str -> str,
                              LinkedHashMap::new, Collectors.counting()));
            System.out.println(map);
      }
}
