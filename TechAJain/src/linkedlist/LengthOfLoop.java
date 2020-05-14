package linkedlist;

public class LengthOfLoop {

	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode(12);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(5);
		node.next.next.next = new LinkedListNode(7);
		node.next.next.next.next = new LinkedListNode(9);
		node.next.next.next.next.next = new LinkedListNode(11);
		node.next.next.next.next.next.next = new LinkedListNode(13);
		node.next.next.next.next.next.next.next = node.next.next;
		
		LengthOfLoop d = new LengthOfLoop();
		int loopLength = d.getLoopLength(node);
		
		if(loopLength > 0) {
			System.out.println("Loop length : " + loopLength);
		} else {
			System.out.println("No loop detected");
		}
		
	}
	
	public int getLoopLength(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		// detect loop
		while(true) { 
			if(fast.next != null ) {
				fast = fast.next.next;
				slow = slow.next;
			}
			if(fast == slow) { // loop found
				break;
			}
			if(fast == null || fast.next == null) { //end of list reached
				return 0;
			}
		}
		
		int count=0;

		LinkedListNode temp = node;

		//identify the start of loop
		if(slow == node) { // condition to check if it is circular list i.e. slow and fast meet at head
			temp = temp.next;
			count++;
		} else { //condition for non-circular list i.e. loop present without head inside loop
			while(temp.next != slow.next) {
				temp = temp.next;
				slow = slow.next;
			}
		}
		while(temp != slow) {
			temp = temp.next;
			count++;
		}
		return count;
	}	
}
