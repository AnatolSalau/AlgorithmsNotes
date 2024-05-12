package functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class ConsumerExample {
      public static void main(String[] args) {
            Consumer<String> printStr = str -> System.out.println(str);
            Consumer<String> printStrShort = System.out::println;

            //BiConsumer<String, String> concatAndPrint = (str1, str2) -> System.out.println(str1+str2);
            BiConsumer<String, Integer> concatAndPrint = ConsumerExample::concatAndPrintMeth;

            printStr.accept("printStr");
            printStrShort.accept("printStr");
            concatAndPrint.accept("Srt1", 1);

            List<String> namesList = new ArrayList<>(List.of("one", "two", "three"));

            Consumer<List<String>> upperCaseAllNodesConsumer = list -> {
                  IntStream.range(0,list.size())
                        .forEach(i -> {
                              list.set(i,list.get(i).toUpperCase());
                        });
            };
            Consumer<List<String>> printAllNodesConsumer = list -> {
                  IntStream.range(0,list.size())
                        .forEach(i -> {
                              System.out.println(list.get(i));
                        });
            };

            upperCaseAllNodesConsumer.andThen(printAllNodesConsumer).accept(namesList);
            System.out.println(namesList);

      }

      private static void concatAndPrintMeth(String s1, Integer i1) {
            System.out.println(s1+i1);
      }
}
