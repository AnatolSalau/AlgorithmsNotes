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
      static int getGeneralNumber(int[] arr1, int[] arr2, int[] arr3) {
/*
            quickSort(arr1,0,arr1.length - 1);
            quickSort(arr2,0,arr2.length - 1);
            quickSort(arr3,0,arr3.length - 1);*/


            int max = 0;

            int i = 0;
            int j = 0;
            int k = 0;

            while ( (i < arr1.length) && (j < arr2.length) && (k < arr3.length) ) {
                  int num1 = arr1[i];

                  int num2 = arr2[j];

                  int num3 = arr3[k];


                  if (num1 == num2 && num2 == num3) return num1;

                  max = Math.max(num1,Math.max(num2, num3));

                  if (num1 < max) {
                        i++;
                        continue;
                  }
                  if (num2 < max) {
                        j++;
                        continue;
                  }
                  if (num3 < max) {
                        k++;
                        continue;
                  }
            }
            return -999;
      }

      static void quickSort(int[] array, int startIndex, int endIndex) {
            if(endIndex<= startIndex) return; //base case

            int pivotIndex = partition(array,startIndex, endIndex);

            quickSort(array,startIndex,pivotIndex - 1);
            quickSort(array,pivotIndex +1,endIndex);
      }

      static int partition(int[] array, int startIndex, int endIndex) {
            int pivot = array[endIndex];
            int i = startIndex - 1;

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if(array[j] < pivot) {
                        i++;
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                  }
            }
            i++;
            int temp = array[i];
            array[i] = array[endIndex];
            array[endIndex] = temp;

            return i;
      }
}
