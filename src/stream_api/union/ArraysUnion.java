package stream_api.union;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Merge two arrays by stream
 * [1, 2, 3, 4] [5, 6, 7]
 * result: [1, 2, 3, 4, 5, 6, 7]
 */
public class ArraysUnion {
      public static void main(String[] args) {
            int[] arr1 = {1, 2, 3, 4};
            int[] arr2 = {5, 6, 7};

            String[] arr1Str = {"1", "2", "3", "4"};
            String[] arr2Str = {"5", "6", "7"};

            String[] strings = merge2Arrays(arr1Str, arr2Str);
            System.out.println(Arrays.toString(strings));

            System.out.println(Arrays.toString(mergeMultiplesArrays(arr1Str, arr2Str)));
      }

      public static String[] merge2Arrays(String[] arr1, String[] arr2) {
            Stream<String> stream1 = Arrays.stream(arr1);
            Stream<String> stream2= Arrays.stream(arr2);

            Stream<String> concat = Stream.concat(stream1, stream2);

            String[] array = concat.toArray(String[]::new);

            return array;
      }

      public static String[] mergeMultiplesArrays(String[]... arrays) {
            String[] array = Arrays.stream(arrays)
                    .flatMap(Arrays::stream)
                    .toArray(String[]::new);
            return array;
      }

      public static String[] mergeMultiplesArraysTest(String[]... arrays) {
            return null;
      }
}