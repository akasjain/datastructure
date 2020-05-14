package ds.linkedlist;

class Node{
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

public class ReverseList {
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    head.next.next.next.next.next = new Node(6);

    Node reverseHead = ReverseList.reverse(head);

    Node temp = reverseHead;
    while(temp!= null) {
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }

  public static Node reverse(Node node) {
    if(node == null || node.next == null) return node;

    Node temp = reverse(node.next);
    node.next.next = node;
    node.next = null;

    return temp;

  }

  private static Node reverseIterative(Node head) {
    Node prev = null;
    while (head != null) {
      Node next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }


}
