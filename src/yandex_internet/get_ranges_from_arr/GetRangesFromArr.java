package yandex_internet.get_ranges_from_arr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 228. Summary Ranges
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 *
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges,
 * and there is no integer x such that x is in one of the ranges but not in nums.
 *
 * Each range [a,b] in the list should be output as:
 *
 * "a->b" if a != b
 * "a" if a == b
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: The ranges are:
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 *
 * Example 2:
 *
 * Input: nums = [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: The ranges are:
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class GetRangesFromArr {

      public static void main(String[] args) {
            test1();
            test2();
            test3();
            test4();
            test5();
      }
      /*
            [0, 2, 3, 4, 6, 8, 9]
            ["0","2->4","6","8->9"]
             l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=0     -> start = 2
            end=0       -> end = 2
            l(0) != r(0+1) -> [0]

                l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=2     -> start = 2
            end=2       -> end = 3
            l(2) == r(2+1) ->

                   l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=2     -> start = 2
            end=3       -> end = 4
            l(3) == r(3+1) ->

                      l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=2     -> start = 6
            end=4       -> end = 6
            l(4) != r(4+1) -> [0],[2->4]

                         l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=6     -> start=8
            end=6       -> end=8
            l(6) != r(6+1) -> [0],[2->4], [6]

                            l  r
            [0, 2, 3, 4, 6, 8, 9]
            start=8     -> start = 8
            end=8       -> end = 9
            l(8) == r(8+1) -> [0],[2->4], [6], [8->9]
       */
      /*
            Explanation:
            1. Create two pointer l and r
                  Initialize l = arr[0], r = arr[1]
            2. Create two variables start and end
                  Initialize start = arr[0] end = arr[0]
            3. Start while loop while r < arr.length
                  1. every iteration move l and r forward
                  2. compare l and r
                        if r == l+1
                              -> end = arr[r]
                        else (r != l+1)
                              if (start == end)
                                    add to builder [start]

                              else (start != end)
                                    add to builder [start->end]
                              add to result
                              clear builder
                              start = arr[r]
                              end = arr[r]
            4. After while check start and end  (add last range in arr)
                  if (start == end)
                        add to builder [start]
                  else (start != end)
                        add to builder [start->end]
                  add to result
       */
      private static List<String> getRanges(int[] arr) {
            List<String> result = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            int l = 0;
            int r = 1;

            int start = arr[0];
            int end = arr[0];

            while ( r <  arr.length) {
                  if (arr[r] == (arr[l] + 1) ) {
                        end = arr[r];
                  } else {
                        if (start == end) {
                              stringBuilder.append(start);
                        } else {
                              stringBuilder.append(start);
                              stringBuilder.append("->");
                              stringBuilder.append(end);
                        }
                        result.add(stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                        start = arr[r];
                        end = arr[r];
                  }

                  l++;
                  r++;
            }
            System.out.println();
            if (start == end) {
                  stringBuilder.append(start);
            } else {
                  stringBuilder.append(start);
                  stringBuilder.append("->");
                  stringBuilder.append(end);
            }
            result.add(stringBuilder.toString());

            return result;
      }

      private static void quickSort(int[] arr, int start, int end) {
            if (start >= end) return;

            int pivotIndex = partition(arr, start, end);

            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
      }

      private static int partition (int[] arr, int start, int end) {
            int i = start - 1;
            int pivot = arr[end];

            for (int j = start; j <= end - 1; j++) {
                  if (arr[j] < pivot) {
                        i++;
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                  }
            }
            i++;
            int temp = arr[end];
            arr[end] = arr[i];
            arr[i]=temp;
            return i;
      }

      private static void test1() {
            System.out.println("Test 1");
            int[] arr = {9,2,6,4,3,8,0};
            System.out.println("Before sort : " + Arrays.toString(arr));
            String expect = "[\"0\",\"2->4\",\"6\",\"8->9\"]";
            quickSort(arr,0,arr.length - 1);
            System.out.println("After sort : " + Arrays.toString(arr));
            List<String> result = getRanges(arr);


            System.out.println("Result : " + result);
            System.out.println("Expect : " + expect);
            System.out.println();
      }

      private static void test2() {
            System.out.println("Test 2");
            int[] arr = {7,1,5,4,2,0};
            System.out.println("Before sort : " + Arrays.toString(arr));
            quickSort(arr,0,arr.length - 1);
            String expect = "[\"0->2\",\"4->5\",\"7\"]";
            quickSort(arr,0,arr.length - 1);
            System.out.println("After sort : " + Arrays.toString(arr));
            List<String> result = getRanges(arr);


            System.out.println("Result : " + result);
            System.out.println("Expect : " + expect);
            System.out.println();
      }
      /*
            [1,4,5,2,3,9,8,11,0] => "0-5,8-9,11"
            [1,4,3,2] => "1-4"
            [1,4] => "1,4"
       */
      private static void test3() {
            System.out.println("Test 3");
            int[] arr = {1,4,5,2,3,9,8,11,0};
            System.out.println("Before sort : " + Arrays.toString(arr));
            quickSort(arr,0,arr.length - 1);
            String expect = "[0->5,8->9,11]";
            quickSort(arr,0,arr.length - 1);
            System.out.println("After sort : " + Arrays.toString(arr));
            List<String> result = getRanges(arr);
            System.out.println("Result : " + result);
            System.out.println("Expect : " + expect);
            System.out.println();
      }
      private static void test4() {
            System.out.println("Test 4");
            int[] arr = {1,4,3,2};
            System.out.println("Before sort : " + Arrays.toString(arr));
            quickSort(arr,0,arr.length - 1);
            String expect = "[1->4]";
            quickSort(arr,0,arr.length - 1);
            System.out.println("After sort : " + Arrays.toString(arr));
            List<String> result = getRanges(arr);
            System.out.println("Result : " + result);
            System.out.println("Expect : " + expect);
            System.out.println();
      }
      private static void test5() {
            System.out.println("Test 5");
            int[] arr = {1,4};
            System.out.println("Before sort : " + Arrays.toString(arr));
            quickSort(arr,0,arr.length - 1);
            String expect = "[1, 4]";
            quickSort(arr,0,arr.length - 1);
            System.out.println("After sort : " + Arrays.toString(arr));
            List<String> result = getRanges(arr);
            System.out.println("Result : " + result);
            System.out.println("Expect : " + expect);
            System.out.println();
      }
}
