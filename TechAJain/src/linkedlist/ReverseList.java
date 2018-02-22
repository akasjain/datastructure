package linkedlist;

public class ReverseList {
	public static LinkedListNode reverseList(LinkedListNode head) {
		
		LinkedListNode t1 = head.getNext();
		LinkedListNode t2 = t1.getNext();
		LinkedListNode t3 = t2.getNext();

		t2.setNext(t1);
		t1.setNext(null);
		while(t3 != null) {
			t1=t2;
			t2=t3;
			if(t3.getNext() != null) {
				t3 = t3.getNext();
			} else {
				t3=null;
			}

			t2.setNext(t1);
		}
		head.setNext(t2);
		return head;
	}
}
