package strings.add_separator_to_string;

/**
 * Create string from array with separator
 */

public class AddSeparatorToString {

      public static void main(String[] args) {
            AddSeparatorToString addSeparatorToString = new AddSeparatorToString();
            addSeparatorToString.test1();
      }
      private String getStringWithSeparator(String[] arr, String separator) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < arr.length; i++) {
                  String curr = arr[i];

                  stringBuilder.append(curr);

                  if (i != arr.length - 1) {
                        stringBuilder.append(separator);
                  }
            }
            return stringBuilder.toString();
      }
      private void test1() {
            String[] arr = {"One", "Two", "Three", "Four"};
            String s = getStringWithSeparator(arr, "-");
            System.out.println(s);
            System.out.println("Expected result :");
            System.out.println("One-Two-Three-Four");
      }
}
