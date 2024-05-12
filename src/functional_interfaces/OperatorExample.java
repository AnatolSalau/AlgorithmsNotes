package functional_interfaces;

import java.util.function.UnaryOperator;

public class OperatorExample {
      public static void main(String[] args) {
            UnaryOperator<String> strToUpperCase = s -> s.toUpperCase();
            UnaryOperator<String> strToUpperCase2 = s -> strToUpperCaseMeth(s);

            System.out.println(strToUpperCase.apply("hello"));
            System.out.println(strToUpperCase2.apply("hello"));


      }

      private static String strToUpperCaseMeth(String str) {
            return str.toUpperCase();
      }
}
