package org.example.leetCodeWithNode;

import java.util.Stack;

public class KthSmallestElementInABST230 {

        public int kthSmallest1(TreeNode root, int k) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode curr = root;
            while (curr != null || !stack.isEmpty()) {
                while (curr != null) {
                    stack.push(curr);
                    curr = curr.left;
                }
                curr = stack.pop();
                if (--k == 0) {
                    return curr.val;
                }
                curr = curr.right;
            }
            return -1; // Not found
        }

    int count;

    public int kthSmallest3(TreeNode root, int k) {
        this.count = k;
        return kthSmallest2(root);
    }

    public int kthSmallest2(TreeNode root) {
        if (root == null) return -1;

        // go all the way left first, since we're looking for the k-th kthSmallest
        int result = kthSmallest2(root.left);
        if (result != -1) return result;

        // on the way up, decrement count
        count --;

        if (count == 0) return root.val;

        // if we couldn't find it in the left subtree, go right
        return kthSmallest2(root.right);
    }
    public int kthSmallest4(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();

        while (root != null) {
            st.push(root);
            root = root.left;
        }

        while (k != 0) {
            TreeNode n = st.pop();
            k--;
            if (k == 0) return n.val;
            TreeNode right = n.right;
            while (right != null) {
                st.push(right);
                right = right.left;
            }
        }

        return -1; // never hit if k is valid
    }
    public int kthSmallest5(TreeNode root, int k) {
        int[] res = helper(root, k, 0);
        return res[0];
    }

    public int[] helper(TreeNode node, int k, int curr) {
        int[] ans = new int[] {0, curr};
        if(node == null) return ans;

        ans = helper(node.left, k, curr);

        if(ans[1] == k) return ans;

        ans[0] = node.val;
        ++ans[1];

        if(ans[1] == k) return ans;

        ans = helper(node.right, k, ans[1]);

        return ans;
    }

    int K = -1;
    int small = Integer.MIN_VALUE;
    public int kthSmallest6(TreeNode root, int k) {
        K = k;
        inOrder(root);
        return small;
    }
    public void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);
        K--;
        if(K==0){
            small = root.val;

        }
        inOrder(root.right);
    }
 }
