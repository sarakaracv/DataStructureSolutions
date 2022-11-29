package org.example.Tasks;

import java.util.LinkedList;

public class IntersectionOfTwoLinkedLists {


    //Given the heads of two singly linked-lists headA and headB, return the node at which the two lists
    //intersect. If the two linked lists have no intersection at all, return null.
    //⮚ For example, the following two linked lists begin to intersect at node c1:
    //a1,a2,b1,b2,b3,c1,c2,c3 intersected c1.
    //⮚ Notes ://▪ There are no cycles anywhere in the entire linked structure.
    //▪ Linked lists must retain their original structure after the function returns.
    //⮚ Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory? (SPICY)

//    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    //a1,a2,c1,c2,c3       b1,b2,b3,c1,c2,c3 intersected c1=8
//    Output: Intersected at 8
//    Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
//    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. There are 2 nodes
//    before the intersected node in A; There are 3 nodes before the intersected node in B.
//- Note that the intersected node's value is not 1 because the nodes with value 1 in A and B (2nd node in A
//    and 3rd node in B) are different node references. In other words, they point to two different locations in
//    memory, while the nodes with value 8 in A and B (3rd node in A and 4th node in B) point to the same
//    location in memory


    public static void main(String[] args) {

IntersectionOfTwoLinkedLists listed= new IntersectionOfTwoLinkedLists();
        LinkedList<Integer> list1= new LinkedList<>();
        list1.add(4);
        list1.add(1);
        list1.add(8);
        list1.add(4);
        list1.add(5);
        LinkedList<Integer> list2= new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(1);
        list2.add(8);
        list2.add(4);
        list2.add(5);




    }


//    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//
//        int c1 = 0;
//        int c2 = 0;
//        for (ListNode n = headA; n != null; n = n.next) {
//            c1++;
//        }
//        for (ListNode n = headB; n != null; n = n.next) {
//            c2++;
//        }
//        int x = Math.abs(c2 - c1);
//        if (c2 >= c1) {
//            for (int i = 0; i < x; i++) {
//                headB = headB.next;
//            }
//        } else {
//            for (int i = 0; i < x; i++) {
//                headA = headA.next;
//            }
//        }
//
//        ListNode l1 = headA;
//        ListNode l2 = headB;
//        while (l1 != null && l2 != null) {
//            if (l1 == l2)
//                return l1;
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return null;
//
//    }

    public static  ListNode getIntersectionNode(ListNode  headA, ListNode headB) {

        int sizeA = length(headA);
        int sizeB = length(headB);

        if (sizeA > sizeB) {
            int diff = sizeA - sizeB;

            for (int i = 1; i <= diff; i++) {
                headA = headA.next;
            }

        } else {

            int diff = sizeB - sizeA;
            for (int i = 1; i <= diff; i++) {
                headB = headB.next;
            }
        }

        return common(headA, headB);

    }

    public static int length(ListNode head) {

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static ListNode common(ListNode head1, ListNode head2) {
        ListNode a = head1, b = head2;

        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;

    }



}


