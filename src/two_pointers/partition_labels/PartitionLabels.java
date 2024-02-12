package two_pointers.partition_labels;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
       763. Partition Labels

       You are given a string s. We want to partition the string into as many parts as possible
       so that each letter appears in at most one part.

       Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

       Return a list of integers representing the size of these parts.

       Example 1:
       Input: s = "ababcbacadefegdehijhklij"
       Output: [9,7,8]
       Explanation:
       The partition is "ababcbaca", "defegde", "hijhklij".
       This is a partition so that each letter appears in at most one part.
       A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

       Example 2:
       Input: s = "eccbbbbdec"
       Output: [10]
 */
public class PartitionLabels {
      public static void main(String[] args) {
            PartitionLabels partitionLabels = new PartitionLabels();
            partitionLabels.testOne();
            partitionLabels.testTwo();
      }

      /**
       Input: s = "ababcbacadefegdehijhklij"
       Output: [9,7,8]
       Explanation:
       The partition is "ababcbaca", "defegde", "hijhklij".
       This is a partition so that each letter appears in at most one part.
       A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

       */
      private  void testOne() {
            String s = "ababcbacadefegdehijhklij";
            int[] rightAnswer = {9, 7, 8};
            System.out.println(s);
            List<Integer> partitionIndexes = getPartitionIndexesTest(s);

            System.out.println("Test one");
            System.out.println("Right answer : " + Arrays.toString(rightAnswer));
            System.out.println("My answer : " + partitionIndexes);
            System.out.println();
      }

      /**
       Example 2:

       Input: s = "eccbbbbdec"
       Output: [10]
       */
      private  void testTwo() {
            String s = "eccbbbbdec";
            int[] rightAnswer = {10};
            List<Integer> partitionIndexes = getPartitionIndexesTest(s);

            System.out.println("Test two");
            System.out.println("Right answer : " + Arrays.toString(rightAnswer));
            System.out.println("My answer : " + partitionIndexes);
            System.out.println();
      }

      /*    ababcbaca defegde hijhklij
     {a=8, b=5, c=7, d=14, e=15, f=11, g=13, h=19, i=22, j=23, k=20, l=21}
     The partition is "ababcbaca", "defegde", "hijhklij".
      [9,7,8]
      a b a b c b a c a
      partIndex = 0
      length = 0
      for
      char - Max(Map(char), partIndex) -> partIndex = max
      0(a) - 8 or 0 -> partIndex = 8, length = 0
      1(b) - 5 or 8 -> partIndex = 8, length = 1
      2(a) - 8 or 8 -> partIndex = 8, length = 2
      3(b) - 5 or 8 -> partIndex = 8, length = 3
      4(c) - 7 or 8 -> partIndex = 8, length = 4
      5(b) - 5 or 8 -> partIndex = 8, length = 5
      6(a) - 8 or 8 -> partIndex = 8, length = 6
      7(c) - 7 or 8 -> partIndex = 8, length = 7
      8(a) - 8 or 8 -> partIndex = 8, length = 8 ( i == partIndex, length to answer) length = 0
      9(d) - 14 or 9 -> partIndex = 14, length = 1
      10(e) - 15 or 14 -> partIndex = 15, length = 2
      11(f) - 11 or 15 -> partIndex = 15, length = 3
      12(e) - 15 or 15 -> partIndex = 15, length = 4
      13(g) - 13 or 15 -> partIndex = 15, length = 5
      14(d) - 14 or 15 -> partIndex = 15, length = 6
      15(e) - 15 or 15 -> partIndex = 15, length = 6 ( i == partIndex, length to answer) length = 0
      */
      private  List<Integer> getPartitionIndexesTest(String s) {
            List<Integer> partitionLengths = new LinkedList<>();
            char[] chars = s.toCharArray();
            HashMap<Character, Integer> charToLastPositionIndex = getCharToLastPositionIndex(chars);

            int maxRightIndex = 0;
            int currPartitionLength = 0;

            for (int i = 0; i < chars.length; i++) {
                  char curr = chars[i];
                  int currRightIndex = charToLastPositionIndex.get(curr);

                  maxRightIndex = Math.max(currRightIndex, maxRightIndex);
                  currPartitionLength += 1;

                  //if curr index == math right index , hence -> this is the end of curr partition
                  if (i == maxRightIndex) {
                        partitionLengths.add(currPartitionLength);
                        currPartitionLength = 0;
                  }
            }

            return partitionLengths;
      }

      private HashMap<Character, Integer> getCharToLastPositionIndex(char[] chars) {
            HashMap<Character, Integer> lastPositionMap = new HashMap<>();

            for (int i = 0; i < chars.length; i++) {
                  char key = chars[i];
                  lastPositionMap.put(key,i);
            }

            return lastPositionMap;
      }
}
