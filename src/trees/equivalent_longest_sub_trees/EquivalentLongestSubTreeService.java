package trees.equivalent_longest_sub_trees;

import javafx.util.Pair;

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

      Map<Set <String>, TreeNode> allSubtrees = new HashMap();

      Pair<Set <String>, TreeNode> answer = null;

      Pair<Set <String>, TreeNode> getTwoEquivalentSubTree(TreeNode root) {

            TreeNode left = root.left;
            TreeNode right = root.right;

            if (left != null) dfs(left);
            if (right != null) dfs(right);

            return answer;
      }

      Set<String> dfs(TreeNode node) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            Set<String> union = new HashSet<>();

            if (left != null)  {
                  Set<String> leftLetters = dfs(left);

                  if (leftLetters != null) {
                        allSubtrees.put(leftLetters, left);
                        union.addAll(leftLetters);
                  }

            }
            if (right != null) {
                  Set<String> rightLetters = dfs(right);

                  if (rightLetters != null) {
                        allSubtrees.put(rightLetters, right);
                        union.addAll(rightLetters);
                  }
            }
            union.add(node.letter);

            if (allSubtrees.containsKey(union)) {
                  answer = new Pair<>(union, node);
            }

            allSubtrees.put(union, node);

            return  union;
      }

      public static void main(String[] args) {

            EquivalentLongestSubTreeService subTreeService = new EquivalentLongestSubTreeService();

            subTreeService.test1();
            subTreeService.allSubtrees = new HashMap<>();
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

            Pair<Set <String>, TreeNode> answer = getTwoEquivalentSubTree(root);
            System.out.println(answer);
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

            Pair<Set <String>, TreeNode> answer = getTwoEquivalentSubTree(root);
            System.out.println(answer);
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
