package org.example.leetCodeWithNode;

public class LinkedListCycle141 {
    public static void main(String[] args) {

    }
    public boolean hasCycle(ListNode head){
        ListNode slow=head, fast=head;
        if (head==null||head.next==null) return false;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow= slow.next;
            if (fast==slow) return true;

        }

        return false;
    }
}
