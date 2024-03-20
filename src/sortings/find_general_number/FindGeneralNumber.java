package sortings.find_general_number;

import java.util.Arrays;

public class FindGeneralNumber {
      /**
       * Найти общее число в трёх коллекциях, не используя дополнительные структуры
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
      }
      /*
      max = 8
       i -> increase
      [1, 2, 3, 10]
       j
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

      max = 8
          i -> increase
      [1, 2, 3, 10]
       j
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

      max = 8
             i -> increase
      [1, 2, 3, 10]
       j
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

      max = 10
                  i
      [1, 2, 3, 10]
          j -> increase
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

       max = 10
                  i
      [1, 2, 3, 10]
             j -> increase
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

      max = 10
                  i
      [1, 2, 3, 10]
                j -> increase
      [4, 5, 6, 7, 10]
       k
      [8, 9, 10]

      max = 10
                  i
      [1, 2, 3, 10]
                    j
      [4, 5, 6, 7, 10]
       k -> increase
      [8, 9, 10]

      max = 10
                  i
      [1, 2, 3, 10]
                    j
      [4, 5, 6, 7, 10]
          k -> increase
      [8, 9, 10]

            max = 10
                  i
      [1, 2, 3, 10]
                    j
      [4, 5, 6, 7, 10]
              k -> increase
      [8, 9, 10]

      10 = 10 = 10 -> return 10
       */
      static void testOne() {
            int[] arr1 = {3,2,1,10};
            int[] arr2 = {4,5,6,7,10};
            int[] arr3 = {8,9};
            System.out.println("Test 1");
            int generalNumber = getGeneralNumber(arr1, arr2, arr3);
            System.out.println("Result : " + generalNumber);
            System.out.println("Expect : -999" );
            System.out.println();
      }

      static void testTwo() {
            int[] arr1 = {3,2,1,10};
            int[] arr2 = {4,5,6,7,10};
            int[] arr3 = {8,9,10};
            System.out.println("Test 2");
            int generalNumber = getGeneralNumber(arr1, arr2, arr3);
            System.out.println("Result : " + generalNumber);
            System.out.println("Expect : 10 ");
            System.out.println();
      }

      static void testThree() {
            int[] arr1 = {3,10,1};
            int[] arr2 = {10,4,5,6,7};
            int[] arr3 = {8,9,10};
            System.out.println("Test 3");
            int generalNumber = getGeneralNumber(arr1, arr2, arr3);
            System.out.println("Result : " + generalNumber);
            System.out.println("Expect : 10 ");
            System.out.println();
      }

      /*
            max = 3
            i -> increase
            1 2 3
            j
            3 4 5 6 7
            k
            3 4 5 6

            max = 3
              i -> increase
            1 2 3
            j
            3 4 5 6 7
             k
            3 4 5 6

            max = 3
                i
            1 2 3
            j
            3 4 5 6 7
            k
            3 4 5 6

            3 = 3 = 3 -> break
       */
      /*
            1. Sort every arr in increasing order
            2. Create three pointer for every arr
            3. Create max value for max value between all passed values
            4. Go through all arr by while loop
                  while i,j,k < arr1,2,3.length
                  1. Compare every curr between each other
                        if curr1 == curr2 == curr3 -> return curr1
                  2. Find max between current values
                  3. Move pointers forward
                        if curr1 < max -> increase curr1 and skip all pointer increasing (continue)
                        if curr2 < max -> increase curr2 and skip all pointer increasing (continue)
                        if curr3 < max -> increase curr3 and skip all pointer increasing (continue)
            5. Return -999 if we didn't find three equal value

       */
      static int getGeneralNumber(int[] arr1, int[] arr2, int[] arr3) {
            // 1. Sort every arr in increasing order
            quickSort(arr1,0,arr1.length - 1);
            quickSort(arr2,0,arr2.length - 1);
            quickSort(arr3,0,arr3.length - 1);

            int i = 0, j = 0, k = 0; //2. Create three pointer for every arr

            int max = 0; // 3. Create max value for max value between all passed values

            while (i < arr1.length && j < arr2.length && k < arr3.length) {
                  int curr1 = arr1[i];
                  int curr2 = arr2[j];
                  int curr3 = arr3[k];

                  if (curr1 == curr2 && curr2 == curr3) return curr1; //1. Compare every curr between each other

                  max = Math.max(curr1, Math.max(curr2, curr3));//2. Find max between current values

                  //3. Move pointers forward
                  if (curr1 < max) {//if curr1 < max -> increase curr1 and skip all pointer increasing (continue)
                        i++;
                        continue;
                  }
                  if (curr2 < max) {//if curr2 < max -> increase curr2 and skip all pointer increasing (continue)
                        j++;
                        continue;
                  }
                  if (curr3< max) {//if curr3 < max -> increase curr3 and skip all pointer increasing (continue)
                        k++;
                        continue;
                  }
            }
            return -999;//5. Return -999 if we didn't find three equal value
      }

      static void quickSort(int[] array, int startIndex, int endIndex) {
            if (startIndex >= endIndex) return; // exit from recursion

            int pivotIndex = partition(array,startIndex, endIndex);

            quickSort(array,startIndex,pivotIndex - 1);
            quickSort(array,pivotIndex + 1, endIndex);

      }

      static int partition(int[] array, int startIndex, int endIndex) {
            int i = startIndex - 1;

            int pivot = array[endIndex];

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if (array[j] < pivot) {
                        i++;
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                  }
            }

            i++;
            int temp = array[endIndex];
            array[endIndex] = array[i];
            array[i] = temp;

            return i;
      }
}
