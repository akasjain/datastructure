package ds.tree;

class Node {
    int data;
    Node left;
    Node right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

public class SumTree {

    static boolean isSumTree(Node node) {

        int leftSum, rightSum;

        if(node == null || isLeaf(node))
            return true;

        if(isSumTree(node.left) && isSumTree(node.right)) {
            if(node.left == null)
                leftSum = 0;
            else if(isLeaf(node.left))
                leftSum = node.left.data;
            else
                leftSum = 2 * node.left.data;

            if(node.right == null)
                rightSum = 0;
            else if(isLeaf(node.right))
                rightSum = node.right.data;
            else
                rightSum = 2 * node.right.data;

            if(node.data == leftSum + rightSum)
                return true;
            else
                return false;
        }
        return false;
    }

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }


    public static void main(String[] args) {


        Node tree = new Node(26);
        tree.left = new Node(10);
        tree.right = new Node(3);
        tree.left.left = new Node(4);
        tree.left.right = new Node(6);
        tree.right.right = new Node(3);

        if (SumTree.isSumTree(tree))
            System.out.println("The given tree is a sum tree");
        else
            System.out.println("The given tree is not a sum tree");

    }
}


