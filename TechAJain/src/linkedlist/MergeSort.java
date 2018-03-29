package linkedlist;

public class MergeSort {
	
	public static void main(String[] args) {

		LinkedListNode node = new LinkedListNode(5);
		node.next = new LinkedListNode(3);
		node.next.next = new LinkedListNode(4);
		node.next.next.next = new LinkedListNode(9);
		node.next.next.next.next = new LinkedListNode(13);
		node.next.next.next.next.next = new LinkedListNode(11);
		node.next.next.next.next.next.next = new LinkedListNode(12);
		node.next.next.next.next.next.next.next = new LinkedListNode(6);


		MergeSort obj = new MergeSort();
		LinkedListNode mergedList = obj.mergeSort(node);
		LinkedListUtils.printLinkedList(mergedList);
	}

	public LinkedListNode mergeSort(LinkedListNode node) {
		
		if(node == null || node.next == null)
			return node;
		
		LinkedListNode middle = this.getMiddleNode(node);
		LinkedListNode nextOfMiddle = middle.next;
		middle.next = null;
		
		LinkedListNode left = mergeSort(node);
		LinkedListNode right = mergeSort(nextOfMiddle);
		
		MergeSortedList obj = new MergeSortedList();
		LinkedListNode sortedList = obj.mergeSortedList(left, right);
		return sortedList;
		
	}

	private LinkedListNode getMiddleNode(LinkedListNode node) {

		if(node == null || node.next == null) 
			return node;
		
		LinkedListNode fast = node.next;
		LinkedListNode slow = node;
		
		
		while(fast.next != null) {
			fast = fast.next;
			if(fast.next != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		
		return slow;
	}

}
