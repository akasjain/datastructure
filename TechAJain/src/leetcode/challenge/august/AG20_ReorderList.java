package leetcode.challenge.august;

/**
 https://leetcode.com/problems/reorder-list/

 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You may not modify the values in the list's nodes, only nodes itself may be changed.

 Example 1:
    Given 1->2->3->4, reorder it to 1->4->2->3.

 Example 2:
    Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
public class AG20_ReorderList {
     public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode slow = head;
        ListNode fast = head;
        ListNode slowPrev = null;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slowPrev = slow;
            slow = slow.next;
        }

        slowPrev.next = null ;

        ListNode first = head;
        ListNode second = reverse(slow);

        while(first != null) {
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next = second;
            if(firstNext != null) // check for for last node in odd sized list
                second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        AG20_ReorderList obj = new AG20_ReorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head.next.next.next.next.next = new ListNode(6);
        obj.reorderList(head);
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
