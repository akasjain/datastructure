package leetcode.challenge.august;

import leetcode.challenge.june.J01_InvertBinaryTree;

import java.util.*;

/**
 987. Vertical Order Traversal of a Binary Tree
 https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

 Given a binary tree, return the vertical order traversal of its nodes values.

 For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 Input: [3,9,20,null,null,15,7]
 Output: [[9],[3,15],[20],[7]]

 Input: [1,2,3,4,5,6,7]
 Output: [[4],[2],[1,5,6],[3],[7]]

 Input: [3,9,20,null,null,15,7,12,null,2,null,null,4,null,null,null,1]
 Output: [[9, 12],[3, 15, 4],[20, 2, 1],[7]]

             3
           /    \
          9     20
              /    \
            15      7
           /       /
          12       2
            \
              4
               \
                 1
  */
public class AG07_VerticalOrderTraversalOfBinaryTree {
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

    public class Triple implements Comparable<Triple> {
        int x,y,val;
        public Triple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Triple o) {
            if(this.x != o.x)
                return this.x - o.x;
            else {
                if(this.y != o.y)
                    return this.y - o.y;
                else
                    return this.val - o.val;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<Triple> pq = new PriorityQueue<>(Triple::compareTo);
        dfs(root, pq, 0, 0);

        while(!pq.isEmpty()) {
            Triple top = pq.peek();
            List<Integer> current = new ArrayList<>();
            while(!pq.isEmpty() && pq.peek().x == top.x) {
                current.add(pq.poll().val);
            }
            result.add(current);
        }
        return result;
    }

    private void dfs(TreeNode node, PriorityQueue<Triple> pq, int x, int y) {
        if(node == null)
            return;

        pq.add(new Triple(x, y, node.val));
        dfs(node.left, pq, x - 1, y+1);
        dfs(node.right, pq, x + 1, y+1);
    }

    public static void main(String[] args) {
        AG07_VerticalOrderTraversalOfBinaryTree obj = new AG07_VerticalOrderTraversalOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = obj.verticalTraversal(root);
        result.forEach(level -> System.out.print(level.toString() + " "));

        System.out.println();
        root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.left.left = new TreeNode(12);
        root.right.left.left.right = new TreeNode(4);
        root.right.left.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(2);
        result = obj.verticalTraversal(root);
        result.forEach(level -> System.out.print(level.toString() + " "));
    }
}
