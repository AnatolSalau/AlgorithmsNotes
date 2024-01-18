package hash_heap.find_all_permutation;

import java.util.HashMap;
import java.util.Map;

/**
 Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

 In other words, return true if one of s1's permutations is the substring of s2.

 Example 1:

 Input: s1 = "ab", s2 = "eidbaooo"
 Output: true
 Explanation: s2 contains one permutation of s1 ("ba").
 Example 2:

 Input: s1 = "ab", s2 = "eidboaoo"
 Output: false
 */
public class FindAllPermutation {
      public static void main(String[] args) {
            FindAllPermutation findAllPermutation = new FindAllPermutation();
            findAllPermutation.test1();
            findAllPermutation.test2();
      }

      private void test1() {
            String str1 = "eidbaooo";
            String str2 = "ab";
            String expected = "true";

            boolean isPermutation = isPermutation(str1, str2);

            System.out.println("Test 1");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("Is permutation : " + isPermutation);
            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private void test2() {
            String str1 = "eidboaoo";
            String str2 = "ab";
            String expected = "true";

            boolean isPermutation = isPermutation(str1, str2);

            System.out.println("Test 1");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("Is permutation : " + isPermutation);
            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private boolean isPermutation(String str1, String str2) {
            int length1 = str1.length();
            int length2 = str2.length();

            char[] char1 = str1.toCharArray();
            char[] char2 = str2.toCharArray();

            if (length1 >= length2) {
                  for (int l = 0; l < length1; l++) {
                        int r = l + length2;
                        if (r > length1) break;
                        Map<Character, Integer> substringFreqMap = new HashMap<>();
                        for (int i = l; i <= r; i++) {
                             updateFreqMap(substringFreqMap, char1[i]);
                        }
                  }
            } else {
                  for (int l = 0; l < length2; l++) {
                        int r = l + length1;
                        if (r > length2) break;
                  }
            }
            return false;
      }

      Map<Character, Integer> getFreqMap(String text) {
            char[] characters = text.toCharArray();
            Map<Character, Integer> freqMap = new HashMap<>();

            for (char ch : characters) {
                  updateFreqMap(freqMap, ch);
            }
            return freqMap;
      }

      Map<Character, Integer> updateFreqMap(Map<Character, Integer> freqMap, char ch) {
                  if (freqMap.containsKey(ch)) {
                        Integer val = freqMap.get(ch);
                        val += 1;
                        freqMap.put(ch, val);
                  } else {
                        freqMap.put(ch, 1);
                  }
            return freqMap;
      }

}
