package tinkof_interview.array_string.subsequence_in_string;

public class SubsequenceInString {
      public boolean isSubsequence(String s, String t) {
            return false;
      }

      public void test1() {
            String s1 = "abc";
            String s2 = "ahbgdc";

            boolean isSubsequence = isSubsequence(s1, s2);
            System.out.println("Test1");
            System.out.println(isSubsequence);
            System.out.println("Expected : true");
            System.out.println();
      }

      public void test2() {
            String s1 = "axc";
            String s2 = "ahbgdc";

            boolean isSubsequence = isSubsequence(s1, s2);
            System.out.println("Test2");
            System.out.println(isSubsequence);
            System.out.println("Expected : false");
            System.out.println();
      }

      public static void main(String[] args) {
            SubsequenceInString subsequenceInString = new SubsequenceInString();
            subsequenceInString.test1();
            subsequenceInString.test2();
      }

}
