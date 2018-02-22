package tree;

public class Node {
	private Object data;
	private Node left;
	private Node right;
	
	public Node(Object data) {
		this.data = data;
		this.setLeft(null);
		this.setRight(null);
	}
	
	public Object getData() {
		return data;
	}
	public Node getLeft() {
		return left;
	}
	public Node getRight() {
		return right;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	
	
}
