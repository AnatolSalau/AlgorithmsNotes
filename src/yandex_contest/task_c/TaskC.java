package yandex_contest.task_c;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * We have none increasing array
 * Delete all duplicates and get array without duplicates in non-decreasing order
 */
public class TaskC {

      public static void main(String[] args) {
            TaskC taskC = new TaskC();
            taskC.testDeleteDublicatesByLoop();
            taskC.testDeleteDublicatesBySet();
            taskC.testDeleteDublicatesByStream();
      }
      /*
      -9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11
      l    r
      l(-9) != r(-8) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
           l  r
      l(-8) != r(0) -> move l and r forward
              l  r
      l(0) == r(0) -> move r forward
              l     r
      l(0) != r(1) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
      -9, -8, 0, 1,
                 l    r
      l(1) == r(1) -> move r forward
                 l      r
      l(1) == r(1) -> move r forward
                 l         r
      l(1) != r(2) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
      -9, -8, 0, 1, 2
                    l         r
      l(2) != r(3) -> {
            1. move left forward
            2. copy right to left
            3. move right forward
      }
            -9, -8, 0, 1, 2, 3
            ....
            -9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,   ...     11
                                                   l             r
      after enf loop we have:
      last element 11 wasn't  moved
      we need move left forward and copy r to l
                  -9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11  ...     11
                                                            l           r
       */
      private int[] removeDuplicatesByLoop(int[] numbers) {

            int l = 0;
            int r = 1;
            while (r < numbers.length) {
                  if (numbers[l] != numbers[r]) { // left and right are equal
                        l++; // 1. move left forward
                        numbers[l] = numbers[r]; // 2. copy right to left
                        r++; // 3. move right forward
                  } else {// left and right are not equal
                        r++;// move right forward
                  }
            }

            l++; // move left pointer to next (free position)
            numbers[l] = numbers[numbers.length - 1];//copy r(last element in array) to l

            int[] result = new int[l]; // create result with size l
          //fill result
          System.arraycopy(numbers, 0, result, 0, l);

            return result;
      }
      private int[] removeDuplicatesBySet(int[] numbers) {
            Set<Integer> set = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
            int[] result = set.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
            return result;
      }
      private int[] removeDuplicatesByStream(int[] numbers) {
            int[] result = Arrays.stream(numbers)
                  .distinct()
                  .toArray();

            return result;
      }

      private void testDeleteDublicatesByLoop() {
            System.out.println("Test 1 (Delete dublicates by loop)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11,11,11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesByLoop(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }

      private void testDeleteDublicatesBySet() {
            System.out.println("Test 2 (Delete dublicates by set)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesBySet(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }

      private void testDeleteDublicatesByStream() {
            System.out.println("Test 3 (Delete dublicates by stream)");
            int[] numbers = {-9, -8, 0, 0, 1, 1, 1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 7, 8, 9, 10, 11};
            System.out.println("Array before : " + Arrays.toString(numbers));
            int[] byLoop = removeDuplicatesByStream(numbers);
            System.out.println("removeDuplicatesByLoop : " + Arrays.toString(byLoop));
            System.out.println("Expected result : [-9, -8, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
            System.out.println();
      }
}
