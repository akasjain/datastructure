package queue;

import linkedlist.LinkedListNode;

public class QueueImpl implements Queue {

	private LinkedListNode front;
	private LinkedListNode rear;
	
	public QueueImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void push(Object data) {
		
		LinkedListNode node = new LinkedListNode(data);
		
		if(front == null) {
			front = node;
		} else {
			rear.setNext(node);
		}
		rear = node;
	}

	@Override
	public Object pop() {

		if(front == null) {
			System.out.println("Nothing to pop");
			return null;
		}
		
		LinkedListNode poppedElem = front;
		if(front.getNext() != null) {
			front = front.getNext();
		} else {
			front = rear = null;
		}
		
		return poppedElem.getData();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public int size() {

		int count = 0;
		if(front == null) {
			count = 0;
		} else {
			LinkedListNode temp = front;
			while(temp != rear) {
				count++;
				temp = temp.getNext();
			}
			count = count + 1;
		}
		return count;
	}

	@Override
	public void printQueue() {
		// TODO Auto-generated method stub
		LinkedListNode temp = front;
		if(!isEmpty()) {
			System.out.println("Printing stack");
			while(temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		} else {
			System.out.println("Queue is empty");
		}
		
		
	}

}
