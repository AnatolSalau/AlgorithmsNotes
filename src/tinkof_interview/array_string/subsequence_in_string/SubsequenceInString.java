package tinkof_interview.array_string.subsequence_in_string;

public class SubsequenceInString {
      public boolean isSubsequenceByRecursion(String s, String t) {

            return recursiveComparing(s, t, s.length()-1, t.length()-1);
      }

      public boolean recursiveComparing(String s, String t, int len1, int len2) {
            if (len1 < 0) return true;
            if (len2 < 0) return false;

            if (s.charAt(len1) == t.charAt(len2)) {
                  return recursiveComparing(s, t, len1 - 1, len2 - 1);
            } else {
                  return recursiveComparing(s, t, len1, len2 - 1);
            }
      }

      public boolean isSubsequenceByIteration(String s, String t) {
            int i = 0;
            int j = 0;

            while (i < s.length() && j < t.length()) {
                  if (s.charAt(i) == t.charAt(j)) {
                        i++;
                        j++;
                  } else {
                        j++;
                  }
            }
            return i == s.length();
      }

      public void test1() {
            String s1 = "abc";
            String s2 = "ahbgdc";

            boolean isSubsequence = isSubsequenceByRecursion(s1, s2);
            System.out.println("Test1");
            System.out.println(isSubsequence);
            System.out.println(isSubsequenceByIteration(s1, s2));
            System.out.println("Expected : true");
            System.out.println();
      }

      public void test2() {
            String s1 = "axc";
            String s2 = "ahbgdc";

            boolean isSubsequence = isSubsequenceByRecursion(s1, s2);
            System.out.println("Test2");
            System.out.println(isSubsequence);
            System.out.println(isSubsequenceByIteration(s1, s2));
            System.out.println("Expected : false");
            System.out.println();
      }

      public void test3() {
            String s1 = "bb";
            String s2 = "ahbgdc";

            System.out.println("Test3");
            System.out.println(isSubsequenceByRecursion(s1, s2));
            System.out.println(isSubsequenceByIteration(s1, s2));
            System.out.println("Expected : false");
            System.out.println();
      }

      public void test4() {
            String s1 = "abc";
            String s2 = "ahbgdc";

            System.out.println("Test4");
            System.out.println(isSubsequenceByRecursion(s1, s2));
            System.out.println(isSubsequenceByIteration(s1, s2));
            System.out.println("Expected : true");
            System.out.println();
      }

      public static void main(String[] args) {
            SubsequenceInString subsequenceInString = new SubsequenceInString();
            subsequenceInString.test1();
            subsequenceInString.test2();
            subsequenceInString.test3();
            subsequenceInString.test4();
      }

}
