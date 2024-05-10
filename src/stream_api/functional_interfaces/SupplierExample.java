package stream_api.functional_interfaces;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.DoubleSupplier;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SupplierExample {
      public static void main(String[] args) {
            DoubleSupplier getDouble = Math::random;
            double randomDouble = getDouble.getAsDouble();
            //Supplier<String> getCurrDateStr = () -> new Date().toString();
            Supplier<String> getCurrDateStr2 = SupplierExample::dateToStr;

            List<String> dateList = IntStream.range(0, 10)
                  //.mapToObj(i -> getCurrDateStr.get())
                  .mapToObj(i -> getCurrDateStr2.get())
                  .collect(Collectors.toList());

            System.out.println(dateList);
      }

      private static String dateToStr() {
            return new Date().toString();
      }
}
