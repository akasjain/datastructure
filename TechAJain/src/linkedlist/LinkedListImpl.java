package linkedlist;

public final class LinkedListImpl {

	public static void main(String[] args) {
		
		LinkedListNode head = new LinkedListNode();

		head = LinkedListUtils.addNodeInFront(head, new Integer(13));		
		head = LinkedListUtils.addNodeAtNthPosition(head, new Integer(12), 1);
		head = LinkedListUtils.addNodeAtLast(head, new Integer(44));
		LinkedListUtils.printLinkedList(head);

		
		head = LinkedListUtils.addNodeInFront(head, new Integer(2));
		head = LinkedListUtils.addNodeInFront(head, new Double(3.0));
		head = LinkedListUtils.addNodeInFront(head, new Integer(4));
		head = LinkedListUtils.addNodeInFront(head, new Integer(5));
		head = LinkedListUtils.addNodeInFront(head, new Integer(7));
		head = LinkedListUtils.addNodeInFront(head, new Integer(6));
		head = LinkedListUtils.addNodeAtLast(head, new Integer(11));
		head = LinkedListUtils.addNodeAtNthPosition(head, new StringBuilder("In between 4th"), 4);
		head = LinkedListUtils.addNodeFromEnd(head, new StringBuilder("From end 4th"), 3);

		LinkedListUtils.printLinkedList(head);
		
		head = LinkedListUtils.deleteFirstNode(head);
		LinkedListUtils.printLinkedList(head);

		head = LinkedListUtils.deleteLastNode(head);
		LinkedListUtils.printLinkedList(head);
		
		head = new LinkedListNode();
		head = LinkedListUtils.addNodeInFront(head, new Integer(2));
		head = LinkedListUtils.addNodeInFront(head, new Integer(4));
		head = LinkedListUtils.addNodeInFront(head, new Integer(6));
		head = LinkedListUtils.addNodeInFront(head, new Integer(8));
		System.out.println("\nBefore");
		LinkedListUtils.printLinkedList(head);
		System.out.println("\nAfter");
		DeleteNodeByReference.deleteNodeByReference(head.getNext());
		LinkedListUtils.printLinkedList(head);
		
		LinkedListNode nthNode = GetNthNode.getNth(head, 2);
		if(nthNode != null) {
			System.out.println("\n nth node is : " + nthNode.getData());
		}
		
		head = new LinkedListNode();
		head = LinkedListUtils.addNodeInFront(head, new Integer(2));
		head = LinkedListUtils.addNodeInFront(head, new Integer(4));
		head = LinkedListUtils.addNodeInFront(head, new Integer(6));
		head = LinkedListUtils.addNodeInFront(head, new Integer(8));
		head = LinkedListUtils.addNodeInFront(head, new Integer(10));

		
		System.out.println("Middle of list");
		FindMiddleOfList.findMiddleOfList(head);
		
		System.out.println("\n Original \n");
		head = new LinkedListNode();
		head = LinkedListUtils.addNodeInFront(head, new Integer(2));
		head = LinkedListUtils.addNodeInFront(head, new Integer(4));
		head = LinkedListUtils.addNodeInFront(head, new Integer(6));
		head = LinkedListUtils.addNodeInFront(head, new Integer(8));
		head = LinkedListUtils.addNodeInFront(head, new Integer(10));
		LinkedListUtils.printLinkedList(head);

		System.out.println("\n Reversed \n");
		head = ReverseList.reverseList(head);
		LinkedListUtils.printLinkedList(head);
	}
}
