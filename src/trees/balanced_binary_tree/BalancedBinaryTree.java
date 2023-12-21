package trees.balanced_binary_tree;
/**
 * Given a binary tree, determine if it is
 * height-balanced
 *
 * A height balanced binary tree is a binary tree
 * in which the height of the left subtree and right subtree of any node
 * does not differ by more than 1 and both the left and right subtree are also height balanced
 */
public class BalancedBinaryTree {

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


      public static void main(String[] args) {
            BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
            balancedBinaryTree.test1();
            balancedBinaryTree.test2();
      }

      private boolean isBalanced(TreeNode root) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left == null || right == null) return false;

            int height = 0;

            int leftHeight = getMaxHeightSubTree(left, height);
            int rightHeight = getMaxHeightSubTree(right, height);

            if (  Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == - 1)
                  return false;

            return true;
      }

      int getMaxHeightSubTree(TreeNode node, int height) {
            if (node == null) {return height;}

            TreeNode left = node.left;
            TreeNode right = node.right;

            if (node != null) height += 1;



            int leftHeight = getMaxHeightSubTree(left, height);
            int rightHeight = getMaxHeightSubTree(right, height);

            if (  Math.abs(leftHeight - rightHeight) > 1 || leftHeight == -1 || rightHeight == - 1)
                  return -1;

            return Math.max(leftHeight, rightHeight);
      }
      /*
                  3
            /           \
           9            20
                       /  \
                      15   7
            is balanced height
       */
      private void test1() {
            TreeNode root2RightLeft = new TreeNode(15, null, null);
            TreeNode root2RightRight = new TreeNode(7, null, null);

            TreeNode root2Left = new TreeNode(9, null, null);
            TreeNode root2Right = new TreeNode(20, root2RightLeft,root2RightRight);

            TreeNode root2 = new TreeNode(3,root2Left, root2Right);
            System.out.println("isBalanced " + isBalanced(root2));
            System.out.println("Expected : true");
      }
      /*
                        0
                 /            \
                10            11
              /   \          /  \
             20   21       null null
            /       \
           30       31
           is not balanced height
       */
      private void test2() {
            TreeNode n30 = new TreeNode(30, null, null);
            TreeNode n31= new TreeNode(31, null, null);

            TreeNode n20 = new TreeNode(20, n30, n31);
            TreeNode n21 = new TreeNode(21, null, null);

            TreeNode n10 = new TreeNode(10, n20,n21);
            TreeNode n11 = new TreeNode(11, null,null);

            TreeNode root00 = new TreeNode(0,n10, n11);
            System.out.println("isBalanced " + isBalanced(root00));
            System.out.println("Expected : false");
      }
}
