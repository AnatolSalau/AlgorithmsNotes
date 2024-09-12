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
        int qtyRows = dishes.length;
        int qtyColumns = 500 / 50 + 1;
        int[][] memorization = new int[qtyRows][qtyColumns];


        /*
         * Matrix i x j : i - rows（dishes）, j - columns (calories: 50,100,150,200,250,300,350,400,450,500)
         */
        int maxDishesLimitInCaloriesForCurrRow = 50;
        for (int i = 0; i < qtyRows; i++) {
            int currCaloriesInColumn = 50;

            for (int j = 1; j < qtyColumns; j++) {

                int currMaxFulness = 0;
                //go through all dishes from last to first
                for (int k = dishes.length - 1; k >= 0; k--) {
                    if (dishes[k].getKey() > maxDishesLimitInCaloriesForCurrRow) { //skip calories in current dishes more then max calories
                        continue;
                    }
                    Pair<Integer, Integer> currDish = dishes[k];
                    Integer dishCalories = currDish.getKey();
                    Integer dishFulness = currDish.getValue();

                    Integer remainder = currCaloriesInColumn - dishCalories;

                    int columnIndexForRemainder = convertCaloriesToColumnIndex(remainder);

                    int maxFulnessForRemainder = getMaxFulnessForColumn(memorization, columnIndexForRemainder);

                    currMaxFulness = Math.max(maxFulnessForRemainder + dishFulness, currMaxFulness);

                }
                memorization[i][j] = currMaxFulness;
                currCaloriesInColumn += 50;
            }
            maxDishesLimitInCaloriesForCurrRow += 50;
        }
        System.out.println();
        int columnIndex = convertCaloriesToColumnIndex(caloriesAmount);
        return memorization[dishes.length - 1][columnIndex];
    }

    private static int getMaxFulnessForColumn(int[][] memorization, int columnIndex) {
        int maxFulness = 0;
        for (int i = 0; i < memorization.length; i++) {
            int[] currRow = memorization[i];
            int currFulness = currRow[columnIndex];
            maxFulness = Math.max(maxFulness, currFulness);
        }
        return maxFulness;
    }

    private static int convertCaloriesToColumnIndex(int calories) {
        return calories / 50;
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
    }
}
