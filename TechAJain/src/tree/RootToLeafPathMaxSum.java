package tree;

import java.util.*;

public class RootToLeafPathMaxSum {
    Integer maxSum = Integer.MIN_VALUE;
    List<Integer> maxSumPath = new ArrayList<>();
    public void pathWithMaxSum(TreeNode root) {
        List<Integer> maxSumPath = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        Integer sum = 0;
        Integer maxSum = Integer.MIN_VALUE;
        maxSumRec(root, sum, maxSum, currentPath);

    }

    private void maxSumRec(TreeNode node, Integer sum, Integer maxSum, List<Integer> currentPath) {

        if(node == null)
            return;

        sum += node.data;
        currentPath.add(node.data);

        if(node.left == null && node.right == null) {
            System.out.println(currentPath.toString());
            if(sum > maxSum) {
                maxSum = sum;
                maxSumPath = new ArrayList<>(currentPath);
            }
        } else {
            maxSumRec(node.left, sum, maxSum, currentPath);
            maxSumRec(node.right, sum, maxSum, currentPath);
        }

        sum -= node.data;
        currentPath.remove(currentPath.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        RootToLeafPathMaxSum rootToLeafPathMaxSum = new RootToLeafPathMaxSum();
        rootToLeafPathMaxSum.pathWithMaxSum(root);
        System.out.println(rootToLeafPathMaxSum.maxSumPath.toString());

    }

}
