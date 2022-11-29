package org.example.leetCodeWithNode;

public class LowestCommonAncestorOfABinarySearchTree235 {
    public static void main(String[] args) {
        int[] keys = { 15, 10, 20, 8, 12, 16, 25 };

        /* Construct the following tree
                  15
                /   \
               /     \
              10     20
             / \     / \
            /   \   /   \
           8    12 16   25
        */

        ListNode root = null;
        for (int key: keys) {
            root = insert(root, key);
        }

        LCA(root, root.left.left, root.left.right);

    }



    public static ListNode insert(ListNode root, int key){
        // if the root is null, create a new node and return it
        if (root == null) {
            return new ListNode(key);
        }

        // if the given key is less than the root node, recur for the left subtree
        if (key < root.val) {
            root.left = insert(root.left, key);
        }
        // if the given key is more than the root node, recur for the right subtree
        else {
            root.right = insert(root.right, key);
        }return root;
    }

    public static boolean search(ListNode root, ListNode key) {
        // traverse the tree and search for the key
        while (root != null)
        {
            // if the given key is less than the current node, go to the left
            // subtree; otherwise, go to the right subtree

            if (key.val < root.val) {
                root = root.left;
            }
            else if (key.val > root.val) {
                root = root.right;
            }
            // if the key is found, return true
            else if (key == root) {
                return true;
            }
            else {
                return false;
            }
        }// we reach here if the key is not present in the BST
        return false;
    }
    // Recursive function to find the lowest common ancestor of given nodes
    // `x` and `y`, where both `x` and `y` are present in the BST
    public static ListNode LCARecursive(ListNode root, ListNode x, ListNode y)
    {
        // base case: empty tree
        if (root == null) {
            return null;
        }

        // if both `x` and `y` is smaller than the root, LCA exists in the
        // left subtree
        if (root.val > Integer.max(x.val, y.val)) {
            return LCARecursive(root.left, x, y);
        }

        // if both `x` and `y` are greater than the root, LCA exists in the
        // right subtree
        else if (root.val < Integer.min(x.val, y.val)) {
            return LCARecursive(root.right, x, y);
        }

        // if one key is greater (or equal) than the root and one key is
        // smaller (or equal) than the root, then the current node is LCA
        return root;
    }

    // Print lowest common ancestor of two nodes in the BST
    public static void LCA(ListNode root, ListNode x, ListNode y)
    {
        // return if the tree is empty or `x` or `y` is not present
        // in the tree
        if (root == null || !search(root, x) || !search(root, y)) {
            return;
        }

        // `lca` stores the lowest common ancestor of `x` and `y`
        ListNode lca = LCARecursive(root, x, y);

        // if the lowest common ancestor exists, print it
        if (lca != null) {
            System.out.println("LCA is " + lca.val);
        }
        else {
            System.out.println("LCA does not exist");
        }
    }


}
