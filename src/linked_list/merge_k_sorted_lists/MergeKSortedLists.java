package linked_list.merge_k_sorted_lists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
       * https://leetcode.com/problems/merge-k-sorted-lists/
       *
       * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
       *
       * Merge all the linked-lists into one sorted linked-list and return it.
       *
       * Example 1:
       * Input: lists = [[1,4,5],[1,3,4],[2,6]]
       * Output: [1,1,2,3,4,4,5,6]
       * Explanation: The linked-lists are:
       * [
       *   1->4->5,
       *   1->3->4,
       *   2->6
       * ]
       * merging them into one sorted list:
       * 1->1->2->3->4->4->5->6
       *
       * Example 2:
       * Input: lists = []
       * Output: []
       *
       * Example 3:
       * Input: lists = [[]]
       * Output: []
 */
public class MergeKSortedLists {
      public static class ListNode {
            int val;
            ListNode next;

            ListNode() {
            }

            ListNode(int val) {
                  this.val = val;
            }

            ListNode(int val, ListNode next) {
                  this.val = val;
                  this.next = next;
            }

            @Override
            public String toString() {
                  return "ListNode{" +
                        "val=" + val +
                        '}';
            }
      }

      public static void main(String[] args) {
            MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
            mergeKSortedLists.testOne();
      }

      /**
       * Time complexity : O(k * log(k)) + O(n * log(k)) = O(n * log(k))
       * where
       *    n - total number of nodes
       *    k - number of lists
       *    O(k * log(k)) - creating minHeap
       *    O(n * log(k)) - processing all nodes in heap

       *  Space complexity : O(k)
       *  where
       *    k - is the number of lists
       *    o(k), minHeap
       */
      private ListNode mergeKListsByPriorityQueue(ListNode[]... lists) {
            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                  Comparator.comparingInt(node -> node.val));
            //fill priority queue
            for (ListNode[] listNodes : lists) {
                  for (ListNode node : listNodes) {
                        priorityQueue.add(node);
                  }
            }
            //add links between elements priority
            ListNode previous = priorityQueue.poll();
            ListNode head = previous;
            while (!priorityQueue.isEmpty()) {
                  ListNode curr = priorityQueue.poll();
                  if (previous != null) {
                        previous.next = curr;
                        previous = curr;
                  }
            }
            return head;
      }

      private void testOne() {
            System.out.println("Test 1: merge k sorted list by priority queue");
            MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

            ListNode list5 = new ListNode(5, null);
            ListNode list4 = new ListNode(4, list5);
            ListNode list3 = new ListNode(3, list4);
            ListNode list2 = new ListNode(2, list3);
            ListNode list1 = new ListNode(1, list2);
            ListNode[] arr1 = {list1, list2, list3, list4, list5};
            ListNode list50 = new ListNode(5, null);
            ListNode list40 = new ListNode(4, list50);
            ListNode list30 = new ListNode(3, list40);
            ListNode list20 = new ListNode(2, list30);
            ListNode list10 = new ListNode(1, list20);
            ListNode[] arr2 = {list10, list20, list30, list40, list50};
            ListNode list500 = new ListNode(500, null);
            ListNode list400 = new ListNode(4, list500);
            ListNode list300 = new ListNode(3, list400);
            ListNode list200 = new ListNode(2, list300);
            ListNode list100 = new ListNode(1, list200);
            ListNode[] arr3 = {list100, list200, list300, list400, list500};
            ListNode headOfList = mergeKListsByPriorityQueue(arr1, arr2, arr3);
            mergeKSortedLists.printLinkedList(headOfList);
            System.out.println();
      }

      private void test2() {
            System.out.println("Test 2: merge k sorted list by priority queue");
            MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();

            ListNode list5 = new ListNode(5, null);
            ListNode list4 = new ListNode(4, list5);
            ListNode list3 = new ListNode(3, list4);
            ListNode list2 = new ListNode(2, list3);
            ListNode list1 = new ListNode(1, list2);
            ListNode[] arr1 = {list1, list2, list3, list4, list5};
            ListNode list50 = new ListNode(5, null);
            ListNode list40 = new ListNode(4, list50);
            ListNode list30 = new ListNode(3, list40);
            ListNode list20 = new ListNode(2, list30);
            ListNode list10 = new ListNode(1, list20);
            ListNode[] arr2 = {list10, list20, list30, list40, list50};
            ListNode list500 = new ListNode(500, null);
            ListNode list400 = new ListNode(4, list500);
            ListNode list300 = new ListNode(3, list400);
            ListNode list200 = new ListNode(2, list300);
            ListNode list100 = new ListNode(1, list200);
            ListNode[] arr3 = {list100, list200, list300, list400, list500};
            ListNode headOfList = mergeKListsByPriorityQueue(arr1, arr2, arr3);
            mergeKSortedLists.printLinkedList(headOfList);
            System.out.println();
      }
      private void printLinkedList(ListNode headOfList) {
            if (headOfList == null) System.out.println("Head of list is null");

            ListNode curr = headOfList;
            while (curr != null) {
                  if (curr.next == null) System.out.print(curr);
                  else System.out.print(curr + " -> ");

                  curr = curr.next;
            }
      }
}
