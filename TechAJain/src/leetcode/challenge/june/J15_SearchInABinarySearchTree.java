package leetcode.challenge.june;

/**
 Given the root node of a binary search tree (BST) and a value.
 You need to find the node in the BST that the node's value equals the given value.
 Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

 */
public class J15_SearchInABinarySearchTree {
    public class TreeNode {
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

    public TreeNode searchBST(TreeNode root, int val) {
        if(root.val == val || root == null)
            return root;
        TreeNode temp = root;
        while(temp != null) {
            if(temp.val < val) {
                temp = temp.right;
            } else if(temp.val > val){
                temp = temp.left;
            } else {
                return temp;
            }
        }
        return null;
    }
}
