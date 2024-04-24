package stream_api;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TASKS {
      public static void main(String[] args) {
            //mergeTwoArr();
            //substractArray();
            //intersectionArray();
            //findMaxInArr();
            sortArrDecreasingOrder();
      }
      /*Объединить два массива*/
      public static void mergeTwoArr() {
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {5, 6, 7};
            IntStream stream1 = Arrays.stream(arr1);
            IntStream stream2 = Arrays.stream(arr2);
            int[] result = IntStream
                  .concat(stream1, stream2)
                  .toArray();
            System.out.println(Arrays.toString(result));
      }

      /*Вычесть с одного массива второй
       * Example 1:
       * Input: nums1 = [1,2,2,1], nums2 = [2,2]
       * Output: [1,1]
       * <p>
       * Example 2:
       * Input: nums1 = [9,4,9,8,4], nums2 = [4,9,5]
       * Output: [8]*/
      public static void substractArray() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            String expectedResult = "[1,1]";
            System.out.println(expectedResult);

            Set<Integer> set2 = Arrays.stream(nums2)
                  .boxed()
                  .collect(Collectors.toSet());
            int[] result = Arrays.stream(nums1)
                  .boxed()
                  .filter(num -> !set2.contains(num))
                  .mapToInt(Integer::intValue)
                  .toArray();
            System.out.println(Arrays.toString(result));
      }

      /*
       Получить пересечение двух массивов
       * Example 1:
       * Input: nums1 = [1,2,2,1], nums2 = [2,2]
       * Output: [2,2]
       * <p>
       * Example 2:
       * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
       * Output: [4,9]
       * Explanation: [9,4] is also accepted.*/
      public static void intersectionArray() {
            int[] nums1 = {1, 2, 2, 1};
            int[] nums2 = {2, 2};
            String expectedResult = "[2,2]";

            Set<Integer> set = Arrays.stream(nums2)
                  .boxed()
                  .collect(Collectors.toSet());
            int[] result = Arrays.stream(nums1)
                  .filter(set::contains)
                  .toArray();
            System.out.println(Arrays.toString(result));
      }

      /*Find max in arr*/
      public static void findMaxInArr() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            //.sorted(Comparator.comparingInt(Integer::intValue).reversed())
            int result = list.stream().max(Comparator.comparing(Integer::intValue, (val1, val2) -> val1 - val2))
                  .orElse(-99);
            System.out.println(result);

      }

      /*Sort array decreasing order*/
      public static void sortArrDecreasingOrder() {
            List<Integer> list = Arrays.asList(10,15,8,49,25,98,98,32,15);
            //.sorted(Comparator.comparingInt(Integer::intValue).reversed())
            int[] result = list.stream()
                  //.sorted(Comparator.comparingInt(Integer::intValue).reversed())
                  .sorted(Comparator
                        .reverseOrder()
                  )
                  .mapToInt(Integer::intValue)
                  .toArray();
            System.out.println(Arrays.toString(result));

      }
}
