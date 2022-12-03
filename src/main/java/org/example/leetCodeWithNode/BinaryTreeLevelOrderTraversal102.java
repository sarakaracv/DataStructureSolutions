package org.example.leetCodeWithNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal102 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> levelOrder(ListNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        Queue<ListNode> q = new LinkedList<>();
        // we have to pop all elements in the queue
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int a = q.size();
            for(int i=0;i<a;i++){
                ListNode m = q.remove();
                list.add(m.val);
                if(m.left!=null)
                    q.add(m.left);
                if(m.right!=null)
                    q.add(m.right);

            }
            sol.add(new ArrayList<>(list));

        }
        return sol;
    }
    public List<List<Integer>> levelOrder1(ListNode root) {
        Queue<ListNode> queue = new LinkedList<ListNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public List<List<Integer>> levelOrder2(ListNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<ListNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> layer = new ArrayList<>();
            while (size > 0) {
                ListNode cur = queue.pollFirst();
                layer.add(cur.val);
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                size--;
            }
            result.add(layer);
        }
        return result;
    }

    public List<List<Integer>> levelOrder3(ListNode root) {
        List<List<Integer>> ll = new ArrayList<>();
        if(root == null)
            return ll;
        traversal(ll, root, 1);
        return ll;
    }
    public void traversal(List<List<Integer>> ll, ListNode node, int depth){
        if(node == null)
            return;
        if(ll.size() == depth - 1) {
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            ll.add(l);
        }
        else if(ll.size() >= depth) {
            List<Integer> li = ll.get(depth - 1);
            li.add(node.val);
        }
        traversal(ll, node.left, depth + 1);
        traversal(ll, node.right, depth + 1);
    }

    public List<List<Integer>> levelOrder4(ListNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        levelOrderHelper(res, root, 0);
        return res;
    }

    public void levelOrderHelper(List<List<Integer>> res, ListNode root, int level) {
        if (root == null)
            return;
        List<Integer> curr;
        if (level >= res.size()) {
            curr = new ArrayList<>();
            curr.add(root.val);
            res.add(curr);
        } else {
            curr = res.get(level);
            curr.add(root.val);
            //res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
        }
        levelOrderHelper(res, root.left, level + 1);
        levelOrderHelper(res, root.right, level + 1);
    }

    public List<List<Integer>> levelOrder5(ListNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<ListNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int levelSize = q.size();
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                ListNode currNode = q.poll();
                currLevel.add(currNode.val);
                if (currNode.left != null)
                    q.add(currNode.left);
                if (currNode.right != null)
                    q.add(currNode.right);
            }
            res.add(currLevel);
        }
        return res;
    }

    public List<List<Integer>> levelOrder6(ListNode root) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, 0, result);
        return result;
    }
    public void helper(ListNode root, int depth, List<List<Integer>> result) {
        if(root == null) return;
        helper(root.left, depth+1, result);
        while(result.size() <= depth) {
            result.add(new ArrayList<>());
        }
        result.get(depth).add(root.val);
        helper(root.right, depth+1, result);
    }

    public List<List<Integer>> levelOrder7(ListNode root) {
        //first create an ArrayList to store integer arrays
        List<List<Integer>> result = new ArrayList<>();
        //corner case
        if(root==null){
            return result;
        }
        //create a FIFO queue to store list of ListNode
        Queue<ListNode> queue = new LinkedList<ListNode>();

        //add the root to queue
        queue.offer(root);
        while(!queue.isEmpty()){
            //create a Integer ArrayList to store the nodes of current level
            ArrayList<Integer> level = new ArrayList<Integer>();
            int size=queue.size();
            //for each node in the current level, add the head to the ArrayList
            for(int i=0; i<size; i++){
                ListNode head = queue.poll();
                level.add(head.val);
                if(head.left!=null){
                    queue.offer (head.left);
                }
                if(head.right!=null){
                    queue.offer(head.right);
                }
            }
            result.add(level); //add the nodes of current level to result
        }
        return result;

    }

    public List<List<Integer>> levelOrder8(ListNode root) {
        List<List<Integer>> result = new ArrayList<>();

        //corner case
        if(root==null){
            return result;
        }

        int maxLevel=0;
        while(true){
            ArrayList<Integer> level= new ArrayList<Integer>();
            dfs(root, level, 0, maxLevel);
            if(level.size()==0){
                break;
            }
            result.add(level);
            maxLevel++;
        }
        return result;

    }

    //idea: starting from current level and stop at max level, and add the node in current level to result
    private void dfs(ListNode root, ArrayList<Integer> level, int curtLevel, int maxLevel){

        //stop when reach maxLevel
        if(root==null || curtLevel>maxLevel){
            return;
        }
        //when only one level (root level)
        if(curtLevel==maxLevel){
            level.add(root.val);
            return;
        }
        dfs(root.left, level, curtLevel+1, maxLevel);
        dfs(root.right, level, curtLevel+1, maxLevel);


    }
    public List<List<Integer>> levelOrder9(ListNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Queue<ListNode> q=new LinkedList<ListNode>();
        if(root==null)
            return res;
        q.offer(root);
        ListNode node;
        int size;

        while(q.peek()!=null){
            List<Integer> subres=new ArrayList<Integer>();
            size=q.size();
            for(int i=0;i<size;i++){
                node=q.poll();
                subres.add(node.val);
                if(node.left!=null)
                    q.offer(node.left);
                if(node.right!=null)
                    q.offer(node.right);
            }
            res.add(subres);
        }
        return res;
    }

    public List<List<Integer>> levelOrder10(ListNode root) {
        List<List<Integer>> mainLs = new ArrayList<>();
        processTree(root,mainLs,0);
        return mainLs;
    }
    public void processTree(ListNode root,List<List<Integer>> mainLs,int level){
        if (root==null){
            return;
        }
        List<Integer> ls;
        if (mainLs.size()==level){
            ls = new ArrayList<Integer>();
            mainLs.add(ls);
        } else{
            ls = mainLs.get(level);
        }
        //System.out.println("adding " + root.val + " at level " + level);
        ls.add(root.val);
        processTree(root.left,mainLs,level+1);
        processTree(root.right,mainLs,level+1);
    }

    public List<List<Integer>> levelOrder11(ListNode root) {
        Queue<ListNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int l = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < l; i++) {
                ListNode node = queue.poll();
                if (node != null) {
                    level.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
            if (!level.isEmpty()) {
                ret.add(level);
            }
        }
        return ret;
    }

    public List<List<Integer>> levelOrder12(ListNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<ListNode> queue = new LinkedList<>();
        if(root != null) queue.offer(root);
        ListNode cur = null;
        while(!queue.isEmpty()){
            List<Integer> elemList = new ArrayList<>();
            int count = queue.size();
            while(count > 0){
                cur = queue.poll();
                elemList.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
                count --;
            }
            list.add(elemList);
        }
        return list;
    }

    public List<List<Integer>> levelOrder13(ListNode root) {
        List<List<Integer>> result = new ArrayList();
        addNode(result,root,0);
        return result;
    }

    public void addNode(List<List<Integer>> result,ListNode node,int i){
        if(node == null) return;
        if(result.size() <= i){
            List<Integer> tmp = new ArrayList();
            tmp.add(node.val);
            result.add(tmp);
        }else{
            result.get(i).add(node.val);
        }
        addNode(result,node.left,i+1);
        addNode(result,node.right,i+1);
    }

    public void levelOrder14(ListNode root,int level,List<List<Integer>> result){
        if(root != null){
            if( result.size() >0 && result.size() > level){
                result.get(level).add(root.val);
            }
            else{
                result.add(new ArrayList<>());
                result.get(level).add(root.val);
            }

            levelOrder14(root.left,level+1,result);
            levelOrder14(root.right,level+1,result);
        }
    }

    HashMap<Integer,List<Integer>> byLevel = new HashMap<Integer,List<Integer>>();
    public List<List<Integer>> levelOrder15(ListNode root) {
        if(root==null) return new ArrayList<List<Integer>>();
        Integer level = 0;
        createList(root,0);
        List<List<Integer>> finalList = new ArrayList<List<Integer>>();
        for(Map.Entry<Integer, List<Integer>> entry : byLevel.entrySet()){
            finalList.add(entry.getValue());
        }
        return finalList;
    }
    private void createList(ListNode root,Integer level){
        if(root==null) return;
        if(byLevel.containsKey(level)){
            byLevel.get(level).add(root.val);
        }
        else{
            List<Integer> l = new ArrayList<Integer>();
            l.add(root.val);
            byLevel.put(level,l);
        }
        if(root.left!=null){
            createList(root.left,level+1);
        }
        if(root.right!=null){
            createList(root.right,level+1);
        }
        if(root.left==null && root.right==null){
            return;
        }
    }

    public List<List<Integer>> levelOrder16(ListNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res,root,0);
        return res;
    }
    public void dfs(List<List<Integer>> list,ListNode node,int deep){
        if(node==null)return;
        if(list.size()==deep)
            list.add(new ArrayList<Integer>());
        list.get(deep).add(node.val);
        dfs(list, node.left, deep+1);
        dfs(list, node.right, deep+1);
    }

    public List<List<Integer>> levelOrder17(ListNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null)
            return res;
        Queue<ListNode> q = new LinkedList<ListNode>();
        q.offer(root);
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                ListNode t = q.poll();
                if (t.left != null)
                    q.offer(t.left);
                if (t.right != null)
                    q.offer(t.right);
                tmp.add(t.val);
            }
            res.add(tmp);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder18(ListNode root) {
        List<List<Integer>> treelist = new ArrayList<List<Integer>>();
        if (root != null) {
            Queue<ListNode> nodelist = new LinkedList<ListNode>();
            nodelist.add(root);
            int count = 1, total = 0;
            List<Integer> level = new ArrayList<Integer>();
            while (!nodelist.isEmpty()) {
                while (count-- > 0) {
                    ListNode node = nodelist.poll();
                    level.add(node.val);
                    if (node.left != null) {
                        nodelist.add(node.left);
                        ++total;
                    }
                    if (node.right != null) {
                        nodelist.add(node.right);
                        ++total;
                    }
                }
                treelist.add(level);
                level = new ArrayList<Integer>();
                count = total;
                total = 0;
            }
        }
        return treelist;
    }
    public List<List<Integer>> levelOrder19(ListNode root) {
        LinkedList<ListNode> currentList = new LinkedList<ListNode>();
        LinkedList<ListNode> nextList = new LinkedList<ListNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        } else {
            nextList.add(root); // notice it's nextList!
            while (!nextList.isEmpty()) {
                // swap current and next
                LinkedList<ListNode> dummy = currentList;
                currentList = nextList;
                nextList = dummy;

                // create a new list for integer
                List<Integer> intRow = new LinkedList<Integer>();
                ListNode curr = null; // iterator

                // add nodes to nextList
                while (!currentList.isEmpty()) {
                    curr = currentList.pollFirst();
                    intRow.add(curr.val);
                    if (curr.left != null) {
                        nextList.add(curr.left);
                    }
                    if (curr.right != null) {
                        nextList.add(curr.right);
                    }
                }
                result.add(intRow);
            }
            return result;
        }

    }
    public static List<List<Integer>> levelOrder20(ListNode root) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<ListNode>queue = new ArrayList<ListNode>();
        if(root==null)return result;
        int k = 2;
        List<Integer> list = new LinkedList<Integer>();
        list.add(root.val);
        queue.add(root.left);
        queue.add(root.right);
        result.add(list);
        while(queue.size()>0){
            List<Integer> list2 = new LinkedList<Integer>();
            int j = k;  k = 0;
            for(int i = 0;i<j;i++){
                if(queue.size()==0)break;
                ListNode node = queue.get(0);queue.remove(0);
                if(node!=null){
                    list2.add(node.val);
                    queue.add(node.left);k++;
                    queue.add(node.right);k++;
                }
            }
            if(list2.size()!=0)result.add(list2);
        }
        return result;
    }
    public List<List<Integer>> levelOrder22(ListNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        ArrayList<ListNode> level = new ArrayList<ListNode>();
        level.add(root);

        while(!level.isEmpty()){
            ArrayList<Integer> values = new ArrayList<Integer>();
            for(int i=0; i<level.size(); i++){
                values.add(level.get(i).val);
            }
            result.add(values);
            ArrayList<ListNode> nextlevel = new ArrayList<ListNode>();
            for(int j=0 ;j<level.size(); j++){
                if(level.get(j).left!=null) nextlevel.add(level.get(j).left);
                if(level.get(j).right!=null) nextlevel.add(level.get(j).right);
            }
            level = nextlevel;
        }
        return result;
    }
    public List<List<Integer>> levelOrder21(ListNode root){
        int top=0;
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> resCell=new ArrayList<Integer>();
        List<ListNode> TreeQ=new ArrayList<>();
        List<ListNode> TempQ=new ArrayList<>();

        if(root==null) return res;
        TreeQ.add(root);


        while(true){
            resCell.clear();
            TempQ.clear();
            while(!TreeQ.isEmpty()){
                ListNode topNode=TreeQ.get(top);
                TreeQ.remove(top);
                if(topNode.left!=null) TempQ.add(topNode.left);
                if(topNode.right!=null) TempQ.add(topNode.right);
                resCell.add(topNode.val);
            }
            res.add(resCell);
            TreeQ=TempQ;
            if(TreeQ.isEmpty())
                break;
        }
        return res;
    }

    public List<List<Integer>> levelOrder23(ListNode root) {
        List<List<Integer>> sol = new ArrayList<>();
        if(root == null){
            return new ArrayList<>();
        }
        Set<Integer> set = new HashSet<>();
        Queue<ListNode> q = new LinkedList<>();
        // we have to pop all elements in the queue
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int a = q.size();
            for(int i=0;i<a;i++){
                ListNode m = q.remove();
                list.add(m.val);
                if(m.left!=null)
                    q.add(m.left);
                if(m.right!=null)
                    q.add(m.right);

            }
            sol.add(new ArrayList<>(list));

        }
        return sol;
    }
    public List<List<Integer>> levelOrder24(ListNode root) {
        Queue<Queue<ListNode>> q = new LinkedList<Queue<ListNode>>();
        Queue<ListNode> level = new LinkedList<ListNode>();
        level.add(root);
        q.add(level);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        if (root == null)
            return list;
        while (!q.isEmpty())
        {
            Queue<ListNode> nextlev = new LinkedList<ListNode>();
            level = q.poll();
            List<Integer> lev = new LinkedList<Integer>();
            while (!level.isEmpty())
            {
                ListNode node = level.poll();
                if (node.left != null)
                    nextlev.add(node.left);
                if (node.right != null)
                    nextlev.add(node.right);
                lev.add(node.val);
            }
            list.add(lev);
            if (!nextlev.isEmpty())
                q.add(nextlev);
        }
        return list;
    }
    List<List<Integer>> list;
    public List<List<Integer>> levelOrder25(ListNode root)
    {

        list = new ArrayList<List<Integer>>();
        helper(root, 0);

        return list;

    }

    private void helper(ListNode node, int level)
    {

        if(node == null)
        {
            return;
        }

        if(list.size() - 1 < level)
        {
            list.add(new ArrayList<Integer>());
        }

        list.get(level).add(node.val);

        helper(node.left, level + 1);
        helper(node.right, level + 1);


    }

}
