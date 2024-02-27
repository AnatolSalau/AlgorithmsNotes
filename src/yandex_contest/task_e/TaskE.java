package yandex_contest.task_e;

import java.util.HashMap;

public class TaskE {
      /**
       Даны две строки, состоящие из строчных латинских букв.
       Требуется определить, являются ли эти строки анаграммами,
       т. е. отличаются ли они только порядком следования символов.
       */
      public static void main(String[] args) {
            String str1 = "abcd";
            String str2 = "dcba";
            boolean anagramaOrNot = isAnagram(str1, str2);
            System.out.println("anagramaOrNot : " + anagramaOrNot);
      }

      static boolean isAnagram(String str1, String str2) {
            if (str1.length() != str2.length()) {
                  return false;
            }
            HashMap<Character, Integer> statisticMap1 = getStatisticMap(str1);
            HashMap<Character, Integer> statisticMap2 = getStatisticMap(str2);

            return statisticMap1.equals(statisticMap2);
      }

      static HashMap<Character, Integer> getStatisticMap(String str) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char[] characters = str.toCharArray();

            for (int i = 0; i < characters.length; i++) {

                  if(hashMap.containsKey(characters[i])) {
                        Integer count = hashMap.get(characters[i]);
                        count += 1;
                        hashMap.put(characters[i], count);
                  }
                  else {
                        hashMap.put(characters[i], 1);
                  }
            }
            return hashMap;
      }
}
