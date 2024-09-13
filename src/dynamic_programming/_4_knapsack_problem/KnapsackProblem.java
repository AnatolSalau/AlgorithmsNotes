package dynamic_programming._4_knapsack_problem;

import javafx.util.Pair;

import java.util.stream.IntStream;

/**
 * <a href="https://www.youtube.com/watch?v=fqvwVE0Ds94&ab_channel=NikhilLohia">...</a>
 */
public class KnapsackProblem {
    public static void main(String[] args) {

        Pair<Integer, Integer> apple = new Pair<>(50, 100);
        Pair<Integer, Integer> cookie = new Pair<>(100, 200);
        Pair<Integer, Integer> fish = new Pair<>(150, 300);
        Pair<Integer, Integer> broccoli = new Pair<>(200, 350);
        Pair<Integer, Integer> soup = new Pair<>(250, 400);

        test1();
        test2();
        test3();

    }

    private static int getMaxFullness(Pair<Integer, Integer>[] dishes, int caloriesAmount) {
        int qtyRows = dishes.length + 1;
        int qtyColumns = 500 / 50 + 1;
        int[][] memorization = new int[qtyRows][qtyColumns];
        fillZeroRow(memorization);

        for (int i = 1; i < qtyRows; i++) {
            int[] currRow = memorization[i];
            int indexLastDishForCurrRow = i - 1;
            Pair<Integer, Integer> lastDish = dishes[indexLastDishForCurrRow];
            for (int j = 1; j < qtyColumns; j++) {
                int currCalories = memorization[0][j];

                int dishCalories = lastDish.getKey();
                int dishFulness = lastDish.getValue();
                int remainder = currCalories - dishCalories;
                int maxFulnessFromColumn = getMaxFulnessFromColumn(memorization, remainder);
                int currMaxFullness =  maxFulnessFromColumn + dishFulness;
                currRow[j] = currMaxFullness;
            }
        }
        System.out.println();
        /*
         * Matrix i x j : i - rows（dishes）, j - columns (calories: 50,100,150,200,250,300,350,400,450,500)
         */

        return 0;
    }

    private static void fillZeroRow(int[][] memorization) {
        int[] zeroRow = memorization[0];
        int calories = 50;
        for (int i = 1; i < zeroRow.length; i++) {
            zeroRow[i] = calories;
            calories += 50;
        }
    }

    private static int getMaxFulnessFromColumn(int[][] memorization, int calories) {
        int maxFulness = 0;
        for (int i = 1; i < memorization.length-1; i++) {
            int[] row = memorization[i];
            for (int j = 0; j < row.length; j++) {
                int currFulness = row[j];
                if (memorization[0][j] == calories) {
                    maxFulness = Math.max(currFulness, maxFulness);
                }
            }
        }
        return maxFulness;
    }

    /*
     * Check max fullness for apple, cookie, fish and 350 calories
     */
    private static void test1() {
        System.out.println("Test 1");
        Pair<Integer, Integer>[] dishes = new Pair[]{new Pair<>(50, 100), new Pair<>(100, 200), new Pair<>(150, 300)};
        System.out.println("Apple : " + dishes[0] + ", Cookie : " + dishes[1] + ", Fish : " + dishes[2]);
        System.out.println("Max fullness for 350 calories : " + getMaxFullness(dishes, 350));
        System.out.println("Expected : " + 600);
        System.out.println();
    }

    /*
     * Check max fullness for apple, cookie, fish, broccoli and 450 calories
     */
    private static void test2() {
        System.out.println("Test 2");
        Pair<Integer, Integer>[] dishes = new Pair[]{new Pair<>(50, 100), new Pair<>(100, 200), new Pair<>(150, 300), new Pair<>(200, 350)};
        System.out.println("Apple : " + dishes[0] + ", Cookie : " + dishes[1] + ", Fish : " + dishes[2] + ", Broccoli : " + dishes[3]);
        System.out.println("Max fullness for 450 calories : " + getMaxFullness(dishes, 450));
        System.out.println("Expected : " + 850);
        System.out.println();
    }

    /*
     * Check max fullness for apple, cookie, fish, broccoli, soup and 500 calories
     */
    private static void test3() {
        System.out.println("Test 3");
        Pair<Integer, Integer>[] dishes = new Pair[]{new Pair<>(50, 100), new Pair<>(100, 200), new Pair<>(150, 300), new Pair<>(200, 350), new Pair<>(250, 400)};
        System.out.println("Apple : " + dishes[0] + ", Cookie : " + dishes[1] + ", Fish : " + dishes[2] + ", Broccoli : " + dishes[3] + ", Soup : " + dishes[4]);
        System.out.println("Max fullness for 500 calories : " + getMaxFullness(dishes, 500));
        System.out.println("Expected : " + 950);
        System.out.println();
    }
}
