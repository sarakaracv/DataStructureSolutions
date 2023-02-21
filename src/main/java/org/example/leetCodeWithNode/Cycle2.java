package org.example.leetCodeWithNode;

import java.util.HashSet;
import java.util.Set;

public class Cycle2 {
    public static void main(String[] args) {


    }
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode slow=head, fast=head;
        while(fast.next!=null&& fast.next.next!=null){
            slow=slow.next;
            fast= fast.next.next;
            if (slow==fast){
                while (head!=slow){
                    head=head.next;
                    slow= slow.next;
                }
                return null;
            }
        }
        return head;
    }
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> nodes= new HashSet<>();
        ListNode current= head;
        while(current!=null){
    if (!nodes.add(current)) return current;
        }
        current=current.next;


        return current;
    }

}
