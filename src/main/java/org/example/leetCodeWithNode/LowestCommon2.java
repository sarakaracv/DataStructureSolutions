package org.example.leetCodeWithNode;

public class LowestCommon2 {
    public static ListNode lowestCommonAncestor1(ListNode root, ListNode p, ListNode q) {
        if (root==null) return null;
        else if (p.val<root.val&&q.val<root.val){
            return lowestCommonAncestor1(root.left,p,q);}
        else if(p.val>root.val&&q.val>root.val){
            return lowestCommonAncestor1(root.right,p,q);}
        else return root;
    }

    public static ListNode lowestCommonAncestor2(ListNode root, ListNode p,ListNode q) {
        int min = p.val, max = q.val;
        if (min > max) {
            min = q.val;
            max = p.val;
        }
        while (true) {
            if (root.val < min)
                root = root.right;
            else if (root.val > max)
                root = root.left;
            else
                return root;
        }
    }

}
