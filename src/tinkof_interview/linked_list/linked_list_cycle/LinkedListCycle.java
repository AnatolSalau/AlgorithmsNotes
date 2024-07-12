package tinkof_interview.linked_list.linked_list_cycle;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LinkedListCycle {
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
            LinkedListCycle linkedListCycle = new LinkedListCycle();
            linkedListCycle.test1();
      }
      public boolean hasCycle(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            while (head != null) {
                  if (nodes.contains(head)) return true;

                  nodes.add(head);

                  head = head.next;
            }
            return  false;
      }

      public boolean hasCycleByTwoLink(ListNode head) {
        // Initialize two pointers, the slow pointer moves one step at a time.
        ListNode slow = head;
        // The fast pointer moves two steps at a time.
        ListNode fast = head;

        // Keep traversing the list as long as the fast pointer and its next are not null.
        while (fast != null && fast.next != null) {
            // Move the slow pointer one step.
            slow = slow.next;
            // Move the fast pointer two steps.
            fast = fast.next.next;

            // If the slow and fast pointers meet, a cycle exists.
            if (slow == fast) {
                return true;
            }
        }
        // If the loop ends without the pointers meeting, there is no cycle.
        return false;
    }

      public void test1() {
            ListNode node0 = new ListNode(0, null);
            ListNode node2 = new ListNode(2, node0);
            ListNode node4 = new ListNode(-4, node2);
            node0.next = node4;
            ListNode head = new ListNode(3, node2);

            //printList(head);
            System.out.println("Test1");
            System.out.println("Expected: true");
            System.out.println(hasCycle(head));
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
