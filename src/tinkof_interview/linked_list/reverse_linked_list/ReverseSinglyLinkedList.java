package tinkof_interview.linked_list.reverse_linked_list;

import java.util.Stack;

public class ReverseSinglyLinkedList {
      class ListNode {
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
                  return " ListNode{" +
                        "val=" + val +
                        '}';
            }
      }
      public static void main(String[] args) {
            ReverseSinglyLinkedList reverseSinglyLinkedList = new ReverseSinglyLinkedList();
            reverseSinglyLinkedList.testOne();
            reverseSinglyLinkedList.testTwo();
            reverseSinglyLinkedList.testThree();
      }
      void printList(ListNode head) {
            if (head == null) {
                  System.out.println(head);
                  return;
            }
            ListNode curr = head;
            while (curr.next != null) {
                  System.out.println(curr);
                  curr = curr.next;
            }
            System.out.println(curr);
      }

      /*
            10 -> 20 -> 30 -> 40 -> 50
   null  <- l  <- m  <- r  <- n
       */
      ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode current = head;
            ListNode next = null;
            while (current != null) {
                  next = current.next;
                  current.next = prev;
                  prev = current;
                  current = next;
            }
            head = prev;
            return head;
      }

      void testOne() {
            ListNode list5 = new ListNode(5, null);
            ListNode list4 = new ListNode(4, list5);
            ListNode list3 = new ListNode(3, list4);
            ListNode list2 = new ListNode(2, list3);
            ListNode list1 = new ListNode(1, list2);
            System.out.println("Linked list");
            printList(list1);
      }

      void testTwo() {
            ListNode list50 = new ListNode(50, null);
            ListNode list40 = new ListNode(40, list50);
            ListNode list30 = new ListNode(30, list40);
            ListNode list20 = new ListNode(20, list30);
            ListNode list10 = new ListNode(10, list20);
            System.out.println("Linked list");
            printList(list10);
            ListNode result = reverseList(list10);
            System.out.println("Reversed list");
            printList(result);
      }

      void testThree() {
            ListNode list500 = new ListNode(500, null);
            ListNode list400 = new ListNode(400, list500);
            ListNode list300 = new ListNode(300, list400);
            ListNode list200 = new ListNode(200, list300);
            ListNode list100 = new ListNode(100, list200);
            System.out.println("Linked list");
            printList(list100);
            ListNode result = reverseList(list100);
            System.out.println("Reversed list");
            printList(result);
      }
}
