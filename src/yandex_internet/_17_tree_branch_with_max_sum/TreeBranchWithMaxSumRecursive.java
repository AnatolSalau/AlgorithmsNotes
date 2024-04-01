package yandex_internet._17_tree_branch_with_max_sum;

import java.util.ArrayList;
import java.util.List;

public class TreeBranchWithMaxSumRecursive {
      private int curSum = 0;
      private int maxSum = 0;

      List<Integer> maxPath = new ArrayList<>();
      List<Integer> currPath = new ArrayList<>();

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
            TreeBranchWithMaxSumRecursive branchWithMaxSumRecursive = new TreeBranchWithMaxSumRecursive();
            TreeNode _7Left3 = new TreeNode(7, null, null);
            TreeNode _9Left3 = new TreeNode(9, null, null);

            TreeNode _5Left2 = new TreeNode(5, _7Left3, null);
            TreeNode _2Right2 = new TreeNode(2, null,null);

            TreeNode _1Left2 = new TreeNode(1, _9Left3, null);
            TreeNode _7Right2 = new TreeNode(7, null,null);

            TreeNode _2Left1 = new TreeNode(2, _1Left2, _7Right2);
            TreeNode _9Right1 = new TreeNode(9, _5Left2, _2Right2);

            TreeNode root0 = new TreeNode(1,_2Left1, _9Right1);
            branchWithMaxSumRecursive.findNumbersNodesInBranchWithMaxSumRecursive(root0);
            System.out.println("Result :" + branchWithMaxSumRecursive.maxPath);
            System.out.println("Expect : [1, 9, 5, 7]");
      }
      /*
            Explanation:
            1. Go to bottom throught DFS
            2. Create variables at class level
                  currSum, maxSum
                  currPath, maxPath
            3. In direct path DFS
                  add curr value to currSum
                  add curr value to currPath
            4. Run recursive DFS for left half
            5. Run recursive DFS for left half
            6. If curr sum more max sum
                  add to max path curr path
                  add to max sum curr sum
            7. remove from curr sum -> curr value
            8. remove from curr path -> last letter in list

       */
      private void findNumbersNodesInBranchWithMaxSumRecursive(TreeNode node) {

            TreeNode leftNode = node.left;
            TreeNode rightNode = node.right;

            curSum += node.val;
            currPath.add(node.val);

            if (leftNode != null) {
                  findNumbersNodesInBranchWithMaxSumRecursive(leftNode);
            }
            if (rightNode != null) {
                  findNumbersNodesInBranchWithMaxSumRecursive(rightNode);
            }
            if (curSum > maxSum) {
                  maxPath = List.copyOf(currPath);
                  maxSum = curSum;
            }
            curSum -= node.val;
            currPath.remove(currPath.size() - 1);

      }

      public static void main(String[] args) {
            test1();
      }
}
