package org.example.leetCodeWithNode;

import java.util.*;

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
    public ListNode lowestCommonAncestor3(ListNode root, ListNode p, ListNode q) {

        if (root == null || p == null || q == null)
            return null;
        if (isDescendant(p,q))
            return p;
        if (isDescendant(q,p))
            return q;
        // If the p and q are on the different side of a node, then this node is the result
        if ((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val))
            return root;
        // If p and q are both on the left side, search the left subtree
        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor3(root.left, p, q);
        // On the right side, search the right subtree
        if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor3(root.right, p, q);
        return null;
    }

    // To find out is q is a descendant of p
    private boolean isDescendant(ListNode p, ListNode q) {
        if (p == q)
            return true;
        boolean left = false;
        if (p.left != null)
            left = isDescendant(p.left, q);
        boolean right = false;
        if (p.right != null)
            right = isDescendant(p.right, q);
        return left || right;
    }

    public ListNode lowestCommonAncestor4(ListNode root, ListNode p, ListNode q) {
        while(root!=null){
            if(root.val>p.val && root.val>q.val) {root=root.left;}
            else if (root.val<p.val && root.val<q.val) {root=root.right;}
            else return root;
        }
        return root;
    }

    public ListNode lowestCommonAncestor5(ListNode root, ListNode p, ListNode q) {
        if(root==null || root==p || root==q) return root;
        if(p==q) return p;
        if(whetherInSameTree(p,q)) return p;
        if(whetherInSameTree(q,p)) return q;

        ListNode res=null;

        ArrayDeque<ListNode> node=new ArrayDeque<>();
        node.add(root);
        while(node.size()>0)
        {
            ListNode curNode=node.poll();
            if(curNode.left!=null) node.add(curNode.left);
            if(curNode.right!=null) node.add(curNode.right);
            if( whetherInSameTree(curNode,p) && whetherInSameTree(curNode,q) ) res=curNode;
        }

        return res;

    }
    public boolean whetherInSameTree(ListNode father,ListNode child)
    {
        boolean res=false;
        ArrayDeque<ListNode> tree=new ArrayDeque<>();
        tree.add(father);
        while(tree.size()>0)
        {
            ListNode curNode=tree.pollLast();
            if(curNode.left!=null) tree.add(curNode.left);
            if(curNode.right!=null) tree.add(curNode.right);
            if(curNode==child) return true;
        }

        return res;
    }

    public ListNode lowestCommonAncestor6(ListNode root, ListNode p, ListNode q) {
        if(p.val < root.val && q.val < root.val){
            return lowestCommonAncestor6(root.left,p,q);}
        else if(p.val > root.val && q.val > root.val){
            return lowestCommonAncestor6(root.right,p,q);}
        else{
            return root;}
    }

    public ListNode lowestCommonAncestor7(ListNode root, ListNode p, ListNode q) {
        boolean change=true;
        while(change){       //when p and q on the two side of BST (or one is equal to root), exit the loop
            change=false;
            while(p.val<root.val&&q.val<root.val){
                root=root.left;
                change=true;
            }

            while(p.val>root.val&&q.val>root.val){
                root=root.right;
                change=true;
            }
        }


        return root;

    }
    public ListNode lowestCommonAncestor8(ListNode root, ListNode p, ListNode q) {
        HashMap<ListNode,ListNode> Dict = new HashMap<ListNode,ListNode>();
        Stack<ListNode> stk = new Stack<ListNode>();
        stk.push(root);
        Dict.put(root, null);
        while(!Dict.containsKey(p) || !Dict.containsKey(q)){
            ListNode item = stk.pop();
            if(item.left!=null){
                stk.push(item.left);
                Dict.put(item.left,item);
            }
            if(item.right!=null){
                stk.push(item.right);
                Dict.put(item.right, item);
            }
        }
        Set<ListNode> path = new HashSet<ListNode>();
        while(p!=null){
            path.add(p);
            p = Dict.get(p);

        }
        while(!path.contains(q)){
            q = Dict.get(q);
        }
        return q;

    }
    public ListNode lowestCommonAncestor9(ListNode root, ListNode p, ListNode q) {
        if (root == null) return root;
        ListNode current = root;
        while (current != null && current != p && current != q){
            if (current.val <= p.val && current.val <= q.val) {
                current = current.right;
            } else if (current.val >= p.val && current.val >= q.val){
                current = current.left;
            } else {
                break;
            }
        }
        return current;
    }

    public ListNode lowestCommonAncestor10(ListNode root, ListNode p, ListNode q) {
        if (p == root || q == root) return root;
        if (p == q || contains(p, q)) return p;// p is equal or upper level
        if (contains(q, p)) return q;    //q is upper level
        ListNode temp = p;
        while (temp != root) {
            temp = findFather(root, p);
            if (contains(temp, q))
                return temp;
            else
                p = temp;
        }
        return null;
    }
    public boolean contains(ListNode ancestor, ListNode descendant){
//ancestor contains descendant or not
        if(ancestor == null) return false;
        if(ancestor.left == null && ancestor.right == null) return false;
        if(ancestor.left == descendant || ancestor.right == descendant)
            return true;
        else
            return contains(ancestor.left, descendant) || contains(ancestor.right, descendant);
    }
    public ListNode findFather(ListNode root, ListNode son){
//return father node
        if(root == null) return null;
        if(root.left == null && root.right == null) return null;
        if(root.left == son || root.right == son) return root;
        if(findFather(root.left, son)!= null) return findFather(root.left, son);
        if (findFather(root.right,son)!=null) return findFather(root.right,son);
        return null;
    }

    public ListNode lowestCommonAncestor11(ListNode root, ListNode p, ListNode q) {
        while(true) {
            if(root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if(root.val < p.val && root.val < q.val) {
                root = root.right;
            } else return root;
        }
    }

    public ListNode lowestCommonAncestor12(ListNode root, ListNode p, ListNode q) {
        HashSet<ListNode> pAncs = new HashSet<>();
        ListNode curr;

        pAncs.add(root);
        curr = root;

        while(curr.val != p.val){
            curr = (curr.val < p.val) ? curr.right : curr.left;
            pAncs.add(curr);
        }

        curr = root;

        while(curr.val != q.val){
            if(pAncs.contains(curr)) root = curr;
            curr = (curr.val < q.val) ? curr.right : curr.left;
        }

        return pAncs.contains(q) ? q : root;

    }
    public ListNode lowestCommonAncestor13(ListNode root, ListNode p, ListNode q) {
        ListNode left = p.val < q.val ? p : q;
        ListNode right = p.val < q.val ? q : p;
        return lca(root, left, right);
    }

    public ListNode lca(ListNode root, ListNode left, ListNode right) {
        if (right.val < root.val) {
            return lca(root.left, left, right);
        } else if (left.val > root.val) {
            return lca(root.right, left, right);
        } else {
            return root;
        }
    }

}
