package ds.linkedlist;

public class RearrangeList {

  static class Node{
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    Node(int data, Node next) {
      this.data = data;
      this.next = null;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(2);
    head.next = new Node(4);
    head.next.next = new Node(6);
    head.next.next.next = new Node(8);
    head.next.next.next.next = new Node(10);
    head.next.next.next.next.next = new Node(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
  }

  private static void reorder(Node node) {
    Node slow = node;
    Node fast = node;

    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }


    Node left = node;
    Node right = reverse(slow.next);
    slow.next = null;

    while(left!= null && right!= null) {
      Node leftNext = left.next;
      Node rightNext = right.next;

      left.next = right;
      right.next = leftNext;

      left = leftNext;
      right = rightNext;
    }

    System.out.println(node);
  }

  public static Node reverse(Node node) {
    if(node == null || node.next == null) return node;

    Node temp = reverse(node.next);
    node.next.next = node;
    node.next = null;

    return temp;

  }
}
