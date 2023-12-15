package searchs.search_in_depth_width.invalid_parentheses;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
       Given a string s that contains parentheses and letters,
       remove the minimum number of invalid parentheses to make the input string valid.

       Return a list of unique strings that are valid with the minimum number of removals.
       You may return the answer in any order.

       Example 1:

       Input: s = "()())()"
       Output: ["(())()","()()()"]

       Example 2:

       Input: s = "(a)())()"
       Output: ["(a())()","(a)()()"]

       Example 3:

       Input: s = ")("
       Output: [""]
 */
public class RemoveInvalidParentheses {
      public static void main(String[] args) {
            RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
            removeInvalidParentheses.test1();
      }
      /*
            *
            ( ) ( ) ) ( ) -> ( -> stack [(]
              *
            ( ) ( ) ) ( ) -> ) -> stack [] - remove top
                *
            ( ) ( ) ) ( ) -> ( -> stack [(]
                  *
            ( ) ( ) ) ( ) -> ) -> stack [] - remove top
                    *
            ( ) ( ) ) ( ) -> ) -> stack [)]
       */
      private Set<String> getRightParentheses (String str) {
            Set<String> rightParentheses = new HashSet<>();
            removeRequiredNumberOfParentheses(str,getCountInvalidParentheses(str), rightParentheses);
            return rightParentheses;
      }

      private void removeRequiredNumberOfParentheses(String str, int countInvalidParentheses, Set<String> rightParentheses) {
            if (countInvalidParentheses== 0) {
                  int countInvalidParenthesesNow = getCountInvalidParentheses(str);
                  if (countInvalidParenthesesNow == 0) {
                        rightParentheses.add(str);
                  }
                  return;
            }
            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0, i);
                  String right = str.substring(i + 1);
                  removeRequiredNumberOfParentheses(left + right,countInvalidParentheses - 1,rightParentheses);
            }
      }

      private int getCountInvalidParentheses(String str) {
            char[] chars = str.toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char ch : chars) {
                  if( ch =='(') {
                        stack.push(ch);
                  }
                  else {
                        //if stack is empty add )
                        if (stack.size() == 0) {
                              stack.push(ch);
                        }
                        // if stack top ) add )
                        else if (stack.peek() == ')') {
                              stack.push(ch);
                        }
                        // if stack top ( - remove top
                        else  {
                              stack.pop();
                        }
                  }
            }
            return stack.size();
      }
      /*
                |
            ()())() -> ()()()
             |
            ()())() -> (())()
       */
      private void test1() {
            String str = "()())()";
            String[] expected = {"(())()","()()()"};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));
            int countInvalidParentheses = getCountInvalidParentheses(str);
            System.out.println("Count invalid parentheses : " + countInvalidParentheses);
            Set<String> rightParentheses = getRightParentheses(str);
            System.out.println(rightParentheses);
            System.out.println();
      }
      /*
                 |
            (a)())() -> (a)()()
              |
            (a)())() -> (a())()
       */
      private void test2() {
            String str = ")(a)())()";
            String[] expected = {"(a())()","(a)()()"};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));
            int countInvalidParentheses = getCountInvalidParentheses(str);
            System.out.println("Count invalid parentheses : " + countInvalidParentheses);
            Set<String> rightParentheses = getRightParentheses(str);
            System.out.println(rightParentheses);
            System.out.println();
      }

      private void test3() {
            String str = ")(";
            String[] expected = {""};
            System.out.println(str);
            System.out.println("Expected : " + Arrays.toString(expected));
            int countInvalidParentheses = getCountInvalidParentheses(str);
            System.out.println("Count invalid parentheses : " + countInvalidParentheses);
            Set<String> rightParentheses = getRightParentheses(str);
            System.out.println(rightParentheses);
            System.out.println();
      }
}
