package tinkof_interview.linked_list.merge_two_sorted_list;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoList {
      public class ListNode {
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
            public boolean equals(Object o) {
                  if (this == o) return true;
                  if (o == null || getClass() != o.getClass()) return false;
                  ListNode listNode = (ListNode) o;
                  return val == listNode.val && Objects.equals(next, listNode.next);
            }

            @Override
            public int hashCode() {
                  return Objects.hash(val, next);
            }

            @Override
            public String toString() {
                  return val + "";
            }
      }

      public static void main(String[] args) {
            MergeTwoList mergeTwoList = new MergeTwoList();
            mergeTwoList.test1();
            mergeTwoList.test2();
      }

      public ListNode mergeTwoListsByPriorityQueue(ListNode list1, ListNode list2) {

            PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                  Comparator.comparingInt(node -> node.val)
            );
            while (list1 != null) {                               //O(n)
                  priorityQueue.add(list1);
                  list1 = list1.next;
            }
            while (list2 != null) {                               //O(m)
                  priorityQueue.add(list2);
                  list2 = list2.next;
            }
            ListNode firstNode = priorityQueue.peek();
            ListNode currNode = priorityQueue.poll();
            while (currNode != null) {                            //O(n+m)
                  ListNode next = priorityQueue.poll();
                  currNode.next = next;
                  currNode = next;
            }
            return firstNode;                                     //O(2n + 2m) - time O(n+m) - memory
      }

      public ListNode mergeTwoListsByTwoPointer(ListNode list1, ListNode list2) {
            return null;
      }



      public void test1() {
            ListNode list1_4 = new ListNode(4, null);
            ListNode list1_2 = new ListNode(2, list1_4);
            ListNode list1_1 = new ListNode(1, list1_2);

            ListNode list2_4 = new ListNode(4, null);
            ListNode list2_3 = new ListNode(3, list2_4);
            ListNode list2_1 = new ListNode(1, list2_3);
            System.out.println("Test1");
            printList(list1_1);
            printList(list2_1);

            System.out.println("Expected : " + "[1,1,2,3,4,4]");
            System.out.println("Result :");
            printList(mergeTwoListsByPriorityQueue(list1_1, list2_1));
            System.out.println();
      }

      public void test2() {
            ListNode list1_4 = new ListNode(4, null);
            ListNode list1_2 = new ListNode(2, list1_4);
            ListNode list1_1 = new ListNode(1, list1_2);

            ListNode list2_4 = new ListNode(4, null);
            ListNode list2_3 = new ListNode(3, list2_4);
            ListNode list2_1 = new ListNode(1, list2_3);
            System.out.println("Test2");
            printList(list1_1);
            printList(list2_1);

            System.out.println("Expected : " + "[1,1,2,3,4,4]");
            System.out.println("Result :");
            printList(mergeTwoListsByTwoPointer(list1_1, list2_1));
            System.out.println();
      }

      public void printList(ListNode listNode) {
            System.out.print("[");
            while (listNode != null) {
                  System.out.print(listNode + " ");
                  listNode = listNode.next;
            }
            System.out.print("]");
      }
}
