package strings.reverse_string;

/**
 * Write a function that reverses a string.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.

 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:

 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class ReverseString {
      public static void main(String[] args) {
            ReverseString reverseString = new ReverseString();
            reverseString.test1();
            reverseString.test2();
      }

      private void test1() {
            System.out.println("Test 1");

            String str = "hello";

            String reverseStr = reverse(str);

            System.out.println("Str : " + str);
            System.out.println("Ans : " + reverseStr);

            System.out.println();
      }

      private void test2() {
            System.out.println("Test 2");

            String str = "Hannah";

            String reverseStr = reverse(str);

            System.out.println("Str : " + str);
            System.out.println("Ans : " + reverseStr);

            System.out.println();
      }

      private String reverse(String str) {
            char[] chars = str.toCharArray();

            int l = 0; //left pointer
            int r = chars.length - 1; // right pointer

            while (l < r) {
                  //swap left with right
                  char temp = chars[l];
                  chars[l] = chars[r];
                  chars[r] = temp;

                  //move pointers
                  l++;
                  r--;

            }
            return String.valueOf(chars);
      }
}
