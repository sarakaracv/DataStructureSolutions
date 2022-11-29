package org.example.leetCodeWithNode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycleII142 {
    public static void main(String[] args) {

    }

    ListNode fast;
    ListNode slow;

    public ListNode detectCycle1(ListNode head){
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
                return head;
            }
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {  // circle detected
                while (head != fast) {
                    fast = fast.next;
                    head = head.next;
                }
                return head;
            }
        }
        return null; // no circle
    }

    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow = head, fast = head;
        boolean isFinish = false;
        while(!isFinish) {
            if (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                isFinish = true;
                fast = head;
            }
        }
        while(isFinish && fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public ListNode detectCycle4(ListNode head) {

        if(head==null || head.next==null) return null;
        if(head.next.next==null) {
            if(head==head.next.next) return head;
            else return null;
        }

        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null && fast.next !=null ){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow) break;
        }

        if(fast==null || fast.next ==null) return null;
        else{
            ListNode third = head;
            while(third!=slow){
                third = third.next;
                slow = slow.next;
            }
            return third;
        }
    }
    public ListNode detectCycle5(ListNode head) {
        for (ListNode slow = head, fast = head; fast != null && fast.next != null; ) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode finder = head;
                for (;finder != slow; finder = finder.next) slow = slow.next;
                return finder;
            }
        }
        return null;
    }
    public ListNode detectCycle6(ListNode head) {
        ListNode p1=head, p2=p1;
        if(p1==null || p1.next==null) return null;
        for(p1=p1.next, p2=p2.next.next;p1!=p2 &&p1!=null && p2!=null && p2.next!=null;p1=p1.next,p2=p2.next.next);
        if(p1!=p2) return null;
        for(p1=head;p1!=p2;p1=p1.next,p2=p2.next);
        return p1;
    }
    public ListNode detectCycle7(ListNode head) {
        if(head == null || head.next == null) return null;
        Map<ListNode,Integer> prev = new HashMap();
        ListNode pointer = head;
        while(pointer.next != null){
            if(prev.containsKey(pointer)) return pointer;
            else {
                prev.put(pointer,1);
                pointer = pointer.next;
            }
        }
        return null;
    }
    public ListNode detectCycle8(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                // found the cycle
                break;
        }

        if (fast == null || fast.next == null)
            // in case there is no cycle
            return null;

        // let the slow pointer go from the head
        // and meet the fast pointer
        // the meeting point is our answer
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
    public ListNode detectCycle9(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        int length=0;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) {
                ListNode temp=slow;
                do {
                    temp=temp.next;
                    length++;
                } while(temp!=slow);
                break;
            }
        }
        if(length==0) return null;
        ListNode first=head;
        ListNode second=head;
        while(length>0)
        {
            second=second.next;
            length--;
        }

        while(first!=second) {
            first=first.next;
            second=second.next;
        }
        return first;
    }

}
