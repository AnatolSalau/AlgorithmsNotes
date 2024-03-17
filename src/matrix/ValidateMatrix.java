package matrix;

import java.util.HashMap;

public class ValidateMatrix {
      /**
       * Матрица должна быть валидна в соответствии с нижележащими правилами
       * 1) Каждая строка должна содержать цифру от 1 до 9 без повторений
       * 2) Каждая колонка должна содержать цифру от 1 до 9 без повторений
       * 3) Матрица может частично заполнена, пустые ячейки содержат '.'
       * 4) Значение ячейки валидно если это цифра от 1 до 9 или .
       * 5) Наличие букв в качестве значений недопустимо
       */
      public static void main(String[] args) {
            char[][] matrix = {
                    {'5', '3', '1', '.', '7', '.', '.', '.', '.'}
                  , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                  , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                  , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                  , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                  , {'7', '.', '.', '.', '.', '.', '.', '.', '6'}
                  , {'1', '6', '.', '.', '.', '.', '2', '8', '.'}
                  , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                  , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
            };
            System.out.println(validMatrix(matrix));
      }
      /*
            Explanation
            1. Create qreq map
                  where all character will have qty 1
                  but character "." will have qty - 1
            2. Iterate through map
                  through all horizontal line - validate each line
                  through all vertical lines - validate each vertical column

                  When we are iterating through column or stroke
                        1. check qty in map
                        if qty == -1 -> this is "." and we haven't to check this character
                        if qty != -1 -> reduce qty
                              we face character only on time in every stroke or column
                              if we face character twice -> this column is wrong and we have to return false


       */
      static boolean validMatrix(char[][] matrix) {
            return goThroughAllColumns(matrix) == goThroughAllLines(matrix);
      }

      static boolean goThroughAllLines(char[][] matrix) {
            for (int y = 0; y < matrix.length; y++) {//iterate through all  - strokes
                  HashMap<Character, Integer> characterFrequencyMap = getCharFreqMap();
                  char[] line = matrix[y];
                  for (int x = 0; x < line.length; x++) {//iterate through all  - columns
                        char curr = line[x];
                        if (!validateCharacter(curr, characterFrequencyMap)) return false;//return false if char has wrong validation
                  }
            }
            return true;
      }

      static boolean goThroughAllColumns(char[][] matrix) {
                  for (int x = 0; x < matrix.length; x++) { // iterate through all x - horizontal index
                        HashMap<Character, Integer> characterFrequencyMap = getCharFreqMap();//map with frequency of chars in column
                        for (int y = 0; y < matrix.length; y++) {// iterate through all y - vertical index
                              char curr = matrix[y][x];
                              if (!validateCharacter(curr, characterFrequencyMap)) return false;//return false if char has wrong validation
                        }
                  }
            return true;
      }

      static boolean validateCharacter(Character character, HashMap<Character, Integer> freqMap) {
            if (freqMap.containsKey(character)) { // check existence in map
                  int quantity = freqMap.get(character); // get qty
                  if (quantity >= 0) { // check only characters with qty >=0
                        if (quantity != 1) { // check qty -> if qty is not 1 return false
                              return false;
                        } else {//decrease qty in map
                              quantity -= 1;
                        }
                        freqMap.put(character, quantity); // save new qty in map
                  }
                  return true;
            } else { // if char doesn't exist in map return false
                  return false;
            }
      }
      static HashMap<Character, Integer> getCharFreqMap() {
            HashMap<Character, Integer> characterFrequencyMap = new HashMap<>();
            characterFrequencyMap.put('1', 1);
            characterFrequencyMap.put('2', 1);
            characterFrequencyMap.put('3', 1);
            characterFrequencyMap.put('4', 1);
            characterFrequencyMap.put('5', 1);
            characterFrequencyMap.put('6', 1);
            characterFrequencyMap.put('7', 1);
            characterFrequencyMap.put('8', 1);
            characterFrequencyMap.put('9', 1);
            characterFrequencyMap.put('.', -1);
            return characterFrequencyMap;
      }

}
