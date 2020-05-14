package leetcode.challenge.april;

/**
 Given a non-empty, singly linked list with head node head, return a middle node of linked list.
 If there are two middle nodes, return the second middle node.
 */
public class C08_MiddleOfLinkedList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
