package org.example.leetCodeWithNode;

public class MiddleNode {

    //reach middle node
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;

    }

    //delete it
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
