package leetcode.challenge.april;

/**
 Return the root node of a binary search tree that matches the given preorder traversal.

 Constraints:
    1. 1 <= preorder.length <= 100
    2. 1 <= preorder[i] <= 10^8
    3. The values of preorder are distinct.
 */
public class C20_ConstructBinarySearchTreeFromPreorderTraversal {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderRec(preorder, 0, preorder.length - 1);
    }

    public TreeNode bstFromPreorderRec(int[] preorder, int start, int end) {

        if(start > end)
            return null;
        if(start == end)
            return new TreeNode(preorder[start]);

        TreeNode node = new TreeNode(preorder[start]);
        int index = findNextGreaterElementIndex(preorder, node.val, start, end);
        if(index == start + 1) {
            node.left = null;
            node.right= bstFromPreorderRec(preorder, index, end);
        } else if(index != -1) {
            node.left = bstFromPreorderRec(preorder, start + 1, index - 1);
            node.right= bstFromPreorderRec(preorder, index, end);
        } else {
            node.left = bstFromPreorderRec(preorder, start + 1, end);
            node.right = null;
        }

        return node;


    }

    public int findNextGreaterElementIndex(int[] preorder, int key, int start, int end) {
        int index = -1;
        for(int i = start+1; i <= end; i++) {
            if(preorder[i] >key) {
                index = i;
                break;
            }
        }

        return index;
    }

    public static void main(String[] args) {
        C20_ConstructBinarySearchTreeFromPreorderTraversal obj = new C20_ConstructBinarySearchTreeFromPreorderTraversal();
        TreeNode root = obj.bstFromPreorder(new int[]{8,5,1,7,10,12});
    }
}
