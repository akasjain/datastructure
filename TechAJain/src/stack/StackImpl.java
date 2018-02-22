package stack;

import linkedlist.LinkedListNode;

public class StackImpl implements Stack {
	
	LinkedListNode top;
	
	public StackImpl() {
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void push(Object data) {
		// TODO Auto-generated method stub
		LinkedListNode node = new LinkedListNode(data);
		if(top != null) {
			node.setNext(top);
		}
		top = node;
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(! this.isEmpty()) {
			Object data = top.getData();
			top = top.getNext();
			return data;
		}
		return "No data to pop";
	}

	@Override
	public boolean isEmpty() {
		
		// TODO Auto-generated method stub
		return top == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		
		int count = 0;
		LinkedListNode temp;
		temp = top;
		while(temp != null) {
			count++;
			temp = temp.getNext();
		}
		return count;
	}

	@Override
	public void printStack() {
		// TODO Auto-generated method stub
		if(top == null) {
			System.out.println("No content to print");
			return;
		}
		LinkedListNode temp;
		temp = top;
		System.out.println("Printing stack content (top first)");
		while(temp != null) {
			System.out.println(temp.getData());
			temp = temp.getNext();
		}
	}

}
