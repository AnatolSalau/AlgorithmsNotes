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
            IntStream stream1 = Arrays.stream(arr1);
            IntStream stream2 = Arrays.stream(arr2);
            int[] union = IntStream.concat(stream1, stream2)
                  .toArray();
            System.out.println(Arrays.toString(union));

      }
}