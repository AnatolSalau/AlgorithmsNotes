package strings.is_anagram;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.



 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 */
public class IsAnagram {
      public static void main(String[] args) {
            IsAnagram isAnagram = new IsAnagram();
            isAnagram.testOne();
      }
      private boolean isAnagram (String str1, String str2) {
            Map<Character, Integer> map1 = getFreqCharMap(str1);
            Map<Character, Integer> map2 = getFreqCharMap(str2);

            return map1.equals(map2);
      }

      private Map<Character, Integer> getFreqCharMap(String str) {
            Map<Character, Integer> freqMap = new HashMap<>();
            char[] characters = str.toCharArray();

            for (char ch : characters) {
                        int qty = freqMap.getOrDefault(ch, 0);
                        qty += 1;
                        freqMap.put(ch,qty);
            }

            return freqMap;
      }
      private void testOne() {
            System.out.println(isAnagram("фара ", "а рфа")); // true
            System.out.println("Expected : " + true + "\n");
            System.out.println(isAnagram("каркас", "краска")); // true
            System.out.println("Expected : " + true + "\n");
            System.out.println(isAnagram("север", "сервер")); // false, разная длина
            System.out.println("Expected : " + false + "\n");
            System.out.println(isAnagram("север", "ветер")); // false, разные буквы
            System.out.println("Expected : " + false + "\n");
      }
}
