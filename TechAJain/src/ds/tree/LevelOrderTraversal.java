package ds.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = LevelOrderTraversal.traverse(root);
    System.out.println("Level order traversal: " + result);
  }

  private static List<List<Integer>> traverse(TreeNode root) {

    if(root == null)
      return null;

    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()) {
      int numOfNodesCurrentLevel = queue.size();
      List<Integer> currentLevel = new ArrayList<>();

      for (int i = 0; i < numOfNodesCurrentLevel; i++) {
        TreeNode node = queue.poll();
        currentLevel.add(node.data);
        if(node.left != null) queue.offer(node.left);
        if(node.right != null) queue.offer(node.right);
      }
      result.add(currentLevel);
    }

    return result;
  }
}
