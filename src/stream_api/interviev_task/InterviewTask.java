package stream_api.interviev_task;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
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
            //findDuplicateElements();
            //addDelimiter();
            //findUniqueInArr();
            //findDeleted();
            //findAllRepeatingElements();
            //dividedIntoPresentAndAbsent();
            //countPresentAndAbsent();
            //countLettersInStrings();
            //charsToString();
            //getAllWordsWithDuplicates();
            _1_removeDuplicatesTest();
            concatAnimalNamesByConcatTest();
            deleteAllAnimalFromL();
            personMapTask();
      }

      /**
       * 1. Remove duplicates
       */
      public static void _1_removeDuplicates() {
            ArrayList<Integer> data = new ArrayList<>();
            Collections.addAll(data, 1, 2, 2, 3, 4);
            ArrayList<Integer> finalData = data;
            data = data.stream()
                  .filter(s -> Collections.frequency(finalData, s) > 1)
                  .collect(Collectors.toCollection(ArrayList::new));
            System.out.println(data);
      }

      public static void _1_removeDuplicatesTest(){
            ArrayList<Integer> data = new ArrayList<>();
            Collections.addAll(data, 1, 2, 2, 3, 4);
            ArrayList<Integer> finalData = data;
            List<Integer> list = finalData.stream()
                  .distinct()
                  .toList();
            System.out.println(list);
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

      public static void concatAnimalNamesByConcatTest() {
            List<String> animals = List.of("Тигр", "Лев", "Горилла");

            String collect = animals.stream()
                  .collect(Collectors.joining(","));
            collect = collect + ".";
            System.out.println(collect);
      }

      public static String concatAnimalNamesByJoining(List<String> animals) {
            Stream<String> withoutLast =
                  animals.stream()
                        .limit(animals.size() - 1)
                        .map(s -> s + "; ");

            Stream<String> last = animals.stream()
                  .skip(animals.size() - 1)
                  .map(s -> s + ".");

            String result = Stream
                  .concat(withoutLast, last)
                  .reduce("", (String s1, String s2) -> s1.concat(s2));
            return result;
      }

      /**
       * 5. Тест на работу с коллекциями.
       */
      public static void deleteAllAnimalFromL() {
            List<String> animals = new ArrayList<>(List.of("Тигр", "Лев", "Горилла", "Лось"));
            System.out.println("Animals before modifying");
            System.out.println(animals);
            //removeByRemoveAll(animals);
            animals = removeByStreamSubstractTest(animals);
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

      public static List<String> removeByStreamSubstractTest(List<String> animals) {
            List<String> result = animals.stream()
                  .filter(str -> !str.startsWith("Л"))
                  .toList();
            animals = result;
            return animals;
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
            System.out.println("String.equals : ");
            System.out.println(one.equals(two));
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
            Map<String, List<Person>> personMap = getPersonMapTest(personList, "English");
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

      public static Map<String, List<Person>> getPersonMapTest(List<Person> personList, String languageName) {
            Map<String, List<Person>> groupByLanguage = personList.stream()
                  .collect(Collectors.groupingBy(Person::language));
            return Map.of(languageName, groupByLanguage.get(languageName));
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
      public static void addDelimiter() {
            String[] strings = {"One", "Two", "Three", "Four"};
            String except = "One-Two-Three-Four";

            String join = String.join("-", strings);
            System.out.println("Result : " + join + ".");

            String collect = Arrays.stream(strings)
                  .collect(Collectors.joining("-"));
            System.out.println("Result : " + collect + ".");
            System.out.println("Except : " + except);

      }

      /**
       * 11
       * Задача: найти первый не повторяющийся элемент в наборе целых чисеl
       * //9, 4, 9, 9, 6, 7, 4, 5, 5 -> 6
       * //5, 9, 8, 5, 7, 9, 8, 7, 1 -> 1
       */
      public static void findUniqueInArr() {
            int[] nums1 = {9, 4, 9, 9, 6, 7, 4, 5, 5};
            int[] nums2 = {5, 9, 8, 5, 7, 9, 8, 7, 1};
            System.out.println(findFirstUnique(nums1));
            System.out.println(findFirstUnique(nums2));
      }

      public static int findFirstUnique(int[] nums) {
            HashMap<Integer, Long> collect = Arrays.stream(nums)
                  .boxed()
                  .collect(
                        Collectors.groupingBy(Function.identity(),
                              HashMap::new,
                              Collectors.counting())
                  );
            int firstUnique = collect.entrySet().stream()
                  .filter(entry -> entry.getValue() == 1L)
                  .findFirst()
                  .orElseThrow(() -> {
                        return new RuntimeException("Dont find entry");
                  })
                  .getKey();
            return firstUnique;
      }

      /** 12
       * Найти и вывести в консоль все не повторяющиеся элементы в массиве
       * input [9, 4, 9, 6, 7, 4, 5]
       * что должно быть напечатано в консоли [6, 7, 5]
       * Написать фильтр без лямбда
       */
      public static void findAllRepeatingElements() {
            int[] arr = {9, 4, 9, 6, 7, 4, 5};
            LinkedHashMap<Integer, Long> freqMap = Arrays.stream(arr)
                  .boxed()
                  .collect(Collectors.groupingBy(
                        Function.identity(), LinkedHashMap::new, Collectors.counting()
                  ));

            int[] result = freqMap.entrySet()
                  .stream()
                  //.filter(entry -> entry.getValue() == 1L)
                  .filter(InterviewTask::compareWith_1L)
                  .map(Map.Entry::getKey)
                  .mapToInt(Integer::intValue)
                  .toArray();

            System.out.println(Arrays.toString(result));
      }

      public static boolean compareWith_1L (Map.Entry<Integer, Long> entry) {
            return entry.getValue() == 1L;
      }

      /**
       * 13
       * Дан массив с числами, одно число удалили и перемешали массив.
       * Найти удаленное число.
       * int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
       * int[] second = {10, 7, 1, 5, 8, 9, 6, 2, 3}, deleted number = 4
       * */
      public static void findDeleted() {
            int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] second = {10, 7, 1, 5, 8, 9, 6, 2, 3};
            int deletedNumber = 4;

            Set<Integer> set2 = Arrays.stream(second)
                  .boxed()
                  .collect(Collectors.toSet());

            int result = Arrays.stream(first)
                  .filter(e -> !set2.contains(e))
                  .findFirst()
                  .orElse(-99);

            System.out.println(result);
            System.out.println("Expected : " + result);
      }

      /**
       * 14
       * Дан массив с числами, несколько число удалили и перемешали массив.
       * Получите мапу
       *  True -> List цифры которые есть в массиве
       *  False -> List цифры которых нету
       * int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
       * int[] second = {10, 1, 5, 8, 9, 6, 3}, deleted number = 2, 4, 7
       * */
      public static void dividedIntoPresentAndAbsent() {
            int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] second = {10, 1, 5, 8, 9, 6, 3};

            Set<Integer> collectSecond = Arrays.stream(second).boxed().collect(Collectors.toUnmodifiableSet());

            Map<Boolean, List<Integer>> partition =
                  Arrays.stream(first)
                        .boxed()
                        .collect(Collectors.partitioningBy(collectSecond::contains));
            System.out.println(partition);
      }

      /**
       * 15
       * Дан массив с числами, несколько число удалили и перемешали массив.
       * Получите мапу
       *  True -> Integer Количество присутствующих
       *  False -> Integer Количество отсутствующих
       * int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
       * int[] second = {10, 1, 5, 8, 9, 6, 3}, deleted number = 2, 4, 7
       * */

      public static void countPresentAndAbsent() {
            int[] first = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] second = {10, 1, 5, 8, 9, 6, 3};

            Set<Integer> collectSecond = Arrays.stream(second).boxed().collect(Collectors.toUnmodifiableSet());

            Map<Boolean, Integer> countPresentAbsent =
                  Arrays.stream(first)
                        .boxed()
                        .collect(Collectors.partitioningBy(
                              collectSecond::contains,
                              Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                              )
                        );
            System.out.println(countPresentAbsent);
      }

      /**
       * 16 Дан набор строк, посчитать количество разных букв во всех строках с использованием StreamAPI
       * реализовать два решения
       * 1 - вывести мапу с количеством символ - количество
       * 2 - вывести количество уникальных букв в символах
       */

      public static void countLettersInStrings() {
            /*    Result
                  a - 2
                  b - 2
                  c - 2
                  d - 1
                  e - 1
                  f - 2
             */
            List<String> strs = List.of("ABC", "abc", "DE", "F", "f");

            Map<Character, Long> charQtyMap = strs.stream()
                  .flatMapToInt(String::chars)
                  .mapToObj(num -> (char) num)
                  .map(Character::toLowerCase)
                  .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.counting())
                  );
            System.out.println(charQtyMap);

            /*подсчитать количество уникальных символов = 6 */

            long count = strs.stream()
                  .flatMapToInt(String::chars)
                  .mapToObj(num -> (char) num)
                  .map(Character::toUpperCase)
                  .distinct()
                  .count();
            System.out.println(count);
      }

      /*
            17. Преобразовать набор символов в строку
       */
      public static void charsToString() {
            Stream<Character> st = Stream.of('C','h','t');
            String collect = st
                  .map(ch -> ch.toString())
                  .collect(Collectors.joining());
      }

      /*
            18. Дано несколько списков слов. Получить список всех слов с этих списков
            c дубликатами
                  Hello World World wide Java Stream API Java one love
            без дубликатов
                  Hello World wide Java Stream API love
       */
      public static void getAllWordsWithDuplicates() {

            List<String> sentences1 = Arrays.asList("Hello World", "World wide");
            List<String> sentences2 = Arrays.asList("Java Stream API", "Java one love");

            List<String> stringsWithDuplicates = Stream.of(sentences1, sentences2)
                  .flatMap(Collection::stream)
                  .map(str -> str.split(" "))
                  .flatMap(Arrays::stream)
                  .toList();
            System.out.println(stringsWithDuplicates);

            List<String> stringsWithoutDuplicates = Stream.of(sentences1, sentences2)
                  .flatMap(Collection::stream)
                  .map(str -> str.split(" "))
                  .flatMap(Arrays::stream)
                  .distinct()
                  .toList();
            System.out.println(stringsWithoutDuplicates);

      }
}
