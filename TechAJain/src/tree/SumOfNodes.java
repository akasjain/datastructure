package tree;

public class SumOfNodes {

	public static void main(String[] args) {

		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		root.left.left.left = new Node(6);

		SumOfNodes obj = new SumOfNodes();
		int sumOfNodes = obj.getSumOfNodes(root);
		System.out.println(sumOfNodes);
		
		int numOfNodes = obj.getNumOfNodes(root);
		System.out.println(numOfNodes);
		
		int numOfLeafNodes = obj.getNumOfLeafNodes(root);
		System.out.println(numOfLeafNodes);
		
		int diffOfNodes = obj.getDifferenceOfNodesAtAlternateLevel(root);
		System.out.println(diffOfNodes);
		
	}


	private int getSumOfNodes(Node root) {

		Node node = root;
		if(node == null) {
			return 0;
		}
		else {
			return (int)node.data + (int)getSumOfNodes(node.left) + (int)getSumOfNodes(node.right);
		}
		
	}
	
	private int getNumOfNodes(Node root) {
		Node node = root;
		if(node == null) {
			return 0;
		}
		else {
			return (int)1 + (int)getNumOfNodes(node.left) + (int)getNumOfNodes(node.right);
		}
		
	}
	
	private int getNumOfLeafNodes(Node root) {

		Node node = root;
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;
		}
		else {
			return (int)getNumOfLeafNodes(node.left) + (int)getNumOfLeafNodes(node.right);
		}
		
	}
	
	private int getDifferenceOfNodesAtAlternateLevel(Node root) {

		Node node = root;
		if(node == null) {
			return 0;
		}
		else {
			return (int)node.data 
					- (int)getDifferenceOfNodesAtAlternateLevel(node.left) 
					- (int)getDifferenceOfNodesAtAlternateLevel(node.right);
		}
		
		
	}
	

}
