package org.example.week30;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfNodeDepths {
    public static void main(String[] args) {
         SumOfNodeDepths.deepestLeavesSum3(new TreeNode());
        System.out.println();
    }


    public int deepestLeavesSum1(TreeNode root) {
        int max=maxSize1(root);
        int sum=0;
        sumAll1(root,max,1);
        return sum;

    }
    public int maxSize1(TreeNode root){
        if (root==null)
            return 0;
        else
            return Math.max(maxSize1(root.left),maxSize1(root.right))+1;
    }
    public void sumAll1(TreeNode root, int max,int level){
        int sum=0;
        if(root==null)
            return;
        if(level==max)
            sum+=root.val;

        level++;
        sumAll1(root.left,max,level);
        sumAll1(root.right,max,level);
    }




    int l = 0, sum = 0;
    public int deepestLeavesSum2(TreeNode root) {
        helper2(root, 1);
        return sum;
    }
    void helper2(TreeNode n, int lev) {
        if (n == null)
            return;
        //if this is leaf and it's deeper than the current deepest
        if (n.left == null && n.right == null && lev >= l) {
            //new deepest, start over with the sum
            if (lev > l ) {
                sum = n.val;
                l = lev;
            }
            //same as current deepest - accumulate this node value
            else
                sum += n.val;
        }
        helper2(n.left, lev + 1);
        helper2(n.right, lev + 1);
    }

    public static int deepestLeavesSum3(TreeNode root) {
        if(root==null)return 0;
        int curSum=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            curSum=0;
            for(int i=0;i<queue.size();i++){
                TreeNode node=queue.remove();
                curSum+=node.val;
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }
        }

        return curSum;

    }

}
