package org.example.leetCodeWithNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
    public static void main(String[] args) {

    }
    List<Integer> val= new ArrayList<>();
    public List<Integer> inOrderTraversal(TreeNode root){

        if (root!=null) {
            inOrderTraversal(root.left);
            val.add(root.val);
            inOrderTraversal(root.right);
        }
        return val;
    }
}
