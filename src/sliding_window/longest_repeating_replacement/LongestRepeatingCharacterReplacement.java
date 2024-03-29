package sliding_window.longest_repeating_replacement;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
       You are given a string s and an integer k.
       You can choose any character of the string and change it to any other uppercase English character.
       You can perform this operation at most k times.

       Return the length of the longest substring containing the same letter
       you can get after performing the above operations.

       Example 1:

       Input: s = "ABAB", k = 2
       Output: 4
       Explanation: Replace the two 'A's with two 'B's or vice versa.

       Example 2:

       Input: s = "AABABBA", k = 1
       Output: 4
       Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
       The substring "BBBB" has the longest repeating letters, which is 4.
       There may exists other ways to achieve this answer too.
 */
public class LongestRepeatingCharacterReplacement {
      public static void main(String[] args) {
            LongestRepeatingCharacterReplacement characterReplacement = new LongestRepeatingCharacterReplacement();
            characterReplacement.test1();
            characterReplacement.test2();
            characterReplacement.test3();
      }

      private  int getMaxRepeatingOfElements(String str, int k) {
            char[] letters = str.toCharArray();
            int l = 0; // start index
            int r = 0; // end index
            int maxLength = 1;

            Map<Character, Integer> charFreqMap = new HashMap<>(); // initialize char freq map
            charFreqMap.put(letters[r], 1); // put to freq map default value

            while (r < letters.length) {

                  int length = r - l + 1;

                  int maxFreq = getMaxFreq(charFreqMap);

                  int possibleChanges = length - maxFreq;

                  if (possibleChanges <= k) { // update possible changes only if it corresponds  k
                        maxLength = Math.max(length, maxLength);
                  }

                  if (possibleChanges <= k) {
                        r++;
                        if (r<letters.length) { // check right bound of arr before add next char in map
                              char right = letters[r];
                              addAndUpdateFreq(right, charFreqMap);
                        }
                  } else {
                        char left = letters[l];
                        reduceAndUpdateFreq(left, charFreqMap);
                        l++;
                  }

            }
            return maxLength;
      }



      private void addAndUpdateFreq(char key, Map<Character, Integer> charFreqMap) {
            if (charFreqMap.containsKey(key)) {
                  int count = charFreqMap.get(key);
                  count ++;
                  charFreqMap.put(key,count);
            } else {
                  charFreqMap.put(key,1);
            }
      }

      private void reduceAndUpdateFreq(char key, Map<Character, Integer> charFreqMap) {
            if (charFreqMap.containsKey(key)) {
                  int count = charFreqMap.get(key);
                  count -- ;

                  if (count == 0) {
                        charFreqMap.remove(key);
                  } else {
                        charFreqMap.put(key,count);
                  }
            }
      }

      private int getMaxFreq(Map<Character, Integer> charFreqMap) {
            Collection<Integer> values = charFreqMap.values();
            Integer max = Collections.max(values);
            return max;
      }

      /*
      i:    0 1 2 3 4 5 6
            a a b c c b b, k = 2, expected = 5 (bbbbb)

      i:1
            0 1 2 3 4 5 6
            a a b c c b b
           se
           a->1
           maxFreq = 1
           possibleChanges = length - maxFreq = 1 - 1 = 0 -> ( if possibleChanges <= k -> maxLength = 1)
           possibleChanges <= k = 0 <= 2 -> e++
      i:2
            0 1 2 3 4 5 6
            a a b c c b b
            s e
           a->2
           maxFreq = 2
           possibleChanges = length - maxFreq = 2 - 2 = 0 -> ( if possibleChanges <= k -> maxLength = 2)
           possibleChanges <= k = 0 <= 2 -> e++
      i:2
            0 1 2 3 4 5 6
            a a b c c b b
            s   e
           a->2
           b->1
           maxFreq = 2
           possibleChanges = length - maxFreq = 3 - 2 = 1 -> ( if possibleChanges <= k -> maxLength = 3)
           possibleChanges <= k = 1 <= 2 -> e++
      i:3
            0 1 2 3 4 5 6
            a a b c c b b
            s     e
           a->2
           b->1
           c->1
           maxFreq = 2
           possibleChanges = length - maxFreq = 4 - 2 = 2 -> ( if possibleChanges <= k -> maxLength = 4)
           possibleChanges <= k = 2 <= 2 -> e++
       i:4
            0 1 2 3 4 5 6
            a a b c c b b
            s       e
           a->2
           b->1
           c->2
           maxFreq = 2
           possibleChanges = length - maxFreq = 5 - 2 = 3 -> ( if possibleChanges <= k -> maxLength = 4) skip
           possibleChanges <= k = 3 <= 2 -> s++
       i:5
            0 1 2 3 4 5 6
            a a b c c b b
              s     e
           a->1
           b->1
           c->2
           maxFreq = 2
           possibleChanges = length - maxFreq = 4 - 2 = 2 -> ( if possibleChanges <= k -> maxLength = 4)
           possibleChanges <= k = 2 <= 2 -> e++
       i:6
            0 1 2 3 4 5 6
            a a b c c b b
              s       e
           a->1
           b->2
           c->2
           maxFreq = 2
           possibleChanges = length - maxFreq = 5 - 2 = 3 -> ( if possibleChanges <= k -> maxLength = 4) skip
           possibleChanges <= k = 3 <= 2 -> s++
       i:6
            0 1 2 3 4 5 6
            a a b c c b b
                s     e
           b->2
           c->2
           maxFreq = 2
           possibleChanges = length - maxFreq = 4 - 2 = 2 -> ( if possibleChanges <= k -> maxLength = 4)
           possibleChanges <= k = 2 <= 2 -> e++
       i:7
            0 1 2 3 4 5 6
            a a b c c b b
                s       e
           b->3
           c->2
           maxFreq = 3
           possibleChanges = length - maxFreq = 5 - 3 = 2 -> ( if possibleChanges <= k -> maxLength = 5)
           possibleChanges <= k = 2 <= 2 -> e++ -> e >= array.length - 1 (7 - 1)
       */
      private void test1() {
            System.out.println("Test 1");
            String str = "aabccbb";
            int k = 2;
            int expected = 5;
            String longestRepeating = "bbbbb";
            int result = getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("k= " + k);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected  + " " + longestRepeating);
            System.out.println();
      }

      private void test2() {
            System.out.println("Test 2");
            String str = "abbcb";
            int k = 1;
            int expected = 4;
            String longestRepeating = "bbbb";
            int result = getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("k= " + k);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected  + " " + longestRepeating);
            System.out.println();
      }

      private void test3() {
            System.out.println("Test 3");
            String str = "abccde";
            int k = 1;
            int expected = 3;
            String longestRepeating = "ccc";
            int result = getMaxRepeatingOfElements(str, k);
            System.out.println(str);
            System.out.println("k= " + k);
            System.out.println("Result : " + result);
            System.out.println("Expected : " + expected + " " + longestRepeating);

            System.out.println();
      }
}
