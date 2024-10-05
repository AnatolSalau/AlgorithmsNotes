package combinatorics.abcd_all_combinations;

import java.util.LinkedList;
import java.util.List;

/**
 * Output all combinations letters from string ABCD
 * Quantity all combinations 4! (1*2*3*4 = 24)
 */
public class AllCombinations {
      public static void main(String[] args) {
            AllCombinations allCombinations = new AllCombinations();
            allCombinations.testABC();
            allCombinations.testABCD();
      }

      private List<String> getAllCombinations(String str) {
            List<String> result = new LinkedList<>();
            String mutation = "";
            makeAllCombinations(str, "",result);
            return result;
      }

      private void makeAllCombinations(String str, String currCombination, List<String> allCombination) {
            // exit from recursion
            if (str.length() == 0) return;

            for (int i = 0; i < str.length(); i++) {
                  String left = str.substring(0, i );
                  String right = str.substring(i + 1);
                  String newStr = left + right;

                  char currChar = str.charAt(i);
                  String newCombination = currCombination + currChar;

                  if (newCombination.length() == 3) {
                        allCombination.add(newCombination);
                  }
                  makeAllCombinations(newStr, newCombination,allCombination);
            }
      }
      private void testABC() {
            String str = "ABC";
            List<String> result = getAllCombinations(str);
            System.out.println(result);
            System.out.println("Length of result list : " + result.size());
            System.out.println("Expected length : 3! = 6");
            System.out.println();
      }

      private void testABCD() {
            String str = "ABCD";
            List<String> result = getAllCombinations(str);
            System.out.println(result);
            System.out.println("Length of result list : " + result.size());
            System.out.println("Expected length : 3! = 24");
            System.out.println();
      }
}
