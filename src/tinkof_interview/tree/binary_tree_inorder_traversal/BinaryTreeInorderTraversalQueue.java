package tinkof_interview.tree.binary_tree_inorder_traversal;

import java.util.*;

/*
      https://leetcode.com/problems/binary-tree-inorder-traversal/description/
      https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 */
public class BinaryTreeInorderTraversalQueue {
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

            public int getVal() {
                  return val;
            }
      }
      /*
            https://leetcode.com/problems/binary-tree-inorder-traversal/description/
       */
      public static void main(String[] args) {
            BinaryTreeInorderTraversalQueue binaryTreeInorderTraversal = new BinaryTreeInorderTraversalQueue();
            binaryTreeInorderTraversal.test1();
      }
      /*
            solution through recursion
       */
      public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            PriorityQueue<Integer> revertNodes = new PriorityQueue<>(
                  Comparator.comparingInt(Integer::intValue).reversed()
            );
            while (!queue.isEmpty()) {
                  if (root.left != null) queue.add(root.left);
                  if (root.right != null) queue.add(root.right);

                  if (!queue.isEmpty() ) {
                        TreeNode pollLeft = queue.poll();
                        revertNodes.add(pollLeft.val);
                  }
            }
            return new ArrayList<>(revertNodes);
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
