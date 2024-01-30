package stack.valid_parenthesses;

import java.util.Stack;

/**
       Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
       determine if the input string is valid.

       An input string is valid if:

       Open brackets must be closed by the same type of brackets.
       Open brackets must be closed in the correct order.
       Every close bracket has a corresponding open bracket of the same type.

       Example 1:
       Input: s = "()"
       Output: true

       Example 2:
       Input: s = "()[]{}"
       Output: true

       Example 3:
       Input: s = "(]"
       Output: false
 */
public class ValidParenthesses {
      public static void main(String[] args) {
            ValidParenthesses validParenthesses = new ValidParenthesses();
            validParenthesses.test1();
            validParenthesses.test2();
            validParenthesses.test3();
      }
      void test1() {
            String str = "()";
            boolean expectedResult = true;
            boolean result = isValidParentheses(str);
            System.out.println();
            System.out.println(str);
            System.out.println("Result " + result);
            System.out.println("Expect " + expectedResult);
      }
      /*
            0 1 2 3 4 5
            ( ) [ ] { }

            i:0
            )
            i:1
            )
            ) -> delete from stack
            i:2
            ]
            i:3
            ]
            ] -> delete from stack
            i:4
            }
            i:5
            }
            } - delete from stack

            stack is empty - return true
       */
      void test2() {
            String str = "()[]{}";
            boolean expectedResult = true;
            boolean result = isValidParentheses(str);
            System.out.println();
            System.out.println(str);
            System.out.println("Result " + result);
            System.out.println("Expect " + expectedResult);
      }

      /*    0 1
            ( ]
            i:0
            )
            i:1
            ]
            )

            stack is empty - return false
       */
      void test3() {
            String str = "(]";
            boolean expectedResult = false;
            boolean result = isValidParentheses(str);
            System.out.println();
            System.out.println(str);
            System.out.println("Result " + result);
            System.out.println("Expect " + expectedResult);
      }

      private boolean isValidParentheses(String str) {
            char[] characters = str.toCharArray();

            Stack<Character> stack = new Stack<>();
            for ( char curr : characters) {
                  if (curr == '(' ) {
                        stack.push(')');
                        continue;
                  }
                  if (curr == '[' ) {
                        stack.push(']');
                        continue;
                  }
                  if (curr == '{' ) {
                        stack.push('}');
                        continue;
                  }
                  if (!stack.isEmpty() && stack.peek() == curr ) {
                        stack.pop();
                  }
            }
            return stack.isEmpty();
      }
}
