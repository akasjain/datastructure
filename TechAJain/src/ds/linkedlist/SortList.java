package ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class SortList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
     }

    public static ListNode sortList(ListNode head) {

        // If there is only one node in the list return it
        if(head == null || head.next == null)
            return head;

        //partition the list into two
        ListNode[] partition = partitionList(head);
        ListNode first = partition[0];
        ListNode second = partition[1];
        first = sortList(first);
        second = sortList(second);


        head = mergeSort(first, second);
        
        
        return head;
    }

    private static ListNode mergeSort(ListNode first, ListNode second) {

        if(first == null)
            return second;
        if(second == null)
            return first;
        ListNode result = null;

        if(first.val < second.val) {
            result = first;
            first.next = mergeSort(first.next, second);
        } else {
            result = second;
            second.next = mergeSort(first, second.next);
        }

        return result;
    }

    private static ListNode[] partitionList(ListNode head) {

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {

            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        return new ListNode[]{head, slow};
    }

    public static void main(String[] args) {
        // 4->2->1->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);

        ListNode result = sortList(head);
        System.out.println(result);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }

}
