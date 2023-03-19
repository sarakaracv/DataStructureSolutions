package org.example.leetCodeWithNode;

import java.util.List;

public class IntersectionOfTwoLinkedLists160 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        while (headB!=null){
            ListNode part1= headA;
            while (part1!=null){
                if (part1==headB) return headB;
                part1=part1.next;
            }
            headB=headB.next;
        }
        return null;
    }
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }

        return pointerA;
    }

}
