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

}
