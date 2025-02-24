package dynamic_programming._9_house_robber_3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode.com/problems/house-robber-iii/description/">...</a>
 */
public class HouseRobber3 {


    public static class TreeNode {
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
        HouseRobber3 houseRobber3 = new HouseRobber3();
        houseRobber3.test1();
        houseRobber3.test2();
        houseRobber3.test3();
    }
    /*
        1. First of all we need to go down to the bottom of tree by recursion
        2. All computes we will do on reverse movement from bottom to top
     */
    public int rob(TreeNode root) {
        int[] memorization = dfsRecursion(root);

        int result = Math.max(memorization[0], memorization[1]);

        return result;
    }

    public int[] dfsRecursion(TreeNode root) {
        if(root == null) return new int[2];

        int[] leftMemo = dfsRecursion(root.left);
        int[] rightMemo = dfsRecursion(root.right);

        int[] memorization = new int[2];

        int ifRob = root.val + leftMemo[1] + rightMemo[1]; // curr val + if not rob left node + if not rob right node
        int ifNotRob = Math.max(leftMemo[0], leftMemo[1]) + Math.max(rightMemo[0], rightMemo[1]);

        memorization[0] = ifRob;
        memorization[1] = ifNotRob;

        return memorization;
    }


    public void test1() {
        TreeNode root = makeRoot(3, 2, 3, null, 3, null, 1);
        int answer = rob(root);
        System.out.println("Test 1: " + answer);
        System.out.println("Expected: 7");
        System.out.println("Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.");
        System.out.println();
    }

    public void test2() {
        TreeNode root = makeRoot(3, 4, 5, 1, 3, null, 1);
        int answer = rob(root);
        System.out.println("Test 2: " + answer);
        System.out.println("Expected: 9");
        System.out.println("Maximum amount of money the thief can rob = 4 + 5 = 9.");
        System.out.println();
    }

    public void test3() {
        TreeNode root = makeRoot(1,9,2,3,null,8,7);
        int answer = rob(root);
        System.out.println("Test 3: " + answer);
        System.out.println("Expected: 24");
        System.out.println("Maximum amount of money the thief can rob = 9 + 8 + 7 = 24");
        System.out.println();
    }


    private TreeNode makeRoot(Integer... values) {
        if (values.length == 0) return null;
        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while (i < values.length) {
            TreeNode current = queue.poll();
            if (values[i] != null) {
                assert current != null;
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }
            i++;
            if (i < values.length && values[i] != null) {
                assert current != null;
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
}
