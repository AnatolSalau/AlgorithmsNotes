package tinkof_interview.sortings_searchings.top_k_frequent;

import java.util.*;

public class TopKFrequent {
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      public static int[] topKFrequent(int[] nums, int k) {
            TreeMap<Integer, Integer> freqNumMap = new TreeMap<>();

            for(int i = 0; i < nums.length; i++) {                                                    //O(n)
                  int curr = nums[i];

                  if (freqNumMap.containsKey(curr)) {
                        Integer count = freqNumMap.get(curr);
                        count++;
                        freqNumMap.put(curr, count);
                  } else {
                        freqNumMap.put(curr, 1);
                  }
            }
            PriorityQueue<Map.Entry<Integer, Integer>> heapEntrySortedByValue = new PriorityQueue<>(
                  Comparator.comparingInt(Map.Entry<Integer, Integer>::getValue).reversed()
            );
            heapEntrySortedByValue.addAll(freqNumMap.entrySet());                                     //O(n)
            int[] result = new int[k];
            for (int j = 0; j < result.length; j++) {
                  Integer num = heapEntrySortedByValue.poll().getKey();
                  result[j] = num;
            }
            return result;                                                                            //O(n^2)
      }

      static void test1() {
            int[] nums = {1,1,1,1,1,2,3,3};
            int k = 2;
            int[] expected = {1,3};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            int[] mostFrequentElements = topKFrequent(nums, k);
            System.out.println(Arrays.toString(mostFrequentElements));
            System.out.println();
      }

      static void test2() {
            int[] nums = {1};
            int k = 1;
            int[] expected = {1};
            System.out.println(Arrays.toString(nums));
            System.out.println("Expected : " + Arrays.toString(expected));
            int[] mostFrequentElements = topKFrequent(nums, k);
            System.out.println(Arrays.toString(mostFrequentElements));
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
            int[] mostFrequentElements = topKFrequent(nums, k);
            System.out.println(Arrays.toString(mostFrequentElements));
            System.out.println();
      }
}
