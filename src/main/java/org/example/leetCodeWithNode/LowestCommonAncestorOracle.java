package org.example.leetCodeWithNode;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestorOracle {
    TreeNode root;
    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    // Finds the path from root node to given root of the
    // tree.
    int findLCA(int n1, int n2)
    {
        path1.clear();
        path2.clear();
        return findLCAInternal(root, n1, n2);
    }

    private int findLCAInternal(TreeNode root, int n1, int n2){

        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0)
                    ? "n1 is present"
                    : "n1 is missing");
            System.out.println((path2.size() > 0)
                    ? "n2 is present"
                    : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }
        return path1.get(i - 1);
    }

    // Finds the path from root node to given root of the
    // tree, Stores the path in a vector path[], returns
    // true if path exists otherwise false
    private boolean findPath(TreeNode root, int n,List<Integer> path){
        // base case
        if (root == null) {
            return false;
        }

        // Store this node . The node will be removed if
        // not in path from root to n.
        path.add(root.val);

        if (root.val == n || findPath(root.left, n, path) ||
                findPath(root.right, n, path)) {
            return true;
        }

        // If not present in subtree rooted with root,
        // remove root from path[] and return false
        path.remove(path.size() - 1);

        return false;
    }

    // Driver code
    public static void main(String[] args) {
        LowestCommonAncestorOracle tree = new LowestCommonAncestorOracle();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println("LCA(4, 5) = "
                + tree.findLCA(4, 5));
        System.out.println("LCA(4, 6) = "
                + tree.findLCA(4, 6));
        System.out.println("LCA(3, 4) = "
                + tree.findLCA(3, 4));
        System.out.println("LCA(2, 4) = "
                + tree.findLCA(2, 4));
    }

}
