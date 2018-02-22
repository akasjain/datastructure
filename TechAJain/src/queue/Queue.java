package queue;

public interface Queue {
	public void push(Object data);
	public Object pop();
	public boolean isEmpty();
	public int size();
	public void printQueue();
}
