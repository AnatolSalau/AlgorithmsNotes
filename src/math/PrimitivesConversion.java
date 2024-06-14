package math;

import java.util.Arrays;
import java.util.stream.IntStream;

public class PrimitivesConversion {
      public static void main(String[] args) {
            //int -> short -> byte
            byte b = 0;
            short s = 1;
            int i = b + s;

            // int -> long
            long l = 125;
            long l1 = l + i;

            //double -> float ->long
            double d = 0.125;
            float f = 0.125F;

            // double -> float
            double f1 = d + f;

            // long -> integer
            long l3 = l + i ;

            int[] arr = {1,2,3};

      }
}
