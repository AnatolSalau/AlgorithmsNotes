package dynamic_programming._4_knapsack_problem;

/*
    https://neerc.ifmo.ru/wiki/index.php?title=%D0%97%D0%B0%D0%B4%D0%B0%D1%87%D0%B0_%D0%BE_%D1%80%D1%8E%D0%BA%D0%B7%D0%B0%D0%BA%D0%B5
 */
public class KnapsackProblem2 {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        int capacity = 13;
        int qty = 5;
        int[] capacities = {3, 4, 5, 8, 9};
        int[] prices = {1, 6, 4, 7, 6};

        int maxPrice = getMaxPrice(capacity, qty, capacities, prices);
        System.out.println("Max price");
        System.out.println(maxPrice);
        System.out.println("Expected result = 13");
    }

    private static int getMaxPrice(int capacityOfKnapsack, int qty, int[] capacities, int[] prices) {
        int[][] memorization = new int[qty + 1][capacityOfKnapsack + 1];
        int startColumn = capacities[0]; // get first capacity

        for (int i = 1; i < qty + 1; i++) {
            int[] currRow = memorization[i];
            for (int j = startColumn; j < capacityOfKnapsack; j++) {
                int colMaxCapacity = j;
                int thingCapacity = getThingCapacity(capacities, i - 1);
                int thingPrice = getThingPrice(prices, i - 1);
                int remainder = thingCapacity - colMaxCapacity;
                int maxCapacityFromColumn = getMaxCapacityFromColumn(memorization, remainder, i);
                System.out.println();
            }
        }
        return 0;
    }

    private static int getMaxCapacityFromColumn(int[][] memorization, int remainder, int currRowIndex) {
        return memorization[currRowIndex - 1][remainder];
    }

    private static int getThingPrice(int[] prices, int thingIndex) {
        return prices[thingIndex];
    }

    private static int getThingCapacity(int[] capacities, int thingIndex) {
        return capacities[thingIndex];
    }
}
