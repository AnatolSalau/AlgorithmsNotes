package dynamic_programming._1_ariphmetic_progression;

public class AriphmeticProgression {
      /**
       * Find sum numbers from n to m by dynamic programming
       */
      public static void main(String[] args) {
            AriphmeticProgression ariphmeticProgression = new AriphmeticProgression();
            System.out.println("Sum from 1 to 5 (1,2,3,4,5) = 15");
            System.out.println(STR."Answer: \{ariphmeticProgression.findSumFromNToM(1, 5)}, .");
            System.out.println();

      }

      public int findSumFromNToM(int n, int m) {
            if (n <= m) {
                  int recursiveResult = findSumFromNToM(n + 1, m);//direct recursion way
                  return n + recursiveResult;//reverse recursion way
            }
            return 0;
      }
}
