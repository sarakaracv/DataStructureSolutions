package org.example.leetCodeWithNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal105 {
    public static void main(String[] args) {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int i=0,j=0;
        TreeNode root = new TreeNode(preorder[i]);
        int n=preorder.length;
        if (n==0) return null;
        if (n==1) return new TreeNode(preorder[0]);
        while (j<n&&inorder[j]!=preorder[i]) j++;
        root.left=buildTree(Arrays.copyOfRange(preorder,1,j+i+1),Arrays.copyOfRange(inorder,0,j));
        root.right=buildTree(Arrays.copyOfRange(preorder,j+i+1,n),Arrays.copyOfRange(inorder,j+1,n));

        return root;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, map, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> map, int index, int left, int right) {
        int value = preorder[index];
        int mid = map.get(value);
        TreeNode root = new TreeNode(value);
        if (mid > left) {
            root.left = buildTree(preorder, map, index + 1, left, mid - 1);
        }
        if (mid < right) {
            root.right = buildTree(preorder, map, index + mid - left + 1, mid + 1, right);
        }
        return root;
    }


//root node -> preorder[i]
//root.left -> left elements in inorder of root
//root.right -> right of elements in

    public static int index= -1;

    public TreeNode BuildTreeFun(int[] preorder, int[] inorder, int si, int ei){

        if(si > ei)
            return null;

        // get data from first index of preOrder
        // because : PreOrder -> root left right
        int data = preorder[index];
        index++;

        // Make node from data integer
        TreeNode root = new TreeNode(data);

        // Find data in inOrder Array
        int k = -1;
        for(int i = si; i <= ei; i++){
            if(data == inorder[i]){
                k=i;
                break;
            }
        }
        // first call in this question is left call
        // because : PreOrder -> root left right
        root.left = BuildTreeFun(preorder,inorder,si,k-1);
        root.right = BuildTreeFun(preorder,inorder,k+1,ei);


        return root;

    }

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null;

        index = 0;

        return BuildTreeFun(preorder, inorder, 0, preorder.length-1);
    }
    HashMap<Integer,Integer> map;
    public TreeNode buildTree4(int[] preorder, int[] inorder)
    {
        map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        return helper(preorder,inorder,0,preorder.length-1,0);
    }
    TreeNode helper(int[] preorder, int[] inorder,int begin, int end, int index )
    {
        TreeNode root=new TreeNode(preorder[index]);
        int temp=map.get(preorder[index]);
        int diff=temp-begin;
        if(diff>0)
            root.left=helper(preorder, inorder, begin, temp-1, index+1);
        if(temp+1<=end)
            root.right=helper(preorder, inorder, temp+1, end, index+diff+1);
        return root;
    }
    public TreeNode buildTree5(int[] preorder, int[] inorder) {
        return buildTreeNode(0, 0, inorder.length-1, preorder, inorder);
    }
    private TreeNode buildTreeNode(int preOrderPos, int inorderLeft, int inorderRight, int[] preorder, int[] inorder) {
        if (preOrderPos > preorder.length || inorderLeft > inorderRight) return null;
        var node = new TreeNode(preorder[preOrderPos]);
        var nodeAtInorderPos = 0;
        for (var i=0; i<=inorderRight; i++) {
            if (inorder[i] == node.val) nodeAtInorderPos = i;
        }

        node.left = buildTreeNode(preOrderPos+1,inorderLeft,nodeAtInorderPos-1,
                preorder, inorder);
        node.right = buildTreeNode(preOrderPos + nodeAtInorderPos - inorderLeft + 1,
                nodeAtInorderPos + 1, inorderRight,preorder, inorder);
        return node;
    }

}