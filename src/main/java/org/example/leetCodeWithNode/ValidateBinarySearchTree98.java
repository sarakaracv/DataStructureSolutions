package org.example.leetCodeWithNode;

import lombok.experimental.Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidateBinarySearchTree98 {
    public static void main(String[] args) {
        ValidateBinarySearchTree98 v= new ValidateBinarySearchTree98();
        TreeNode node= new TreeNode();
        node.insertTree(node,5);
        node.insertTree(node,8);
        node.insertTree(node,10);
        System.out.println(v.isValidBST(node));

    }

    public boolean isValidBST(TreeNode root){
        if (root==null) return true;
        Stack<TreeNode> stack= new Stack<>();
        TreeNode prev=null;
        while (root!=null||!stack.isEmpty()){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            root=stack.pop();
            if (prev!=null&& root.val<= prev.val) return false;
            prev=root;
            root=root.right;
        }
        return true;

    }

    public boolean isValidBST1(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val >=max || root.val<=min) return false;
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    private List<Integer> in = new ArrayList<>();
    public boolean isValidBST2(TreeNode root) {
        inorder(root);
        for (int i = 0; i < in.size() - 1; i++) {
            if (in.get(i) >= in.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        in.add(root.val);
        inorder(root.right);
    }
    public boolean isValidBST3(TreeNode root) {
        Stack<TreeNode> stack= new Stack<>();
        double leftChildVal= Double.MIN_VALUE;
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
            stack.push(root);
            root=root.left;
            }
        root=stack.pop();
        if (root.val<=leftChildVal)return false;
        leftChildVal=root.val;
        root=root.right;
        }
        return true;
    }
    }

