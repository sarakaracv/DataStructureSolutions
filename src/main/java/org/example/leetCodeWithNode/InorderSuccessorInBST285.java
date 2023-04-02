package org.example.leetCodeWithNode;

public class InorderSuccessorInBST285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode successor = null;
        while (root != null) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }
}
