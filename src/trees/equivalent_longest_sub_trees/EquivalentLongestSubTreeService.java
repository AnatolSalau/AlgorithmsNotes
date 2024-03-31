package trees.equivalent_longest_sub_trees;

import java.util.*;

/**
       Дано бинарное дерево с выделенным корнем, в каждой вершине которого
       записано по одной букве A-Z.
       Две вершины считаются эквивалентными, если поддеревья этих вершин
       содержат одинаковое множество (т.е. без учета частот) букв.
       Нужно найти две эквивалентные вершины с максимальным суммарным
       размером поддеревьев.
 */
public class EquivalentLongestSubTreeService {

      Set<Set<String>> allSubtrees = new HashSet<>();

      TreeNode getTwoEquivalentSubTree(TreeNode root) {

            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left != null) dfs(left);
            if (right != null) dfs(right);

            return null;
      }

      Set<String> dfs(TreeNode node) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            Set<String> leftLetter = null;
            Set<String> rightLetter = null;

            if (left != null) leftLetter = dfs(left);
            if (right != null) rightLetter = dfs(right);

            Set<String> union = new HashSet<>();

            if (leftLetter != null) {
                  leftLetter.add(node.letter);
                  allSubtrees.add(leftLetter);
            }
            if (rightLetter != null) {
                  rightLetter.add(node.letter);
                  allSubtrees.add(rightLetter);
            }

            union.add(node.letter);

            allSubtrees.add(union);

            return  union;
      }

      public static void main(String[] args) {

            EquivalentLongestSubTreeService subTreeService = new EquivalentLongestSubTreeService();

            subTreeService.test1();
            subTreeService.test2();
      }
      /*
                    A
                /        \
               B+        B+
              / \      /     \
             C   D    B       D
                     /  \    / \
                    C    D  C   D
        */
      void test1() {
            TreeNode leftLeft = new TreeNode("C");
            TreeNode leftRight = new TreeNode("D");

            TreeNode rightLeftLeft = new TreeNode("C");
            TreeNode rightLeftRight = new TreeNode("D");
            TreeNode rightLeft = new TreeNode("B", rightLeftLeft, rightLeftRight);

            TreeNode rightRightLeft = new TreeNode("C");
            TreeNode rightRightRight = new TreeNode("D");
            TreeNode rightRight = new TreeNode("D", rightRightLeft, rightRightRight);

            TreeNode left = new TreeNode("B", leftLeft, leftRight);
            TreeNode right = new TreeNode("B", rightLeft, rightRight);

            TreeNode root = new TreeNode("A",left, right);

            TreeNode largestEquivalentSubTree = getTwoEquivalentSubTree(root);
            System.out.println(largestEquivalentSubTree);
      }
      /*
                A
             /    \
            C      B+
          /  \   /  \
         A+   D A    A
        /             \
       B               B

      */
      void test2() {
            TreeNode leftLeftLeft = new TreeNode("B");
            TreeNode leftLeft = new TreeNode("A", leftLeftLeft, null);
            TreeNode leftRight = new TreeNode("D");

            TreeNode rightLeft = new TreeNode("A", null, null);

            TreeNode rightRightRight = new TreeNode("B");
            TreeNode rightRight = new TreeNode("A", null, rightRightRight);

            TreeNode left = new TreeNode("C", leftLeft, leftRight);
            TreeNode right = new TreeNode("B", rightLeft, rightRight);

            TreeNode root = new TreeNode("A",left, right);

            TreeNode largestEquivalentSubTree = getTwoEquivalentSubTree(root);
            System.out.println(largestEquivalentSubTree);
      }

      public static class TreeNode {
            String letter;
            TreeNode left;
            TreeNode right;

            TreeNode() {
            }

            TreeNode(String letter) {
                  this.letter = letter;
            }

            TreeNode(String letter, TreeNode left, TreeNode right) {
                  this.letter = letter;
                  this.left = left;
                  this.right = right;
            }
      }
}
