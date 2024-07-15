package tinkof_interview.stack.backspaces_in_string;

import java.util.Stack;

public class BackSpacesInString {
      public static void main(String[] args) {
            BackSpacesInString backSpacesInString = new BackSpacesInString();
            backSpacesInString.test1();
            backSpacesInString.test2();
            backSpacesInString.test3();
            backSpacesInString.test4();
      }

      String getString(String str) {
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                  char curr = str.charAt(i);

                  if (curr == '#') {
                        if (!stack.isEmpty()) {
                              stack.pop();
                        }
                  } else {
                        stack.add(curr);
                  }
            }

            StringBuilder stringBuilder = new StringBuilder(stack.size());

            while (!stack.isEmpty()) {
                  Character ch = stack.remove(0);
                  stringBuilder.append(ch);
            }

            return stringBuilder.toString();
      }

      String getStringByPointer(String str) {

            return null;
      }
      public void test1() {
            String str = "abc#d##c";
            String expect = "ac";
            String resul = getString(str);

            System.out.println("Test1");
            System.out.println("Expect : " + expect);
            System.out.println("Result : " + resul);
            System.out.println("Result by pointers : " + getStringByPointer(str));
            System.out.println();
      }

      public void test2() {
            String str = "abc##d######";
            String expect = "";
            String resul = getString(str);

            System.out.println("Test2");
            System.out.println("Expect : " + expect);
            System.out.println("Result : " + resul);
            System.out.println("Result by pointers : " + getStringByPointer(str));
            System.out.println();
      }

      public void test3() {
            String str = "#######";
            String expect = "";
            String resul = getString(str);

            System.out.println("Test3");
            System.out.println("Expect : " + expect);
            System.out.println("Result : " + resul);
            System.out.println("Result by pointers : " + getStringByPointer(str));
            System.out.println();
      }

      public void test4() {
            String str = "";
            String expect = "";
            String resul = getString(str);

            System.out.println("Test4");
            System.out.println("Expect : " + expect);
            System.out.println("Result : " + resul);
            System.out.println("Result by pointers : " + getStringByPointer(str));
            System.out.println();
      }
}
