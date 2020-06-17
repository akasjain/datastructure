package leetcode.challenge.june;

/**
 https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class J02_DeleteNodeInALinkedList {

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next= node.next.next;
    }
}
