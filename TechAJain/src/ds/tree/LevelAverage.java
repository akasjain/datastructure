package ds.tree;

import java.util.*;

class LevelAverage {
    public static List<Double> findLevelAverages(TreeNode root) {
        List<Double> result = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int numOfNodesInCurrentLevel = queue.size();

            Double avg = 0.0;
            for (int i = 0; i < numOfNodesInCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();
                avg += Integer.valueOf(currentNode.data);
                if(currentNode.left != null)    queue.add(currentNode.left);
                if(currentNode.right != null)    queue.add(currentNode.right);
            }
            result.add(avg / numOfNodesInCurrentLevel);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
