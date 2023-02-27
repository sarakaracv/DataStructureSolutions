package org.example.leetCodeWithNode;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode root;

    int val;

    public TreeNode(int val) {
        this.val = val;

    }

    TreeNode() {
    }

    ;

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }

    void insertNodeSorted(TreeNode x, TreeNode tree) {
        if (x.val < tree.val) {
            if (tree.left == null) {
                tree.left = x;
            } else
                insertNodeSorted(x, tree.left);
        } else {
            if (tree.right == null) {
                tree.right = x;
            } else
                insertNodeSorted(x, tree.right);
        }
    }
    public void insert(TreeNode x) {
        if (root == null) {
            root = x;
            return;
        }
        insertNodeSorted(x, root);
    }
    private TreeNode addRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }

}
