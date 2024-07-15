package tinkof_interview.tree_graphs.invert_binary_tree;

public class InvertBinaryTree {
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

            @Override
            public String toString() {
                  return "TreeNode{" +
                        "val=" + val +
                        ", left=" + left +
                        ", right=" + right +
                        '}';
            }
      }

      public TreeNode invertTree(TreeNode root) {
            if (root == null) return root;


            TreeNode leftSubTree = invertTree(root.left);
            TreeNode rightSubTree = invertTree(root.right);


            TreeNode temp = leftSubTree;

            leftSubTree = rightSubTree;
            rightSubTree = temp;

            TreeNode newRoot = new TreeNode(
                  root.val, leftSubTree, rightSubTree
            );

            return newRoot;
      }


      /*
        1                     4                                         4
                        /           \                             /           \
        2              2             7                           7             2
                     /   \         /   \                       /   \          /   \
        3           1     3       6     9                     9     6        3      1
       */
      public void test1() {
            TreeNode left3_1 = new TreeNode(1, null, null);
            TreeNode left3_3 = new TreeNode(3, null, null);
            TreeNode left2_2 = new TreeNode(2, left3_1, left3_3);

            TreeNode right3_6 = new TreeNode(6, null, null);
            TreeNode right3_9 = new TreeNode(9, null, null);
            TreeNode right2_7 = new TreeNode(7, right3_6, right3_9);

            System.out.println("Test1");
            TreeNode root1_4 = new TreeNode(4, left2_2, right2_7);
            System.out.println("Before inversion");
            System.out.println(root1_4);
            TreeNode answer = invertTree(root1_4);
            System.out.println("After inversion");
            System.out.println(answer);

      }

      public static void main(String[] args) {
            InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
            invertBinaryTree.test1();
      }
}
