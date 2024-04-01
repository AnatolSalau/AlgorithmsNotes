package yandex_internet._17_tree_branch_with_max_sum;

import javafx.util.*;

import java.util.LinkedList;
import java.util.List;

public class TreeBranchWithMaxSumRecursive {
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }
      }
      /*
               0                     1
                                  /     \
               1                2         9
                              /  \      /   \
               2             1    7    5     2
                            /         /
               3           9         7

               right answer is 1, 9, 5, 7 O(n)
       */
      private static void test1() {
            TreeNode _7Left3 = new TreeNode(7, null, null);
            TreeNode _9Left3 = new TreeNode(9, null, null);

            TreeNode _5Left2 = new TreeNode(5, _7Left3, null);
            TreeNode _2Right2 = new TreeNode(2, null,null);

            TreeNode _1Left2 = new TreeNode(1, _9Left3, null);
            TreeNode _7Right2 = new TreeNode(7, null,null);

            TreeNode _2Left1 = new TreeNode(2, _1Left2, _7Right2);
            TreeNode _9Right1 = new TreeNode(9, _5Left2, _2Right2);

            TreeNode root0 = new TreeNode(1,_2Left1, _9Right1);
            List<Integer> resultWithSum = findNumbersNodesInBranchWithMaxSumRecursive(root0);
            System.out.println("Result :" + resultWithSum);
            System.out.println("Expect : [1, 9, 5, 7]");
      }

      private static List<Integer> findNumbersNodesInBranchWithMaxSumRecursive(TreeNode root) {

            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;

            if (leftNode != null) {
                  findNumbersNodesInBranchWithMaxSumRecursive(leftNode);
            }
            if (rightNode != null) {
                  findNumbersNodesInBranchWithMaxSumRecursive(rightNode);
            }


            return null;
      }

      public static void main(String[] args) {
            test1();
      }
}
