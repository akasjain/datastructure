package leetcode.challenge.april;

import leetcodeeducative.tree.BinaryTreeMaximumPathSum;
import leetcodeeducative.tree.TreeNode;

/**
 Given a non-empty binary tree, find the maximum path sum.

 For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

 Example 1:
    Input: [1,2,3]
    1
  /  \
 2    3
    Output: 6

 Example 2:
    Input: [-10,9,20,null,null,15,7]
       -10
       /  \
       9  20
         /  \
        15   7
    Output: 42
 */
public class C29_BinaryTreeMaximumPathSum {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxPath == Integer.MIN_VALUE ? 0 : maxPath;
    }

    public int pathSum(TreeNode root) {

        if(root == null)
            return 0;

        int leftSum = Math.max(0, pathSum(root.left));
        int rightSum = Math.max(0, pathSum(root.right));

        maxPath = Math.max(maxPath, root.val + leftSum + rightSum);
        return root.val + Math.max(leftSum, rightSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        C29_BinaryTreeMaximumPathSum obj = new C29_BinaryTreeMaximumPathSum();
        System.out.println(obj.maxPathSum(root));
    }
}
