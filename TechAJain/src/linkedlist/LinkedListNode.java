package linkedlist;

public class LinkedListNode {
	public LinkedListNode next;
	public Object data;
	
	public LinkedListNode(Object data) {
		this.data = data;
	}
	
	public LinkedListNode() {
		//this.setNext(null);
	}
	
	public LinkedListNode getNext() {
		return next;
	}

	public void setNext(LinkedListNode next) {
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	
}
