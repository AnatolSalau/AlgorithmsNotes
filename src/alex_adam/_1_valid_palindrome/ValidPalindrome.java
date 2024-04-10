package alex_adam._1_valid_palindrome;
/**
 https://leetcode.com/problems/valid-palindrome/description/
 A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 and removing all non-alphanumeric characters,
 it reads the same forward and backward. Alphanumeric characters include letters and numbers.

 Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {
      public static boolean validPalindrome(String s) {
            if (s.isBlank() || s == null ) return false;

            if (s.length() == 1) return true;

            s = s.toLowerCase();

            s.replaceAll("[^a-zA-Z\\s”,]", "");

            char[] chars =s.toCharArray();

            int middleIndex = s.length() / 2;

            if (s.length() % 2 == 0) { // even length
                  return isPalindrome(chars,0,middleIndex + 1,s.length() - 1, middleIndex - 1);
            } else { //odd length
                  return isPalindrome(chars,0,middleIndex ,s.length() - 1, middleIndex);
            }

      }

      public static boolean isPalindrome(char[] chars, int fromLeft, int toLeft, int fromRightReverse, int toRightReverse) {
            while (fromLeft < toLeft && fromRightReverse > toRightReverse) {
                  if (chars[fromLeft] != chars[fromRightReverse]) return false;
                  fromLeft++;
                  fromRightReverse--;
            }
            return true;
      }

      public static void main(String[] args) {
            test1();
            test2();
            test3();
      }

      public static void test1() {
            System.out.println("Test1");
            String s = "abca";
            boolean result = validPalindrome(s);
            System.out.println(s);
            System.out.println(result);

            System.out.println();
      }

      public static void test2() {
            System.out.println("Test2");
            String s = "aba";
            boolean result = validPalindrome(s);
            System.out.println(s);
            System.out.println(result);

            System.out.println();
      }

      public static void test3() {
            System.out.println("Test3");
            String s = "abc";
            boolean result = validPalindrome(s);
            System.out.println(s);
            System.out.println(result);

            System.out.println();
      }

}
