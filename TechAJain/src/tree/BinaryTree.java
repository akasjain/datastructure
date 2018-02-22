package tree;

import queue.QueueImpl;

public class BinaryTree {

	public static Node createCompleteBinaryTree(Node root, Node node) {
		
		//reach end of rightmost side
		// add new node
		
		if(root.getRight() == null && root.getLeft() == null) {
			root.setLeft(node);
			return root;
		}
		
		QueueImpl queue = new QueueImpl();
		queue.push(root);
		
		Node temp;
		
		while(true) {
			temp = (Node) queue.pop();
			
			if(temp.getRight() == null && temp.getLeft() == null && !queue.isEmpty()) {
				temp.setLeft(node);
				break;
			} else if (temp.getRight() == null && temp.getLeft() != null) {
				temp.setRight(node);
				break;
			} else if(temp.getRight() != null && temp.getLeft() != null) {
				queue.push(temp.getLeft());
				queue.push(temp.getRight());
			}
			
		}
		return root;
	}
	
	public static void printTreeLevelWise(Node root) {
		QueueImpl queue = new QueueImpl();
		if(root == null) {
			return;
		}
		Node temp = root;
		queue.push(temp);

		while(true) {
			if(queue.isEmpty()) {
				break;
			}
			temp = (Node) queue.pop();
			
			if(temp.getLeft() != null) {
				queue.push(temp.getLeft());
			}
			if(temp.getRight() != null) {
				queue.push(temp.getRight());
			}
			System.out.print(" " + temp.getData() + " ");
		}
	}
	
	public static void printInorderTraversal(Node node) {
		if (node == null)
            return;
		
		if(node.getLeft() != null) {
			printInorderTraversal(node.getLeft());
		}
		System.out.print(node.getData() + " ");
		if(node.getRight() != null) {
			printInorderTraversal(node.getRight()); 
		}
	}
	
	public static void printPreorderTraversal(Node node) {
		if (node == null)
            return;
		
		System.out.print(node.getData() + " ");
		if(node.getLeft() != null) {
			printPreorderTraversal(node.getLeft());
		}
		if(node.getRight() != null) {
			printPreorderTraversal(node.getRight()); 
		}
	}
	
	public static void printPostorderTraversal(Node node) {
		if (node == null)
            return;
		
		if(node.getLeft() != null) {
			printPostorderTraversal(node.getLeft());
		}
		if(node.getRight() != null) {
			printPostorderTraversal(node.getRight()); 
		}
		System.out.print(node.getData() + " ");
	}
}
