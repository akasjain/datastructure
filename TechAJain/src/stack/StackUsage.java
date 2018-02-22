package stack;

public class StackUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackImpl stack = new StackImpl();
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.printStack();
		
		System.out.println("Popped element - " + stack.pop());
		stack.printStack();
		System.out.println("Size of stack - " + stack.size());
		System.out.println("isEmpty - " + stack.isEmpty());
		stack.pop();
		System.out.println("isEmpty - " + stack.isEmpty());
		stack.printStack();
		stack.pop();
		System.out.println("isEmpty - " + stack.isEmpty());
		stack.printStack();
		stack.push(6);
		stack.push(9);
		stack.printStack();
	}
}
