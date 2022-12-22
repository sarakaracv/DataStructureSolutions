package org.example.leetCodeWithNode;


import java.util.*;

public class MergeKSortedLists23 {
    public static void main(String[] args) {
        List<ListNode> lists = new ArrayList<>();

               int [][] liste= {{1,4,5},{1,3,4},{2,6}};
        System.out.println(mergeKLists(lists));
    }
    public static ListNode mergeKLists(List<ListNode> lists) {
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

}
