package yandex_internet.longest_subarr_of1;

public class LongestSubArrOf1 {
      /**
       Given a binary array nums, you should delete one element from it.

       Return the size of the longest non-empty subarray containing only 1's in the resulting array.
       Return 0 if there is no such subarray.

       Example 1:
                          2
       Input: nums = [1,1,0,1]
       Output: 3
       Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

       Example 2:
                              4
       Input: nums = [0,1,1,1,0,1,1,0,1]
       Output: 5
       Explanation: After deleting the number in position 4,
       [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

       Example 3:
       Input: nums = [1,1,1]
       Output: 2
       Explanation: You must delete one element.
       */
      public static void main(String[] args) {
            test1();
            test2();
            test3();
            test4();
            test5();
      }
      /*            4
            0,1,1,1,0,1,1,0,1
            after deleting element on index 4
            expected 5 = [1,1,1,1,1].

            Explanation:
            1. Run through arr and searh zero and increase zeroCount every time when we find zero
                  1.1 increase r pointer every loop
            2. if count of zero > 1 -> the same as we have two
                  2.1 Move left pointer while we don't find zero
                  2.2 If we find zero - decrease pointer of zero and move left pointer forward
                        2.2.3 If count of zero will less than 2 -> we go out from while loop
                  2.3 If we didn't find zero - just move left pointer forward
            3. Calculate result every loop
                  Result this is length between r and l pointers
                  result = r - l
       */
      /*    i:    0 1 2 3 4 5 6 7 8
            arr:  0,1,1,1,0,1,1,0,1
                  lr                      countZero = 1                             lengthOf1 = 0 - 0 = 0
                  l r                     countZero = 1                             lengthOf1 = 1 - 0 = 1
                  l   r                   countZero = 1                             lengthOf1 = 2 - 0 = 2
                  l     r                 countZero = 1                             lengthOf1 = 3 - 0 = 3
                  l       r               countZero = 2 -> inner while is started   result is not calculate in while
                    l     r               countZero = 1 -> inner while is ended     lengthOf1 = 4 - 1 = 3
                    l       r             countZero = 1                             lengthOf1 = 5 - 1 = 4
                    l         r           countZero = 1                             lengthOf1 = 6 - 1 = 5 (Max)
                    l           r         countZero = 2 -> inner while is started   result is not calculate in while
                            l   r         countZero = 1 -> inner while is ended     lengthOf1 = 7 - 5 = 2
                            l     r       countZero = 1 -> end                      lengthOf1 = 8 - 5 = 3
           return lengthOf1Max
       */
      private static void test1() {
            int[] nums = {0,1,1,1,0,1,1,0,1};
            System.out.println("Test 1");
            System.out.println("Expected result = 5");
            System.out.println(gemLongestSubarrayAfterDeletingOneEl(nums));
            System.out.println();

      }
      private static void test2() {
            int[] nums = {1,1,0,1};
            System.out.println("Test 2");
            System.out.println("Expected result = 3");
            System.out.println(gemLongestSubarrayAfterDeletingOneEl(nums));
            System.out.println();
      }

      private static void test3() {
            int[] nums = {1,1,1};
            System.out.println("Test 3");
            System.out.println("Expected result = 2");
            System.out.println(gemLongestSubarrayAfterDeletingOneEl(nums));
            System.out.println();
      }

      private static void test4() {
            System.out.println("Test 4");
            int[] nums = {0,0,0};
            System.out.println("Expected result = 0");
            System.out.println(gemLongestSubarrayAfterDeletingOneEl(nums));
            System.out.println();
      }

      private static void test5() {
            int[] nums = {1,1,1,0};
            System.out.println("Test 5");
            System.out.println("Expected result = 3");
            System.out.println(gemLongestSubarrayAfterDeletingOneEl(nums));
            System.out.println();
      }

      private static int gemLongestSubarrayAfterDeletingOneEl(int[] nums) {
            int l = 0; // left pointer
            int zeroQty = 0; //quantity of zero in length
            int maxLength = 0;

            for (int r = 0; r < nums.length; r++) {
                  if (nums[r] == 0) zeroQty++; // increase zero qty when we find 0

                  while (zeroQty > 1) {
                        if (nums[l] == 0) zeroQty --;
                        l++;
                  }

                  int currLength = r - l;
                  maxLength = Math.max(currLength, maxLength); // calculate max length
            }
            return maxLength;
      }
}
