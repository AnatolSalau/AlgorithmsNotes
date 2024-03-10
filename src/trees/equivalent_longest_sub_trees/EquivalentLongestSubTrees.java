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
public class EquivalentLongestSubTrees {
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
      public static void main(String[] args) {
            TreeNode leftLeft = new TreeNode("C");
            TreeNode leftRight = new TreeNode("D");

            TreeNode rightLeftLeft = new TreeNode("C");
            TreeNode rightLeftRight = new TreeNode("C");
            TreeNode rightLeft = new TreeNode("C", rightLeftLeft, rightLeftRight);

            TreeNode rightRightLeft = new TreeNode("C");
            TreeNode rightRightRight = new TreeNode("D");
            TreeNode rightRight = new TreeNode("D", rightRightLeft, rightRightRight);

            TreeNode left = new TreeNode("B", leftLeft, leftRight);
            TreeNode right = new TreeNode("B", rightLeft, rightRight);

            TreeNode root = new TreeNode("A",left, right);

            TreeNode[] twoEquivalentSubTree = getTwoEquivalentSubTree(root);

      }

      /*
                    A
                /        \
               B          B
              / \      /     \
             C   D    C       D
                     /  \    / \
                    C    D  C   D
        */

      static TreeNode[] getTwoEquivalentSubTree(TreeNode root) {
            HashMap<Set<String>, Integer> setQuantityMap = new HashMap<>();
            System.out.println(setQuantityMap);
            fillSetQuantityMap(root.right,root.right, setQuantityMap);
            System.out.println(setQuantityMap);
            return null;
      }

      static void fillSetQuantityMap(TreeNode left, TreeNode right, HashMap<Set<String>, Integer> setQuantityMap) {
            String letterLeft = left.letter;
            Set<String> allLettersLeft = new HashSet<>();
            allLettersLeft.add(letterLeft);
            int count = 1;

            Queue<TreeNode> queue = new LinkedList<>();

            if (left.left != null) {
                  queue.add(left.left);
            }
            if (left.right != null) {
                  queue.add(left.right);
            }
            //collect all letters from left map
            while (!queue.isEmpty()) {
                  TreeNode poll = queue.poll();
                  allLettersLeft.add(poll.letter);
                  if (poll.left != null) {
                        queue.add(poll.left);
                        count++;
                  }
                  if (poll.right != null) {
                        queue.add(poll.right);
                        count++;
                  }
            }
            setQuantityMap.put(allLettersLeft, count);
            if (left.left != null) {
                  fillSetQuantityMap(left.left,right.right, setQuantityMap);
            }
            if (left.right != null) {
                  fillSetQuantityMap(left.right,right.right, setQuantityMap);
            }
      }
}
