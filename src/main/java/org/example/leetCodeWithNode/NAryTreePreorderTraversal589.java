package org.example.leetCodeWithNode;

import java.util.*;

public class NAryTreePreorderTraversal589 {
    public static void main(String[] args) {

    }

    public List<Integer> preorder1(ListNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Stack<ListNode> toVisit = new Stack<>();
        toVisit.push(root);

        while (!toVisit.isEmpty()) {
            ListNode visited = toVisit.pop();
            result.add(visited.val);
            Collections.reverse(visited.children);
            for (ListNode n : visited.children) {
                if (n != null) {
                    toVisit.push(n);
                }
            }
        }
        return result;
    }
    public List<Integer> preorder2(ListNode root) {
        List<Integer> list = new ArrayList<>();
        return preorder3(root, list);
    }
    public List<Integer> preorder3(ListNode root, List<Integer> list){
        if(root == null) return list;

        list.add(root.val);

        for(int i=0; i<root.children.size(); i++){

            list = preorder3(root.children.get(i), list);
        }
        return list;
    }
    public List<Integer> preorder4(ListNode root) {
        return preOrder5(root, new ArrayList<>());
    }
    private List<Integer> preOrder5(ListNode current, List<Integer> output) {
        if (current == null) return output;
        output.add(current.val);
        for(ListNode child : current.children) {
            preOrder5(child, output);
        }
        return output;
    }
    public List<Integer> preorder6(ListNode root) {
        if (root == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.add(root.val);
        for (ListNode node : root.children) {
            res.addAll(preorder6(node));
        }
        return res;
    }
    public List<Integer> preorder7(ListNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }
    public void helper(ListNode root, List<Integer> list){
        if(root == null) return ;
        list.add(root.val);
        if(root.children == null) return;
        for(ListNode child : root.children){
            helper(child,list);
        }
    }

    public List<Integer> preorder8(ListNode root) {
        List<Integer> toReturn = new ArrayList<>();
        if(root==null)
            return toReturn;
        if(root.children==null)
        {
            toReturn.add(root.val);
            return toReturn;
        }
        Stack<ListNode> stack=new Stack<>();
        stack.push(root);
        while(stack.size()!=0) {
            ListNode pop=stack.pop();
            toReturn.add(pop.val);
            //    System.out.println(pop.val);
            Stack<ListNode> newstack= new Stack<>();
            for(ListNode m : pop.children)
            {
                newstack.push(m);
            }
            while(newstack.size()!=0)
            {
                stack.push(newstack.pop());
            }
        }
        return toReturn;
    }

    public List<Integer> preorder9(ListNode root) {
        Stack<ListNode> stk = new Stack<ListNode>();
        List<Integer> preorder = new LinkedList<Integer>();
        stk.push(root);

        if(root == null) {
            return preorder;
        }

        while(!stk.isEmpty()) {
            ListNode curr = stk.pop();
            preorder.add(curr.val);
            for(int i = curr.children.size() - 1; i >= 0; i--) {
                stk.push(curr.children.get(i));
            }
        }
        return preorder;
    }
    public List<Integer> preorder10(ListNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null)  return list;
        Stack<ListNode> visit =new Stack<>();
        visit.push(root);
        while (!visit.isEmpty())
        {
            ListNode visited=visit.pop();
            list.add(visited.val);
            Collections.reverse(visited.children);
            for(ListNode n :visited.children)
                if(n!=null)  visit.push(n);
        }
        return list;
    }

    public List<Integer> preorder11(ListNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;
        Stack<ListNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.empty()){
            ListNode node = stack.pop();
            ans.add(node.val);
            for(int i = node.children.size()-1;i>=0;i--){
                if(node.children.get(i) != null)stack.push(node.children.get(i));
            }
        }
        return ans;
    }
    List<Integer> res = new ArrayList<>();
    public List<Integer> preorder12(ListNode root) {
        if(root == null){
            return res;
        }
        res.add(root.val);
        for(ListNode n: root.children){
            preorder12(n);
        }
        return res;
    }
    public List<Integer> preorder13(ListNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<ListNode> s = new Stack<>();
        s.push(root);
        ListNode t = null;
        while(!s.isEmpty()){
            t = s.pop();
            res.add(t.val);
            int i = t.children.size();
            while(i-->0){
                s.push(t.children.get(i));
            }
        }
        return res;
    }
    public List<Integer> preorder14(ListNode root) {
        List<Integer> array = new ArrayList();
        preorder15(root, array);
        return array;
    }

    private void preorder15(ListNode root, List<Integer> array){
        if(root != null){
            array.add(root.val);
            for(ListNode i : root.children)
                preorder15(i, array);
        }
    }

    public List<Integer> preorder16(ListNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        util(root, list);
        return list;
    }
    private void util(ListNode root,  List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.val);
        for(ListNode node : root.children){
            util(node, list);
        }
    }

    public List<Integer> preorder17(ListNode root) {
        Stack<ListNode> q=new Stack<ListNode>();
        q.add(root);
        List<Integer> result=new ArrayList<>();
        if(root==null)
            return result;
        while(!q.isEmpty()) {
            ListNode p=q.pop();
            result.add(p.val);
            if(p.children!=null)
            {
                Collections.reverse(p.children);
                q.addAll(p.children);
            }
        }
        return result;
    }
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder18(ListNode root)
    {
        order(root);
        return list;
    }
    public void order(ListNode root)    {
        if(root==null)
            return ;

        list.add(root.val);
        for(ListNode i:root.children)
        {
            preorder18(i);
        }
    }

    public List<Integer> preorder19(ListNode root) {
        List<Integer> res = new ArrayList<>();
        recersive(root, res);
        return res;
    }
    private void recersive(ListNode root, List<Integer> list) {
        if(null == root){
            return;
        }
        list.add(root.val);
        if(root.children != null && root.children.size() != 0) {
            for(ListNode child : root.children) {
                recersive(child, list);
            }
        }
    }
    public List<Integer> preorder20(ListNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        preorder21(root, result);
        return result;
    }

    private void preorder21(ListNode root, List<Integer> list){
        list.add(root.val);

        for(ListNode node: root.children){
            preorder21(node, list);
        }
    }
    List<Integer> listpre = new ArrayList<>();
    public List<Integer> preorder22(ListNode root) {
        if(root==null){
            return listpre;
        }
        int size = root.children.size();
        listpre.add(root.val);
        for(int i=0;i<size;i++){

            preorder22(root.children.get(i));
        }
        return listpre;
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder23(ListNode root) {
        if (root == null) return ans;
        ans.add(root.val);
        for (ListNode child : root.children)
            preorder23(child);
        return ans;
    }

    private final List<Integer> result1 = new ArrayList<>();

    public List<Integer> preorder24(ListNode root) {
        traverse(root);
        return result1;
    }

    private void traverse(ListNode node) {
        if (node == null) {
            return;
        }
        result1.add(node.val);

        for (ListNode child : node.children) {
            traverse(child);
        }
    }


}
