package two_pointers.squares_sorted_array;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 *
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 *
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 */
public class SquaresOfSortedArray {
      public static void main(String[] args) {
            SquaresOfSortedArray squaresOfSortedArray = new SquaresOfSortedArray();
            squaresOfSortedArray.test1();
            squaresOfSortedArray.test2();
      }

      private int[] sortSquaresOfArray(int[] nums) {
            int[] squaresIncreaseOrder = new int[nums.length];

            int l = 0;
            int r = nums.length - 1;

            for (int i = squaresIncreaseOrder.length - 1; i >= 0; i--) {
                  int leftAbs = Math.abs(nums[l]);
                  int rightAbs = Math.abs(nums[r]);

                  //if leftAbs less than rightAbs -> decrease right pointer
                  if(leftAbs < rightAbs) {
                        //add to result max value -> that is rightAbs
                        squaresIncreaseOrder[i] = rightAbs * rightAbs;
                        r--;
                  } else {//if leftAbs more than rightAbs -> increase left pointer
                        //add to result max value -> that is leftAbs
                        squaresIncreaseOrder[i] = leftAbs * leftAbs;
                        l++;
                  }
            }

            return squaresIncreaseOrder;
      }
      /*
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 0 , 0]
                   lo            hi
           i=length - 1

           i = 4:  lo= -4,       hi= 10
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 0 , 100]
                   lo        hi
           i = 3:  lo= -4,       hi= 3
                  [-4, -1, 0, 3, 10]    [0, 0, 0, 16 , 100]
                       lo    hi
           i = 2:  lo= -1,       hi= 3
                  [-4, -1, 0, 3, 10]    [0, 0, 9, 16 , 100]
                       lo hi
           i = 1:  lo= -1,       hi= 0
                  [-4, -1, 0, 3, 10]    [0, 1, 9, 16 , 100]
                         lohi
           i = 0:  lo= 0,       hi= 0
                  [-4, -1, 0, 3, 10]    [0, 1, 9, 16 , 100]
                         lohi

       */
      /*
            [-7, -3, 3, 11]    [0, 0, 0 , 0]
             lo         hi
     i=length - 1

     i = 3:  lo= -7,       hi= 11
            [-7, -3, 3, 11]    [0, 0, 0, 121]
             lo      hi
     i = 2:  lo= -7,       hi= 3
            [-7, -3, 3, 11]    [0, 0, 49, 121]
                 lo hi
     i = 1:  lo= -3,       hi= 3
            [-7, -3, 3, 11]    [0, 9, 49, 121]
                 lo  hi
     i = 0:  lo= -3,       hi= -3
            [-7, -3, 3, 11]    [9, 9, 49, 121]
                 lohi

      */
      private void test1() {
            int[] nums1 = {-4, -1, 0, 3, 10};
            System.out.println(Arrays.toString(nums1));
            System.out.println("Right answer : ");
            System.out.println("[0, 1, 9, 16, 100]");
            int[] res1 = sortSquaresOfArray(nums1);
            System.out.println(Arrays.toString(res1));
            System.out.println();
      }

      private void test2() {
            int[] nums2 = {-3,2,3,11};
            System.out.println(Arrays.toString(nums2));
            System.out.println("Right answer : ");
            System.out.println("[4,9,9,121]");
            int[] res2 = sortSquaresOfArray(nums2);
            System.out.println(Arrays.toString(res2));
      }
}
