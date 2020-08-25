package leetcode.challenge.july;

import ds.tree.TreeNode;
import leetcode.challenge.june.J01_InvertBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
      3
     / \
    9  20
   /  \
 15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 */
public class JL02_BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                level.add(top.val);
                if(top.left != null)
                    queue.offer(top.left);
                if(top.right != null)
                    queue.offer(top.right);
            }
            result.add(0, level);
        }
        return result;
    }

    public static void main(String[] args) {
        JL02_BinaryTreeLevelOrderTraversalII obj = new JL02_BinaryTreeLevelOrderTraversalII();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        List<List<Integer>> result = obj.levelOrderBottom(root);
        result.forEach(level -> System.out.println(level.toString()));
    }
}
