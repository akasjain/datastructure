package ds.tree.leetcode;

import leetcodeeducative.tree.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

public class ConstructTreeInorderPostOrder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        return buildTree(inorder, postorder, 0, inorder.length - 1, new AtomicInteger(inorder.length - 1));
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end, AtomicInteger index) {
        if(start == end)
            return new TreeNode(postorder[index.getAndDecrement()]);

        if(start > end)
            return null;

        TreeNode node = new TreeNode(postorder[index.getAndDecrement()]);
        int rootIdx = search(inorder, start, end, node.val);

        node.right = buildTree(inorder, postorder, rootIdx + 1, end, index);
        node.left = buildTree(inorder, postorder, start, rootIdx - 1, index);

        return node;
    }

    public int search(int[] arr, int start, int end, int val) {

        for(int i = start; i <= end; i++) {
            if(arr[i] == val)
                return i;
        }
        return -1;
    }
}
