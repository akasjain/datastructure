package ds.linkedlist;

public class PalindromicLinkedList {

  static class Node{
    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    Node head = new Node(2);
    head.next = new Node(4);
    head.next.next = new Node(6);
    head.next.next.next = new Node(6);
    head.next.next.next.next = new Node(4);
    head.next.next.next.next.next = new Node(2);

    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new Node(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }

  /*private static boolean isPalindrome(Node node) {

    Node slow = node;
    Node fast = node;
    boolean isEven = false;

    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    if(fast == null)
      isEven = true;

    Node middle = slow;

    Node reverseHead = reverse(slow);
    Node copyReverseHead = reverseHead;
    Node temp = node;

    while(temp != null || reverseHead != null) {
      if(temp.data != reverseHead.data)
        break;
      temp = temp.next;
      reverseHead = reverseHead.next;
    }

    reverse(copyReverseHead);

    if (temp == null || reverseHead == null) // if both halves match
      return true;
    return false;
  }

  private static Node reverse(Node node) {
    if(node == null || node.next == null) return node;

    Node temp = reverse(node.next);
    node.next.next = node;
    node.next = null;

    return temp;

  }*/

  public static boolean isPalindrome(Node head) {
    if (head == null || head.next == null)
      return true;

    // find middle of the LinkedList
    Node slow = head;
    Node fast = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    Node previousNodeOfSecondHalf = head;
    while(previousNodeOfSecondHalf.next != slow) {
      previousNodeOfSecondHalf = previousNodeOfSecondHalf.next;
    }
    Node headSecondHalf = reverse(slow); // reverse the second half
    Node copyHeadSecondHalf = headSecondHalf; // store the head of reversed part to revert back later

    // compare the first and the second half
    Node temp = head;
    while (temp != null && headSecondHalf != null) {
      if (temp.data != headSecondHalf.data) {
        break; // not a palindrome
      }
      temp = temp.next;
      headSecondHalf = headSecondHalf.next;
    }

    previousNodeOfSecondHalf.next = reverse(copyHeadSecondHalf); // revert the reverse of the second half
    if (temp == null || headSecondHalf == null) // if both halves match
      return true;
    return false;
  }

  private static Node reverse(Node head) {
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
