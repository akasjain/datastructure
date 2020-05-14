package tree;

public class ConvertToMirrorTree {

	private void convertTreeToMirror(Node node) {

		if(node == null) {
			return;
		}

		Node temp = node.left;
		node.left = node.right;
		node.right = temp;

		convertTreeToMirror(node.left);
		convertTreeToMirror(node.right);
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(2);
		root.right.left = new Node(3);
		root.right.right = new Node(4);
		root.left.left.left = new Node(6);

		ConvertToMirrorTree mirror = new ConvertToMirrorTree();
		mirror.convertTreeToMirror(root);
	}
}
