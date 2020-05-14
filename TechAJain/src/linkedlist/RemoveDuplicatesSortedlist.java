package linkedlist;

public class RemoveDuplicatesSortedlist {

	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode(2);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(3);
		node.next.next.next = new LinkedListNode(3);
		node.next.next.next.next = new LinkedListNode(4);
		node.next.next.next.next.next = new LinkedListNode(6);
		node.next.next.next.next.next.next = new LinkedListNode(6);
		node.next.next.next.next.next.next.next = new LinkedListNode(6);
		node.next.next.next.next.next.next.next.next = new LinkedListNode(7);
		
		RemoveDuplicatesSortedlist obj = new RemoveDuplicatesSortedlist();
		obj.removeDuplicatesSortedList(node);
		LinkedListUtils.printLinkedList(node);
	}

	public LinkedListNode removeDuplicatesSortedList(LinkedListNode head) {

		LinkedListNode temp = head;
		if(head == null)
			return head;
				
		while(temp.next != null) {
			if(temp.data == temp.next.data) {
				temp.next = temp.next.next;
				continue;
			} else {
				temp = temp.next;
			}
		}
		
		return head;
	}

}
