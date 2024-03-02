package yandex_internet.same_string_after_deleting;
/**
       Написать функцию, которая вернёт True,
       если из первой строки можно получить вторую,
       совершив не более 1 изменения (== удаление / замена символа/добавление).

      Write function that return true
      if we can get second string from first
      do only one change (== deleting / change symbol / adding symbol)

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
            System.out.println();
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
            System.out.println();
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
            System.out.println();
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
            abcv -> i = 4, j = 3 count = 1 -> answer is true
       */
      private static void testFour() {
            String str1 = "aabcv";
            String str2 = "abcv";
            System.out.println(str1);
            System.out.println(str2);
            System.out.println(isEditDistanceOne(str1,str2));
            System.out.println("Expected : true" );
            System.out.println();
      }

      static boolean isEditDistanceOne(String s1, String s2) {
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();

            if (s1.isBlank() || s2.isBlank() || s1 == null || s2 == null) return false;

            // if length strings are different more than 1 char -> return false
            if (Math.abs(s1.length() - s2.length()) > 1) return false;

            int countChanges = 0;

            int i = 0;// pointer in first string
            int j = 0;// pointer in second string

            while (i < chars1.length && j < chars2.length) {

                  if(countChanges > 1) return false; //check count
                  //compare chars
                  if (chars1[i] == chars2[j]) { // if chars equal just move pointer ahead
                       i++;
                       j++;
                  } else {// if chars are different
                        //compare lengths of strings
                        if(chars1.length == chars2.length) { //length the same so move two pointers ahead
                              i++;
                              j++;
                        } else { // length are different so move ahead in more long string
                              if (chars1.length > chars2.length) { //move in first string
                                    i++;
                              } else {// move in second  string
                                    j++;
                              }
                        }
                        countChanges++;
                  }
            }
            // if count changes = 0 and length the same-> strings are equal and we
            //cannot to change this string -> so answer is false
            if (countChanges == 0 && s1.length() == s2.length()) return false;

            return true;
      }
}


