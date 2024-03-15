package hash_heap.find_all_duplicates;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Handler;

public class FindAllDuplicates {
      /**
       * Вернуть все дубликаты которые встречаются среди первого или второго
       * массива.
       * Дубликатами считаются числа, которые находятся либо в одинаковых,
       * либо в разных массивах.
       * Дубликаты должны быть возвращены в том же порядке в котором они
       * встречаются сначала в первом массиве, затем во втором
       * Например:
       * a = [4, 4, 3, 9, 8]
       * b = [2, 1, 2, 9]
       * Ожидаемый результат:
       * [4, 4, 9, 2, 2, 9]
       */
      public static void main(String[] args) {
            testOne();
      }

      private static void testOne() {
            int[] nums1 = {4, 4, 3, 9, 8};
            int[] nums2 = {2, 1, 2, 9};
            int[] expectedResult = {4, 4, 9, 2, 2, 9};
            FindAllDuplicates task19 = new FindAllDuplicates();
            List<Integer> allDublicates = task19.getAllDuplicates(nums1, nums2);
            System.out.println("Result : " + allDublicates);
            System.out.println("Expect : " + Arrays.toString(expectedResult));
      }

      /*
            Explanation
            0. Create result list
            1. Go through first and second arr -> create map with qty of numbers numFreqMap
            3. Remove all keys vith values 1
            4. Go through first arr
                  if curr char in arr is contains in numFreqMap and it qty more than 1
                        add this char to result with specified number of time
            4. Go through second arr
                  if curr char in arr is contains in numFreqMap and it qty more than 1
                        add this char to result with specified number of time

       */
      private List<Integer> getAllDuplicates(int[] nums1, int[] nums2) {
            List<Integer> result = new LinkedList<>(); // 0. Create result list
            HashMap<Integer, Integer> numFreqMap = new HashMap<>(); //create map with qty of numbers
            for (int key : nums1) {// fill map from first arr
                  if (numFreqMap.containsKey(key)) {
                        Integer qty = numFreqMap.get(key);
                        qty++;
                        numFreqMap.put(key, qty);
                  } else {
                        numFreqMap.put(key, 1);
                  }
            }

            for (int key : nums2) {// fill map from second arr
                  if (numFreqMap.containsKey(key)) {
                        Integer qty = numFreqMap.get(key);
                        qty++;
                        numFreqMap.put(key, qty);
                  } else {
                        numFreqMap.put(key, 1);
                  }
            }

            //3. Remove all keys vith values 1
            for (Integer key : numFreqMap.keySet().toArray(new Integer[0])) {
                  if(numFreqMap.get(key) == 1 ) numFreqMap.remove(key);
            }

            for (int key : nums1) {//2. Go through first arr

                  //if curr char in arr is contains in numFreqMap and it qty more than 1
                  if (numFreqMap.containsKey(key)) {
                        Integer qty = numFreqMap.get(key);
                        //add this char to result with specified number of time
                        result.add(key);
                        qty--;//decrease qty
                        if (qty == 0) numFreqMap.remove(key); // remove key if qty is 0
                        else numFreqMap.put(key, qty); // save decreased qty in map

                  }
            }

            for (int key : nums2) {//2. Go through second arr
                  //if curr char in arr is contains in numFreqMap and it qty more than 1
                  if (numFreqMap.containsKey(key)) {
                        Integer qty = numFreqMap.get(key);
                        //add this char to result with specified number of time
                        result.add(key);
                        qty--;//decrease qty
                        if (qty == 0) numFreqMap.remove(key); // remove key if qty is 0
                        else numFreqMap.put(key, qty); // save decreased qty in map

                  }
            }

            return result;
      }
}
