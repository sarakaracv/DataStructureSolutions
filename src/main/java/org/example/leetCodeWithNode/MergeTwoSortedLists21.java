package org.example.leetCodeWithNode;


public class MergeTwoSortedLists21 {
    public static void main(String[] args) {

        ListNode node1= new ListNode();
        node1.add(1);
        node1.add(2);
        node1.add(4);

        ListNode node2= new ListNode();
        node2.add(1);
        node2.add(3);
        node2.add(4);
        node1.printNode();
        node2.printNode();
        System.out.println(mergeTwoLists(node1,node2));
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists2(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists2(l1, l2.next);
        }
        return mergeHead;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) current.next = l2;
        if (l2 == null) current.next = l1;
        return head.next;
    }

    public ListNode mergeTwoLists4(ListNode l1, ListNode l2) {
        if(null == l1) return l2;
        if(null == l2) return l1;
        ListNode head;
        if(l1.val <= l2.val){
            head = new ListNode(l1.val);
            head.next = mergeTwoLists4(l1.next, l2);
        } else {
            head = new ListNode(l2.val);
            head.next = mergeTwoLists4(l1, l2.next);
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        if (list1==null) return list2;
        if (list2==null) return list1;
        if (list1.val<list2.val){ list1.next= mergeTwoLists(list1.next,list2); return list1;}
        else {
            list2.next=mergeTwoLists(list1,list2.next); return list2;
        }
    }

    public ListNode mergeTwoLists5(ListNode list1, ListNode list2) {

        ListNode head1 = list1;
        ListNode head2 = list2;


        ListNode dummyHead = new ListNode(-1);
        ListNode sortedList = dummyHead;

        while (head1 != null && head2 != null) {
            int value1 = head1.val;
            int value2 = head2.val;
            if (value1 > value2) {
                sortedList.next = head2;
                head2 = head2.next;
            } else if (value1 <= value2) {
                sortedList.next = head1;
                head1 = head1.next;
            }
            sortedList = sortedList.next;
        }
        if (head1 == null) {
            sortedList.next = head2;
        } else if (head2 == null) {
            sortedList.next = head1;
        }

        return dummyHead.next;
    }
    }

