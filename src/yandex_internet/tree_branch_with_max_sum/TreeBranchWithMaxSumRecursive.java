package yandex_internet.tree_branch_with_max_sum;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeBranchWithMaxSumRecursive {
      public static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(int val) {
                  this.val = val;
            }

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

               right answer is 1, 9, 5, 7
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
            System.out.println("Result :" + findNumbersNodesInBranchWithMaxSum(root0));
            System.out.println("Expect : [1, 9, 5, 7]");
      }

      private static List<Integer> findNumbersNodesInBranchWithMaxSum(TreeNode root) {
            List<Integer> pathWithMaxSum = null;
            List<Integer> currPath = new LinkedList<>();

            Stack<TreeNode> stack = new Stack<>();
            stack.add(root);

            int maxSumInTheBottom = 0;

            int currSumInTheBottom = 0;

            while (!stack.isEmpty()) {
                  TreeNode node = stack.pop();

                  TreeNode left = node.left;
                  TreeNode right = node.right;
                  // stack.isEmpty()-> remove all from curr path because we in the root,
                  // but we don't  have to remove curr path if we in the bottom, so add && left != null && right != null
                  if(stack.isEmpty() && left != null && right != null) {
                        currPath = new LinkedList<>();
                        currSumInTheBottom = 0;
                  }

                  currPath.add(node.val);//add curr value
                  currSumInTheBottom = currSumInTheBottom + node.val; //update sum

                  if (left == null && right == null) {// checking to see if we are at the bottom
                        if (currSumInTheBottom > maxSumInTheBottom) { // update maximums
                              maxSumInTheBottom = currSumInTheBottom;
                              pathWithMaxSum = List.copyOf(currPath);
                        }
                        // remove last in path because we go up one level to the top
                        currPath.remove(currPath.size() - 1);

                        // remove val from curr sum in path because we go up one level to the top
                        currSumInTheBottom = currSumInTheBottom - node.val;
                  }

                  if (left != null) stack.add(left);
                  if (right != null) stack.add(right);
            }

            return pathWithMaxSum;
      }

      public static void main(String[] args) {
            test1();
      }
}
