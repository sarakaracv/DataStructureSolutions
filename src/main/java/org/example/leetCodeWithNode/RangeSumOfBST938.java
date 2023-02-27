package org.example.leetCodeWithNode;

public class RangeSumOfBST938 {
    public static void main(String[] args) {
        RangeSumOfBST938 r = new RangeSumOfBST938();
        TreeNode node = new TreeNode();
        node.add(10);
        node.add(5);
        node.add(15);
        node.add(3);
        node.add(7);
        node.add(18);

        System.out.println(r.rangeSumBST(node, 7, 15));

    }

    int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return -1;
        if (root.val <= low) return rangeSumBST(root.right, low, high);
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else {
            rangeSumBST(root.left, low, high);
            rangeSum += root.val;
            rangeSumBST(root.right, low, high);
            return rangeSum;
        }
    }
    int result = 0;
    public int rangeSumBST2(TreeNode root, int low, int high) {
        if(root == null) return -1;

        if(root.val == low || root.val == high || (root.val>low) && (root.val<high)){
            result+=root.val;
        }
        rangeSumBST2(root.left, low, high);
        rangeSumBST2(root.right, low, high);

        return result;
    }

    int res=0;
    public int rangeSumBST3(TreeNode root, int low, int high) {
        if(root == null) return -1;
        if(root.val >=low && root.val<=high) res+= root.val;
        if(root.val>low) rangeSumBST3(root.left, low, high);
        if(root.val<high) rangeSumBST3(root.right, low, high);
        return res;
    }
}
