package org.example.leetCodeWithNode;


import java.util.*;

public class MergeKSortedLists23 {
    public static void main(String[] args) {

    }

    public static ListNode mergeKLists1(List<ListNode> lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
             public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
    public ListNode mergeKLists2(ListNode[] lists) {

        if(lists == null || lists.length == 0) return null;
        ListNode newNode = new ListNode(Integer.MIN_VALUE);
        ListNode curr = newNode;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(ListNode list: lists){
            if(list!= null){
                pq.add(list); //this built the min Heap with the head of the lists
            }
        }
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            if(min != null){
                curr.next = min;
                if(min.next != null){
                    pq.add(min.next);
                }
                curr = curr.next;
            }
        }

        return newNode.next;

    }
    public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            } else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;
        }
        if(list1 != null) curr.next = list1;
        if(list2 != null) curr.next = list2;
        return head.next;
    }
    public ListNode mergeKListsHelper(ListNode[] lists, int s, int e) {
        if(s == e) return lists[s];
        int mid = s + (e-s)/2;
        ListNode l1 = mergeKListsHelper(lists, s, mid);
        ListNode l2 = mergeKListsHelper(lists, mid+1, e);
        return mergeTwoLists3(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeKListsHelper(lists, 0, lists.length-1);
    }
    public ListNode mergeKLists4(ListNode[] lists) {
        ListNode root = null;
        Comparator<ListNode> comp =  (ListNode l1, ListNode l2) -> l1.val - l2.val;
        PriorityQueue<ListNode> headNodeQueue = new PriorityQueue(comp);
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] == null) {
                continue;
            }
            headNodeQueue.add(lists[i]);
        }
        ListNode prevNode = null;
        while (!headNodeQueue.isEmpty()) {
            ListNode peek = headNodeQueue.poll();
            if (prevNode == null) {
                prevNode = new ListNode(peek.val);
                root = prevNode;
            } else {
                prevNode.next = new ListNode(peek.val);
                prevNode = prevNode.next;
            }
            if (peek.next != null) {
                headNodeQueue.add(peek.next);
            }
        }
        return root;
    }
    public ListNode mergeKLists5(ListNode[] lists) {

        //Input: lists = [[1,4,5],[1,3,4],[2,6]]
        //Output: [1,1,2,3,4,4,5,6]

        List<Integer> list = new ArrayList<>();

        int idx = 0;
        while(idx < lists.length){
            ListNode node = lists[idx];
            while(node != null){
                list.add(node.val);
                node = node.next;
            }
            idx++;
        }
        Collections.sort(list);
        return buildList(list,0);
    }

    public ListNode buildList(List<Integer> list, int idx){
        if(idx == list.size()) return null;
        ListNode newNode = new ListNode(list.get(idx));
        if(idx < list.size()){
            newNode.next = buildList(list, idx + 1);
        }
        return newNode;
    }
    public ListNode mergeKLists6(ListNode[] lists) {

        // keep the value of each element in arraylist
        // sort the arraylist
        // form a linked list from the sorted arraylist
        // return the linkedlist

        ArrayList<Integer> list = new ArrayList<>();
        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        for (ListNode head2 : lists) {
            while (head2 != null) {
                list.add(head2.val);
                head2 = head2.next;
            }
        }

        Collections.sort(list);

        for (int value : list) {
            head.next = new ListNode(value);
            head = head.next;
        }

        return dummy.next;
    }
    public ListNode mergeKLists7(ListNode[] lists) {
        List<Integer> l = new ArrayList<>();

        for(ListNode ln : lists){
            // System.out.println(ln);
            while(ln != null){
                // System.out.println(ln);
                l.add(ln.val);
                ln = ln.next;
            }
        }

        Collections.sort(l);
        // System.out.println(l);

        ListNode head = new ListNode(0);
        ListNode h = head;
        for (int i : l) {
            ListNode t = new ListNode(i);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }
    public ListNode mergeKLists8(ListNode[] lists) {
        ListNode pre = new ListNode(0);
        ListNode head = pre;
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < lists.length; i++){
            ListNode node = lists[i];
            while(node != null){
                numbers.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(numbers);
        for (Integer value : numbers) {
            pre.next = new ListNode(value);
            pre = pre.next;
        }
        return head.next;
    }
    public ListNode mergeKLists9(ListNode[] arr) {

        PriorityQueue< ListNode > pq = new PriorityQueue<>(((o1,o2) -> {
            if( o1.val > o2.val ){
                return 1 ;
            }
            else if( o1.val == o2.val ){
                return 0 ;
            }
            return -1 ;
        })) ;

        int len = arr.length ;

        for( int i = 0 ; i < len ; i++ ){
            if( arr[i] != null ){
                pq.offer( arr[i] ) ;
            }
        }
        ListNode dummy = new ListNode() ;
        ListNode curr = dummy ;

        while( !pq.isEmpty() ){
            ListNode node = pq.poll() ;

            if( node.next != null ){
                pq.offer( node.next ) ;
            }

            curr.next = node ;
            curr = node ;
            System.out.println(curr.val) ;
        }

        curr.next = null ;

        return dummy.next ;

    }
    public ListNode mergeKLists10(ListNode[] lists) {
        PriorityQueue<Integer> h=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++)
        {
            while(lists[i]!=null)
            {
                h.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        ListNode head=null;
        ListNode newNode=null;
        while(!h.isEmpty())
        {
            System.out.print(h.peek()+" ");
            ListNode s=new ListNode(h.poll());
            // s.next=null;
            if(head==null)
            {
                head=s;
                newNode=head;
            }
            else
            {
                newNode.next=s;
                newNode=newNode.next;
            }
        }
        return head;
    }
    public ListNode mergeKLists11(ListNode[] lists) {
        if (lists == null || lists.length == 0) {return null;}
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val == l2.val) {return 0;}
                else if (l1.val < l2.val) {return -1;}
                else {return 1;}
            }
        });
        for (ListNode node : lists ) {
            ListNode currentNode = node;
            while (currentNode != null) {
                System.out.println(currentNode.val);
                queue.add(currentNode);
                currentNode = currentNode.next;
            }
        }

        System.out.println("Second part");
        ListNode answer = queue.poll();
        ListNode currentNode = answer;
        ListNode next = answer;
        while (!queue.isEmpty()) {
            System.out.println(currentNode.val);
            next = queue.poll();
            currentNode.next = next;
            currentNode = currentNode.next;
        }
        if (next != null) {next.next = null;}

        return answer;
    }
    public ListNode mergeKLists12(ListNode[] lists) {
        PriorityQueue<Integer> h=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++)
        {
            while(lists[i]!=null)
            {
                h.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        ListNode head=null;
        ListNode newNode=null;
        while(!h.isEmpty())
        {
            System.out.print(h.peek()+" ");
            ListNode s=new ListNode(h.poll());
            // s.next=null;
            if(head==null)
            {
                head=s;
                newNode=head;
            }
            else
            {
                while(newNode.next!=null)
                {
                    newNode=newNode.next;
                }
                newNode.next=s;
            }
        }
        return head;
    }
    public ListNode mergeKLists13(ListNode[] lists) {
        PriorityQueue<Integer> h=new PriorityQueue<>();
        for(int i=0;i<lists.length;i++)
        {
            while(lists[i]!=null)
            {
                h.add(lists[i].val);
                lists[i]=lists[i].next;
            }
        }
        ListNode head=null;
        ListNode newNode=null;
        while(!h.isEmpty())
        {
            System.out.print(h.peek()+" ");
            ListNode s=new ListNode(h.poll());
            s.next=null;
            if(head==null)
            {
                head=s;
                newNode=head;
            }
            else
            {
                while(newNode.next!=null)
                {
                    newNode=newNode.next;
                }
                newNode.next=s;
            }
        }
        return head;
    }
    private Map<Integer, List<ListNode>> nodeMap = new HashMap<>();
    public List<ListNode> minNodes = new ArrayList<>();

    public ListNode mergeKLists14(ListNode[] lists) {
        ListNode head = null;
        if (lists.length == 0) return null;
        for(int i=0; i<lists.length; i++) {
            if(lists[i]!=null) {
                addToNodeMap(lists[i]);
            }
        }
        if(nodeMap.isEmpty()) return head;
        else return merge(head);
    }

    private void addToNodeMap(ListNode node) {
        if(!nodeMap.containsKey(node.val))
            nodeMap.put(node.val, new ArrayList<ListNode>());
        nodeMap.get(node.val).add(node);
    }

    private ListNode getMinNode() {
        if(minNodes.isEmpty() || minNodes.size()==0) {
            int min = nodeMap.keySet().stream().min(Integer::compare).get();
            minNodes = nodeMap.get(min);
            nodeMap.remove(min);
        }
        ListNode min = minNodes.get(0);
        minNodes.remove(0);
        ListNode temp = min.next;
        if(temp!=null) {
            if(temp.val == min.val) minNodes.add(temp);
            else addToNodeMap(temp);
        }
        return min;
    }

    private ListNode merge(ListNode head) {
        if(head==null) head = getMinNode();
        if(nodeMap.isEmpty() && minNodes.isEmpty()) return head;
        head.next = merge(getMinNode());
        return head;
    }
    public ListNode mergeKLists15(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        Comparator<ListNode> compareNode = Comparator.comparing(ListNode -> ListNode.val);
        Queue<ListNode> pq = new PriorityQueue<>(lists.length, compareNode);
        for (ListNode l: lists){
            if (l != null){
                pq.add(l);
            }
        }
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        while (!pq.isEmpty()){
            ListNode node = pq.poll();
            dummy.next = node;
            dummy = dummy.next;
            if (node.next != null){
                pq.add(node.next);
            }
        }
        return ans.next;
    }
    private Comparator<ListNode> compareVal() {
        return Comparator.comparing(ln -> ln.val);
    }
    public ListNode mergeKLists16(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode dup = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(compareVal());
        for (ListNode ln : lists) {
            if (ln != null) {
                pq.add(ln);
            }
        }
        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            dup.next = node;
            dup = dup.next;
            if (node.next != null) {
                pq.add(node.next);
            }
        }
        return dummy.next;
    }
    public ListNode mergeKLists17(ListNode[] lists) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (ListNode list : lists) {

            if (list == null) continue;

            ListNode tmp = list;
            while (tmp != null) {

                int val = tmp.val;

                int freq = map.getOrDefault(val, 0);
                map.put(val, freq + 1);

                tmp = tmp.next;
            }
        }

        ListNode head = null;
        ListNode last = null;

        int mapSize = map.size();
        for (int i = 0; i < mapSize; i++) {

            int freq = (int) map.firstEntry().getValue();

            while (freq > 0) {

                ListNode node = new ListNode();
                node.val = (int) map.firstEntry().getKey();

                if (head == null && last == null) {

                    head = last = node;
                } else {

                    last.next = node;
                    last = node;
                }

                freq--;
            }
            map.remove(map.firstEntry().getKey());
        }

        return head;

    }
    public ListNode mergeKLists18(ListNode[] arr) {

        PriorityQueue< ListNode > pq = new PriorityQueue<>(((o1,o2) -> {
            if( o1.val > o2.val ){
                return 1 ;
            }
            else if( o1.val == o2.val ){
                return 0 ;
            }
            return -1 ;
        })) ;

        int len = arr.length ;

        for( int i = 0 ; i < len ; i++ ){
            if( arr[i] != null ){
                pq.offer( arr[i] ) ;
            }
        }
        ListNode dummy = new ListNode() ;
        ListNode curr = dummy ;

        while( !pq.isEmpty() ){
            ListNode node = pq.poll() ;

            if( node.next != null ){
                pq.offer( node.next ) ;
            }

            curr.next = node ;
            curr = node ;
            System.out.println(curr.val) ;
        }

        curr.next = null ;

        return dummy.next ;

    }
}
