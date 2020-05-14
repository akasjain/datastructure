package ds.linkedlist;

public class PairwiseSwapNodes {

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null)
            return head;

        ListNode prev = head;
        ListNode current = head.next;
        ListNode next = current.next;

        current.next = prev;
        prev.next = swapPairs(next);

        return current;

    }
}
