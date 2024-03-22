package two_pointers.sorted_squares_arr;

import java.util.Arrays;

public class SortedSquaresArr {
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
      public static void main(String[] args) {
            test1();
            test2();
      }

      private static void test1() {
            System.out.println("Task34");
            int[] nums1 = {-4, -1, 0, 3, 10};
            System.out.println(Arrays.toString(nums1));
            System.out.println("Right answer : ");
            System.out.println("[0, 1, 9, 16, 100]");
            int[] res1 = sortedSquares(nums1);
            System.out.println("Answer : ");
            System.out.println(Arrays.toString(res1));
            System.out.println();
      }

      private static void test2() {
            int[] nums2 = {-3,2,3,11};
            System.out.println(Arrays.toString(nums2));
            System.out.println("Right answer : ");
            System.out.println("[4,9,9,121]");
            int[] res2 = sortedSquares(nums2);
            System.out.println("Answer : ");
            System.out.println(Arrays.toString(res2));
            System.out.println();
      }
      /*
            Arr: -4,-1,0,3,10
            Res:  0,1,9,16,100

             l         r                    i
i=4.        -4,-1,0,3,10  res: [0, 0, 0, 0, 0]
            abs(-4) = 4
            abs(10) = 10
            add to resul 10*10 = 100
            r > l -> decrease r

             l      r                    i
i=4.        -4,-1,0,3,10  res: [0, 0, 0, 0, 100]
            abs(-4) = 4
            abs(3)  = 3
            add to result 4*4 = 16
            l > r -> increase l

                l   r                 i
i=4.        -4,-1,0,3,10  res: [0, 0, 0, 16, 100]
            abs(-1) = 1
            abs(3)  = 3
            add to result 3*3 = 9
            l < r -> decrease r

                l r                i
i=4.        -4,-1,0,3,10  res: [0, 0, 9, 16, 100]
            abs(-1) = 1
            abs(0)  = 0
            add to result 1*1 = 1
            l > r -> increase l
                  lr            i
i=4.        -4,-1,0,3,10  res: [0, 1, 9, 16, 100]
            abs(0)  = 0
            abs(0)  = 0
            add to result 0*0 = 0
            l == r increase l
       */
      /*
            1. Create arr result with size the same as nums
            2. Create two pointers
                  l - from start arr
                  r - from end arr
                  i - end of result
            3. Go through while until l <= r
                  Compare modules left and right
                        if module left more then right or equal to right
                              add left square to the end of result
                              increase l
                              decrease i
                        else (module left less than right)
                              add right square to the end of result
                              decrease r
                              decrease i

       */
      static int[] sortedSquares(int[] nums) {
            int[] result = new int[nums.length]; //1. Create arr result with size the same as nums
            int l = 0;// from start arr
            int r = nums.length-1;// from end arr
            int i = result.length - 1;// end of result

            while (l <= r) {
                  int left = Math.abs(nums[l]);
                  int right = Math.abs((nums[r]));
                  //Compare modules left and right
                  if (left >= right) {//if module left more then right or equal to right
                        int sqr = left * left;
                        result[i] = sqr; //add left square to the end of result
                        l++;//increase l
                        i--;//decrease i
                  } else {//module left less than right
                        int sqr = right *right;
                        result[i] = sqr; //add left square to the end of result
                        r--;//increase l
                        i--;//decrease i
                  }
            }
            return result;
      }
}
