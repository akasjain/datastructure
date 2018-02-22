package queue;

public class QueueUsage {

	public static void main(String[] args) {

		QueueImpl queue = new QueueImpl();
		queue.push(3);
		queue.push(5);
		queue.push(6);
		queue.printQueue();
		queue.pop();
		queue.printQueue();
		queue.push(8);
		queue.printQueue();
		queue.pop();
		queue.printQueue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		queue.pop();
		queue.pop();
		queue.printQueue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());


		

	}

}
