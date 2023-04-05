package org.example.leetCodeWithNode;

import java.util.ArrayList;
import java.util.List;

public class OddEvenLinkedList328 {
    public ListNode oddEvenList1(ListNode head) {
        if(head==null) return null;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenHead=even;

        while(even!=null&&even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return head;
    }
    public ListNode oddEvenList2(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode oddHead = head, evenHead = head.next;
        ListNode oddTail = oddHead, evenTail = evenHead;



        while (oddTail.next != null && oddTail.next.next != null) {
            // links them to the next odd and even nodes, respectively
            oddTail.next = oddTail.next.next;
            evenTail.next = evenTail.next.next;
            // moves oddTail and evenTail to the next odd and even nodes
            oddTail = oddTail.next;
            evenTail = evenTail.next;
        }

        oddTail.next = evenHead; // link two lists together

        if (evenTail != null) {
            evenTail.next = null;
        }
        return oddHead;
    }
    public ListNode oddEvenList3(ListNode head) {

        if(head== null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode sec = head.next;
        while(odd.next.next!=null && even.next.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;


        }

        if(odd.next.next==null);
        else if(even.next.next == null){
            odd.next = odd.next.next;
            odd = odd.next;
        }
        odd.next = sec;
        even.next = null;
        System.gc();
        return head;

    }
    public ListNode oddEvenList4(ListNode head) {
        ListNode t = head;
        ListNode other = head;
        Boolean b = true;
        List<Integer> oddList = new ArrayList<Integer>();
        List<Integer>evenList = new ArrayList<Integer>();
        while(t!=null){
            if(b){
                oddList.add(t.val);
            }
            else{
                evenList.add(t.val);
            }
            b=!b;
            t=t.next;
        }
        for(int i=0;i<oddList.size();i++){
            other.val = oddList.get(i);
            other=other.next;
        }
        for(int i=0;i<evenList.size();i++){
            other.val = evenList.get(i);
            other=other.next;
        }
        return head;
    }
}
