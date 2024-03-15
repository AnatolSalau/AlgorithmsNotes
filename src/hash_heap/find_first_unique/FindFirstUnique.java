package hash_heap.find_first_unique;

import java.util.HashMap;

public class FindFirstUnique {
      /**
       * //Задача: найти первый не повторяющийся элемент в наборе целых чисел
       * //9, 4, 9, 9, 6, 7, 4, 5, 5 -> 6
       * //5, 9, 8, 5, 7, 9, 8, 7, 1 -> 1
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      private static void testOne() {
            int[] nums = {9, 4, 9, 9, 6, 7, 4, 5, 5};
            FindFirstUnique task17 = new FindFirstUnique();
            int unique = task17.findUnique(nums);
            int expectedResult = 6;
            System.out.println("Unique : " + unique);
            System.out.println("Expect : " + expectedResult);
      }

      private static void testTwo() {
            int[] nums = {5, 9, 8, 5, 7, 9, 8, 7, 1};
            FindFirstUnique task17 = new FindFirstUnique();
            int unique = task17.findUnique(nums);
            int expectedResult = 1;
            System.out.println("Unique : " + unique);
            System.out.println("Expect : " + expectedResult);
      }
      /*
            Explanation
            1. Create map with quantity of numbers
            2. Go through this map
                  compare value (qty) in every entry
                  if qty is 1 -> return key as result
       */
      private int findUnique(int[] arr) {
            HashMap<Integer, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < arr.length; i++) {
                  int curr = arr[i];
                  if (frequencyMap.containsKey(curr)) {
                        Integer val = frequencyMap.get(curr);
                        val += 1;
                        frequencyMap.put(curr,val);
                  } else {
                        frequencyMap.put(curr,1);
                  }
            }

            for (int i = 0; i < arr.length; i++) {
                  int curr = arr[i];
                  int qty = frequencyMap.get(curr);
                  if (qty == 1) {
                        return curr;
                  }
            }

            throw new RuntimeException("Array doesn't contain unique elements");
      }
}
