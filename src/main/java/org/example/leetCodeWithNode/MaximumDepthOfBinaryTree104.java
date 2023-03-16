package org.example.leetCodeWithNode;

public class MaximumDepthOfBinaryTree104 {
    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root){
        if (root==null) return 0;
        int left=maxDepth(root.left);
        int right= maxDepth(root.right);
        return Math.max(left,right)+1;
    }
    public  int maxDepth1(TreeNode root){
        if (root==null) return 0;
        return 1+Math.max(maxDepth1(root.left),maxDepth1(root.right));

    }
}
