package tree;

import stack.StackImpl;

public class PathRootToLeaf {
	StackImpl stack = new StackImpl();

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		root.left.left.left = new Node(6);
		
		PathRootToLeaf path = new PathRootToLeaf();
		path.stack.push((int)root.data);
		path.printPath(root);
		
	}

	private void printPath(Node root) {
		Node node = root;
		if(root == null)
			return;
		
		if(node.left == null && node.right == null) {
			stack.printStack();
		}
		
		if(node.left != null) {
			stack.push((int)node.left.data);
			printPath(node.left);
			stack.pop();
		} 
		
		if(node.right != null) {
			stack.push((int)node.right.data);
			printPath(node.right);
			stack.pop();
		}
	}

}
