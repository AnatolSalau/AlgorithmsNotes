package combinatorics.all_brackets_valid_combinations;

import java.util.*;

public class AllBracketValidCombinations {
      /**
       * Print all balanced bracket combinations from ((()))
       * "((()))"
       * "(()())"
       * "(())()"
       * "()(())"
       * "()()()"
       */
      public static void main(String[] args) {
            AllBracketValidCombinations allBracketValidCombinations = new AllBracketValidCombinations();
            allBracketValidCombinations.test1();
      }

      private LinkedHashSet<String> getAllValidBracketCombinations(List<String> brackets) {
            LinkedHashSet<String> result = new LinkedHashSet<>();
            String combination = new String();
            addValidBracketCombination(brackets, combination, result );
            return result;
      }

      private void addValidBracketCombination(List<String> brackets, String combination, LinkedHashSet<String> combinationList) {
            if (brackets.size() == 0) {
                  if (isValidBracketCombination(combination)) {
                        combinationList.add(combination);
                  }

                  return;
            }
            for (int i = 0; i < brackets.size(); i++) {
                  List<String> left = brackets.subList(0,i);
                  List<String> right = brackets.subList(i + 1,brackets.size());
                  List<String> newBrackets = new ArrayList<>();
                  newBrackets.addAll(left);
                  newBrackets.addAll(right);

                  String curr = brackets.get(i);
                  String newCombination = combination + curr;

                  addValidBracketCombination(newBrackets, newCombination,combinationList);
            }
      }

      private boolean isValidBracketCombination(String combination) {
            char[] chars = combination.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                  char curr = chars[i];


                  if (curr == '(') {
                        stack.add(')');
                        continue;
                  }
                  if (curr == ')') {
                        if (stack.isEmpty()) {
                              return false;
                        }

                        Character pop = stack.pop();
                        if (pop != ')') return false;
                  }
            }
            return true;
      }

      private void test1() {
            List<String> brackets = new ArrayList<>(Arrays.asList("(", "(", "(", ")", ")",")"));
            String expectedResult = """
                              ((()))
                              (()())
                              (())()
                              ()(())
                              ()()() 
                  """;
            LinkedHashSet<String> result = getAllValidBracketCombinations(brackets);
            printResult(result);
            System.out.println();
            System.out.println(expectedResult);
            System.out.println();
      }

      private void printResult(LinkedHashSet<String> result) {
            for(String str : result) {
                  System.out.println(str);
            }
      }

}
