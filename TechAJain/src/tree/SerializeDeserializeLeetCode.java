package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SerializeDeserializeLeetCode {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeRecursive(root, sb);
        return sb.toString();
    }
    public void serializeRecursive(TreeNode node, StringBuilder sb) {

        if(node == null) {
            sb.append('/');
            return;
        }

        sb.append(node.data);
        serializeRecursive(node.left, sb);
        serializeRecursive(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        AtomicInteger index = new AtomicInteger(0);
        return deSerializeRecursive(data, index);

    }

    public TreeNode deSerializeRecursive(String data, AtomicInteger index) {
        if(data.charAt(index.get()) == '/') {
            index.getAndIncrement();
            return null;
        }

        TreeNode newNode = new TreeNode(data.charAt(index.get()) - '0');
        index.getAndIncrement();
        newNode.left = deSerializeRecursive(data, index);
        newNode.right = deSerializeRecursive(data, index);

        return newNode;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        SerializeDeserializeLeetCode sd = new SerializeDeserializeLeetCode();
        String data = sd.serialize(root);
        System.out.println(data);

        TreeNode rootDes = sd.deserialize(data);
        System.out.println(rootDes.data);
        System.out.println(rootDes.left.data);
        System.out.println(rootDes.right.data);
        System.out.println(rootDes.right.left.data);
        System.out.println(rootDes.right.right.data);
    }
}
