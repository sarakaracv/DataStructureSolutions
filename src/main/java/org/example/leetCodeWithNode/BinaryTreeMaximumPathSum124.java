package org.example.leetCodeWithNode;

import java.util.ArrayList;

public class BinaryTreeMaximumPathSum124 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum1(TreeNode root) {
        maxPathSumHelper(root);
        return maxSum;
    }

    private int maxPathSumHelper(TreeNode node) {
        if (node == null) return 0;
        int leftSum = Math.max(maxPathSumHelper(node.left), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right), 0);

        int curSum = node.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, curSum);

        return node.val + Math.max(leftSum, rightSum);

    }

    public int maxPathSum2(TreeNode root) {
        int maxval[] = new int[1];
        maxval[0] = Integer.MIN_VALUE;
        solve(root, maxval);
        return maxval[0];
    }

    int solve(TreeNode root, int maxval[]) {
        if (root == null) return 0;
        int leftsum = Math.max(0, solve(root.left, maxval));
        int rightsum = Math.max(0, solve(root.right, maxval));
        maxval[0] = Math.max(maxval[0], leftsum + rightsum + root.val);
        return root.val + Math.max(leftsum, rightsum);

    }
    public int maxPathSum3(TreeNode root) {
        ArrayList<Integer> sums = new ArrayList<>();

        dfs(root, sums);

        int max = -2000;

        for(Integer sum : sums){
            if(sum > max){
                max = sum;
            }
        }

        return max;
    }

    public int dfs(TreeNode node, ArrayList<Integer> sums){
        int leftval = -2000;
        int rightval = -2000;

        if(node.left != null){
            leftval = dfs(node.left, sums);
        }

        if(node.right != null){
            rightval = dfs(node.right, sums);
        }

        int nodeval = Math.max(Math.max(node.val, node.val + leftval), node.val + rightval);

        sums.add(Math.max(nodeval, node.val + leftval + rightval));

        return nodeval;
    }
    private int max = Integer.MIN_VALUE;

    public int maxPathSum4(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root){
        if(root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);
        int sum = left + right + root.val;
        int leftSum = left + root.val;
        int rightSum = right + root.val;

        max = Math.max(max, leftSum);
        max = Math.max(max, rightSum);
        max = Math.max(max, sum);
        max = Math.max(max, root.val);

        System.out.println(max);
        if(leftSum > rightSum && leftSum > root.val) return leftSum;
        else if(rightSum > leftSum && rightSum > root.val) return rightSum;
        else return root.val;
    }
    public int maxPathSum5(TreeNode root) {
        if (root == null) return 0;
        return maxSum(root)[1];
    }

    // [max_path_sum, max_sum]
    private int[] maxSum(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] leftSum = maxSum(root.left);
        int[] rightSum = maxSum(root.right);
        int[] currMaxSum = {root.val, root.val};
        if (root.left != null) {
            currMaxSum[0] = Math.max(currMaxSum[0], root.val + leftSum[0]);
            currMaxSum[1] = Math.max(currMaxSum[1], leftSum[1]);
        }
        if (root.right != null) {
            currMaxSum[0] = Math.max(currMaxSum[0], root.val + rightSum[0]);
            currMaxSum[1] = Math.max(currMaxSum[1], rightSum[1]);
        }
        currMaxSum[1] = Math.max(currMaxSum[1],
                root.val + Math.max(0, leftSum[0]) + Math.max(0, rightSum[0]));
        return currMaxSum;
    }
    private Integer mSum = 0;
    public int maxPathSum6(TreeNode root) {
        mSum = Integer.MIN_VALUE;
        findSum(root);
        return mSum;
    }

    public Integer findSum(TreeNode root){
        if(root == null)
            return 0;

        int lSum = findSum(root.left);
        int rSum = findSum(root.right);
        int pSum = Math.max(lSum + rSum + root.val, root.val);
        mSum = Math.max(mSum, pSum);
        return Math.max(0, root.val + Math.max(lSum, rSum));
    }
}
