package linkedlist;

public class MultiLinkNode {

	int data;
	MultiLinkNode right;
	MultiLinkNode down;
	
	public MultiLinkNode(int data) {
		this.data = data;
		this.right = null;
		this.down = null;
	}
	
	public static void printMultiLinkNodeByDownLink(MultiLinkNode head) {
		if(head.down == null) {
			System.out.println(head.data);
			return;
		}
		MultiLinkNode temp = head;
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.down;
			
		}
	}
	
}
