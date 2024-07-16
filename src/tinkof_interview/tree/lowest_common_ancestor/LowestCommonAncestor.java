package tinkof_interview.tree.lowest_common_ancestor;

import java.util.Objects;

public class LowestCommonAncestor {

      public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                  val = x;
            }

            public TreeNode(int val, TreeNode left, TreeNode right) {
                  this.val = val;
                  this.left = left;
                  this.right = right;
            }

            @Override
            public boolean equals(Object o) {
                  if (this == o) return true;
                  if (o == null || getClass() != o.getClass()) return false;
                  TreeNode node = (TreeNode) o;
                  return val == node.val && Objects.equals(left, node.left) && Objects.equals(right, node.right);
            }

            @Override
            public int hashCode() {
                  return Objects.hash(val, left, right);
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

      public static void main(String[] args) {
            LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
            lowestCommonAncestor.test1();
      }

      public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            return null;
      }
      /*  0                3
                   /             \
          1       5               1
               /     \          /    \
          2   6      2         0      8
                   /    \
          3       7      4
      */
      public void test1() {

            TreeNode node3_7 = new TreeNode(7, null, null);
            TreeNode node3_4 = new TreeNode(4, null, null);

            TreeNode node2_6 = new TreeNode(6, null, null);
            TreeNode node2_2 = new TreeNode(2, node3_7, node3_4);

            TreeNode node2_0 = new TreeNode(0, null, null);
            TreeNode node2_8 = new TreeNode(8, null, null);

            TreeNode node1_5 = new TreeNode( 5, node2_6, node2_2);
            TreeNode node1_1 = new TreeNode( 1, node2_0, node2_8);

            TreeNode node0_3_root = new TreeNode( 3, node1_5, node1_1);
            System.out.println("Test 1");
            System.out.println("Result : ");
            System.out.println(lowestCommonAncestor(node0_3_root, node1_5, node1_1));
            System.out.println("Expected output : ");
            System.out.println(node0_3_root);
            System.out.println();
      }
}
