package leetcode.challenge.august;

/**
 404. Sum of Left Leaves
 https://leetcode.com/problems/sum-of-left-leaves/

 Find the sum of all left leaves in a given binary tree.

 Example:
     3
    / \
   9  20
     /  \
    15   7
 There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class AG24_SumOfLeftLeaves {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return dfs(root, false);
    }

    private int dfs(TreeNode node, boolean isLeft) {
        if(node == null)
            return 0;
        return ((isLeft && node.left == null && node.right == null) ? node.val : 0) +
                dfs(node.left, true) +
                dfs(node.right, false);
    }
}
