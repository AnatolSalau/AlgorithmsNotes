package hash_heap.group_anagrams;

import java.util.*;

/**
       Given an array of strings strs, group the anagrams together.
       You can return the answer in any order.

       An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
       typically using all the original letters exactly once.

       Example 1:
       Input: strs = ["eat","tea","tan","ate","nat","bat"]
       Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

       Example 2:
       Input: strs = [""]
       Output: [[""]]

       Example 3:
       Input: strs = ["a"]
       Output: [["a"]]
 */
public class GroupAnagrams {
      public static void main(String[] args) {
            GroupAnagrams groupAnagrams = new GroupAnagrams();
            groupAnagrams.test1();
            groupAnagrams.test2();
            groupAnagrams.test3();
      }

      private void test1() {
            String[] str = {"eat","tea","tan","ate","nat","bat"};
            String[][] expectedResult = {{"bat"},{"nat","tan"},{"ate","eat","tea"}};

            System.out.println("test1");
            System.out.println(Arrays.toString(str));
            System.out.println("Result : " + groupAnagrams(str));
            System.out.println("Expected: " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void test2() {
            String[] str = {""};
            String[][] expectedResult = {{""}};

            System.out.println("test2");
            System.out.println(Arrays.toString(str));
            System.out.println("Result : " + groupAnagrams(str));
            System.out.println("Expected: " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private void test3() {
            String[] str = {"a"};
            String[][] expectedResult = {{"a"}};

            System.out.println("test3");
            System.out.println(Arrays.toString(str));
            System.out.println("Result : " + groupAnagrams(str));
            System.out.println("Expected: " + Arrays.deepToString(expectedResult));
            System.out.println();
      }

      private List<List<String>> groupAnagrams(String[] str) {
            Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();
            for (String st : str) {
                  Map<Character, Integer> key = getFreqMap(st);
                  if (anagramMap.containsKey(key)) {
                        List<String> value = anagramMap.get(key);
                        value.add(st);
                        anagramMap.put(key,value);
                  } else {
                        List<String> value = new LinkedList<>();
                        value.add(st);
                        anagramMap.put(key,value);
                  }
            }
            List<List<String>> result = new ArrayList<>();
            Collection<List<String>> values = anagramMap.values();
            for (List<String> val : values) {
                  result.add(val);
            }

            return result;
      }

      private Map<Character, Integer> getFreqMap(String str) {
            Map<Character, Integer> freqMap = new HashMap<>();
            char[] chars = str.toCharArray();
            for (char key : chars ) {
                  if (freqMap.containsKey(key)) {
                        Integer count = freqMap.get(key);
                        count ++;
                        freqMap.put(key, count);
                  } else {
                        freqMap.put(key, 1);
                  }
            }

            return freqMap;
      }
}
