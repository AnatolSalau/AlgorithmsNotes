package dynamic_programming._5_climbing_stairs;

/**
 * <a href="https://www.youtube.com/watch?v=UUaMrNOvSqg&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=3&ab_channel=NikhilLohia">...</a>
 * <a href="https://leetcode.com/problems/climbing-stairs/description/">...</a>
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int result1 = climbingStairs.climbStairs(2);
        System.out.println("Result 1 : " + result1 );
        int result2 = climbingStairs.climbStairs(3);
        System.out.println("Result 2 : " + result2 );
    }
    public int climbStairs(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] memorization = new int[n + 1];
        memorization[0]= 0;
        memorization[1]= 1;
        memorization[2]= 2;
        for (int i = 3; i < memorization.length; i++) {
            memorization[i] = memorization[i - 1] + memorization[i - 2];
        }
        return  memorization[n];
    }
}
