package stream_api.interviev_task;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InterviewTask {
      public static void main(String[] args) {

            //_1_removeDuplicates();
            //_2_removeEvenNums();
            //_3_removeEvenIndexes();
            //_4_animals();
            //deleteAllAnimalFromL();
            //personMapTask();
            //mapWithCountFromStr();
            //randomizeListTest();
            findDuplicateElements();
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
            List<String> animals = List.of("Тигр", "Лев", "Горилла");
            String result = concatAnimalNamesByConcat1(animals);
            String result2 = concatAnimalNamesByJoining(animals);
            System.out.println("Result 1 : " + result ) ;
            System.out.println("Result 2 : " + result2 ) ;
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
            StringBuilder result = new StringBuilder();
            IntStream.range(0, animals.size())
                  .peek(index -> {
                        if (index == animals.size() - 1) {
                              result.append(animals.get(index)).append(".");
                        } else {
                              result.append(animals.get(index)).append(", ");
                        }
                  })
                  .mapToObj(index -> animals.get(index))
                  .collect(Collectors.joining());
            return result.toString();
      }

      /**
       * 5. Тест на работу с коллекциями.
       */
      public static void deleteAllAnimalFromL() {
            List<String> animals = new ArrayList<>(List.of("Тигр", "Лев", "Горилла", "Лось"));
            System.out.println("Animals before modifying");
            System.out.println(animals);
            //removeByRemoveAll(animals);
            animals = removeByStreamSubstract(animals);
            System.out.println("Animals after modifying");
            System.out.println(animals);
      }
      /**
       * Требуется модифицировать список - удалить всех животных, начинающиеся на русскую букву "Л"
       * @param animals список животных
       */
      public static void removeByRemoveAll(List<String> animals) {
            List<String> allWithL = animals
                  .stream()
                  .filter(animal -> animal.startsWith("Л"))
                  .toList();
            animals.removeAll(allWithL);
            System.out.println(allWithL);
      }
      public static List<String> removeByStreamSubstract(List<String> animals) {
            HashSet<String> allWithL = animals
                  .stream()
                  .filter(animal -> animal.startsWith("Л"))
                  .collect(Collectors.toCollection(HashSet::new));

            List<String> result = animals.stream()
                  .filter(animal -> !allWithL.contains(animal))
                  .toList();
            return result;
      }

      /**
       * 6.
       * Из листа, хранящих Person, создать мапу, где ключ - язык Person (у Person есть
       * поле language), а значение - коллекция Person с этим языком.
       * *Язык у каждого Person только один, это нативный язык.*
       */

      record Person(Long id, String name, String language) {}

      public static void personMapTask() {
            String one = new String("English");
            String two = new String("English");
            System.out.println("String.compare : ");
            System.out.println(one.compareTo(two));
            List<Person> personList = List.of(
                 new Person(1L, "One", "English"),
                  new Person(2L, "Two", "Russian"),
                  new Person(3L, "Three", "French"),
                  new Person(4L, "Four", "Russian"),
                  new Person(5L, "Five", "Russian"),
                  new Person(6L, "Six", "English"),
                  new Person(7L, "Seven", "French")
            );
            System.out.println(personList);
            Map<String, List<Person>> personMap = getPersonMap(personList, "English");
            System.out.println("All persons with english");
            System.out.println(personMap);
      }

      public static Map<String, List<Person>> getPersonMap(List<Person> personList, String languageName) {
            Map<String, List<Person>> personMap = personList.stream()
                  //.filter(person -> person.language().equals(languageName))
                  .filter(person -> person.language().compareTo(languageName) == 0)
                  .peek(System.out::println)
                  .collect(Collectors.groupingBy(Person::language, Collectors.toList()));

            return personMap;
      }

      /**
       * 7.
       * Напишите программу на Java для подсчета количества
       * конкретных слов в строке, используя HashMap.
       */
      public static void mapWithCountFromStr() {
            String str = "Count words in this string with some words";
            System.out.println(str);
            HashMap<String, Long> mapFreq = getMapFreq(str);
            System.out.println(mapFreq);

      }
      public static HashMap<String, Long> getMapFreq(String str) {
            String[] s = str.split(" ");
            System.out.println(Arrays.toString(s));
            HashMap<String, Long> freqMap = Arrays
                  .stream(s)
                  .collect(
                        Collectors.groupingBy(Function.identity(),
                              HashMap::new,
                              Collectors.counting()));
            return freqMap;
      }

      /**
       * 8. Необходимо outputSize раз взять случайным образом элементы из списка input и
       * поместить
       *  * их в выходной список. Повторения допустимы.
       *  *
       *  * @param input входной список
       *  * @param outputSize размер выходного списка
       *  * @return выходной список со случайными элементами из входного списка
       *  */

      public static void randomizeListTest() {
            List<String> input = List.of("One", "Two", "Three");
            List<String> strings = randomizeList(input, 10);
            System.out.println(strings);
      }
      public static  List<String> randomizeList(List<String> input, int outputSize) {
            Random random = new Random();

            List<String> strings = IntStream.range(0, outputSize)
                  .mapToObj(index -> {
                        return input.get(random.nextInt(input.size()));
                  })
                  .toList();

            return strings;
      };

      /**
       * 9.
       * Given two integer arrays nums1 and nums2, return an array of their intersection. Each
       * element in the result must be unique and you may return the result in any order.
       * Example 1:
       * Input: nums1 = [1,2,2,1], nums2 = [2,2]
       * Output: [2]
       * Example 2:
       * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
       * Output: [9,4]
       * Explanation: [4,9] is also accepted.
       */
      public static void findDuplicateElements() {
            int[] arr1 = {1,2,2,1};
            int[] arr2 = {2,2};
            int[] answer1 = findDuplicate(arr1, arr2);
            System.out.println("Answer 1 : " + Arrays.toString(answer1));
            System.out.println("Expected 1 : " + "[2]");
            System.out.println();

            int[] arr3 = {4,9,5};
            int[] arr4 = {9,4,9,8,4};
            int[] answer2 = findDuplicate(arr3, arr4);
            System.out.println("Answer 2 : " + Arrays.toString(answer2));
            System.out.println("Expected 2 : " + "[9,4]");
            System.out.println("");
      }

      public static int[] findDuplicate(int[] arr1, int[] arr2) {
            HashSet<Integer> set1 = Arrays.stream(arr1)
                  .boxed()
                  .collect(Collectors.toCollection(HashSet::new));

            int[] result = Arrays.stream(arr2)
                  .boxed()
                  .filter(set1::contains)
                  .distinct()
                  .mapToInt(Integer::intValue)
                  .toArray();
            return result;
      }
      /**
       * 10
       * Написать метод, который должен принимать n
       * количество объектов( строк), в методе вернуть строку с содержанием этих
       * объектов вставив между ними разделитель "-"
       */


}
