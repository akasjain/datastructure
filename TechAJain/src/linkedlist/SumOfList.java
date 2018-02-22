package linkedlist;

public class SumOfList {

	//Given two lists, find the sum of numbers and store in third one.
	public static void main(String[] args) {

		LinkedListNode head1 = new LinkedListNode();
		head1 = LinkedListUtils.addNodeAtLast(head1, new Integer(2));
		head1 = LinkedListUtils.addNodeAtLast(head1, new Integer(1));
		head1 = LinkedListUtils.addNodeAtLast(head1, new Integer(9));
		//head1 = LinkedListUtils.addNodeAtLast(head1, new Integer(2));

		LinkedListNode head2 = new LinkedListNode();
		head2 = LinkedListUtils.addNodeAtLast(head2, new Integer(7));
		head2 = LinkedListUtils.addNodeAtLast(head2, new Integer(2));
		
		LinkedListNode head3 = getSumOfList(head1, head2);
		LinkedListUtils.printLinkedList(head3);
		
		
		
	}

	private static LinkedListNode getSumOfList(LinkedListNode head1, LinkedListNode head2) {
		// TODO Auto-generated method stub
		LinkedListNode head3 = new LinkedListNode();
		
		
		return null;
	}

}
