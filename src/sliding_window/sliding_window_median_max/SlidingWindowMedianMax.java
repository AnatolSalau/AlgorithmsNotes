package sliding_window.sliding_window_median_max;


import java.util.*;

/**
 * You are given an array of integers nums,
 * there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 * <p>
 * Return the max sliding window.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 */
final class SlidingWindowMedianMax {
      public static void main(String[] args) {
            SlidingWindowMedianMax slidingWindowMedianMax = new SlidingWindowMedianMax();
            slidingWindowMedianMax.test1();
            slidingWindowMedianMax.test2();
      }
      /*

       */
      private void test1() {
            int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
            int k = 3;
            double[] expected = {3, 3, 5, 5, 6, 7};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            List<Double> result = getMediansList(arr, k);
            System.out.println("Expect =" + Arrays.toString(expected));
            System.out.println("Result =" + result);
            System.out.println();
      }

      private void test2() {
            int[] arr = {1, 2, 3, 4, 2, 3, 1, 4, 2};
            int k = 3;
            double[] expected = {3.00000, 4.00000, 4.00000, 4.00000, 3.00000, 4.00000, 4.00000};
            System.out.println("Arr =" + Arrays.toString(arr));
            System.out.println("k =" + k);
            List<Double> result = getMediansList(arr, k);
            System.out.println("Expect =" + Arrays.toString(expected));
            System.out.println("Result =" + result);
            System.out.println();
      }

      /*     0 1 2 3 4
             1 2 3 4 k = 2
            l = 0, r = l + k - 1 = 0 + 2 - 1 = 1
            l = 1, r = l + k - 1 = 1 + 2 - 1 = 2
       */
      private List<Double> getMediansList(int[] arr, int k) {
            List<Double> maxList = new LinkedList<>();

            TreeMap<Integer, Integer> freqMap = null;

            for (int l = 0, r = l + k - 1; r < arr.length; l++, r++) {
                  int left = arr[l];

                  if (freqMap == null) { // initialize set
                        freqMap = initializeMap(arr,l,r);
                  }
                  double max = freqMap.lastKey();
                  maxList.add(max);

                  removeLeft(freqMap, left);
                  if (r + 1 < arr.length) {
                        int next = arr[r + 1];
                        addRight(freqMap, next);
                  }

            }
            return maxList;
      }

      private void addRight(TreeMap<Integer, Integer> map, int next) {
            if (map.containsKey(next)) {
                  int count = map.get(next);
                  count ++;
                  map.put(next,count);
            } else {
                  map.put(next,1);
            }
      }

      private void removeLeft(TreeMap<Integer, Integer> map, int left) {
            int count = map.get(left);
            count --;
            if (count == 0) {
                  map.remove(left);
            } else {
                  map.put(left,count);
            }
      }

      private TreeMap<Integer, Integer> initializeMap(int[] arr, int startIndex, int endIndex) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int i = startIndex; i <= endIndex; i++) {
                  int key = arr[i];
                  if (map.containsKey(key)) {
                        int count = map.get(key);
                        count ++;
                        map.put(key,count);
                  } else {
                        map.put(key,1);
                  }
            }
            return map;
      }
}
