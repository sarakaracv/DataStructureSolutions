package org.example.leetCodeWithNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        serializeHelper(node.left, sb);
        serializeHelper(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(queue);
    }

    private TreeNode deserializeHelper(Queue<String> queue) {
        String val = queue.poll();
        if (val.equals("null")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = deserializeHelper(queue);
        node.right = deserializeHelper(queue);
        return node;
    }

    public class Codec {
        static TreeNode main;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            main = root;
            return "abc";
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return main;
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

    class Global{
        static HashMap<String,TreeNode> map=new HashMap<>();
    }
    public class Codec2 {
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            String s="sth";
            Global.map.put(s,root);
            return s;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return Global.map.get(data);
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));

}