package linkedlist;

import stack.StackImpl;

public class CheckPalindrome {

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode();

		head = LinkedListUtils.addNodeAtLast(head, 'a');
		head = LinkedListUtils.addNodeAtLast(head, 'c');
		head = LinkedListUtils.addNodeAtLast(head, 'd');
		head = LinkedListUtils.addNodeAtLast(head, 'd');
		head = LinkedListUtils.addNodeAtLast(head, 'c');
		head = LinkedListUtils.addNodeAtLast(head, 'a');
		//head = LinkedListUtils.addNodeAtLast(head, 'a');

		LinkedListUtils.printLinkedList(head);
		
		boolean isPal = isPalindrome(head.getNext());
		System.out.println("Is palindrome : " + isPal);

	}
	
	public static Boolean isPalindrome(LinkedListNode head) {
		int count=1;
		if(head == null) {
			return false;
		}		
		LinkedListNode slowPtr = head;	
		LinkedListNode fastPtr = head;
		StackImpl stack = new StackImpl();
		
		while(fastPtr != null && fastPtr.getNext() != null) {
			stack.push((char)slowPtr.getData());
			count = count + 2;
			fastPtr = fastPtr.getNext().getNext();
			slowPtr = slowPtr.getNext();
			
		}
		
		stack.printStack();
		
		if(fastPtr == null) { // for even number of nodes
			count = count - 1;
		} else {			// for odd numer of nodes, skip pushing center node
			slowPtr = slowPtr.getNext();
		}
		
		while(!stack.isEmpty() && slowPtr != null) {
			char item = (char) stack.pop();
			if(item == (char)slowPtr.getData()) {
				slowPtr = slowPtr.getNext();
				continue;
			} else {
				return false;
			}
		}
		stack.printStack();


		return true;
	}

}
