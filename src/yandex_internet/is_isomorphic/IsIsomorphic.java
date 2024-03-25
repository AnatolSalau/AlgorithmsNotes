package yandex_internet.is_isomorphic;

import java.util.HashMap;

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
            if (str1.length() != str2.length()) return false;

            int length = str1.length();

            char[] chars1 = str1.toCharArray();
            char[] chars2 = str2.toCharArray();

            HashMap<Character, Character> characterLinksMap= new HashMap<>();

            for (int i = 0; i < length; i++) {
                  char ch1 = chars1[i];
                  char ch2 = chars2[i];

                  if (characterLinksMap.containsKey(ch1)) {
                        Character value = characterLinksMap.get(ch1);
                        if (value != ch2) return false;
                  } else {
                        characterLinksMap.put(ch1,ch2);
                  }
            }

            return true;
      }
      private void testOne() {
            //System.out.println(isIsomorphic("egg", "add")); // true
            System.out.println("Expected : " + true + "\n");

            System.out.println(isIsomorphic("foo", "bar")); // false
            System.out.println("Expected : " + false + "\n");

            //System.out.println(isIsomorphic("paper", "title")); // true
            System.out.println("Expected : " + true + "\n");
      }
}
