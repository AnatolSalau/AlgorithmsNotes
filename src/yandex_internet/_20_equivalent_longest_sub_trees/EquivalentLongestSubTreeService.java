package yandex_internet._20_equivalent_longest_sub_trees;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
       Дано бинарное дерево с выделенным корнем, в каждой вершине которого
       записано по одной букве A-Z.
       Две вершины считаются эквивалентными, если поддеревья этих вершин
       содержат одинаковое множество (т.е. без учета частот) букв.
       Нужно найти две эквивалентные вершины с максимальным суммарным
       размером поддеревьев.
 */
public class EquivalentLongestSubTreeService {

      Map<Set <String>, TreeNode> allSubtreesLetterComb = new HashMap();//Hash map with  <all letters set> -> Node

      Pair<Set <String>, TreeNode> answer = null;//Pair with answer <all letters set> -> Node

      /*
      Explanation:
      1.    Lets declare two variables at class level
                  Hash map with  <all letters set> -> Node
                  Map<Set <String>, TreeNode> allSubtreesLetterComb
                        <Letter set> -> <this top level node>
                        <<ABC>, <A>, <B>> -> Node<B>
                  Pair with answer <all letters set> -> Node
                  Pair<Set <String>, TreeNode> answer = null;
      2.    Create method getTwoEquivalentSubTree that will call recursive search in debt
      3.    Drop root to left and right half
      4.    Call recursive DFS for every half

            DFS
            All actions in reverse way (from bottom to top)
            1. DFS function return:
                  !!!!!!!
                  Union : Set <Node.letter + Left.letters + Right.letters>

       */
      Pair<Set <String>, TreeNode> getTwoEquivalentSubTree(TreeNode root) {

            TreeNode left = root.left;//Drop root to left and right half
            TreeNode right = root.right;

            if (left != null) dfs(left);//Call recursive DFS for every half
            if (right != null) dfs(right);

            return answer;
      }

      Set<String> dfs(TreeNode node) {
            TreeNode left = node.left;
            TreeNode right = node.right;

            Set<String> union = new HashSet<>(); //union with letters

            if (left != null)  {
                  Set<String> leftLetters = dfs(left); // letters from left bottom

                  if (leftLetters != null) {
                        union.addAll(leftLetters); // add to union left half
                  }

            }
            if (right != null) {
                  Set<String> rightLetters = dfs(right); // letters from right bottom

                  if (rightLetters != null) {
                        union.addAll(rightLetters);// add to union right half
                  }
            }
            union.add(node.letter);// add to union letter current node

            if (allSubtreesLetterComb.containsKey(union)) { // check existing in union in letter combination
                  answer = new Pair<>(union, node);
            }

            allSubtreesLetterComb.put(union, node);// add to letter combination current union

            return  union;
      }

      public static void main(String[] args) {

            EquivalentLongestSubTreeService subTreeService = new EquivalentLongestSubTreeService();

            subTreeService.test1();
            subTreeService.allSubtreesLetterComb = new HashMap<>();
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
