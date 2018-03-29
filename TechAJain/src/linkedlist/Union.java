package linkedlist;

import java.util.HashMap;

public class Union {

	public static void main(String[] args) {

		LinkedListNode head1 = new LinkedListNode(10);
		head1.next = new LinkedListNode(15);
		head1.next.next = new LinkedListNode(4);
		head1.next.next.next = new LinkedListNode(20);

		
		
		LinkedListNode head2 = new LinkedListNode(8);
		head2.next = new LinkedListNode(4);
		head2.next.next = new LinkedListNode(2);
		head2.next.next.next = new LinkedListNode(10);
		
		Union obj = new Union();
		LinkedListNode union = obj.unionList(head1, head2);
		if(union != null) {
			LinkedListUtils.printLinkedList(union);
		} else {
			System.out.println("Input strings are empty");
		}
		
	}

	private LinkedListNode unionList(LinkedListNode list1, LinkedListNode list2) {

		HashMap<Integer, Integer> map = new HashMap<>();
		LinkedListNode union = list1, temp, t1, t2;
		
		
		if(list1 == null && list2 == null) 
			return null;
		else if (list1 == null)
			return list2;
		else if (list2 == null) 
			return list1;
		
		t1 = list1;
		while(t1 != null) {
			map.put((Integer) t1.data, 1);
			temp = t1.next;
		}
				
		temp = union;
		//reach end of list1
		
		while(temp.next != null) {
			temp = temp.next;
		}
		
		t2 = list2;
		while(t2 != null) {
			if(map.containsKey(t2.data)) {
				int val = map.get(t2.data);
				map.put((Integer) t2.data, val + 1);
				continue;
			} else {
				map.put((Integer) t2.data, 1);
				LinkedListNode newNode = new LinkedListNode(t2.data);
				temp.next = newNode;

			}
		}
		return union;
	}

}
