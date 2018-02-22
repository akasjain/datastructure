package linkedlist;

public class FindMiddleOfList {
	public static void findMiddleOfList(LinkedListNode head) {
		LinkedListNode temp1 = head;
		LinkedListNode temp2 = head;
		int counter = 0;

		while(temp1.getNext() != null) {
			if(temp1.getNext() != null) {
				temp1 = temp1.getNext();
				temp2 = temp2.getNext();
				counter++;
			}
			if(temp1.getNext() != null) {
				temp1 = temp1.getNext();
				counter++;
			}
		}
		if(counter%2 == 0) {
			System.out.println("Middle element is : " + temp2.getNext().getData());
		} else { 
			System.out.println("Middle element is : " + temp2.getData());
		}
	}
}
