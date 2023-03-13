package org.example.leetCodeWithNode;

import org.example.groupweeks.tree.Tree;

import java.util.Arrays;

public class LowestCommonAncestorOfABinaryTree236 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.add(5);
        node.add(1);
        node.add(6);
        node.add(2);
        node.add(0);
        node.add(8);
        node.add(7);
        node.add(4);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(3);
        System.out.println(Arrays.toString(new TreeNode[]{lowestCommonAncestor(node, p, q)}));

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (root == p || root == q) return root;
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
    public static TreeNode lowestCommonAncestor(TreeNode root, int n1,int n2){
        if (root==null) return null;
        if (root.val==n1||root.val==n2) return root;
        TreeNode left=lowestCommonAncestor(root.left,n1,n2);
        TreeNode right=lowestCommonAncestor(root.right,n1,n2);
        if (left!=null&&right!=null)return root;
        if (left==null&& right==null) return null;


        return left!=null?left:right;
    }
}
