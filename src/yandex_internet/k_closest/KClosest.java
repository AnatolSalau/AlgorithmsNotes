package yandex_internet.k_closest;

import java.util.Arrays;

public class KClosest {
      /**
       Дан отсортированный массив чисел а, индекс элемента index и целое число k.
       Необходимо вернуть в любом порядке k чисел из массива,
       которые являются ближайшими по значению к элементу а[index].
                               *
       find_k_closest(a={2,3,5,7,11}, index=3, k=2) -> {5,7}
                           *
       find_k_closest(a={4,12,15,15,24}, index=1, k=3) -> {12,15,15}
                             *
       find_k_closest(a={2,3,5,7,11}, index=2, k=2) -> {5,7} или {3,5}
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      static public int[] findClosetElements(int[] arr, int range, int indexTarget) {
            int target = arr[indexTarget];
            int l = 0;
            int r = arr.length - 1;

            while (r - l >= range) {
                  int left = arr[l];
                  int leftDistance = Math.abs(left - target); // distance between left element and target

                  int right = arr[r];
                  int rightDistance = Math.abs(right - target);// distance between target and right element

                  if (leftDistance >= rightDistance) {
                        l++;
                  } else {
                        r--;
                  }
            }
            int resultLength = r - l + 1;
            int[] result = new int[resultLength];

            for (int i = l, j = 0; i <= r ; i++, j++) {
                  result[j] = arr[i];
            }

            return result;
      }
      /*
          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
            l        h  (h[4] - l[0]) = 4 - sliding window size
            arr[l] - target ( 2 - 7 ) = 5
            arr[h] - target ( 11 - 7 ) = 4
            5 >= 4 -> l++

          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
              l      h  (h[4] - l[1]) = 3
            arr[l] - target ( 3 - 7 ) = 4
            arr[h] - target ( 11 - 7 ) = 4
            4 >= 4 -> l++

          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
                l    h  (h[4] - l[2]) = 2
            arr[l] - target ( 5 - 7 ) = 2
            arr[h] - target ( 11 - 7 ) = 4
            4 >= 4 -> h--

          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
                l h     (h[3] - l[2]) = 1
                break;

          for i = 2; i <= 3 -> 5 7
       */
      public static void test1() {
            int[] arr = {2,3,5,7,11};
            int indexTarget = 3;
            int range = 2;
            int[] expected = {5,7};
            int[] closetElements = findClosetElements(arr, range, indexTarget);
            System.out.println(Arrays.toString(arr));
            System.out.println("Index : " + indexTarget + ", element : " + arr[indexTarget]);
            System.out.println("Range : " + range);
            System.out.println("Expect : " + Arrays.toString(expected));
            System.out.println("Result : " + Arrays.toString(closetElements));
            System.out.println();
      }
      /*
          i:0  1  0  3  4, target 15 (i:2), range = 3
            4 12 15 15 24
            l     *     r
            length  4 - 0 = 4
            left distance 4 - 15 = 11
            right distance 24 - 15 = 9
            11 >= 9 -> l++

          i:0  1  0  3  4, target 15 (i:2), range = 3
            4 12 15 15 24
               l     *  r
            length  4 - 1 = 3
            left distance 12 - 15 = 3
            right distance 24 - 15 = 9
            3 !>= 9 -> r--

          i:0  1  0  3  4, target 15 (i:2), range = 3
            4 12 15 15 24
               l     r
            length  3 - 1 = 2 - > break

       */
      public static void test2() {
            int[] arr = {4,12,15,15,24};
            int indexTarget = 2;
            int range = 3;
            int[] expected = {12,15,15};
            int[] closetElements = findClosetElements(arr, range, indexTarget);
            System.out.println(Arrays.toString(arr));
            System.out.println("Index : " + indexTarget + ", element : " + arr[indexTarget]);
            System.out.println("Range : " + range);
            System.out.println("Expect : " + Arrays.toString(expected));
            System.out.println("Result : " + Arrays.toString(closetElements));
            System.out.println();
      }

      public static void test3() {
            int[] arr = {2,3,5,7,11};
            int indexTarget = 2;
            int range = 2;
            int[] expected = {5, 7};
            int[] closetElements = findClosetElements(arr, range, indexTarget);
            System.out.println(Arrays.toString(arr));
            System.out.println("Index : " + indexTarget + ", element : " + arr[indexTarget]);
            System.out.println("Range : " + range);
            System.out.println("Expect : " + Arrays.toString(expected));
            System.out.println("Result : " + Arrays.toString(closetElements));
            System.out.println();
      }
}
