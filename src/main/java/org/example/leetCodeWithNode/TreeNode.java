package org.example.leetCodeWithNode;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;

    int val;

    public TreeNode(int val){
        this.val=val;

    }
    TreeNode(){};

    public TreeNode(TreeNode left, TreeNode right, int val) {
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
