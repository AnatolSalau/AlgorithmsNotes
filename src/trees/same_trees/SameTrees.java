package trees.same_trees;

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
            return false;
      }

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

      private void test2() {
            TreeNode root1Left = new TreeNode(2);
            TreeNode root1 = new TreeNode(1, root1Left, null);

            TreeNode root2Right= new TreeNode(2);
            TreeNode root2 = new TreeNode(1, null, root2Right);
            System.out.println(isEqualBinaryTree(root1,root2));
            System.out.println("Expected result is " + false);
      }

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
