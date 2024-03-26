package yandex_internet._5_get_sqrs;

import java.util.Arrays;

/**
 * Дан массив целых чисел х длинной N
 * Массив упорядочен
 * Написать функцию которая из этого массива получит массив квадратов чисел
 * упорядоченный по возрастанию
 * [-3, 2, 4] -> [4, 9, 16]
 * [-6 -6 -3 -1] -> [1 9 36 36]
 */
public class GetSqr {
      public static void main(String[] args) {
            int[] arr = {-3, 2, 4};
            int[] arr2 = {-6, -6, -3, -1};
            int[] sqrs = getSqrs(arr2);
            System.out.println(Arrays.toString(sqrs));

      }

      public static int[] getSqrs(int[] arr) {
            int[] result = new int[arr.length];

            int l = 0;
            int r = arr.length - 1;
            int i = result.length - 1;

            while (l <= r) {
                  int left = Math.abs(arr[l]);
                  int right = Math.abs(arr[r]);

                  if (left >= right) {
                        result[i] = left * left;
                        i--;
                        l++;
                  } else {
                        result[i] = right * right;
                        i--;
                        r--;
                  }
            }

            return result;
      }
}
