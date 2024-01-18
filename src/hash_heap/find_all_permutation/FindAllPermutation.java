package hash_heap.find_all_permutation;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
 * In other words, return true if one of s1's permutations is the substring of s2.
 *
 * Example 1:
 * Input: s1 = "ab", s2 = "eidbaooo"
 * Output: true
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input: s1 = "ab", s2 = "eidboaoo"
 * Output: false
 */
public class FindAllPermutation {
      public static void main(String[] args) {
            FindAllPermutation findAllPermutation = new FindAllPermutation();
            findAllPermutation.test1();
            findAllPermutation.test2();
            findAllPermutation.test3();
            findAllPermutation.test4();
      }

      private void test1() {
            String str1 = "ab";
            String str2 = "eidbaooo";
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
            String str1 = "ab";
            String str2 = "eidboaoo";
            String expected = "false";

            boolean isPermutation = isPermutation(str1, str2);

            System.out.println("Test 2");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("Is permutation : " + isPermutation);
            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private void test3() {
            String str1 = "adc";
            String str2 = "dcda";
            String expected = "true";

            boolean isPermutation = isPermutation(str1, str2);

            System.out.println("Test 3");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("Is permutation : " + isPermutation);
            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private void test4() {
            String str1 = "ad";
            String str2 = "a";
            String expected = "false";

            boolean isPermutation = isPermutation(str1, str2);

            System.out.println("Test 4");
            System.out.println(str1);
            System.out.println(str2);
            System.out.println("Is permutation : " + isPermutation);
            System.out.println("Expected = " + expected);
            System.out.println();
      }

      private boolean isPermutation(String str1, String str2) {
            int length1 = str1.length();
            int length2 = str2.length();

            if (length1 > length2) return false;

            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            if (length1 == 1 && length2 == 1 && chars1[0] == chars2[0]) return true;


            if (length1 >= length2) {
                  //go through chars1
                  Map<Character, Integer> currTextFreqMap = getFreqMap(chars1, 0, length2);
                  Map<Character, Integer> sampleFreqMap = getFreqMap(chars2, 0, length2);

                  for (int l = 0; l < length1; l++) {
                        int r = l + length2;
                        if (r > length1) return false;

                        if (currTextFreqMap.equals(sampleFreqMap)) return true;

                        removeLeftFromFreqMap(currTextFreqMap, chars1[l]);

                        if (r  < length1) {
                              addRightToFreqMap(currTextFreqMap, chars1[r]);
                        }
                  }

            } else {
                  //go through chars2
                  Map<Character, Integer> currTextFreqMap = getFreqMap(chars2, 0, length1);
                  Map<Character, Integer> sampleFreqMap = getFreqMap(chars1, 0, length1);

                  for (int l = 0; l < length2; l++) {
                        int r = l + length1;
                        if (r > length2) return false;

                        if (currTextFreqMap.equals(sampleFreqMap)) return true;

                        removeLeftFromFreqMap(currTextFreqMap, chars2[l]);

                        if (r < length2) {
                              addRightToFreqMap(currTextFreqMap, chars2[r]);
                        }
                  }

            }
            return false;
      }

      private void addRightToFreqMap(Map<Character, Integer> currTextFreqMap, char c) {
            if (currTextFreqMap.containsKey(c)) {
                  Integer count = currTextFreqMap.get(c);
                  count++;
                  currTextFreqMap.put(c,count);
            } else {
                  currTextFreqMap.put(c,1);
            }
      }

      private void removeLeftFromFreqMap(Map<Character, Integer> currTextFreqMap, char c) {
            if (currTextFreqMap.containsKey(c)) {
                  Integer count = currTextFreqMap.get(c);
                  count--;
                  if (count <= 0) {
                        currTextFreqMap.remove(c);
                        return;
                  }
                  currTextFreqMap.put(c,count);
            }
      }

      Map<Character, Integer> getFreqMap(char[] text, int startIndex, int endIndex) {
            Map<Character, Integer> freqMap = new HashMap<>();

            for (int i = 0; i < endIndex; i++) {
                  addCharToFreqMap(freqMap, text[i]);
            }

            return freqMap;
      }

      Map<Character, Integer> addCharToFreqMap(Map<Character, Integer> freqMap, char ch) {
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
