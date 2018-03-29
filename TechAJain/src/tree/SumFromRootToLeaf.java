package tree;

public class SumFromRootToLeaf {
	
	int numOfPaths;
	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		root.left.left.left = new Node(6);

		int k=20;
		
		SumFromRootToLeaf obj = new SumFromRootToLeaf();
		obj.printPathsWithSpecificSumMethod1(root, k); 
		
		
	}
	
	private void printPathsWithSpecificSumMethod1(Node root, int k) {

		
		
		
		
	}

}
