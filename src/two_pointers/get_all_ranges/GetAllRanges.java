package two_pointers.get_all_ranges;

import java.util.Arrays;

public class GetAllRanges {
      /**
       Дан список целых чисел, повторяющихся элементов в списке нет.
       Нужно преобразовать это множество в строку, сворачивая соседние по
       значению числа в диапазоны.
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
            int[] nums = {1,4,5,2,3,9,8,11,0};
            String expectedResult = "0-5,8-9,11";
            System.out.println("Test 1");
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums,0,nums.length - 1);
            System.out.println("Array after sort : " + Arrays.toString(nums));
            System.out.println(getRangesFromSortedArr(nums));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

      static void test2() {
            int[] nums = {1,4,3,2};
            String expectedResult = "1-4";
            System.out.println("Test 1");
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums,0,nums.length - 1);
            System.out.println("Array after sort : " + Arrays.toString(nums));
            System.out.println(getRangesFromSortedArr(nums));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

      static void test3() {
            int[] nums = {1,4};
            String expectedResult = "1-4";
            System.out.println("Array before sort : " + Arrays.toString(nums));
            quickSort(nums,0,nums.length - 1);
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
      static String getRangesFromSortedArr(int[] arr) {
          return null;
      }
      static void quickSort(int[] arr, int startIndex, int endIndex) {
            if (endIndex <= startIndex) return;

            int pivotIndex = partition(arr, startIndex, endIndex);

            quickSort(arr,startIndex,pivotIndex - 1);
            quickSort(arr,pivotIndex + 1, endIndex);

      }

      static int partition(int[] arr, int startIndex, int endIndex) {
            int pivot = arr[endIndex];

            int i = startIndex - 1;

            for(int j = startIndex; j <= endIndex - 1 ; j++) {
                  if(arr[j] < pivot) {
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
