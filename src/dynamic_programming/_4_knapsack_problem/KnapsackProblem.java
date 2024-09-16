package dynamic_programming._4_knapsack_problem;

import javafx.util.Pair;

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

            for (int j = 1; j < qtyColumns; j++) {
                int currCalories = memorization[0][j];
                Pair<Integer, Integer> lastDish = getLastDish(dishes, indexLastDishForCurrRow, currCalories);
                int dishCalories = lastDish.getKey();
                int dishFulness = lastDish.getValue();

                int remainder = currCalories - dishCalories;
                int maxFulnessFromColumn = getMaxFromColumn(memorization, i, j);
                if (remainder > 0) {
                    int maxFulnessForRemainder = getMaxFulnessForRemainder(memorization, i, j, remainder);
                    int currMaxFullness =  dishFulness + maxFulnessForRemainder;
                    currRow[j] = Math.max(currMaxFullness, maxFulnessFromColumn);
                } else {
                    currRow[j] = Math.max(dishFulness, maxFulnessFromColumn);
                }
            }
        }

        /*
         * Matrix i x j : i - rows（dishes）, j - columns (calories: 50,100,150,200,250,300,350,400,450,500)
         */

        for (int i = 0; i < qtyColumns; i++) {
            if (memorization[0][i] == caloriesAmount) {
                return memorization[memorization.length - 1][i];
            }
        }
        return -1;
    }

    private static void fillZeroRow(int[][] memorization) {
        int[] zeroRow = memorization[0];
        int calories = 50;
        for (int i = 1; i < zeroRow.length; i++) {
            zeroRow[i] = calories;
            calories += 50;
        }
    }

    private static int getMaxFulnessForRemainder(int[][] memorization, int rowIndex, int columnIndex, int remainder) {
        int maxFulness = 0;
        for (int i = 1; i < rowIndex; i++) {
            int[] row = memorization[i];
            for (int j = 0; j <= columnIndex; j++) {
                if (memorization[0][j] == remainder) {
                    int currFulness = row[j];
                    maxFulness = Math.max(currFulness, maxFulness);
                    break;
                }
            }
        }
        return maxFulness;
    }

    private static int getMaxFromColumn(int[][] memorization, int rowIndex, int columnIndex) {
        int max = 0;
        for (int i = 1; i < rowIndex; i++) {
            int currFulness = memorization[i][columnIndex];
            max = Math.max(currFulness, max);
        }
        return max;
    }

    private static Pair<Integer, Integer> getLastDish(Pair<Integer, Integer>[] dishes, int indexLastDishForCurrRow, int maxCalories) {
        Pair<Integer, Integer> lastDish = dishes[indexLastDishForCurrRow];
        if (lastDish.getKey() > maxCalories) {
            while (lastDish.getKey() > maxCalories) {
                indexLastDishForCurrRow--;
                lastDish = dishes[indexLastDishForCurrRow];
            }
        }
        return lastDish;
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
