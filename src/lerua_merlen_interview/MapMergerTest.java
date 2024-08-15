package lerua_merlen_interview;

import java.util.*;
/*
      Реализовать метод с наименьшей алгоритмической сложностью, который принимает два списка карт List<Map<K,V>>
      и возвращает одну карту Map<K, Map.Entry<V1, V2>>.
      Если ключи в картах из двух списков совпадают, необходимо добавить этот ключ в итоговую карту,
      а значения из двух карт положить в качестве пары Map.Entry<V1, V2>.
 */
public class MapMergerTest {

      public static <K, V> Map<K, Map.Entry<V, V>> mergeMaps(List<Map<K, V>> list1, List<Map<K, V>> list2) {
            Map<K, Map.Entry<K, V>> map1 = new HashMap<>();

            for(Map<K, V> entry : list1) {
                  entry.entrySet().forEach( kvEntry -> {
                              map1.put(kvEntry.getKey(), kvEntry);
                        }
                  );
            }

            Map<K, Map.Entry<V, V>> result = new HashMap<>();

            for (Map<K, V> entry : list2) {
                  entry.entrySet().forEach(kvEntry -> {
                        K key = kvEntry.getKey();
                        if (map1.containsKey(key)) {
                              V value1 = map1.get(key).getValue();
                              V value2 = kvEntry.getValue();
                              Map.Entry<V, V> entryRes = new AbstractMap.SimpleEntry<>(value1, value2);
                                    result.put(key, entryRes);
                              }
                        }
                  );
            }
            return result;
      }

      public static void main(String[] args) {
            // Пример 1
            Map<String, Integer> map1a = new HashMap<>();
            map1a.put("key1", 1);
            map1a.put("key2", 2);
            map1a.put("key3", 3);

            Map<String, Integer> map2a = new HashMap<>();
            map2a.put("key2", 4);
            map2a.put("key3", 5);
            map2a.put("key4", 6);

            List<Map<String, Integer>> list1a = new ArrayList<>();
            list1a.add(map1a);

            List<Map<String, Integer>> list2a = new ArrayList<>();
            list2a.add(map2a);

            System.out.println("Пример 1:");
            System.out.println(list1a);
            System.out.println(list2a);
            Map<String, Map.Entry<Integer, Integer>> result1 = mergeMaps(list1a, list2a);
            result1.forEach((key, value) -> System.out.println(key + " -> (" + value.getKey() + ", " + value.getValue() + ")"));

            // Пример 2
            Map<String, Integer> map1b = new HashMap<>();
            map1b.put("apple", 10);
            map1b.put("banana", 20);

            Map<String, Integer> map2b = new HashMap<>();
            map2b.put("banana", 30);
            map2b.put("cherry", 40);

            List<Map<String, Integer>> list1b = new ArrayList<>();
            list1b.add(map1b);

            List<Map<String, Integer>> list2b = new ArrayList<>();
            list2b.add(map2b);

            System.out.println("\nПример 2:");
            System.out.println(list1b);
            System.out.println(list2b);
            Map<String, Map.Entry<Integer, Integer>> result2 = mergeMaps(list1b, list2b);
            result2.forEach((key, value) -> System.out.println(key + " -> (" + value.getKey() + ", " + value.getValue() + ")"));

            // Пример 3
            Map<String, Integer> map1c = new HashMap<>();
            map1c.put("x", 100);
            map1c.put("y", 200);

            Map<String, Integer> map2c = new HashMap<>();
            map2c.put("y", 300);
            map2c.put("z", 400);

            Map<String, Integer> map3c = new HashMap<>();
            map3c.put("y", 500);
            map3c.put("w", 600);

            List<Map<String, Integer>> list1c = new ArrayList<>();
            list1c.add(map1c);

            List<Map<String, Integer>> list2c = new ArrayList<>();
            list2c.add(map2c);
            list2c.add(map3c);

            System.out.println("\nПример 3:");
            System.out.println(list1c);
            System.out.println(list2c);
            Map<String, Map.Entry<Integer, Integer>> result3 = mergeMaps(list1c, list2c);
            result3.forEach((key, value) -> System.out.println(key + " -> (" + value.getKey() + ", " + value.getValue() + ")"));
      }
}
