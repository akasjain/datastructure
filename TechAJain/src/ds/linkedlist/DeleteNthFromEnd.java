package ds.linkedlist;

public class DeleteNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int i = 0;
        while(i < n && temp != null) {
            temp = temp.next;
            i++;
        }
        if(temp == null) { // head is to be deleted
            head = head.next;
            return head;
        }

        ListNode start = head;
        while(temp.next != null) {
            start = start.next;
            temp = temp.next;
        }
        start.next = start.next.next;
        return head;
    }
}
