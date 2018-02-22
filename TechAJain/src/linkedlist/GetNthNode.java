package linkedlist;

public class GetNthNode {
	public static LinkedListNode getNth(LinkedListNode head, int loc) {
		LinkedListNode temp = head;
		int count = 0;
		
		while(count < loc) {
			if(temp.getNext() != null) {
				count++;
				temp = temp.getNext();
				
			} else {
				System.out.println("\n Position doesn't exist");
				return null;
			}
		}
		return temp;
	}
}
