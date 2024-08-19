package tinkof_interview.sortings_searchings.search_in_rotated_sorted;

public class SearchInRotatedSorted {
      public static void main(String[] args) {
            SearchInRotatedSorted searchInRotatedSorted = new SearchInRotatedSorted();
            searchInRotatedSorted.test1();
            searchInRotatedSorted.test2();
      }

      public int search(int[] nums, int target) {
            return doSearch(nums, 0, nums.length - 1, target);
      }

      private int doSearch(int[] arr, int startIndex, int endIndex, int target) {
            //exit from recursion
            if (startIndex <= endIndex) {
                  int middleIndex = startIndex + ((endIndex - startIndex) / 2);

                  int middle = arr[middleIndex];

                  if (middle == target) return middleIndex;

                  if (target < middle) { // target less than middle do search in left half
                        return doSearch(arr, startIndex, middleIndex - 1, target);
                  } else {// target more than middle so do search in right half
                        return doSearch(arr, middleIndex + 1, endIndex, target);
                  }
            }
            return -1;
      }

      public void test1() {
            System.out.println("Test 1");
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            int target = 0;

            int search = search(nums, target);
            System.out.println("Result : " + search);
            System.out.println("Expect : " + 4);
      }

      public void test2() {
            System.out.println("Test 1");
            int[] nums = {4, 5, 6, 7, 0, 1, 2};
            int target = 3;

            int search = search(nums, target);
            System.out.println("Result : " + search);
            System.out.println("Expect : " + "-1");
      }
}
