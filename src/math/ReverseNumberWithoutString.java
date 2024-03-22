package math;

public class ReverseNumberWithoutString {
      /**
       Реверс числа без использования строк
       */
      /**
       Алгоритм:

       1. Найдем остаток от деления на 10 исходного (первого) числа. Тем самым получим последнюю его цифру. Запомним ее.
       2. Присвоим эту цифру новому (второму) числу-"перевертышу".
       3. Разделим нацело на 10 первое число. Тем самым избавимся от последней цифры в нем.
       4.  Снова найдем остаток от деления на 10 того, что осталось от первого числа. Запомним цифру-остаток.
       5. Разделим нацело на 10 первое число. Избавимся от текущей последней цифры в нем.
       Умножим на 10 второе число. Тем самым увеличим его разрядность до двух и сдвинем первую цифру в более старший разряд.
       Добавим к полученному второму числу запомненную ранее цифру из первого числа.
       Будем повторять действия п. 4-7 пока первое число не уменьшится до нуля, т. е. пока не избавимся от всех его разрядов.
       */
      public static void main(String[] args) {
            testOne();
      }
      /*
            1. Initialize new number by las symbol from old number
            2. Reduce last symbol from old number
            3. Run cycle while until old number is not 0
                  1. Increase new number by adding zero to the end
                  2. Replace last zero in new number by last char from old
                  3. Reduce last symbol from old number
       */
      private static int getReverseNum(int num) {
            int newNumber = num % 10;//1. Initialize new number by las symbol from old number
            num = num / 10; //2. Reduce last symbol from old number
            while (num > 0) {//3. Run cycle while until old number is not 0
                  newNumber = newNumber * 10;//1. Increase new number by adding zero to the end
                  newNumber = newNumber + (num % 10); // 2. Replace last zero in new number by last char from old
                  num = num / 10;//3. Reduce last symbol from old number
            }
            return newNumber;
      }

      private static void testOne() {
            int num = 123;
            int expectedResult = 321;
            System.out.println("test 1");
            System.out.println("Old num : " + num);
            System.out.println(getReverseNum(num));
            System.out.println("Expected result = " + expectedResult);
      }
}
