package tinkof_interview.array_string.longest_substring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 Given a string s, find the length of the longest
 substring
 without repeating characters.

 Example 1:
 Input: s = "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.

 Example 2:
 Input: s = "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.

 Example 3:
 Input: s = "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
 Notice that the answer must be a substring,
 "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {
      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }
      public static int lengthOfLongestSubstring(String s) {
            if (s.isEmpty()) return 0;
            if (s.isBlank()) return 1;
            char[] split = s.toCharArray(); //O(n + k) -> O(n)

            int i = 0;
            int maxSize = 0;
            Set<Character> charSet = new HashSet<>();

            for (int j = 0; j < split.length; j++) {
                  while (charSet.contains(split[j])) {
                        charSet.remove(split[i]);
                        i++;
                  }
                  charSet.add(split[j]);
                  maxSize = Math.max(maxSize, charSet.size());
            }

            return maxSize;
      }

      public static int lengthOfLongestSubstringOptimized(String s) {
            //best solution, start with thinking about what data structures we have avaiable.
            //Sliding Window HashMap Algorithm.
            int maxLength = 0;
            Map<Character, Integer> checkedCharacters = new HashMap<>();

            for(int right= 0, left = 0; right < s.length(); right++){//initialising our pointers.
                  char currentCharacter = s.charAt(right);
                  if(
                        checkedCharacters.containsKey(currentCharacter)
                        &&
                        checkedCharacters.get(currentCharacter) >= left
                  ){
                        left = checkedCharacters.get(currentCharacter) + 1;
                  }
                  maxLength = Math.max(maxLength, right - left + 1);
                  checkedCharacters.put(currentCharacter, right);
            }
            return maxLength;
      }

      public static void test1() {
            String s = "abcabcbb";
            int expect = 3;
            System.out.println("test1");
            System.out.println("expected = " + expect);
            System.out.println(lengthOfLongestSubstring(s));
            System.out.println();
      }

      public static void test2() {
            String s = "bbbbb";
            int expect = 1;
            System.out.println("test2");
            System.out.println("expected = " + expect);
            System.out.println(lengthOfLongestSubstring(s));
            System.out.println();
      }

      public static void test3() {
            String s = "pwwkew";
            int expect = 3;
            System.out.println("test3");
            System.out.println("expected = " + expect);
            System.out.println(lengthOfLongestSubstring(s));
            System.out.println();
      }
}
