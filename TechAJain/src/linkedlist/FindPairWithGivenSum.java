package linkedlist;

import java.util.HashMap;

/**
 * Find pair in 2 lists having a sum 
 */
public class FindPairWithGivenSum {

	public static void main(String[] args) {
		
		int sum = 10;
		LinkedListNode head1 = new LinkedListNode(3);
		head1.next = new LinkedListNode(1);
		head1.next.next = new LinkedListNode(5);
		head1.next.next.next = new LinkedListNode(7);

		LinkedListNode head2 = new LinkedListNode(8);
		head2.next = new LinkedListNode(2);
		head2.next.next = new LinkedListNode(5);
		head2.next.next.next = new LinkedListNode(3);
		
		FindPairWithGivenSum obj = new FindPairWithGivenSum();
		obj.printPairWithTotalSum(head1, head2, sum);
	}

	private void printPairWithTotalSum(LinkedListNode head1, LinkedListNode head2, int sum) {

		LinkedListNode temp1 = head1;
		LinkedListNode temp2 = head2;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		while(temp1 != null) {
			
			if(map.containsKey(temp1.data)) {
				int val = map.get(temp1.data);
				map.put((Integer) temp1.data, val + 1);
				
			} else {
				map.put((Integer) temp1.data, 1);
			}
			temp1 = temp1.next;
		}
		
		while(temp2 != null) {
			int rem = sum - (Integer)temp2.data;
			if(map.containsKey(rem)) {
				System.out.println("Pair found : " + rem + " & " + (sum-rem));
				int val = map.get(rem);
				if(val == 0) {
					map.remove(rem);
				} else {
					map.put(rem, val - 1);
				}
			}
			temp2 = temp2.next;
		}
	}
}
