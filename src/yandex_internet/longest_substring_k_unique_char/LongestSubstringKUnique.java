package yandex_internet.longest_substring_k_unique_char;

import java.util.HashMap;

/**
       Для заданной строки s и целого числа k вернуть длину самой длинной подстроки s,
       содержащей не более k различных символов.

       Input: s = "eceba", k = 2
       Output: 3 [ece]
 */
/*
      1. Go through arr
            add new char with qty in map
            if length map less or equal k -> go ahead
                        calculate window size
            else move l pointer forward -> decrease qty in map (remove char if necessary)


 */
public class LongestSubstringKUnique {

      public static void main(String[] args) {
            testOne();
            testTwo();
      }
      /*
            target K - max quantity unique char in substring
            Explanation:

            1. Initialize frequency map (char->quantity)
                  -> initialize freqMap by first character from arr

            2. Initialize sliding window l(left pointer) r(right pointer) from start arr
                  - we keep quantity chars in our sliding window by frequency map
                  - save max size sliding window - every iteration (math function) - our answer

            3. Go through arr
                  - if qty in freq map (size freq map) less or equal K
                        -> update max size of sliding window
                        -> move right pointer forward
                        -> add new char to frequency map
                  - if qty in freq map more than K
                        -> move left pointer forward
                        -> decrease quantity in frequency map or remove char in qty is 0
            4. Return max size sliding window

            0 1 2 3
              l   r
       */
      static int geMaxLengthSubstringWithKDistinctChar(String s, int k) {
            char[] arr = s.toCharArray();
            HashMap<Character, Integer> freqMap = new HashMap<>(); //frequency map (char->quantity)
            //initialize freqMap by first character
            freqMap.put(arr[0], 1);
            int maxWindowSize = 0; // max size sliding window - our answer

            int l = 0;
            int r =0;

            while (l < arr.length && r < arr.length) {                                                //O(2n)
                  int currWindowSize = r - l + 1;

                  if(freqMap.size() <= k) { // if freqMap size is right
                        maxWindowSize = Math.max(currWindowSize, maxWindowSize); // update max size of sliding window
                        r++; // move right pointer forward
                        if (r < arr.length) { // check null pointer exception
                              increaseFreqMap(freqMap,arr[r]);// add new char to frequency map  //O(2)
                        }

                  } else {// if freqMap size is wrong
                        decreaseFreqMap(freqMap, arr[l]);//decrease quantity in frequency map or remove char in qty is 0      //O(1)
                        l++;// move left pointer forward
                  }
            }

            return maxWindowSize; // O(2n) + O(2) + O(1) = O(n)
      }

      static void increaseFreqMap(HashMap<Character, Integer> freqMap, Character newChar) {
            if (freqMap.containsKey(newChar)) {
                  Integer qty = freqMap.get(newChar);
                  qty++;
                  freqMap.put(newChar, qty);
            } else {
                  freqMap.put(newChar,1);
            }
      }

      static void decreaseFreqMap(HashMap<Character, Integer> freqMap, Character ch) {
            if (freqMap.containsKey(ch)) {
                  Integer qty = freqMap.get(ch);
                  qty--;
                  if (qty > 0) {
                        freqMap.put(ch, qty);
                  } else {
                        freqMap.remove(ch);
                  }
            }
      }
      /*    k = 2, expected result = 4

          i:0 1 2 3 4 5
            a a b b c c       a -> 1, mapSize = 1, windowsLength = 1
           lr

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 1, windowsLength = 2
            l r

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 2, windowsLength = 3
            l   r             b -> 1

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 2, windowsLength = 4
            l     r           b -> 2

          i:0 1 2 3 4 5
            a a b b c c       a -> 2, mapSize = 3 -> 3 > k(2) -> l++, and decrease count in map a->1,
            l l     r         b -> 2
                              c -> 1

          i:0 1 2 3 4 5
            a a b b c c       a -> 1, mapSize = 3 -> 3 > k(2) -> l++, and decrease count in map a->0, and delete a from map becouse count is 0
              l l     r       b -> 2
                              c -> 1
       */
      public static void testOne() {
            String s = "aabbcc";
            int k = 2;
            int expectedResult = 4;
            System.out.println("Test 1");
            System.out.println(s);
            System.out.println(geMaxLengthSubstringWithKDistinctChar(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }
      /* k=2, expectedResult = 3
         i: 0  1  2  3  4
            e  c  e  b  a     e -> 1, mapSize = 1 <= k(2), windowsLength = 1
           lr

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 1, mapSize = 2 <= k(2), windowsLength = 2
            l  r              c -> 1

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 2, mapSize = 2 <= k(2), windowsLength = 3
            l     r           c -> 1

         i: 0  1  2  3  4
            e  c  e  b  a     e -> 2, mapSize = 3 > k(2) -> move l++, decrease count      e -> 1, mapSize = 3 ->
            l  l  l  r        c -> 1                                                      c -> 1
                              b -> 1                                                      b -> 1

         ->  3 > k(2) -> move l++, decrease count (count = 0 - delete from map) -> e -> 1, mapSize = 2

          i: 0  1  2  3  4
             e  c  e  b  a    e -> 1, mapSize = 2 > k(2) -> move l++
                   l     r    b -> 1
                              a -> 1
       */
      public static void testTwo() {
            String s = "eceba";
            int k = 2;
            int expectedResult = 3;
            System.out.println("Test 2");
            System.out.println(s);
            System.out.println(geMaxLengthSubstringWithKDistinctChar(s,k));
            System.out.println("Expected result : " + expectedResult);
            System.out.println();
      }

}

