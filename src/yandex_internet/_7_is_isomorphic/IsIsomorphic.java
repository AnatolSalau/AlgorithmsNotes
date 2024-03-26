package yandex_internet._7_is_isomorphic;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 */
public class IsIsomorphic {
      public static void main(String[] args) {
            IsIsomorphic isIsomorphic = new IsIsomorphic();
            isIsomorphic.testOne();
      }
      /*
            e -> a
            g -> d
            true
      */
      /*
            f -> b
            o -> a, r
            false
       */
      /*
            p -> t
            a -> i
            e -> l
            r -> e
            true
       */
      private boolean isIsomorphic(String str1, String str2) {
            if (str1.length() != str2.length()) return false; //compare lengths

            char[] chars1 = str1.toCharArray();                                                 //O(n)
            char[] chars2 = str2.toCharArray();                                                 //O(m)

            Map<Character, Character> pairMap = new HashMap<>();

            for (int i = 0; i < chars1.length; i++) {
                  char ch1 = chars1[i];                                                         //O(n)
                  char ch2 = chars2[i];                                                         //O(m)

                  if (pairMap.containsKey(ch1)) {
                        Character val = pairMap.get(ch1);
                        if (ch2 != val) return false;
                  } else {
                        pairMap.put(ch1, ch2);
                  }
            }

            return true;                                           //O(m +n)
      }
      private void testOne() {
            System.out.println(isIsomorphic("egg", "add")); // true
            System.out.println("Expected : " + true + "\n");

            System.out.println(isIsomorphic("foo", "bar")); // false
            System.out.println("Expected : " + false + "\n");

            System.out.println(isIsomorphic("paper", "title")); // true
            System.out.println("Expected : " + true + "\n");
      }
}
