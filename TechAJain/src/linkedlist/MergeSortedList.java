package linkedlist;

public class MergeSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListNode head1 = new LinkedListNode(2);
		head1.next = new LinkedListNode(5);
		head1.next.next = new LinkedListNode(6);
		head1.next.next.next = new LinkedListNode(8);

		
		
		LinkedListNode head2 = new LinkedListNode(3);
		head2.next = new LinkedListNode(4);
		head2.next.next = new LinkedListNode(10);
		head2.next.next.next = new LinkedListNode(12);

		
		MergeSortedList sort = new MergeSortedList();
		LinkedListNode sorted = sort.mergeSortedList(head1, head2);
		
		//print the list
		
		
	}

	public LinkedListNode mergeSortedList(LinkedListNode head1, LinkedListNode head2) {
		
		LinkedListNode head = new LinkedListNode(-1);
		LinkedListNode temp = head;
		
		while(head1 != null && head2 != null) {
			if((int)head1.data <= (int)head2.data) {
				temp.next = head1;
				head1 = head1.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
			}
			temp = temp.next;
		}
		
		if(head1 == null) {
			temp.next = head2;
			
			
/*			while(head2 != null) {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}*/
		} else {
			temp.next = head1;

			/*while(head1 != null) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			}*/
		}
		
		return head.next;
	}
	
	public MultiLinkNode mergeSortedList(MultiLinkNode head1, MultiLinkNode head2) {
        MultiLinkNode head = new MultiLinkNode(-1);
        MultiLinkNode temp = head;

        while(head1 != null && head2 != null) {
                if((int)head1.data <= (int)head2.data) {
                        temp.down = head1;
                        head1 = head1.down;
                } else {
                        temp.down = head2;
                        head2 = head2.down;
                }
                temp = temp.down;
        }

        if(head1 == null) {
                temp.down = head2;
        } else {
                temp.down = head1;
        }

        return head.down;
}

}
