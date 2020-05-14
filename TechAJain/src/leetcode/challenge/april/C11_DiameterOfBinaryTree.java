package leetcode.challenge.april;

import leetcode.challenge.may.C07_CousinsInBinaryTree;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class C11_DiameterOfBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public int treeDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return treeDiameter == 0 ? 0 : treeDiameter -1;
    }
    public int calculateHeight(TreeNode node) {
        if(node == null)
            return 0;

        int lheight = calculateHeight(node.left);
        int rheight = calculateHeight(node.right);
        int currentDia = 1 + lheight + rheight;

        treeDiameter = Math.max(treeDiameter, currentDia);

        return 1 + Math.max(lheight, rheight);
    }

    public static void main(String[] args) {
        C11_DiameterOfBinaryTree obj = new C11_DiameterOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(obj.diameterOfBinaryTree(root));
    }
}
