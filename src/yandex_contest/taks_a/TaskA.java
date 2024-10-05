package yandex_contest.taks_a;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class TaskA {
      /**
       * Даны две строки строчных латинских символов: строка J и строка S.
       * Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
       * Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
       * Проще говоря, нужно проверить, какое количество символов из S входит в J.
       */
      public static void main(String[] args) {
            String[] jewels = {"a", "b", "c", "d", "e", "f"};
            String[] stones = { "d", "e", "f"};

            int countOfStonesInJewelBySet = getCountOfStonesInJewelBySet(jewels, stones);
            System.out.println("countOfStonesInJewelBySet : " + countOfStonesInJewelBySet);
      }

      /**
       * O(n + m) - time
       * O(n) - memory
       */
      static int getCountOfStonesInJewelBySet(String[] jewels, String[] stones) {
            int count = 0;
            //create set from jewels
            Set<String> jewelsSet = new HashSet<>();
          Collections.addAll(jewelsSet, jewels);
            //check stones
            for (int i = 0; i < stones.length; i++) {
                  if (jewelsSet.contains(stones[i])) count++;
            }
            return count;
      }
}