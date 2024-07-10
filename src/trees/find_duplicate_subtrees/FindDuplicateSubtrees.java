package trees.find_duplicate_subtrees;

import java.util.*;

public class FindDuplicateSubtrees {
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
            public boolean equals(Object o) {
                  if (this == o) return true;
                  if (o == null || getClass() != o.getClass()) return false;
                  TreeNode treeNode = (TreeNode) o;
                  return val == treeNode.val && Objects.equals(left, treeNode.left) && Objects.equals(right, treeNode.right);
            }

            @Override
            public int hashCode() {
                  return Objects.hash(val, left, right);
            }

            @Override
            public String toString() {
                  return val + "";
            }
      }

      private final HashMap<String, Integer> subtreeFreqMap = new HashMap<>();

      private final Set<TreeNode> duplicateSubtrees = new HashSet<>();

      public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            String rootSubstring = dfsReturnSubtree(root);
            System.out.println(rootSubstring);
            System.out.println("SubtreeFreqMap" + subtreeFreqMap);
            System.out.println("DuplicateSubtrees" + duplicateSubtrees);
            return new ArrayList<>(duplicateSubtrees);
      }

      public String dfsReturnSubtree(TreeNode node) {
            String left = "#";
            String right = "#";

            if (node.left != null) {
                  left = dfsReturnSubtree(node.left);
            }
            if (node.right != null) {
                  right = dfsReturnSubtree(node.right);
            }

            String union = node.val + left + right;

            if (subtreeFreqMap.containsKey(union)) {
                  Integer count = subtreeFreqMap.get(union);
                  count++;
                  subtreeFreqMap.put(union, count);
                  duplicateSubtrees.add(node);
            } else {
                  subtreeFreqMap.put(union, 1);
            }

            return union;
      }

      public static void main(String[] args) {
            FindDuplicateSubtrees findDuplicateSubtrees = new FindDuplicateSubtrees();
            findDuplicateSubtrees.test1();
      }
      /*
        root 3             1
                        /           \
             2         2             3
                   /              /     \
             1    4              2       4
                                /
             0                 4
                Answer: [[2,4],[4]]
       */
      public  void test1() {
            //right half subtree
            TreeNode right4_0 = new TreeNode(4, null, null);
            TreeNode right2_1 = new TreeNode(2, right4_0, null);
            TreeNode right4_1 = new TreeNode(4, null, null);
            TreeNode right3_2 = new TreeNode(3, right2_1, right4_1);

            //left half subtree
            TreeNode left4_1 = new TreeNode(4, null, null);
            TreeNode left2_2 = new TreeNode(2, left4_1, null);

            //root
            TreeNode root_1_3 = new TreeNode(1, left2_2, right3_2);

            List<TreeNode> answer = findDuplicateSubtrees(root_1_3);
            System.out.println("Test 1");
            System.out.println("Right answer : " + "[[2,4],[4]]");
            System.out.println("Answer: " + answer);
      }
}

