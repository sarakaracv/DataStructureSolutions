package org.example.groupweeks.week31Task;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        return p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTree2(TreeNode p, TreeNode q) {
        return p == null || q == null
                ? p == q
                : p.val == q.val && isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }

    public static boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p != null && q == null) || (p == null && q != null))
            return false;
        else if (p.val != q.val)
            return false;
        else
            return isSameTree3(p.left, q.left) && isSameTree3(p.right, q.right);
    }

    public boolean isSameTree4(TreeNode p, TreeNode q) {

        //need to check this first in order to avoid NullPointerException
        if (p == null && q == null)
            return true;

        if ((p == null && q != null) || (q == null && p != null))
            return false;

        if (p.val != q.val)
            return false;

        //if all fine so far, recurse
        return (isSameTree4(p.left, q.left) && isSameTree4(p.right, q.right));
    }

    public boolean isSameTree5(TreeNode p, TreeNode q) {
        return (p == null || q == null) ? p == q : (p.val == q.val) && isSameTree5(p.left, q.left) && isSameTree5(p.right, q.right);
    }

    public boolean isSameTree6(TreeNode p, TreeNode q) {
        boolean PNull = p == null;
        boolean QNull = q == null;

        if (PNull && QNull) return true;
        if (PNull == !QNull) return false;

        boolean L = true;
        boolean R = true;

        if (!PNull && !QNull) {
            if (p.val != q.val) return false;
            L = isSameTree6(p.left, q.left);
            R = isSameTree6(p.right, q.right);
        }

        return L && R;
    }
    public boolean isSameTree7(TreeNode p, TreeNode q) {
        if ((p != null) && (q != null) && (p.val == q.val)) return isSameTree7(p.left, q.left) && isSameTree7(p.right, q.right);
        else if ((p == null) && (q == null)) return true;
        else return false;
    }
}
