package leetcode.challenge.august;

import java.util.ArrayList;
import java.util.List;

/**


 You are given a binary tree in which each node contains an integer value.
 Find the number of paths that sum to a given value.
 The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

 Example:
    root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

           10
          /  \
         5   -3
        / \    \
       3   2   11
      / \   \
     3  -2   1

 Return 3. The paths that sum to 8 are:
 1.  5 -> 3
 2.  5 -> 2 -> 1
 3. -3 -> 11

 */
public class AG08_PathSumIII {
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

    int answer = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum, new ArrayList<Integer>());
        return answer;
    }

    private void dfs(TreeNode node, int sum, List<Integer> current) {
        if(node == null)
            return;


        int partialSum = 0;
        current.add(node.val);
        for(int i = current.size() - 1; i >=0; i--) {
            partialSum += current.get(i);
            if(partialSum == sum)
                answer++;
        }

        dfs(node.left, sum, current);
        dfs(node.right, sum, current);
        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        AG08_PathSumIII obj = new AG08_PathSumIII();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);
        int result = obj.pathSum(root, 8);
        System.out.println(result);
    }
}
