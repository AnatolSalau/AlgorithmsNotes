package tinkof_interview.tree.binary_tree_inorder_traversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

            @Override
            public String toString() {
                  return "TreeNode{" +
                        "val=" + val + "}";
            }
      }
      /*
            https://leetcode.com/problems/binary-tree-inorder-traversal/description/
       */
      public static void main(String[] args) {
            BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
            binaryTreeInorderTraversal.test1();
      }
      /*
            solution through recursion
       */
      public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            List<Integer> revertNodes = new ArrayList<>();
            revertNodes.add(root.val);
            if (root.left != null) dfs(root.left, revertNodes);
            if (root.right != null)dfs(root.right, revertNodes);
            return revertNodes;
      }

      public void dfs(TreeNode root, List<Integer> revertNodes) {
            if(root == null) return;

            dfs(root.left, revertNodes);
            dfs(root.right, revertNodes);

            revertNodes.add(root.val);
      }
      /*
            solution through priority queue
       */
      public List<Integer> inorderTraversalQueue(TreeNode root) {
            return null;
      }

      public void test1() {
            TreeNode left3 = new TreeNode(3, null, null );
            TreeNode right2 = new TreeNode(2, left3, null );
            TreeNode root1 = new TreeNode(1, null, right2 );

            System.out.println("Test 1");
            List<Integer> list = inorderTraversal(root1);
            System.out.println("Result: " + list);
            System.out.println("Expect: [1,3,2]");
      }
}
