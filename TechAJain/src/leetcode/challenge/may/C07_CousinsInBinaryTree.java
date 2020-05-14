package leetcode.challenge.may;

import java.util.LinkedList;
import java.util.Queue;

/**
 Week1 May7
 https://leetcode.com/problems/cousins-in-binary-tree/

 In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 Return true if and only if the nodes corresponding to the values x and y are cousins.

 Example 1:
    Input: root = [1,2,3,4], x = 4, y = 3
    Output: false

 Example 2:
    Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
    Output: true

 Example 3:
    Input: root = [1,2,3,null,4], x = 2, y = 3
    Output: false

 Constraints:
    1. The number of nodes in the tree will be between 2 and 100.
    2. Each node has a unique integer value from 1 to 100.
 */
public class C07_CousinsInBinaryTree {
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

    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode lca = findLCA(root, x, y);
        int xDepth = findDepth(lca, x);
        int yDepth = findDepth(lca, y);

        return xDepth == yDepth && xDepth > 1;
    }

    public TreeNode findLCA(TreeNode root, int x, int y){
        if(root == null)
            return null;
        if(root.val == x || root.val == y) {
            return root;
        }

        TreeNode leftLCA = findLCA(root.left, x, y);
        TreeNode rightLCA = findLCA(root.right, x, y);

        if(leftLCA != null && rightLCA != null)
            return root;

        return leftLCA != null ? leftLCA : rightLCA;
    }

    public int findDepth(TreeNode root, int key) {
        if(root == null)
            return -1;

        if(root.val == key) {
            return 0;
        }

        int left = findDepth(root.left, key);
        int right = findDepth(root.right, key);

        if(left != -1) {
            return 1 + left;
        } else if(right != -1) {
            return 1 + right;
        }

        return -1;
    }

    /**
     * BFS solution
     * Source - https://leetcode.com/problems/cousins-in-binary-tree/discuss/622982/Easy-to-understand-BFS-solution
     */
    public boolean isCousinsBFS(TreeNode root, int x, int y) {

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        TreeNode parentx = null;
        TreeNode parenty = null;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i<size; i++) {
                TreeNode n = q.remove();
                if (n.left != null) {
                    if (n.left.val == x) {
                        parentx = n;
                    }
                    if (n.left.val == y) {
                        parenty = n;
                    }
                    q.add(n.left);
                }
                if (n.right != null) {
                    if (n.right.val == x) {
                        parentx = n;
                    }
                    if (n.right.val == y) {
                        parenty = n;
                    }
                    q.add(n.right);
                }
            }

            if (parentx == null && parenty != null) {
                return false;
            }
            else if (parentx != null && parenty == null) {
                return false;
            }else if (parentx == null && parenty == null) {
                continue;
            }
            else if (parentx.val == parenty.val) {
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        C07_CousinsInBinaryTree obj = new C07_CousinsInBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(obj.isCousins(root, 4, 3));

        root = new TreeNode(1);
        root.left = new TreeNode(2, null, null);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);
        System.out.println(obj.isCousins(root, 5, 4));

        root = new TreeNode(1);
        root.left = new TreeNode(2, null, null);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3, null, null);
        System.out.println(obj.isCousins(root, 2, 3));
    }
}
