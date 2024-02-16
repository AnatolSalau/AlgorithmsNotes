package linked_list.reverse_double_linked_list;


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
      /*
      null <-> 5 <-> 4 <-> 3 <-> 2 <-> 1 <-> null

      null <-> 1 <-> 2 <-> 3 <-> 4 <-> 5 <-> null

      i:5
      null <-> 5 <-> 4
         swap
      4 <-> 5 <-> null


      i:4
      5 <-> 4 <-> 3
         swap
      3 <-> 4 <-> 5

      i:3
      4 <-> 3 <-> 2
         swap
      2 <-> 3 <-> 4

      i:2
      3 <-> 2 <-> 1
         swap
      1 <-> 2 <-> 3

      i:1
      2 <-> 1 <-> null
         swap
      null <-> 1 <-> 2
       */
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
            head1 = reverseList(head1);
            printList("Reversed list: ", head1);
      }
            /*
            i:1   prev(null) <-> 1 <-> next(2)  swap  prev(2) <-> 1 <-> next(null)
            i:2   prev(1) <-> 2 <-> next(3)  swap  prev(3) <-> 2 <-> next(1)
            */
      private static Node reverseList(Node head) {
            Node previous = null;
            Node curr = head;
            Node next = null;

            while (curr != null) {
                  previous = curr.prev;
                  next = curr.next;

                  //swap prev and next in current
                  Node temp = curr.prev;
                  curr.prev = curr.next;
                  curr.next = temp;

                  if (previous != null) {
                        previous.prev = curr;
                  }

                  curr = next;

                  System.out.println();

            }
            return null;

      }

      public static void printList(String msg, Node head)
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
