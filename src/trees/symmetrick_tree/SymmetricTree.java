package trees.symmetrick_tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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

      /**
       * Given the root of a binary tree, check whether it is a mirror of itself
       * (i.e., symmetric around its center).
       */
      public static void main(String[] args) {
            SymmetricTree symmetricTree = new SymmetricTree();
            symmetricTree.test1();
            symmetricTree.test2();
      }
      private boolean isSymmetricTree(TreeNode root) {
            if (root == null || root.left == null || root.right ==null ) return false;

            TreeNode left = root.left;
            TreeNode right = root.right;

            Queue<TreeNode> queueLeft = new LinkedList<>();
            Queue<TreeNode> queueRight = new LinkedList<>();

            queueLeft.add(left);
            queueRight.add(right);

            while (!queueLeft.isEmpty() && !queueRight.isEmpty()) {
                  TreeNode leftNode = queueLeft.poll();
                  TreeNode rightNode = queueRight.poll();

                  // skip if node are null
                  if (leftNode == null && rightNode == null) continue;

                  // check null symmetric
                  if (leftNode == null && rightNode != null) return false;
                  if (leftNode != null && rightNode == null) return false;

                  int leftVal = leftNode.val;
                  int rightVal = rightNode.val;

                  if (leftVal != rightVal) return false;

                  queueLeft.add(leftNode.left);
                  queueRight.add(rightNode.right);

                  queueLeft.add(leftNode.right);
                  queueRight.add(rightNode.left);
            }
            return true;
      }
      /*
                  1
                /    \
              2        2
            /   \     /  \
           3     4   4    3
           result = true
     */
      private void test1() {
            TreeNode root1LeftLeft = new TreeNode(3);
            TreeNode root1LeftRight = new TreeNode(4);

            TreeNode root1RightLeft = new TreeNode(4);
            TreeNode root1RightRight = new TreeNode(3);

            TreeNode root1Left = new TreeNode(2, root1LeftLeft, root1LeftRight);
            TreeNode root1Right = new TreeNode(2, root1RightLeft, root1RightRight);

            TreeNode root1 = new TreeNode(1, root1Left,root1Right);

            System.out.println(isSymmetricTree(root1));
      }
      /*
                   1
                /     \
               2       2
             /   \   /   \
           null   3 null  3
           result = false
       */
      private void test2() {
            TreeNode root1LeftRight = new TreeNode(3);
            TreeNode root1Left = new TreeNode(2, null, root1LeftRight);

            TreeNode root1RightRight = new TreeNode(3);
            TreeNode root1Right = new TreeNode(2, null,root1RightRight);
            TreeNode root1 = new TreeNode(1, root1Left, root1Right);

            System.out.println(isSymmetricTree(root1));
      }
}
