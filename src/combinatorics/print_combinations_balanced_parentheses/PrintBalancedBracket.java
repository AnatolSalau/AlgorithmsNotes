package combinatorics.print_combinations_balanced_parentheses;

/**
 *    Print all combinations of balanced parentheses
 *    https://kalkicode.com/print-combinations-balanced-parentheses
 *    https://www.youtube.com/watch?v=bRs6E_SL2Tk&ab_channel=ApnaCollege
 */
public class PrintBalancedBracket {
      public static void main(String[] args) {
            PrintBalancedBracket printBalancedBracket = new PrintBalancedBracket();
            printBalancedBracket.test2Bracket();
            printBalancedBracket.test3Bracket();
            printBalancedBracket.test4Bracket();
      }

      private void printBalancedBracketsRecursive(String result, int openQty, int closeQty, int maxQtyOfClosedBrackets) {
            //print result and exit from recursion
            if (closeQty == maxQtyOfClosedBrackets)
            {
                  System.out.println(result);
                  return;
            }
            //add open bracket if it qty is less than necessary
            if (openQty < maxQtyOfClosedBrackets) {
                  String newResult = result + "(";
                  int newOpenQty = openQty + 1;
                  printBalancedBracketsRecursive(newResult,newOpenQty,closeQty,maxQtyOfClosedBrackets);
            }
            //add closed bracket if it qty less than open qty
            if (closeQty < openQty) {
                  String newResult = result + ")";
                  int newCloseQty = closeQty + 1;
                  printBalancedBracketsRecursive(newResult,openQty,newCloseQty,maxQtyOfClosedBrackets);
            }

      }
      /*
                  ""
                  |
                  (
                 / \
               ((   ()
               /      \
             (()       ()(
            /            \
          (())          ()()
       */
      private void test2Bracket() {
            int maxQtyOfClosedBrackets = 2;
            System.out.println("Test 2 bracket : ((()))");
            printBalancedBracketsRecursive("",0,0,maxQtyOfClosedBrackets);
            System.out.println();
      }

      private void test3Bracket() {
            int maxQtyOfClosedBrackets = 3;
            System.out.println("Test 3 bracket : ((()))");
            printBalancedBracketsRecursive("",0,0,maxQtyOfClosedBrackets);
            System.out.println();
      }

      private void test4Bracket() {
            int maxQtyOfClosedBrackets = 4;
            System.out.println("Test 4 bracket : (((())))");
            printBalancedBracketsRecursive("",0,0,maxQtyOfClosedBrackets);
            System.out.println();
      }
}
