package org.example.groupweeks.week31Task;

public class MyTree {

    TreeNode root;
    TreeNode left;
    TreeNode right;
    TreeNode val;


    public MyTree() {

    }

    public MyTree(TreeNode root, TreeNode left, TreeNode right, TreeNode val) {
        this.root = root;
        this.left = left;
        this.right = right;
        this.val = val;
    }

    void insert(int value) {
        TreeNode treeNode = new TreeNode(value);

        if (root == null) {
            root = treeNode;
            return;
        }
        TreeNode current = root;
        while (true) {
            if (value <= current.val) {
                if (current.left == null) {
                    current.left = treeNode;
                    break;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = treeNode;
                    break;
                }
                current = current.right;
            }
        }
    }
}
