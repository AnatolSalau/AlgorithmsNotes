package hash_heap.find_all_anagrams_strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Example 1:
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 * <p>
 * Example 2:
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 */
public class FindAllAnagrams {

      public static void main(String[] args) {
            FindAllAnagrams findAllAnagramsInString = new FindAllAnagrams();
            findAllAnagramsInString.test1();
            findAllAnagramsInString.test2();
      }

      /**

       */
      private List<Integer> findAllAnagramsByUpdateMap(String text, String sample) {
            List<Integer> result = new LinkedList<>();
            char[] textChars = text.toCharArray();

            Map <Character, Integer> currTextMap = null;
            Map <Character, Integer> sampleMap = null;

            for (int l = 0; l < textChars.length; l++) {
                  int r = l + sample.length() - 1;

                  if (r >= textChars.length) return result;

                  if ( currTextMap == null && sampleMap == null) {
                        String currText = text.substring(l, r + 1);
                        currTextMap = initializeFreqMap(currText);
                        sampleMap = initializeFreqMap(sample);
                  } else {
                        Character leftToDelete = textChars[l - 1];

                        char rightToAdd = textChars[r];

                        updateFreqMap(currTextMap,leftToDelete,rightToAdd);
                  }

                  if (currTextMap.equals(sampleMap)) result.add(l);

            }
            return null;
      }

      Map<Character, Integer> initializeFreqMap(String text) {
            char[] characters = text.toCharArray();
            Map<Character, Integer> freqMap = new HashMap<>();

            for (char ch : characters) {
                  if (freqMap.containsKey(ch)) {
                        Integer val = freqMap.get(ch);
                        val += 1;
                        freqMap.put(ch, val);
                  } else {
                        freqMap.put(ch, 1);
                  }
            }
            return freqMap;
      }

      void updateFreqMap(Map <Character, Integer> freqMap, Character left, Character right) {
            if (left != null && freqMap.containsKey(left)) {
                  Integer leftQty = freqMap.get(left);
                  leftQty -= 1 ;
                  freqMap.put(left, leftQty);
                  if (leftQty <= 0) {
                        freqMap.remove(left);
                  }
            }

            if (freqMap.containsKey(right)) {
                  Integer val = freqMap.get(right);
                  val += 1;
                  freqMap.put(right, val);
            } else {
                  freqMap.put(right, 1);
            }
      }

      /*   l    r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
            a b c
            expected result : [0,6]

            l:0 -> isAnagram = true -> add to result
            l    r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
            a b c

            l:1
              l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
              a b c

            l:2
                l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                a b c

            l:3
                  l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                  a b c

            l:4
                    l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                    a b c

            l:5
                      l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                      a b c

            l:6 -> isAnagram = true -> add to result
                        l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                        a b c

            l:7
                          l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                          a b c
            l:8
            r > 9 (length - 1) -> return answer
                            l   r
            0 1 2 3 4 5 6 7 8 9
            c b a e b a b a c d
                            a b c
       */
      void test1() {
            String text = "cbaebabacd";
            String sample = "abc";
            List<Integer> result = findAllAnagramsByUpdateMap(text, sample);
            System.out.println(result);
            System.out.println("Expected : [0,6]");
      }


      void test2() {
            String text = "abab";
            String sample = "ab";
            List<Integer> result = findAllAnagramsByUpdateMap(text, sample);
            System.out.println(result);
            System.out.println("Expected : [0,1,2]");
      }

}
