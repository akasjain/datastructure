package ds.tree;



public class MirrorTree {

    static Node mirror(Node node) {
        if(node == null)
            return node;
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    public static void main(String[] args) {

        Node tree = new Node(26);
        tree.left = new Node(10);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(6);
        tree.right.right = new Node(3);

        Node mirror = MirrorTree.mirror(tree);
        System.out.println(mirror.data);
    }
}
