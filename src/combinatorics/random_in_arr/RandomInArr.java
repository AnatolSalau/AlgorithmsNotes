package combinatorics.random_in_arr;

import java.util.Arrays;
import java.util.Random;

public class RandomInArr {
      /**
       Необходимо outputSize раз взять случайным образом элементы из списка input и
       поместить
       * их в выходной список. Повторения допустимы.
       *
       *  input  - входной список
       *  outputSize - размер выходного списка
       *  result - выходной список со случайными элементами из входного списка
       */
      public static void main(String[] args) {
            int[] input = {1,2,3};
            int[] result = getRandomArr(input, 6);
            System.out.println(Arrays.toString(result));
      }

      static int[] getRandomArr(int[] input, int outputSize) {
            int[] result = new int[outputSize];
            Random random = new Random();
            for (int i = 0; i < outputSize; i++) {
                  int randomIndex = random.nextInt(input.length);
                  result[i] = input[randomIndex];
            }
            return result;
      }
}
