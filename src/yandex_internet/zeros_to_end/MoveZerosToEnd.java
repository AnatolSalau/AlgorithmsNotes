package yandex_internet.zeros_to_end;

import java.util.Arrays;

public class MoveZerosToEnd {
      /**
       Перенести нули в конец массива, сохранив порядок остальных элементов

       [1,0,8,9] → [1,8,9,0]
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
      }
      /*
        for
          i:0  1  2  3
            1, 0, 8, 9        count = 0
            i
            curr = 1 -> arr[0] = arr[0] -> 1, 0, 8, 9, count ++

          i:0  1  2  3
            1, 0, 8, 9        count = 1
               i
            curr = 0

          i:0  1  2  3
            1, 0, 8, 9        count = 1
                  i
            curr = 8-> arr[1] = arr[2] -> 1, 8, 8, 9, count ++

          i:0  1  2  3
            1, 8, 8, 9        count = 2
                     i
            curr = 9-> arr[2] = arr[3] -> 1, 8, 9, 9, count ++

            count = 3
         while
            arr[3] = 0
       */
      public static void testOne() {
            int[] nums = {1,0,8,9};
            int[] expectedResult = {1,8,9,0};
            System.out.println("Test 1");
            System.out.println("Arr: " + Arrays.toString(nums));
            System.out.println("Exp: " + Arrays.toString(expectedResult));
            pushZerosToEnd(nums);
            System.out.println("Res: " + Arrays.toString(nums));
            System.out.println();
      }
      /*
      f - pointer from
      t - pointer to
      for
        i:0  1  2  3  4  5  6
          0, 1, 0, 0, 8, 0, 9
         tf
          count = 0, curr = 0,

        i:0  1  2  3  4  5  6
          0, 1, 0, 0, 8, 0, 9
          t  f
          count = 0, curr = 1, -> 1 1 0 0 8 0 9, count ++

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
             t  f
          count = 1, curr = 0

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
             t     f
          count = 1, curr = 0

        i:0  1  2  3  4  5  6
          1, 1, 0, 0, 8, 0, 9
             t        f
          count = 1, curr = 8, -> 1 8 0 0 8 0 9, count ++

        i:0  1  2  3  4  5  6
          1, 8, 0, 0, 8, 0, 9
                t        f
          count = 2, curr = 0

        i:0  1  2  3  4  5  6
          1, 8, 0, 0, 8, 0, 9
                t           f
          count = 2, curr = 9 -> 1 8 9 0 8 0 9, count ++

          1 8 9 0 8 0 9
          for
          count = 3
          putt all 0 from i = 3 to end
          1 8 9 0 8 0 9 -> 1 8 9 0 0 0 0
       */
      /*
            two pointer from and to
            for loop through arr i = f(from)
                  check curr num
                        if curr is 0 -> continue loop
                        if curr is not 0 -> copy (from) to (to) and increase counter to and to pointer
       */
      public static void testTwo() {
            int[] nums = {0,1,0,0,8,0,9};
            int[] expectedResult = {1,8,9,0,0,0,0};
            System.out.println("Test 2");
            System.out.println("Arr: " + Arrays.toString(nums));
            System.out.println("Exp: " + Arrays.toString(expectedResult));
            pushZerosToEnd(nums);
            System.out.println("Res: " + Arrays.toString(nums));
            System.out.println();
      }
      /*
            1. Create two pointers
                  l - left pointer
                  r - right pointer
            2. Create count of none zero values
            2. Move through arr
                  - every iteration we will count none zero values
                  -if right value is not zero -> we will copy from right to left
                  - assign left pointer value from count of none zero value
            3. Fill end of arr from left pointer to end
       */
      static void pushZerosToEnd(int arr[]) {
            int countNoneZero = 0;
            int l = 0; //l - left pointer
            for (int r = 0; r < arr.length; r++) { // r - right pointer                                     //O(n)
                  if (arr[r] != 0) {//if right value is not noll
                        countNoneZero++ ;//count none zero values
                        arr[l] = arr[r]; //we will copy from right to left
                        l++;
                  }
            }
            //Fill end of arr from left pointer to end
            for (int i = countNoneZero; i < arr.length; i++) {
                  arr[i] = 0;
            }
                                                                        //result: O(n)
      }
}
