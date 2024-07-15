package tinkof_interview.stack.valid_parentheses;

import java.util.Stack;

public class ValidParentheses {
      public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();

            for(int i = 0; i < s.length() ; i++) {
                  char curr = s.charAt(i);
                  if (curr == '[') {
                        stack.add(']');
                        continue;
                  }
                  if (curr == '{') {
                        stack.add('}');
                        continue;
                  }
                  if (curr == '(') {
                        stack.add(')');
                        continue;
                  }
                  if (curr != stack.peek()) return false;

                  stack.pop();

            }
            return true;
      }

      public static void main(String[] args) {
            ValidParentheses validParentheses = new ValidParentheses();
            validParentheses.test1();
            validParentheses.test2();
      }
      public void test1() {
            System.out.println("Test 1");
            String str = "(]";
            System.out.println("Expect : " + false);
            System.out.println("Result : " + isValid(str));
            System.out.println();
      }

      public void test2() {
            System.out.println("Test 1");
            String str = "()[]{}";
            System.out.println("Expect : " + true);
            System.out.println("Result : " + isValid(str));
            System.out.println();
      }
}
