package ds.tree;

import java.util.*;

class ZigzagTraversal {
    public static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        boolean direction = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int numOfNodesInCurrentLevel = queue.size();

            List<Integer> nodes = new ArrayList<>();
            for (int i = 0; i < numOfNodesInCurrentLevel; i++) {
                TreeNode currentNode = queue.poll();
                if(direction) {
                    nodes.add(currentNode.data);
                    if(currentNode.left != null)    queue.add(currentNode.left);
                    if(currentNode.right != null)    queue.add(currentNode.right);
                } else {
                    nodes.add(0, currentNode.data);
                    if(currentNode.left != null)    queue.add(currentNode.left);
                    if(currentNode.right != null)    queue.add(currentNode.right);
                }
            }
            result.add(nodes);
            direction = !direction;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(20);
        root.right.left.right = new TreeNode(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
