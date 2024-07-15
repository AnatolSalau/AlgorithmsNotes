package tinkof_interview.linked_list.add_two_numbers;


import tinkof_interview.linked_list.linked_list_cycle.LinkedListCycle;

import java.util.Objects;

public class AddTwoNumbers {
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
                  return Objects.hash(val);
            }

            @Override
            public String toString() {
                  return val + "";
            }
      }

      public static void main(String[] args) {
            AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
            addTwoNumbers.test1();
            addTwoNumbers.test2();
      }

      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null) return null;

            ListNode head = null;
            ListNode curr = null;
            int carry = 0; // remainder

            while (l1 != null || l2 != null || carry != 0) {
                  int val1 = 0;
                  if (l1 != null) {
                        val1 = l1.val;
                  }
                  int val2 = 0;
                  if (l2 != null) {
                        val2 = l2.val;
                  }

                  int full_sum = val1 + val2 + carry;
                  int sum = full_sum % 10; // last digit

                  carry = full_sum / 10; // remainder

                  if (head == null) {     //first iteration
                        head = new ListNode(sum, null);
                        curr = head;
                  } else {    // all remaining ones
                        ListNode newNode = new ListNode(sum, null);
                        curr.next = newNode;
                        curr = newNode;
                  }

                  if (l1 != null) { // move pointer forward
                        l1 = l1.next;
                  }

                  if (l2 != null) { // move pointer forward
                        l2 = l2.next;
                  }
            }
            return head;
      }

      public void test1() {
            ListNode list1_3 = new ListNode(3, null);
            ListNode list1_4 = new ListNode(4, list1_3);
            ListNode list1_2 = new ListNode(2, list1_4);

            ListNode list2_4 = new ListNode(4, null);
            ListNode list2_6 = new ListNode(6, list2_4);
            ListNode list2_5 = new ListNode(5, list2_6);

            System.out.println();
            System.out.println("Test1");
            printList(list1_2);
            printList(list2_5);

            printList(addTwoNumbers(list1_2, list2_5));
      }

      public void test2() {
            ListNode list1_7 = new ListNode(9, null);
            ListNode list1_6 = new ListNode(9, list1_7);
            ListNode list1_5 = new ListNode(9, list1_6);
            ListNode list1_4 = new ListNode(9, list1_5);
            ListNode list1_3 = new ListNode(9, list1_4);
            ListNode list1_2 = new ListNode(9, list1_3);
            ListNode list1_1 = new ListNode(9, list1_2);

            ListNode list2_4 = new ListNode(9, null);
            ListNode list2_3 = new ListNode(9, list2_4);
            ListNode list2_2 = new ListNode(9, list2_3);
            ListNode list2_1 = new ListNode(9, list2_2);
            System.out.println();
            System.out.println("Test2");
            printList(list1_1);
            printList(list2_1);

            printList(addTwoNumbers(list1_1, list2_1));
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
