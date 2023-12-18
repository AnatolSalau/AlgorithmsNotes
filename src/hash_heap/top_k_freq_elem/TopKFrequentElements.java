package hash_heap.top_k_freq_elem;

import java.util.*;

public class TopKFrequentElements {
      /**
             Given an integer array nums and an integer k,
             return the k most frequent elements.
             You may return the answer in any order.

             Example 1:

             Input: nums = [1,1,1,2,2,3], k = 2
             Output: [1,2]

             Example 2:
             Input: nums = [1], k = 1
             Output: [1]
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      /**
            O( (n^2 + k) log(n)  )
       */
      static List<Integer> getMostFrequentElements(int[] nums, int k) {
            TreeMap<Integer,Integer> freqMap = new TreeMap<>();
            //fill freqMap
            for (int i = 0; i < nums.length; i++) {
                  int current = nums[i];
                  //add to freq map
                  if (freqMap.containsKey(current)) {
                        int val = freqMap.get(current);
                        int newVal = val + 1;
                        //add to freqMap
                        freqMap.put(current,newVal);

                  } else {
                        freqMap.put(current,1);
                  }
            }
            PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));

            heap.addAll(freqMap.keySet());

            List<Integer> result = new LinkedList<>();
            while (!heap.isEmpty()) {
                  result.add(heap.poll());
                  if (result.size() >= k) return result;
            }
            return result;

      }

      static void test1() {
            int[] nums = {1,1,1,1,1,2,3,3};
            int k = 2;
            int[] expected = {1,3};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            List<Integer> mostFrequentElements = getMostFrequentElements(nums, k);
            System.out.println(mostFrequentElements);
            System.out.println();
      }

      static void test2() {
            int[] nums = {1};
            int k = 1;
            int[] expected = {1};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            List<Integer> mostFrequentElements = getMostFrequentElements(nums, k);
            System.out.println(mostFrequentElements);
            System.out.println();
      }

      /*
            1 1 1 2 2 2 3 3
       */
      static void test3() {
            int[] nums = {1,1,1,2,2,2,3,3};
            int k = 2;
            int[] expected = {1,2};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            List<Integer> mostFrequentElements = getMostFrequentElements(nums, k);
            System.out.println(mostFrequentElements);
            System.out.println();
      }
}
