package org.example.groupweeks.week30;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
       TreeNode node= new TreeNode();
       node.val=5;
       node.right.val=7;
       node.left.val=3;
       node.left.left.val=1;
       node.right.right.val=9;
        System.out.println(inorderTraversal(node));





    }

    void inOrderTraversal(TreeNode root){
        if (root==null) return; // termination
        inOrderTraversal(root.left);
        System.out.print(root.val+", ");
        inOrderTraversal(root.right);
    }

    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }
    public List<Integer> inorderTraversal3(TreeNode root){
        List<Integer> toRet = new ArrayList<Integer>();
        TreeNode start = new TreeNode(0);
        start.right = root;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(start);
        while(s.size() > 0)
        {
            TreeNode curr = s.pop();
            toRet.add(curr.val);
            curr = curr.right;
            while(curr != null)
            {
                s.push(curr);
                curr = curr.left;
            }
        }
        toRet.remove(0);
        return toRet;
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root == null){
            return result;
        }else{
            inorder(root.left,result);
            result.add(root.val);
            inorder(root.right,result);
        }
        return result;
    }
    public static void inorder(TreeNode node,List<Integer> list){
        if(node==null){return;}
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right, list);

    }
}
