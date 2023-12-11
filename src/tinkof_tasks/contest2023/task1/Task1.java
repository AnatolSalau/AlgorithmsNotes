package tinkof_tasks.contest2023.task1;

/**
      Абонентская плата составляет A рублей в месяц.
      За эту стоимость Костя получает B мегабайт трафика.
      Если Костя выйдет за лимит трафика,
      то каждый следующий мегабайт будет стоить ему С рублей.

      Костя планирует потратить D мегабайт в следующем месяце.
      Помогите сосчитать - во сколько обойдется интернет.

      Ввод:
      A - стоимость тарифа (абонентская плата)
      В - размер тарифа
      С - стоимость каждого лишнего мегабайта
      D - сколько Костя потратит мегабайт

      Вывод:
      Вывести одно число - суммарные расходы Кости на интернет

      Пример1:
      100 - стоимость тарифа
      10 - размер тарифа МБ
      12 - стоимость 1 лишнего мегабайта
      15 - сколько Костя потратит

      Итого: 160

      5 лишних мегабайт - 5 х 12 = 60 - цена лишних мегабайт
      60 + 100 (стоимость тарифа) = 160

      Пример2:
      100 10 12 1
      Итого: 100

      100 - так как Костя укладывается  в размер трафика
 */
public class Task1 {
      public static void main(String[] args) {
            Task1 task1 = new Task1();

            task1.testByExtraSize();
            task1.testWithoutExtraSize();
      }

      private  void testByExtraSize() {
            int ratePrice = 100;
            int rateSize = 10;
            int oneExtraMbPrice = 12;
            int featureRateSize = 15;

            System.out.println("Rate price " + ratePrice);
            System.out.println("Rate size " + rateSize);
            System.out.println("One extra Mb price " + oneExtraMbPrice);
            System.out.println("Feature rate size " + featureRateSize);
            System.out.println("Result (feature price) : " +
                  getFeatureCost(ratePrice,rateSize,oneExtraMbPrice,featureRateSize)
            );
            System.out.println();
      }

      private  void testWithoutExtraSize() {
            int ratePrice = 100;
            int rateSize = 10;
            int oneExtraMbPrice = 12;
            int featureRateSize = 1;

            System.out.println("Rate price " + ratePrice);
            System.out.println("Rate size " + rateSize);
            System.out.println("One extra Mb price " + oneExtraMbPrice);
            System.out.println("Feature rate size " + featureRateSize);
            System.out.println("Result (feature price) : " +
                  getFeatureCost(ratePrice,rateSize,oneExtraMbPrice,featureRateSize)
            );
            System.out.println();
      }

      private int getFeatureCost(int ratePrize, int rateSize, int oneExtraMbPrice, int featureRateSize ) {
            //return ratePrize if we have enough MB size
            if (featureRateSize <= rateSize) {
                  return ratePrize;
            }

            int extraMBSize = featureRateSize - rateSize;

            int extraPrice = extraMBSize * oneExtraMbPrice;

            int featurePrize = extraPrice + ratePrize;

            return featurePrize;
      }
}
