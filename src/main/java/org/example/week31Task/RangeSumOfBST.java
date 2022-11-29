package org.example.week31Task;

import java.util.LinkedList;

public class RangeSumOfBST {
    int rangeSum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (root.val < low) return rangeSumBST(root.right, low, high);
        else if (root.val > high) return rangeSumBST(root.left, low, high);
        else {
            rangeSumBST(root.left, low, high);
            rangeSum += root.val;
            rangeSumBST(root.right, low, high);
            return rangeSum;
        }
    }

    int answer = 0;

    public int rangeSumBST5(TreeNode root, int left, int right) {
        if (root == null) return 0;

        if (root.val >= left && root.val <= right) {
            return root.val + rangeSumBST5(root.left, left, right) + rangeSumBST5(root.right, left, right);
        } else if (root.val < right) {
            return rangeSumBST5(root.right, left, right);
        } else if (root.val > left) {
            return rangeSumBST5(root.left, left, right);
        }

        return answer;
    }

    int ans = 0;

    public int rangeSumBST1(TreeNode root, int L, int R) {
        if (root == null) return -1;
        if (root.val >= L && root.val <= R) ans += root.val;
        if (root.val > L) rangeSumBST1(root.left, L, R);
        if (root.val < R) rangeSumBST1(root.right, L, R);
        return ans;
    }

    public int rangeSumBST2(TreeNode root, int low, int high) {
        if (root == null) return 0;
        if (low <= root.val && high >= root.val) {
            return root.val + rangeSumBST2(root.left, low, high) + rangeSumBST2(root.right, low, high);
        } else if (root.val < low) {
            return rangeSumBST2(root.right, low, high);
        } else {
            return rangeSumBST2(root.left, low, high);
        }
    }

    int sum = 0;
    boolean flag = false;

    public int rangeSumBST3(TreeNode root, int low, int high) {
        inorder(root, low, high);
        return sum;
    }

    public void inorder(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        inorder(root.left, low, high);
        if (root.val == low) {
            flag = true;
        }
        if (flag == true) {
            sum += root.val;
        }
        if (root.val == high) {
            flag = false;
        }
        inorder(root.right, low, high);
    }

    public int rangeSumBST4(TreeNode root, int low, int high) {

        if (root == null) return 0;

        if (root.val < low)
            return rangeSumBST4(root.right, low, high);
        if (root.val > high)
            return rangeSumBST4(root.left, low, high);

        return rangeSumBST4(root.left, low, high)
                + rangeSumBST4(root.right, low, high)
                + root.val;
    }
    int ans1=0;
    public int rangeSumBST6(TreeNode root, int low, int high) {
        if(root==null){
            return ans1;
        }
        solve(root,low,high);
        return ans1;
    }
    void solve(TreeNode root, int l, int h){
        if(root==null){
            return ;
        }
        if(root.val>=l && root.val<=h){
            ans1+=root.val;
        }
        solve(root.left,l,h);
        solve(root.right,l,h);
    }
    public int rangeSumBST7(TreeNode root, int low, int high) {
        if(root==null)
            return 0;
        return rangeSumBST7(root.left,low,high)+rangeSumBST7(root.right,low,high)+(root.val>=low&&root.val<=high?root.val:0);
    }
    int sum1 = 0;
    public int rangeSumBST8(TreeNode root, int low, int high) {
        helper(root, low, high);
        return sum1;
    }
    public void helper(TreeNode node, int low, int high) {
        if (node == null) return;
        if (low <= node.val && node.val <= high) {
            sum1 += node.val;
        }
        if (low < node.val) {
            helper(node.left, low, high);
        }
        if (node.val < high) {
            helper(node.right, low, high);
        }
    }

    public int rangeSumBST9(TreeNode root, int low, int high) {
        return helper1(root, low, high, 0);
    }
    private int helper1(TreeNode root, int low, int high, int sum){
        if(root==null)return 0;
        if(root.val<=high&&root.val>=low){
            sum=sum+root.val;

        }
        sum=sum+helper1(root.left,low,high,0);
        sum=sum+helper1(root.right,low,high,0);
        return sum;
    }

    public int rangeSumBSTStack(TreeNode root, int low, int high) {
        if (root == null) return 0;

        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;

        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode cur = stack.removeLast();
            if (cur != null) {
                if (low <= cur.val && cur.val <= high) {
                    sum += cur.val;
                }

                if (low < cur.val) {
                    stack.add(cur.left);
                }

                if (high > cur.val) {
                    stack.add(cur.right);
                }
            }
        }
        return sum;
    }
    int i;
    public int rangeSumBST10(TreeNode root, int low, int high) {
        i = 0;
        helper2(root, low, high);
        return i;
    }

    public void helper2(TreeNode root, int low, int high) {
        if (root != null) {
            if (low <= root.val && root.val <= high) {
                i += root.val;
            }
            if (low < root.val) {
                helper(root.left, low, high);
            }
            if (root.val < high) {
                helper(root.right, low, high);
            }
        }
    }

    public int rangeSumBST11(TreeNode root, int low, int high) {
        if(root==null) return 0;

        int temp;
        if(root.val>=low && root.val<=high) {
            temp=root.val;
        } else {
            temp=0;
        }
        return temp + rangeSumBST11(root.left, low, high) + rangeSumBST11(root.right, low, high);
    }
}


