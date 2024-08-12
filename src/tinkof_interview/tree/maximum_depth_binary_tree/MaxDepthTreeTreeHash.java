package tinkof_interview.tree.maximum_depth_binary_tree;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/*
      https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaxDepthTreeTreeHash {
      public class TreeNode {
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
            MaxDepthTreeTreeHash maxDepthTree = new MaxDepthTreeTreeHash();
            maxDepthTree.test1();
            maxDepthTree.test2();
      }

      public int maxDepth(TreeNode root) {
            TreeSet<Integer> leafQueue = new TreeSet<>();

            dfs(root, leafQueue, 0);
            if (leafQueue.isEmpty()) return 0;
            return leafQueue.last();
      }

      public void dfs(TreeNode root, TreeSet<Integer> leafQueue, int initialDepth) {
            if (root == null) return;

            int newDepth = initialDepth + 1;

            if (root.left == null && root.right == null) {
                  leafQueue.add(newDepth);
            }
            dfs(root.left, leafQueue, newDepth);
            dfs(root.right, leafQueue, newDepth);
      }
      /*
            3
          /   \
         9     20
              /   \
             15    7

        result = 3

       */
      public void test1() {
            TreeNode right7 = new TreeNode(7, null, null);
            TreeNode left15 = new TreeNode(15, null, null);
            TreeNode right20 = new TreeNode(20, left15, right7);
            TreeNode left9 = new TreeNode(9, null, null);
            TreeNode root3 = new TreeNode(3, left9, right20);
            int result = maxDepth(root3);

            System.out.println("Test 1");
            System.out.println("Expect : 3");
            System.out.println("Result : " + result);

      }
      /*
            1
              \
               2

        result = 2
       */
      public void test2() {
            TreeNode right2 = new TreeNode(2, null, null);
            TreeNode root1 = new TreeNode(1, null, right2);
            int result = maxDepth(root1);

            System.out.println("Test 2");
            System.out.println("Expect : 2");
            System.out.println("Result : " + result);
      }
}
