package org.example.leetCodeTask;

import org.example.groupweeks.Tasks.ListNode;

public class DeleteTheMiddleNodeOfALinkedList2095 {
    public static void main(String[] args) {

    }
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = head;
        if(head == null) return null;
        if(head.next == null) return null;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;

        return head;
    }
}
