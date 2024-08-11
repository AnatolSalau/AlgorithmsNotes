package tinkof_interview.tree.maximum_depth_binary_tree;

public class MaxDepthTree {
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
            MaxDepthTree maxDepthTree = new MaxDepthTree();
            maxDepthTree.test1();
            maxDepthTree.test2();
      }

      public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int depth = 1;

            if (root.left != null) {
                  int leftDepth = dfs(root.left, depth);
                  depth = Math.max(depth, leftDepth);
            }

            if (root.right != null) {
                  int rightDepth = dfs(root.right, depth);
                  depth = Math.max(depth, rightDepth);
            }
            return depth;
      }

      public int dfs(TreeNode root, int currDepth) {
            currDepth  = currDepth + 1;
            if (root.left != null) {
                  int leftDepth = dfs(root.left, currDepth);
                  currDepth = Math.max(currDepth, leftDepth);
            }

            if (root.right != null) {
                  int rightDepth = dfs(root.right, currDepth);
                  currDepth = Math.max(currDepth, rightDepth);
            }
            return currDepth;
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
            TreeNode right22 = new TreeNode(2, null, null);
            TreeNode right2 = new TreeNode(2, null, right22);
            TreeNode root1 = new TreeNode(1, null, right2);
            int result = maxDepth(root1);

            System.out.println("Test 1");
            System.out.println("Expect : 2");
            System.out.println("Result : " + result);
      }
}
