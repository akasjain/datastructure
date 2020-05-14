package linkedlist;

public class RemoveLoop {

	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode(12);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(5);
		node.next.next.next = new LinkedListNode(7);
		node.next.next.next.next = new LinkedListNode(9);
		node.next.next.next.next.next = new LinkedListNode(11);
		node.next.next.next.next.next.next = new LinkedListNode(13);
		node.next.next.next.next.next.next.next = node;//.next.next.next;
		
		RemoveLoop d = new RemoveLoop();
		boolean isLoopRemoved = d.removeLoop(node);
		
		if(isLoopRemoved) {
			while(node != null) {
				System.out.print(" " + node.data + " ");
				node = node.next;
			}
		} else {
			System.out.println("No loop detected");
		}
		
	}
	
	// remove the loop if present
	public boolean removeLoop(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		while(true) {
			if(fast.next != null ) {
				fast = fast.next.next;
				slow = slow.next;
			}
			if(fast == slow) { // loop found
				break;
			}
			if(fast == null || fast.next == null) {
				return false;
			}
		}
		
		
		if(slow == node) { // slow and fast meet at head -> circular loop
			while(slow.next != node) {
				slow = slow.next;
			}
		} else {
			LinkedListNode temp = node;
			while(temp.next != slow.next) {
				temp = temp.next;
				slow = slow.next;
			}
		}
		
		slow.next = null;
		
		return true;
	}	
}
