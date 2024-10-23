package dynamic_programming._14_longest_common_subsequence;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        LongestCommonSubsequence obj = new LongestCommonSubsequence();
        obj.test1();
        obj.test2();
        obj.test3();
        obj.test4();

    }

    public int longestCommonSubsequence(String text1, String text2) {
        //text2 - top chars
        //text1 - left chars
        int columnQty = text2.length() + 1;
        int rowQty = text1.length() + 1;
        int[][] memorization = new int[columnQty][rowQty];

        for (int i = 1; i < columnQty; i++) { //
            for (int j = 1; j < rowQty; j++) {
                char topChar = text1.charAt(j - 1);
                char leftChar = text2.charAt(i - 1);

                int topCount = memorization[i][j - 1];
                int leftCount = memorization[i - 1][j];
                int diagonalCount = memorization[i - 1][j - 1];

                int maxCount = Math.max(topCount, leftCount);

                if (topChar == leftChar) {
                    maxCount = diagonalCount + 1;
                }

                memorization[i][j] = maxCount;
            }
        }

        return memorization[memorization.length - 1][memorization[0].length - 1];
    }

    public void test1() {
        System.out.println("Test 1");

        String text1 = "abcde";
        String text2 = "ace";
        int expected = 3;
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println("Expected : " + expected);
        System.out.println();

    }

    public void test2() {
        System.out.println("Test 2");

        String text1 = "abc";
        String text2 = "abc";
        int expected = 3;
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println("Expected : " + expected);
        System.out.println();
    }

    public void test3() {
        System.out.println("Test 3");

        String text1 = "abc";
        String text2 = "def";
        int expected = 0;
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println("Expected : " + expected);
        System.out.println();
    }
    /*
     *   0  a b c d a f - i
     * 0 0  0 0 0 0 0 0
     * a 0  1 1 1 1 1 1
     * c 0  1 1 2 2 2 2
     * b 0  1 2 2 2 2 2
     * c 0  1 2 3 3 3 3
     * f 0  1 2 3 3 3 4
     * |
     * j
     */
    public void test4() {
        System.out.println("Test 4");

        String text1 = "abcdaf";
        String text2 = "acbcf";
        int expected = 4;
        System.out.println(longestCommonSubsequence(text1, text2));
        System.out.println("Expected : " + expected);
        System.out.println();
    }

}
