package trees.same_trees;

import java.util.LinkedList;
import java.util.Queue;

public class SameTrees {
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
       * Given the roots of two binary trees p and q,
       * write a function to check if they are the same or not.
       *
       * Two binary trees are considered the same if they are structurally identical,
       * and the nodes have the same value.
       */
      public static void main(String[] args) {
            SameTrees sameTrees = new SameTrees();
            sameTrees.test1();
            sameTrees.test2();
            sameTrees.test3();
      }

      private boolean isEqualBinaryTree(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) return false;

            Queue<TreeNode> queue1 = new LinkedList<>();
            Queue<TreeNode> queue2 = new LinkedList<>();

            queue1.add(root1);
            queue2.add(root2);
            //return false if queues are different
            while (!queue1.isEmpty() && !queue2.isEmpty()) {
                  TreeNode poll1 = queue1.poll();
                  TreeNode poll2 = queue2.poll();
                  /*
                        node
                        / \
                      null node
                   */
                  if (poll1.left == null && poll2.left != null) return false;
                  if (poll1.left != null && poll2.left == null) return false;

                  int val1 = poll1.val;
                  int val2 = poll2.val;

                  if (val1 != val2) return false;

                  //add left half
                  if (poll1.left != null) queue1.add(poll1.left);
                  if (poll2.left != null) queue2.add(poll2.left);

                  //add right half
                  if (poll1.right != null) queue1.add(poll1.right);
                  if (poll2.right != null) queue2.add(poll2.right);
            }
            return true;
      }
      /*
            1                 1
           / \               /  \
          2   3             2    3
          result = true
       */
      private void test1() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1Right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1, root1Left,root1Right);

            TreeNode root2Left = new TreeNode(2);
            TreeNode root2Right = new TreeNode(3);

            TreeNode root2 = new TreeNode(1,root2Left, root2Right);
            System.out.println(isEqualBinaryTree(root1,root2));
            System.out.println("Expected result is " + true);
      }
      /*
            1                 1
           /                   \
          2                     2
          result = false
       */
      private void test2() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1 = new TreeNode(1, root1Left, null);

            TreeNode root2Right= new TreeNode(2);
            TreeNode root2 = new TreeNode(1, null, root2Right);
            System.out.println(isEqualBinaryTree(root1,root2));
            System.out.println("Expected result is " + false);
      }
      /*
            1           1
           /  \        /  \
          2    3      3    2
          result = false
       */
      private void test3() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1Right = new TreeNode(3);

            TreeNode root1 = new TreeNode(1, root1Left, root1Right);

            TreeNode root2Left = new TreeNode(2);
            TreeNode root2Right = new TreeNode(3);

            TreeNode root2 = new TreeNode(1, root2Right, root2Left);
            System.out.println(isEqualBinaryTree(root1, root2));
            System.out.println("Expected result is " + false);
      }
}
