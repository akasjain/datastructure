package tree;

import java.util.ArrayList;
import java.util.List;

public class SerializeDeserialize {
    public void serialize(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(-1);
            return;
        }

        list.add(node.data);

        serialize(node.left, list);
        serialize(node.right, list);
    }

    int deSerializeIndex = 0;

    public TreeNode deSerialize(List<Integer> list) {
        if (list.get(deSerializeIndex) == -1) {
            deSerializeIndex++;
            return null;
        }

        TreeNode newTreeNode = new TreeNode(list.get(deSerializeIndex++));

        newTreeNode.left = deSerialize(list);
        newTreeNode.right = deSerialize(list);

        return newTreeNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(6);
        root.right = new TreeNode(9);
        root.right.right = new TreeNode(3);

        List<Integer> list= new ArrayList<>();
        SerializeDeserialize sd = new SerializeDeserialize();
        sd.serialize(root, list);

        root = sd.deSerialize(list);
    }
}
