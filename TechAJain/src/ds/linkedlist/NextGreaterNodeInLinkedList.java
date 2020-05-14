package ds.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    static class ListNode {
        int val = 0;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        List<Integer> nodes = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            nodes.add(temp.val);
            temp = temp.next;
        }

        int[] result = new int[nodes.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nodes.size(); i++) {
            while (!stack.isEmpty() && nodes.get(stack.peek()) < nodes.get(i)) {
                result[stack.pop()] = nodes.get(i);
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = 0;
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterNodeInLinkedList obj = new NextGreaterNodeInLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        int[] result = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(result));
        System.out.println();
        //[1,7,5,1,9,2,5,1]
        head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);
        result = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(result));

        head = new ListNode(3);
        head.next = new ListNode(3);
        result = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(result));
    }


}
