package linkedlist;

import java.util.HashMap;

public class RemoveDuplicatesUnsortedList {

	public static void main(String[] args) {
		LinkedListNode node = new LinkedListNode(2);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(6);
		node.next.next.next = new LinkedListNode(7);
		node.next.next.next.next = new LinkedListNode(3);
		node.next.next.next.next.next = new LinkedListNode(2);
		node.next.next.next.next.next.next = new LinkedListNode(5);
		node.next.next.next.next.next.next.next = new LinkedListNode(3);
		node.next.next.next.next.next.next.next.next = new LinkedListNode(5);

		RemoveDuplicatesUnsortedList obj = new RemoveDuplicatesUnsortedList();
		obj.removeDuplicatesUnsortedList(node);
		LinkedListUtils.printLinkedList(node);
	}

	public void removeDuplicatesUnsortedList(LinkedListNode node) {

		if(node == null)
			return;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put((Integer) node.data, 1);
		LinkedListNode temp = node;
		
		while(temp.next != null) {
			if(map.containsKey(temp.next.data)) {
				temp.next = temp.next.next;
				continue;
				
			} else {
				map.put((Integer) temp.next.data, 1);
				temp = temp.next;
			}
		}
	}

}
