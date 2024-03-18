package stack.balanced_brackets;

import java.util.Stack;

public class BalancedBrackets {
      /**
             Напишите функцию, которая проверяет строку, состоящую из символов "(",")",
             "*", "+" на сбалансированность скобок.
             Примеры входа и выхода функции:
             Вход -> Выход
             ([]) -> true
             (() -> false
             [(]) -> false
             )( -> false
             [[[(([]))][]()]] -> true
       */
      public static void main(String[] args) {
            testOne();
            testTwo();
            testThree();
            testFour();
            testFiver();
      }
      /*
            1. Create stack for characters
            2. Go through arr
                  1. For every open backed like '(' or '[' add to stack it mirror
                        '(' add ')'
                        '[' add ')'
                  2. Check stack is to avoid stack is empty exception
                  3. For every closed brackets pop from stack current char
                        ')' pop ')'
                        ']' pop ']'
                  3. Compare current char with bracket from stack
                        if they are equal - continue to next char
                        if they are not equal - return false
       */
      static boolean isRightParenthesesSequence(String str) {
            return false;
      }
      static void testOne() {
            String str = "([])";
            String expectedResul = "true";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println("Test 1");
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
            System.out.println();
      }

      static private void testTwo() {
            String str = "(()";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println("Test 2");
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
            System.out.println();
      }

      static private void testThree() {
            String str = "[(])";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println("Test 3");
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
            System.out.println();
      }

      static private void testFour() {
            String str = ")(";
            String expectedResul = "false";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println("Test 4");
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
            System.out.println();
      }

      static private void testFiver() {
            String str = "[[[(([]))][]()]]";
            String expectedResul = "true";
            boolean answer = isRightParenthesesSequence(str);
            System.out.println("Test 5");
            System.out.println(answer);
            System.out.println("Expected : " + expectedResul);
            System.out.println();
      }
}
