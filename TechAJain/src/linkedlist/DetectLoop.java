package linkedlist;

public class DetectLoop {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedListNode node = new LinkedListNode(12);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(5);
		node.next.next.next = new LinkedListNode(7);
		node.next.next.next.next = new LinkedListNode(9);
		node.next.next.next.next.next = new LinkedListNode(11);
		node.next.next.next.next.next.next = new LinkedListNode(13);
		node.next.next.next.next.next.next.next = node.next.next;
		
		DetectLoop d = new DetectLoop();
		System.out.println(d.detectLoop(node));
		
	}
	
	public boolean detectLoop(LinkedListNode node) {
		LinkedListNode slow = node;
		LinkedListNode fast = node;
		
		while(true) {
			if(fast.next != null ) { 
				fast = fast.next.next;
				slow = slow.next;
			}
			if(fast == slow) { // fast and slow meet
				System.out.println(fast.data);
				return true;
			}
			if(fast == null || fast.next == null) { // fast becomes null indicating end of list without loop
				return false;
			}
		}
	}
	
	

}
