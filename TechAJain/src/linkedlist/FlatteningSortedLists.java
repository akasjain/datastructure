package linkedlist;

public class FlatteningSortedLists {
	
	/*Node head; 
	
	class Node {
		int data;
		Node down;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.down = null;
			this.right = null;
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MultiLinkNode list1 = new MultiLinkNode(5);
		list1.down = new MultiLinkNode(7);
		list1.down.down = new MultiLinkNode(8);
		list1.down.down.down = new MultiLinkNode(30);

		MultiLinkNode list2 = new MultiLinkNode(10);
		list2.down = new MultiLinkNode(20);
		
		MultiLinkNode list3 = new MultiLinkNode(19);
		list3.down = new MultiLinkNode(22);
		list3.down.down = new MultiLinkNode(50);
		
		MultiLinkNode list4 = new MultiLinkNode(28);
		list4.down = new MultiLinkNode(35);
		list4.down.down = new MultiLinkNode(40);
		list4.down.down.down = new MultiLinkNode(45);
		
		list1.right = list2;
		list2.right = list3;
		list3.right = list4;

		MultiLinkNode head;
		head = flattenList(list1);
		
		MultiLinkNode.printMultiLinkNodeByDownLink(head);
		
	}

	private static MultiLinkNode flattenList(MultiLinkNode list1) {

		if (list1 == null || list1.right == null)
            return list1;
		
		MultiLinkNode t1 = list1;
		MultiLinkNode t2 = t1.right;
		
		MergeSortedList obj = new MergeSortedList();
		
		while(t2 != null) {
			
			MultiLinkNode temp = t2.right;

			t1.right = null;
			t2.right = null;
			
			
			MultiLinkNode sorted = obj.mergeSortedList(t1, t2);
			if(temp != null) {
				sorted.right = temp;
			}
			t1 = sorted;
			t2 = t1.right;
		}
		
		return t1;
	}
	
	
	

}
