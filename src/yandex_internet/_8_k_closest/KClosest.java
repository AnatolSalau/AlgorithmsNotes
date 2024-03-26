package yandex_internet._8_k_closest;

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

      /*          *
            2,3,5,7,11

                  *
            2,3,5,7,11
            l       r length = 5
              5    4
                  *
            2,3,5,7,11
              l     r length = 4
              4    4

                  *
            2,3,5,7,11
                l    r length = 3
                2    4
                  *
            2,3,5,7,11
                l r length = 2
                2 0
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      /*
            Explanation
            1. Create two pointers
                  l - from start arr
                  e - from end arr
            2. Go through arr
                  - calculate sliding window size - > if size == target -> break from loop
                  - calculate distance to left side from target number
                  - calculate distance to right side from target number
                  - if left distance > right distance -> increase left pointer
                  - if right distance > left distance -> decrease right pointer
                  - if distances are equal -> move forward left pointer
            3. Fill result from left pointer  to right pointer

       */
      static public int[] findClosetElements(int[] arr, int range, int indexTarget) {
            int startIndex = 0;
            int endIndex = 0;

            int l = 0; // left pointer
            int r = arr.length - 1; // right pointer
            int sizeWindow = r - l + 1;

            //check size arr
            if (arr.length == 0 || arr.length < sizeWindow) return null;

            while (l < arr.length && r >= 0) {                                                 //O(n)
                  sizeWindow = r - l + 1; //calculate sliding window size - > if size == target -> break from loop
                  if (sizeWindow == range) {
                        startIndex = l;
                        endIndex = r;
                        break;
                  }
                  int leftDistance = arr[indexTarget] - arr[l];
                  int rightDistance = arr[r] - arr[indexTarget];

                  //if left distance > right distance -> increase left pointer
                  //if distances are equal -> move forward left pointer
                  if ( (leftDistance > rightDistance) || (leftDistance == rightDistance) ) {
                        l++;
                  } else {//if right distance > left distance -> decrease right pointer
                        r--;
                  }
            }
            //fill result from left pointer  to right pointer
            int[] resultRange = new int[sizeWindow];
            for (int i = startIndex, j = 0; i <= endIndex; i++, j++) {                         //O(m)
                  resultRange[j] = arr[i];
            }
           return resultRange;                                                                 //O(n + m)
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
              l      h  (h[4] - l[1]) = 3 - sliding window size
            arr[l] - target ( 3 - 7 ) = 4
            arr[h] - target ( 11 - 7 ) = 4
            4 >= 4 -> l++

          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
                l    h  (h[4] - l[2]) = 2 - sliding window size
            arr[l] - target ( 5 - 7 ) = 2
            arr[h] - target ( 11 - 7 ) = 4
            4 >= 4 -> h--

          i:0 1 2 3  4, target = 7, range 2
            2 3 5 7 11
                l h     (h[3] - l[2]) = 1 - sliding window size < target -> return result
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
