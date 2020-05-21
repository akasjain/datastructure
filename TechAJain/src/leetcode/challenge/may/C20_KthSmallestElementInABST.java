package leetcode.challenge.may;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class C20_KthSmallestElementInABST {
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

    /**
     * Solution 2
     * Time - O(N)
     * Space - O(H) H is the height of the tree
     */
    public int kthSmallestUsingInOrderTraversalUptoK(TreeNode root, int k) {
        AtomicInteger count = new AtomicInteger(k);
        return kthSmallestUptoK(root, count).val;
    }

    public TreeNode kthSmallestUptoK(TreeNode root, AtomicInteger count) {
        if(root == null)
            return null;

        TreeNode left = kthSmallestUptoK(root.left, count);
        if(left != null) {
            return left;
        }

        count.getAndDecrement();
        if(count.get() == 0) {
            return root;
        }

        return kthSmallestUptoK(root.right, count);
    }


    /**
     * Solution 3
     * Time - (N)
     * Space(N)
     */
    public int kthSmallestUsingFullInOrderTraversal(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        bstInorder(root, inorder);
        return inorder.get(k-1);
    }

    public void bstInorder(TreeNode root, List<Integer> inorder) {
        if(root == null)
            return;
        bstInorder(root.left, inorder);
        inorder.add(root.val);
        bstInorder(root.right, inorder);
    }

    public static void main(String[] args) {
        C20_KthSmallestElementInABST obj = new C20_KthSmallestElementInABST();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        System.out.println(obj.kthSmallestUsingInOrderTraversalUptoK(root, 1));
        System.out.println(obj.kthSmallestUsingFullInOrderTraversal(root, 1));

        System.out.println(obj.kthSmallestUsingInOrderTraversalUptoK(root, 2));
        System.out.println(obj.kthSmallestUsingFullInOrderTraversal(root, 2));

        System.out.println(obj.kthSmallestUsingInOrderTraversalUptoK(root, 3));
        System.out.println(obj.kthSmallestUsingFullInOrderTraversal(root, 3));

        System.out.println(obj.kthSmallestUsingInOrderTraversalUptoK(root, 4));
        System.out.println(obj.kthSmallestUsingFullInOrderTraversal(root, 4));
    }

}
