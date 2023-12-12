package searchs.binary_search;
/**
       Given an array of integers nums which is sorted in ascending order,
       and an integer target, write a function to search target in nums.
       If target exists, then return its index. Otherwise, return -1.

       You must write an algorithm with O(log n) runtime complexity.

       Example 1:

       Input: nums = [-1,0,3,5,9,12], target = 9
       Output: 4
       Explanation: 9 exists in nums and its index is 4

       Example 2:

       Input: nums = [-1,0,3,5,9,12], target = 2
       Output: -1
       Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch {
      public static void main(String[] args) {
            BinarySearch binarySearch = new BinarySearch();
            binarySearch.testByTargetNine();
            binarySearch.testByTargetTwo();
      }

      private void testByTargetNine() {
            int target = 9;
            int[] nums = {-1,0,3,5,9,12};
            int expected = 4;
            System.out.println(doSearch(nums,0,nums.length - 1,target));
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      private void testByTargetTwo() {
            int target = 2;
            int[] nums = {-1,0,3,5,9,12};
            int expected = -1;
            System.out.println(doSearch(nums,0,nums.length - 1,target));
            System.out.println("Expected : " + expected);
            System.out.println();
      }

      private int doSearch(int[] arr, int startIndex, int endIndex, int target) {
            //exit from recursion
            if (startIndex <= endIndex) {
                  int middleIndex = startIndex + ((endIndex - startIndex)/2);

                  int middle = arr[middleIndex];

                  if (middle == target) return middleIndex;

                  if (target < middle) { // target less than middle do search in left half
                        return doSearch(arr, startIndex, middleIndex - 1, target);
                  } else {// target more than middle so do search in right half
                       return doSearch(arr,middleIndex +1, endIndex, target);
                  }
            }
            return -1;
      }
}
