package strings.find_indexes_substrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 28. Find the Indexes of the All Occurrence in a String
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0, 6
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0 and 6 , so we return 0 and 6.
 * <p>
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 * <p>
 * Example 3:
 * Input: haystack = "aabaabaaaaaabaabaabaabbaaab", needle = "aabaab"
 * Output: 0, 10, 13, 16
 */
public class FindIndexesSubstringKMP {
      public static void main(String[] args) {
            FindIndexesSubstringKMP findIndexesSubstringPower = new FindIndexesSubstringKMP();
            findIndexesSubstringPower.test1();
            findIndexesSubstringPower.test2();
            findIndexesSubstringPower.test3();
            findIndexesSubstringPower.test4();
            //findIndexesSubstringPower.testPrefixFunction();
      }

      private void test1() {
            String text = "sadbutsad";
            String sample = "sad";
            String expect = "[0, 6]";
            List<Integer> indexesSubstring = getIndexesKMP(text, sample);

            System.out.println("Test 1");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Sample prefix table : " + Arrays.toString(getPrefixTable(sample)));
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void test2() {
            String text = "leetcode";
            String sample = "leeto";
            String expect = "-1";
            List<Integer> indexesSubstring = getIndexesKMP(text, sample);

            System.out.println("Test 2");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Sample prefix table : " + Arrays.toString(getPrefixTable(sample)));
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void test3() {
            String text = "aabaabaaaaaabaabaabaabbaaab";
            String sample = "aabaab";
            String expect = "0, 10, 13, 16";
            List<Integer> indexesSubstring = getIndexesKMP(text, sample);

            System.out.println("Test 3");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Sample prefix table : " + Arrays.toString(getPrefixTable(sample)));
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void test4() {
            String text = "abcabab abababaabac";
            String sample = "ababaaba";
            String expect = "10";
            List<Integer> indexesSubstring = getIndexesKMP(text, sample);

            System.out.println("Test 4");
            System.out.println("Text : " + text);
            System.out.println("Sample : " + sample);
            System.out.println("Sample prefix table : " + Arrays.toString(getPrefixTable(sample)));
            System.out.println("Expect : " + expect);
            System.out.println("Answer : " + indexesSubstring);
            System.out.println();
      }

      private void testPrefixFunction() {
            String sample1 = "aabaa";
            int[] prefixTable = getPrefixTable(sample1);
            System.out.println("Sample 1 : " + sample1);
            System.out.println("Expected : " + "[0 1 0 1 2]");
            System.out.println(Arrays.toString(prefixTable));
            System.out.println();

            String sample2 = "aabaab";
            int[] prefixTable2 = getPrefixTable(sample2);
            System.out.println("Sample 2 : " + sample2);
            System.out.println("Expected : " + "[0 1 0 1 2 3]");
            System.out.println(Arrays.toString(prefixTable2));
            System.out.println();

            String sample3 = "sad";
            int[] prefixTable3 = getPrefixTable(sample3);
            System.out.println("Sample 3 : " + sample3);
            System.out.println("Expected : " + "[0 0 0]");
            System.out.println(Arrays.toString(prefixTable3));
            System.out.println();
      }

      /*
            text = sadbutsad
            sample = sad

            i
            sadbutsad
            sad
            j
       */

      /**
       *    O(n+m)
       */
      /*

      text = abcabab abababaabac
      sample = ababaaba
               0  1  2  3  4  5  6  7
      table = [0, 0, 1, 2, 3, 1, 2, 3]

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 : t (text index)
a b c a b a b _ a b a  b  a  b  a  a  b  a  c
. . t
. . s
0 1 2 3 4 5 6 7 : s (sample index)
a b a b a a b a  -> c != a -> s = table[s - 1] = table[2 - 1] = 0
    t
    s
    0 1 2 3 4 5 6 7
    a b a b a a b a -> c != a && s == 0 move -> forward
      t . . . t
      s . . . s
      0 1 2 3 4 5 6 7
      a b a b a a b a -> _ != a -> s = table[s - 1] = table[4 - 1] = 2
              t
              s
          0 1 2 3 4 5 6 7
          a b a b a a b a -> _ != a -> s = table[s - 1] = table[2 - 1] = 0
              t
              s
              0 1 2 3 4 5 6 7
              a b a b a a b a -> _ != a && s == 0 move -> forward

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 : t (text index)
a b c a b a b _ a b a  b  a  b  a  a  b  a    c
                t . .  .  .  t
                s . .  .  .  s
                0 1 2  3  4  5  6  7
                a b a  b  a  a  b  a -> b != a -> s = table[s - 1] = table[5 - 1] = 3

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 : t (text index)
a b c a b a b _ a b a  b  a  b  a  a  b  a    c
                             t  .  .  .  t
                             s  .  .  .  s
                    0  1  2  3  4  5  6  7
                    a  b  a  b  a  a  b  a - > a == a && s == last index in sample -> add to result
                                               s = table[s - 1] = table[7 - 1] = 1
                                         t
                                         s
                                      0  1  2  3  4  5  6  7
                                      a  b  a  b  a  a  b  a -> a != b -> s = table[s - 1] = table[1 - 1] = 0
                                         t    t
                                         s    s
                                         0    1  2  3  4  5  6  7
                                         a    b  a  b  a  a  b  a -> c != b && s == 0 -> move forward
                                              t
                                              s
                                              0    1  2  3  4  5  6  7
                                              a    b  a  b  a  a  b  a -> c != b && s == 0 -> move forward
                                              t >= text length - exit from program
       */
      private List<Integer> getIndexesKMP(String text, String sample) {
            ArrayList<Integer> found = new ArrayList<>();

            int[] prefixTable = getPrefixTable(sample);

            char[] textArr = text.toCharArray();
            char[] sampleArr = sample.toCharArray();

            int t = 0; // text pointer
            int s = 0; // sample pointer
            while (t < textArr.length) {
                  char textChar = textArr[t];
                  char sampleChar = sampleArr[s];

                  if (textChar == sampleChar) { // chars are equal
                        if (s >= sample.length() - 1) { // we in the end of sample
                              found.add(t - s); // add start index to result
                              s = prefixTable[s - 1]; // move only sample
                        } else {// we not in the end of sample
                              t++;// move forward both indexes
                              s++;
                        }

                  } else {// chars are not equal
                        if (s == 0) { //we in the start of sample
                              t++;// move forward both indexes
                              s++;
                        } else {
                              s = prefixTable[s - 1]; // move only sample
                        }
                  }
            }

            return found;
      }
      /*
            sample = a a b a a b
            table    0 0 0 0 0 0
 a a b a a b
 a a b a a b
 0 0 0 0 0 0 - 0 is always 0
   a a b a a b
 0 1 0 0 0 0
     a a b a a b
 0 1 0 0 0 0
       a a b a a b
 0 1 0 1 2 3
         a a b a a b
 0 1 0 1 2 3
           a a b a a b
 0 1 0 1 2 3
       */
      /*
      text = sad
      sample = sad

      s a d
      s a d
      0 0 0
        s a d
      0 0 0
          s a d
      0 0 0
       */
      /*
 text = a a b a a
 sample = a a b a a
 a a b a a
 a a b a a

 0 0 0 0 0
   a a b a a
 0 1 0 0 0
     a a b a a
 0 1 0 0 0
       a a b a a
 0 1 0 1 2

       */
      private int[] getPrefixTable(String sample) {
            char[] text = sample.toCharArray();
            int[] table = new int[text.length];

            for (int i = 1; i < text.length; i++) {
                  int s = 0;//index in sample
                  while (s < text.length) {
                        int t = i + s; //index in text

                        if (t >= text.length) break;// check boundary of array

                        if (text[t] == text[s]) {//compare char from text with char from sample

                              table[t] = Math.max(table[t], s + 1);//add only max prefix
                              s++;
                        } else { //if char different move sample forward
                              break;
                        }
                  }
            }
            return table;
      }
}
