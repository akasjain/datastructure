package linkedlist;

public class LinkedListUtils {
	public static LinkedListNode addNodeInFront(LinkedListNode head, Object data) {
		LinkedListNode node = new LinkedListNode(data);
		if(head.getNext()!= null) { 
			node.setNext(head.getNext());
		}
		head.setNext(node);
		return head;
	}
	
	public static LinkedListNode addNodeAtLast(LinkedListNode head, Object data) {
		LinkedListNode node = new LinkedListNode(data);
		if(head.getNext() == null) {
			head.setNext(node);
			return head;
		}
		
		LinkedListNode temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(node);	
		return head;
	}
	
	public static LinkedListNode addNodeAtNthPosition(LinkedListNode head, Object data, int loc) {
		
		LinkedListNode node = new LinkedListNode(data);
		LinkedListNode temp = head;
		
		int count = 0;
		
		while(count < loc-1) {
			if(temp.getNext() != null) {
					count++;
					temp = temp.getNext();
			} else {
				System.out.println("Desired location is not available. Skiiping add operating");
				return head;
			}
		}
		node.setNext(temp.getNext());
		temp.setNext(node);
		
		return head;
	}
	
	public static LinkedListNode addNodeFromEnd(LinkedListNode head, Object data, int loc) {
		// get total number of nodes
		// exit if total number less than loc
		// compute total - loc
		// call add from front with difference

		LinkedListNode temp = head;
		int count = 0;
		
		while(temp.getNext() != null) {
			temp = temp.getNext();
			count++;
		}
		System.out.println("count - " + count);
		System.out.println("loc" + loc);
		
		
		int locFromFront = (count+1) - loc + 1; 
		// add 2 : 1 for added node count, 1 because count from end is 1 more from front
		System.out.println(locFromFront);
		return addNodeAtNthPosition(head, data, locFromFront);
	}
	
	public static void printLinkedList(LinkedListNode head) {
		if(head.getNext() == null) {
			return;
		}
		LinkedListNode temp = head;
		while(temp.getNext() != null) {
			temp = temp.getNext();
			System.out.print(temp.getData() + " -> ");
			
		}
	}
	
	public static LinkedListNode deleteFirstNode(LinkedListNode head) {
		
		if(head.getNext() == null) {
			return head;
		} 
		LinkedListNode firstNode = head.getNext();
		if(firstNode.getNext() != null) {
			head.setNext(firstNode.getNext());
		}
		System.out.println("Deleted Node : " + firstNode.getData());
		return head;
	}
	
	public static LinkedListNode deleteLastNode(LinkedListNode head) {
		if(head.getNext() == null) {
			return head;
		} 
		LinkedListNode temp = head.getNext();
		LinkedListNode precedingNode = head;
		
		while(temp.getNext() != null) {
			precedingNode = temp;
			temp = temp.getNext();
		}
		System.out.println("Deleted Node : " + temp.getData());		
		precedingNode.setNext(null);	
		return head;
	}
}
