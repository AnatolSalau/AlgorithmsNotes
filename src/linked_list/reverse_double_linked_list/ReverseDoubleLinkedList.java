package linked_list.reverse_double_linked_list;

import java.util.Stack;

public class ReverseDoubleLinkedList {

      class Node
      {
            int data;
            Node next, prev;

            public Node() {
            }

            public Node(int data, Node prev, Node next) {
                  this.data = data;
                  this.next = next;
                  this.prev = prev;
            }

      }
      public static void main(String[] args)
      {
            ReverseDoubleLinkedList reverseList = new ReverseDoubleLinkedList();
            reverseList.test1();
      }

      private void test1() {
            Node node5 = new Node();
            Node node4 = new Node();
            Node node3 = new Node();
            Node node2 = new Node( );
            Node head1 = new Node();

            node5 = new Node(5, node4, null);
            node4 = new Node(4, node3, node5);
            node3 = new Node(3, node2, node4);
            node2 = new Node(2, head1, node3 );
            head1 = new Node(1, null, node2);


            printList("Original list: ", head1);
            head1 = reverseListByStack(head1);
            printList("Reversed list: ", head1);
      }
      private  Node reverseListByPointers(Node head) {
            Node prev = null;
            Node curr = head;

            // traverse the list
            while (curr != null)
            {
                  // swap `next` and `prev` pointers for the current node
                  if (prev == null) {
                        Node temp = curr.prev;
                        curr.prev = curr.next;
                        curr.next = temp;
                  }

                  // update the previous node before moving to the next node
                  prev = curr;

                  // move to the next node in the doubly linked list
                  curr = curr.prev;
                  //update links inside curr
                  if (curr != null) {
                        curr.prev = curr.next;
                        curr.next = prev;
                  }
            }

            // update head pointer to the last node
            if (prev != null) {
                  head = prev;
            }

            return head;
      }

      private Node reverseListByStack(Node head) {
            Stack<Node> stack = new Stack<>();
            // fill stack
            Node cur = head;
            while (cur != null) {
                  stack.add(cur);
                  if (cur.next == null) { // add link to las node
                        head = cur;
                  }
                  cur = cur.next;

            }
            Node previous = null;
            // change links inside nodes in stack
            while (!stack.isEmpty()) {
                  Node node = stack.pop();

                  Node temp = node.prev;
                  node.prev = node.next;
                  node.next = temp;

                  if (previous != null) {
                        previous.next = node;
                  }
                  previous = node;

            }
            return head;
      }


      public  void printList(String msg, Node head)
      {
            System.out.print(msg);
            while (head != null)
            {
                  System.out.print(head.data + " -> ");
                  head = head.next;
            }
            System.out.println(head);
      }
}
