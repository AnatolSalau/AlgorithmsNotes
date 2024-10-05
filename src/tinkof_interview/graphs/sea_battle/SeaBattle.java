package tinkof_interview.graphs.sea_battle;

public class SeaBattle {
      public static void main(String[] args) {
            SeaBattle seaBattleVar1 = new SeaBattle();
            seaBattleVar1.test1();
            seaBattleVar1.test2();
      }

      public int getShipsCount(char[][] map) {
            if (map == null || map.length == 0) throw new RuntimeException("Map is incorrect");
            int shipCount = 0;

            for (int i = 0; i < map.length; i++) {
                  if (map[0] == null || map[0].length == 0) throw new RuntimeException("Row in map is incorrect");

                  for (int j = 0; j < map[0].length; j++) {
                        if (map[i][j] == 'X') {
                              if ( isVisitedShip(map,i, j) ) {
                                    continue;
                              } else {
                                    shipCount++;
                              }
                        }
                  }
            }
            return shipCount;
      }

      public boolean isVisitedShip(char[][] map, int i, int j) {
            if ( i > 0 && (map[i-1][j] == 'X') ) return true;
          return j > 0 && (map[i][j - 1] == 'X');
      }

      public void test1() {
            char[][] map = {
                        {'X', '.', '.', 'X'},
                        {'.', '.', '.', 'X'},
                        {'.', '.', '.', 'X'}
            };
            int expected = 2;
            System.out.println("Test 1");
            System.out.println("Result : " + getShipsCount(map));
            System.out.println("Expected : " + expected);
      }

      public void test2() {
            char[][] map = {
                  {'X', '.', '.', 'X'},
                  {'.', '.', '.', '.'},
                  {'.', 'X', 'X', '.'}
            };
            int expected = 3;
            System.out.println("Test 2");
            System.out.println("Result : " + getShipsCount(map));
            System.out.println("Expected : " + expected);
      }
}