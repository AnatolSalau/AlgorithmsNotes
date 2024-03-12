package math;

public class ReplaceABWithoutLoop {
      /**
       a = 5
       b = 10
       без циклов и условных операторов не вводя третью
       переменную поменять местами a и b т.е. а = 10 b = 5;
       */
      public static void main(String[] args) {
            int a = 5;
            int b = 10;
            System.out.println("a = " + a + ", b = " + b);

            a = a + b;
            b = a - b;
            a = a - b;
            System.out.println("a = " + a + ", b = " + b);

            a = a + b - (b = a);
            System.out.println("a = " + a + ", b = " + b);
      }
}
