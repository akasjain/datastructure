package leetcode.challenge.april;

/**
 https://codenuclear.com/leetcode-check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/

 Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.

 We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.

 Example 1:
    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,1,0,1]
    Output: true
    Explanation:
     The path 0 -> 1 -> 0 -> 1 is a valid sequence
     Other valid sequences are:
     0 -> 1 -> 1 -> 0
     0 -> 0 -> 0

 Example 2:
    Input: root = [0,1,0,0,1,0,null,null,1,0,0], arr = [0,0,1]
    Output: false
    Explanation: The path 0 -> 0 -> 1 does not exist, therefore it is not even a sequence.
 */
public class C30_CheckIfStringIsAValidSequenceFromRootToLeaves {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isValidSequence(TreeNode root, int[] arr) {
        if(root == null && arr.length != 0)
            return false;

        return isValidRec(root, arr, 0);
    }

    public boolean isValidRec(TreeNode root, int[] arr, int index) {

        if(root == null)
            return index == arr.length;

        if(index < arr.length && root.val == arr[index]) {
            return isValidRec(root.left, arr, index + 1) || isValidRec(root.right, arr, index + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        C30_CheckIfStringIsAValidSequenceFromRootToLeaves obj = new C30_CheckIfStringIsAValidSequenceFromRootToLeaves();

        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right =  new TreeNode(0, null, new TreeNode(0));
        root.left.left  = new TreeNode(0);
        root.left.right  = new TreeNode(1);
        root.left.left.right  = new TreeNode(1);
        root.left.right.left  = new TreeNode(0);
        root.left.right.right  = new TreeNode(0);
        System.out.println(obj.isValidSequence(root, new int[]{0,1,0,1}));
        System.out.println(obj.isValidSequence(root, new int[]{0,1,1}));
        System.out.println(obj.isValidSequence(null, new int[]{0}));
        System.out.println(obj.isValidSequence(null, new int[]{}));

        root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.left.left  = new TreeNode(2);
        root.left.right  = new TreeNode(1);
        root.left.left.right  = new TreeNode(1);
        root.left.left.left  = new TreeNode(5);
        root.left.left.right  = new TreeNode(4);
        System.out.println(obj.isValidSequence(root, new int[]{8}));
    }
}
