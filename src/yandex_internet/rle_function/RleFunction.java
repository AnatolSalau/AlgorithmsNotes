package yandex_internet.rle_function;

/**
       Дана строка, состоящая из букв A-Z:
       * "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB"
       * Нужно написать функцию RLE, которая на выходе даст строку вида:
       * "A4B3C2XYZD4E3F3A6B28"
       * И сгенерирует любую ошибку, если на вход пришла невалидная строка.
       *
       * Пояснения:
       * 1. Если символ встречается 1 раз, он остается без изменений
       * 2. Если символ повторяется более 1 раза, к нему добавляется количество
       повторений
 */
public class RleFunction {
      public static void main(String[] args) {
            RleFunction rleFunction = new RleFunction();
            rleFunction.testOne();
            rleFunction.testFour();
            //rleFunction.testTwo();
            rleFunction.testThree();
      }

      private void testOne() {
            String input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
            System.out.println(input);
            String result = doRLE(input);
            System.out.println("A4B3C2XYZD4E3F3A6B28");
            System.out.println(result);
            System.out.println();
      }
      private void testFour() {
            String input = "ABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
            System.out.println(input);
            String result = doRLE(input);
            System.out.println("AB3C2XYZD4E3F3A6B28");
            System.out.println(result);
            System.out.println();
      }
      private void testTwo() {
            String input = "";
            System.out.println(input);
            doRLE(input);
            System.out.println();
      }

      private void testThree() {
            String input = null;
            System.out.println(input);
            doRLE(input);
            System.out.println();
      }

      private String doRLE(String input) {
            checkString(input);
            StringBuilder stringBuilder = new StringBuilder();

            char[] chars = input.toCharArray();

            int count = 0;

            for (int i = 0; i < chars.length; i++) {

                  checkCharacter(chars[i]);

                  for (int j = i; j < chars.length; j++) {
                        if (chars[i] == chars[j]) {
                              count++;
                              if (j != chars.length - 1) { // check the last character
                                    continue;
                              }
                        }

                        if (count == 1) {
                              stringBuilder.append(chars[i]);
                        } else {
                              stringBuilder.append(chars[i]);
                              stringBuilder.append(count);
                        }
                        i = j;
                        count = 1;
                  }
            }
            return stringBuilder.toString();
      }

      private void checkString(String str) {
            if (str == null || str.isBlank()) throw new RuntimeException("Invalid string");
      }

      private void checkCharacter(Character character) {
            if (Character.isDigit(character)) throw new RuntimeException("Character is digit");

            if (Character.isLowerCase(character)) throw new RuntimeException("Character is lower case");

            if (Character.isWhitespace(character)) throw new RuntimeException("Character is whitespace");
      }
}