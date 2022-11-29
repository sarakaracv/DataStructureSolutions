package org.example.week31Task;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
   // TreeNode root;
   TreeNode(int val){
       this.val=val;
   }

    public TreeNode( TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }
}
