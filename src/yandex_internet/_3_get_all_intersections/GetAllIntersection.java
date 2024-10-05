package yandex_internet._3_get_all_intersections;

import java.util.*;

/**
 *
 We have two arrays: [1, 2, 3, 2, 0] и [5, 1, 2, 7, 3, 2]
 Return [1, 2, 2, 3] (order is not important)
 - all intersections with duplicates
 */
/*
      Go through arr1 -> create map
      Go throught arr2 - decrease count in map
 */
public class GetAllIntersection {

      public static void main(String[] args) {
            testOne();
      }
      /*
           O(n+m) time complexity
            1. create map with quantity numbers in arr1 O(arr1.length)
            2. iterate through arr2 (arr2.length) O(arr2.length)
                  - if curr number in arr 2 -> exist in qtyMap
                        add this number from map
                        decrease qty in map
                        remove number from  map if qty is 0

       */
      static List<Integer> getAllIntersections(int[] arr1, int[] arr2) {
            List<Integer> intersectionsList = new LinkedList<>();

            //create map with quantity number in arr1
            Map<Integer, Integer> numberQtyArr1Map = new HashMap<>();
            //fill charQtyArr1Map
            for (int i = 0; i < arr1.length; i++) {                                 //O(n)
                  int curr = arr1[i];

                  if (numberQtyArr1Map.containsKey(curr)) {
                        int qty = numberQtyArr1Map.get(curr);
                        qty ++;
                        numberQtyArr1Map.put(curr, qty);
                  } else {
                        numberQtyArr1Map.put(curr,1);
                  }
            }
            // iterate through arr2
            for (int i = 0; i < arr2.length; i++) {                                 //O(m)
                  int curr = arr2[i];
                  //check curr number exist in qtyMap
                  if (numberQtyArr1Map.containsKey(curr)) {
                        Integer qty = numberQtyArr1Map.get(curr);
                        // add this number
                        intersectionsList.add(curr);
                        // decrease count in map
                        qty --;
                        if (qty > 0) {
                              numberQtyArr1Map.put(curr,qty);
                        } else {
                              numberQtyArr1Map.remove(curr);
                        }
                  }
            }

            return intersectionsList;                                               // O(n+m)
      }
      static void testOne() {
            int[] arr1 = {1, 2, 3, 2, 0};
            int[] arr2 = {5, 1, 2, 7, 3, 2};
            List<Integer> allIntersections = getAllIntersections(arr1, arr2);
            System.out.println("Test 1");
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println("Result : " + allIntersections);
            System.out.println("Expect : " + "[1, 2, 2, 3" +
                  "]");
      }
}
