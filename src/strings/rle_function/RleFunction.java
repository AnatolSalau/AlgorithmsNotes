package strings.rle_function;

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

      }

      private void testOne() {
            String input = "AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB";
            System.out.println(input);
            doRLE(input);
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

      private void doRLE(String input) {
            //check string
            checkString(input);

            char[] characters = input.toCharArray();
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < characters.length; i++) {
                  char curr = characters[i];
                  //check character
                  checkCharacter(curr);

            }
      }

      private void checkString(String str) {
            if (str.isBlank()) throw new RuntimeException("Invalid string");
      }

      private void checkCharacter(Character character) {
            if (Character.isDigit(character)) throw new RuntimeException("Character is digit");

            if (Character.isLowerCase(character)) throw new RuntimeException("Character is lower case");

            if (Character.isWhitespace(character)) throw new RuntimeException("Character is whitespace");
      }
}
