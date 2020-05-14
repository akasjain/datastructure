package ds.tree;

public class BinaryTree2DoubleLinkedList {
    Node root;
    Node head;
    Node prev = null;
    void binaryTree2DoubleLinkedList(Node root)
    {
        // Base case
        if (root == null)
            return;

        // Recursively convert left subtree
        binaryTree2DoubleLinkedList(root.left);

        // Now convert this node
        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        // Finally convert right subtree
        binaryTree2DoubleLinkedList(root.right);
    }

    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.data + " ");
            node = node.right;
        }
    }

    public static void main(String[] args) {
        BinaryTree2DoubleLinkedList tree = new BinaryTree2DoubleLinkedList();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);

        // convert to DLL
        tree.binaryTree2DoubleLinkedList(tree.root);

        // Print the converted List
        tree.printList(tree.head);
    }

}
