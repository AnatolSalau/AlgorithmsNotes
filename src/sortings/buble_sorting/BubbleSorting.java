package sortings.buble_sorting;

import java.util.Arrays;

public class BubbleSorting {
      public static void main(String[] args) {
            BubbleSorting bubbleSorting = new BubbleSorting();
            bubbleSorting.testBubbleSorting();
      }

      private  void testBubbleSorting() {
            int[] arr = {10, 4, 1, 5, 2, -1, -1, 3, 10,};
            System.out.println("arr after : " + Arrays.toString(arr));
            doSort(arr);
            System.out.println("arr before : " + Arrays.toString(arr));
      }

      private void doSort(int[] arr) {
            //go through all pairs in two loops by brut force
            for (int i = 0; i < arr.length - 1; i++) {
                  for (int j = i; j < arr.length; j++) {
                        //swap elements
                        if (arr[i] > arr[j]) {
                              int temp = arr[i];
                              arr[i] = arr[j];
                              arr[j] = temp;
                        }
                  }
            }
      }
}
