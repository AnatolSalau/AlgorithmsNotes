package hash_heap.top_k_freq_elem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequentWords {
      /**
       Top K Frequent Words

       Given an array of strings words and an integer k, return the k most frequent strings.

       Return the answer sorted by the frequency from highest to lowest.
       Sort the words with the same frequency by their lexicographical order.

       Example 1:

       Input: words = ["i","love","leetcode","i","love","coding"], k = 2
       Output: ["i","love"]
       Explanation: "i" and "love" are the two most frequent words.
       Note that "i" comes before "love" due to a lower alphabetical order.
       Example 2:

       Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
       Output: ["the","is","sunny","day"]
       Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
      }

      /**
       * O( n^2 log(n)^2 + k )
       */
      List<String> getMostFrequentStrings(int k, String... strArr) {

            HashMap<String, Integer> freqMap = new HashMap<>();

            for (String string : strArr) {
                  if (freqMap.containsKey(string)) {
                        Integer val = freqMap.get(string);
                        val ++;
                        freqMap.put(string, val);
                  } else {
                        freqMap.put(string, 1);
                  }
            }

            List<Map.Entry<String, Integer>> sortedList = new LinkedList<>(freqMap.entrySet());
            sortedList.sort((entry1, entry2) -> {
                  return entry2.getValue().compareTo(entry1.getValue());
            });

            List<String> result = new LinkedList<>();

            for (Map.Entry<String, Integer> entry : sortedList) {
                  result.add(entry.getKey());

                  if (result.size() >= k) break;
            }

            result.sort((e1, e2) -> {
                  return e1.compareToIgnoreCase(e2);
            });

            return result;
      }
      static void testOne() {
            String[] str = {"i","love","leetcode","i","love","coding"};
            int k = 2;
            TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
            List<String> mostFrequentStrings = topKFrequentWords.getMostFrequentStrings(k, str);
            System.out.println(mostFrequentStrings);
            System.out.println();
      }

      static void testTwo() {
            String[] str = {"the","day","is","sunny","the","the","the","sunny","is","is"};
            int k = 4;
            TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
            List<String> mostFrequentStrings = topKFrequentWords.getMostFrequentStrings(k, str);
            System.out.println(mostFrequentStrings);
            System.out.println();
      }
}
