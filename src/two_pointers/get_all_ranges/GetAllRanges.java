package two_pointers.get_all_ranges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetAllRanges {
      /**
       * Дан список целых чисел, повторяющихся элементов в списке нет.
       * Нужно преобразовать это множество в строку, сворачивая соседние по
       * значению числа в диапазоны.
       * Примеры:
       * [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
       * [1,4,3,2] => "1-4"
       * [1,4] => "1,4"
       * [1,2] => "1-2"
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      static void test1() {
            int[] nums = {1, 4, 5, 2, 3, 9, 8, 11, 0};
            String expectedResult = "0-5,8-9,11";
            System.out.println("Test 1");
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums, 0, nums.length - 1);
            System.out.println("Array after sort : " + Arrays.toString(nums));
            System.out.println(getRangesFromSortedArr(nums));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

      static void test2() {
            int[] nums = {1, 4, 3, 2};
            String expectedResult = "1-4";
            System.out.println("Test 1");
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums, 0, nums.length - 1);
            System.out.println("Array after sort : " + Arrays.toString(nums));
            System.out.println(getRangesFromSortedArr(nums));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

      static void test3() {
            int[] nums = {1, 4};
            String expectedResult = "1, 4";
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums, 0, nums.length - 1);
            System.out.println("Array after sort : " + Arrays.toString(nums));
            System.out.println(getRangesFromSortedArr(nums));
            System.out.println("Expected result : " + expectedResult);
      }

      /*    0  1  2  3  4  5  6  7  8
            0, 1, 2, 3, 4, 5, 8, 9, 11
            0  1 -> "0"
               1  2 -> "0"
                  2  3 -> "0"
                     3  4 -> "0"
                        4  5 -> "0"
                           5  8 -> "0-5, 8"
                              8  9 -> "0-5, 8"
                                 9  11 -> "0-5, 8-9, 11"
       */
      /*
            Explanation
            1. Sort arr
            2. Create two pointers
                  - left pointer - initialize with 0
                  - - left pointer - initialize with 0
            3. Create list with result
            4. Go through arr
                  - every iteration compare left and right element
                  - if right element no equal left element plus 1
                        -> add to result list left element (end previous range) and right element (start next range)
                  - every iteration move left pointer and right pointer to one element forward

       */
      static String getRangesFromSortedArr(int[] arr) {
            List<Integer> indexes = new ArrayList<>(); // Create list with result
            int l = 0;//- left pointer - initialize with 0
            int r = 1;//- left pointer - initialize with 0

            while (l < arr.length && r < arr.length) {
                  int left = arr[l];
                  int right = arr[r];
                  if (right != (left + 1)) {//if right element no equal left element plus 1
                        indexes.add(l);
                        indexes.add(r);
                  }
                  l++;
                  r++;
            }
            StringBuilder result = new StringBuilder();
            //fill result
            // indexes -are empty -> we have one range in arr
            if (indexes.size() == 0) {
                  result.append(arr[0]);
                  result.append("-");
                  result.append(arr[arr.length - 1]);
                  return result.toString();
            } else { // we have some ranges in our arr
                  result.append(arr[0]);
                  for (int j = 1; j < indexes.size(); j += 2) {
                        int i = j - 1;
                        result.append("-");
                        result.append(arr[indexes.get(i)]);
                        result.append(", ");
                        result.append(arr[indexes.get(j)]);

                  }
                  //check last element in arr with odd length
                  if (indexes.size() % 2 != 0) {
                        //we in the end of odd arr
                        result.append(arr[arr.length - 1]);
                  }

                  return result.toString();
            }
      }

      static void quickSort(int[] arr, int startIndex, int endIndex) {
            if (endIndex <= startIndex) return;

            int pivotIndex = partition(arr, startIndex, endIndex);

            quickSort(arr, startIndex, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, endIndex);

      }

      static int partition(int[] arr, int startIndex, int endIndex) {
            int pivot = arr[endIndex];

            int i = startIndex - 1;

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if (arr[j] < pivot) {
                        i++;
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                  }
            }
            i++;

            int temp = arr[i];
            arr[i] = arr[endIndex];
            arr[endIndex] = temp;

            return i;
      }

}
