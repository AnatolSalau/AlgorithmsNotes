package yandex_internet.same_string_after_deleting;
/**
       Написать функцию, которая вернёт True,
       если из первой строки можно получить вторую,
       совершив не более 1 изменения (== удаление / замена символа).

      a b c d
      a b c
 */
/**
       Let the input strings be s1 and s2 and lengths of input
       strings be m and n respectively.
       1) If difference between m an n is more than 1,
       return false.
       2) Initialize count of edits as 0.
       3) Start traversing both strings from first character.
       a) If current characters don't match, then
       (i)   Increment count of edits
       (ii)  If count becomes more than 1, return false
       (iii) If length of one string is more, then only
       possible  edit is to remove a character.
       Therefore, move ahead in larger string.
       (iv)  If length is same, then only possible edit
       is to  change a character. Therefore, move
       ahead in both strings.
       b) Else, move ahead in both strings.
 */

public class SameStringAfterDeleting {

      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
            testFour();
      }

      /*    expected result = true
            i
            abcd
            j
            abc -> count = 0

             i
            abcd
             j
            abc -> count = 0

              i
            abcd
              j
            abc -> count = 0

              i
            abcd
              j
            abc ->
            i = 2, j = 2, but length1 is 4 , so 4 - 1 = 3 and i < 3
            count = 1 < 2 - answer is true
       */
      private static void testOne() {
            String str1 = "abcd";
            String str2 = "abc";
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(isEditDistanceOne(str1,str2));
            System.out.println("Expected : true" );
      }
      /*    expected result = false
            i
            abcd
            j
            abcd -> count = 0

             i
            abcd
             j
            abcd -> count = 0

              i
            abcd
              j
            abcd -> count = 0

               j
            abcd
               j
            abcd -> count = 0
            count must be 1, because if count = 0 and length strings the same this means result false
            because if we make one change in equals strings - this string wil not be equal
       */
      private static void testTwo() {
            String str1 = "abcd";
            String str2 = "abcd";
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(isEditDistanceOne(str1,str2));
            System.out.println("Expected : false" );
      }
      /*
            i
            abcd
            j
            avcd -> count = 0 i++ j++

             i
            abcd
             j
            avcd -> b != v -> count = 1 i++ j++ (count < 2 so go ahead)
              i
            abcd
              j
            avcd -> count = 1 and length1 == length2 -> i++ j++

               i
            abcd
               j
            avcd -> count = 1 answer is true
       */
      private static void testThree() {
            String str1 = "abcd";
            String str2 = "avcd";
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(isEditDistanceOne(str1,str2));
            System.out.println("Expected : true" );
      }
      /*
            i
            aabcv
            j
            abcv -> count = 0 i++ j++

             i
            aabcv
             j
            abcv -> count = 1, length1 > length2 -> i++

              i
            aabcv
             j
            abcv -> count = 1

              i
            aabcv
             j
            abcv -> count = 1

               i
            aabcv
              j
            abcv -> count = 1

                i
            aabcv
               j
            abcv -> i = 4, j = 3 count = 1 -> answer is true
       */
      private static void testFour() {
            String str1 = "aabcv";
            String str2 = "abcv";
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(isEditDistanceOne(str1,str2));
            System.out.println("Expected : true" );
      }

      static boolean isEditDistanceOne(String s1,
                                       String s2)
      {
            int length1 = s1.length();
            int length2 = s2.length();

            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            // check both string is empty
            if (s1.isEmpty() && s2.isEmpty()) return false;
            // check string lengths is different more than 1
            if (Math.abs(s1.length() - s2.length()) > 1) return false;

            int count = 0;
            int i = 0; //pointer s1
            int j = 0; //pointer s2

            while (i < length1 && j < length2) {
                  char curr1 = c1[i];
                  char curr2 = c2[j];

                  if (curr1 == curr2) {
                        i++;
                        j++;
                  } else {
                        if (length1 > length2) {
                              i++;
                        } else if (length1 < length2) {
                              j++;
                        } else {
                              i++;
                              j++;
                        }
                        count ++;
                  }
            }

            // edge case check, when count = 0, but we have one extra character
            if (i < length1  || j < length2) {
                  count ++;
            }
            //if string is equal count = 0 -> return false
            return count == 1;
      }
}


