package sortings.quick_sorting;

import java.util.Arrays;

public class QuickSorting {
      public static void main(String[] args) {

            QuickSorting quickSorting = new QuickSorting();
            quickSorting.testQuickSorting();
      }

      private void testQuickSorting() {
            int[] array = {1,9, 5, 2, 8, -1, -9 };
            System.out.println("After before : " + Arrays.toString(array));
            quickSort(array,0,array.length - 1);
            System.out.println("After after : " + Arrays.toString(array));
      }

      private void quickSort(int[] arr, int startIndex, int endIndex) {
            //exit from recursion
            if (startIndex >= endIndex) return;

            int pivotIndex = partition(arr, startIndex, endIndex);

            quickSort(arr,startIndex,pivotIndex - 1);
            quickSort(arr,pivotIndex + 1,endIndex);
      }

      private int partition(int[] arr, int startIndex, int endIndex) {
            int i = startIndex - 1;
            int pivot = arr[endIndex];

            for (int j = startIndex; j <= endIndex - 1; j++) {
                  if (arr[j] < pivot) {
                        i++;
                        int temp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = temp;
                  }
            }

            i++;
            int temp = arr[endIndex];
            arr[endIndex] = arr[i];
            arr[i] = temp;
            return i;
      }
}
