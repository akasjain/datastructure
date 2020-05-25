package leetcode.challenge.may;

public class C24_ConstructBinarySearchTreeFromPreorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
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

}
