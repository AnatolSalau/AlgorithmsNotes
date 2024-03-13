package hash_heap.distribute_evenly;

import java.util.*;
import java.util.stream.Collectors;

public class DistributeEvenly {
      /**
       Your distributeEvenly function will take an array as an argument and needs to return a new array with the values distributed evenly.

       Example 1:
       Argument: ['one', 'one', 'two', 'two', 'three', 'three', 'four', 'four']
       Result: ['one', 'two', 'three', 'four', 'one', 'two', 'three', 'four']

       Example 2:
       Argument: ['one', 'one', 'one', 'one', 'one', 'two', 'three']
       Result: [ 'one', 'two', 'three', 'one', 'one', 'one', 'one' ]
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      /*
            Explanation
            done:       "1, 1, 1, 2, 2, 3"
            result:     "1, 2, 3, 1, 2, 1"

            1. Create linked map str -> qty ( because we need to save element order)
                  1->3
                  2->2
                  3->1
            2. Create result list
            3. Distribute elements from hash map while it will be empty
                  1. Go through map by loop
                  2. Add key to result
                  3. Decrease count in map
                  4. If count is 0 - remove from map
       */
      public static String[] distributeEvenly(String[] arr) {
            List<String> resultList = new LinkedList<>();//2. Create result list
            //1. Create linked map str -> qty ( because we need to save element order)
            LinkedHashMap<String, Integer> elemFreqMap = new LinkedHashMap<>();
            for (String str : arr) {
                  if(elemFreqMap.containsKey(str)) {
                        Integer qty = elemFreqMap.get(str);
                        qty++;
                        elemFreqMap.put(str,qty);
                  } else {
                        elemFreqMap.put(str,1);
                  }
            }
            // 3. Distribute elements from hash map while it will be empty
            while (!elemFreqMap.isEmpty()) {
                  // 1. Go through map by loop
                  for (String key : elemFreqMap.keySet().stream().toList()) {
                        // 2. Add key to result
                        resultList.add(key);
                        // 3. Decrease count in map
                        Integer qty = elemFreqMap.get(key);
                        qty --;
                        //4. If count is 0 - remove from map
                        if (qty == 0) {
                              elemFreqMap.remove(key);
                        } else {
                              elemFreqMap.put(key,qty);
                        }
                  }
            }

            return resultList.toArray(new String[0]);
      }

      static void test1() {
            String[] arr = {"one", "one", "two", "two", "three", "three", "four", "four"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "'one', 'two', 'three', 'four', 'one', 'two', 'three', 'four'");
            System.out.println();
      }

      static void test2() {
            String[] arr = {"one", "one", "one", "one", "one", "two", "three"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "'one', 'two', 'three', 'one', 'one', 'one', 'one'");
      }

      static void test3() {
            String[] arr = {"1","1","1","2","2","3"};
            System.out.println(Arrays.toString(arr));
            String[] results = distributeEvenly(arr);
            System.out.println(Arrays.toString(results));
            System.out.println("Expected result : " + "1, 2, 3, 1, 2, 1");
      }
}
