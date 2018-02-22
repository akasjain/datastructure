package tree;

public class TreeOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		Node temp = createCBTree(root);
		BinaryTree.printTreeLevelWise(temp);
		System.out.println("\nINORDER");
		BinaryTree.printInorderTraversal(root);
		System.out.println("\nPREORDER");
		BinaryTree.printPreorderTraversal(root);
		System.out.println("\nPOSTORDER");
		BinaryTree.printPostorderTraversal(root);

	}

	private static Node createCBTree(Node root) {
		// TODO Auto-generated method stub
		
		 BinaryTree.createCompleteBinaryTree(root, new Node(3));
		 BinaryTree.createCompleteBinaryTree(root, new Node(4));
		 BinaryTree.createCompleteBinaryTree(root, new Node(6));
		 BinaryTree.createCompleteBinaryTree(root, new Node(7));
		 BinaryTree.createCompleteBinaryTree(root, new Node(9));
		 BinaryTree.createCompleteBinaryTree(root, new Node(10));
		 BinaryTree.createCompleteBinaryTree(root, new Node(12));
		 BinaryTree.createCompleteBinaryTree(root, new Node(13));
		 BinaryTree.createCompleteBinaryTree(root, new Node(15));
		 BinaryTree.createCompleteBinaryTree(root, new Node(16));
		return root;
	}

}
