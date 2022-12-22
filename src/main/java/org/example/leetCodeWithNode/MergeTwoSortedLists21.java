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
        System.out.println(mergeTwoLists20(node1,node2));
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

    public static ListNode mergeTwoLists20(ListNode list1, ListNode list2){
        if (list1==null) return list2;
        if (list2==null) return list1;
        if (list1.val<list2.val){ list1.next= mergeTwoLists20(list1.next,list2); return list1;}
        else {
            list2.next=mergeTwoLists20(list1,list2.next); return list2;
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

    public ListNode mergeTwoLists6(ListNode list1, ListNode list2) {
        if (list1==null){
            return list2;
        }
        else if (list2 == null){
            return list1;
        }
        ListNode point3 = new ListNode();
        ListNode list3= point3;

        do {
            if(list1.val <= list2.val){
                point3.next = list1;
                list1=list1.next;
                point3 = point3.next;
            }
            else{
                point3.next = list2;
                list2= list2.next;
                point3 = point3.next;
            }


        } while (list1!= null && list2!=null);

        if(list1==null){
            point3.next = list2;
        }
        else{
            point3.next = list1;
        }

        return list3.next;
    }
    public ListNode mergeTwoLists7(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode tail = null;

        // 1) In a loop, find the shortest of list1 and list2 and append
        // it to tail (adapting tail acordingly). Update head if it is null
        // 2) Advanced which ever one gets chosen and repeat
        while(list2 != null || list1 != null) {
            ListNode smallest = list1;
            if (list2 != null) {
                if (list1 == null || list2.val < list1.val) {
                    smallest = list2;
                }
            }

            if (head == null) {
                head = smallest;
            }

            if (tail == null) {
                tail = smallest;
            } else {
                tail.next = smallest;
                tail = smallest;
            }

            // Move list1 or list2 up
            if (smallest == list1) {
                list1 = smallest.next;
            } else {
                list2 = smallest.next;
            }
        }

        return head;
    }
    public ListNode mergeTwoLists8(ListNode list1, ListNode list2) {
        ListNode dummyHead = new ListNode();
        ListNode tail = dummyHead;

        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }
        tail.next = (list1 != null) ? list1: list2;
        return dummyHead.next;
    }
    public ListNode mergeTwoLists9(ListNode list1, ListNode list2) {
        ListNode list3=new ListNode();
        ListNode head=list3;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                list3.next=list1;
                list1=list1.next;
            }
            else
            {
                list3.next=list2;
                list2=list2.next;
            }
            list3=list3.next;
        }
        if(list1!=null)
            list3.next=list1;
        else
            list3.next=list2;
        return head.next;
    }
    public ListNode mergeTwoLists10(ListNode list1, ListNode list2) {
        ListNode tail = new ListNode();
        ListNode beforeNewList = tail;

        while (list1 != null && list2 != null) {
            int chosenVal;
            if (list1.val <= list2.val) {
                chosenVal = list1.val;
                list1 = list1.next;

            } else {
                chosenVal = list2.val;
                list2 = list2.next;
            }
            tail.next = new ListNode(chosenVal);
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }

        if (list2 != null) {
            tail.next = list2;
        }
        return beforeNewList.next;
    }

    public ListNode mergeTwoLists11(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        //while both lists are not empty
        while (list1!=null && list2!=null){
            //if list 1 has smaller value, add it
            if (list1.val<list2.val){
                tail.next=list1;
                //move to next value in list1
                list1=list1.next;
            }
            else{
                //add list2 value to dummy
                tail.next=list2;
                //move to next value in list2
                list2=list2.next;
            }
            //move to empty space after adding a node to tail
            tail=tail.next;
        }

        //in event that one list is longer than the other
        //add remaining list1 elements to tail
        if (list1 !=null){
            tail.next=list1;
        }
        //add remaining list2 elements to tail
        else if(list2 != null) {
            tail.next=list2;
        }
        //return top value of dummy
        return dummy.next;
    }
    public ListNode mergeTwoLists12(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        //while both lists are not empty
        while (list1!=null && list2!=null){
            //if list 1 has smaller value, add it
            if (list1.val<list2.val){
                tail.next=list1;
                //move to next value in list1
                list1=list1.next;
            }
            else{
                //add list2 value to dummy
                tail.next=list2;
                //move to next value in list2
                list2=list2.next;
            }
            //move to empty space after adding a node to tail
            tail=tail.next;
        }

        //in event that one list is longer than the other
        //add remaining list1 elements to tail
        if (list1 !=null){
            tail.next=list1;
        }
        //add remaining list2 elements to tail
        else if(list2 != null) {
            tail.next=list2;
        }
        //return top value of dummy
        return dummy.next;
    }
    public ListNode mergeTwoLists13(ListNode list1, ListNode list2) {

        ListNode res = new ListNode(0);
        ListNode resTail = res;


        while(true){
            if(list1 == null) {resTail.next = list2; break;}
            if(list2 == null) {resTail.next = list1; break;}

            if(list1.val <= list2.val){
                resTail.next = list1;
                list1 = list1.next;

            }else{
                resTail.next = list2;
                list2 = list2.next;

            }
            resTail = resTail.next;


        }


        return res.next;
    }
    public ListNode mergeTwoLists14(ListNode list1, ListNode list2) {
        ListNode dummy =new ListNode(0);
        ListNode curr= dummy;
        while(list1!= null && list2 != null){
            if(list1.val<= list2.val){
                curr.next = list1;
                list1 = list1.next;
            }
            else{
                curr.next = list2;
                list2= list2.next;
            }
            curr = curr.next;
        }
        if(list1 !=null){
            curr.next = list1;
        }
        else{
            curr.next = list2;
        }
        return dummy.next;
    }
    public ListNode mergeTwoLists15(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null && list2 != null){
            return list2;
        }
        if(list1 != null && list2 == null){
            return list1;
        }
        if(list1.val < list2.val){
            list1.next = mergeTwoLists15(list1.next, list2);
            return list1;
        } else{
            list2.next = mergeTwoLists15(list1, list2.next);
            return list2;
        }

    }

    public ListNode mergeTwoLists16(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;

        while(list1 != null && list2 != null) {
            if(list1.val <= list2.val) {
                current.next = list1;
                current = current.next;
                list1 = list1.next;
            } else {
                current.next = list2;
                current = current.next;
                list2 = list2.next;
            }
        }

        while(list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }

        while(list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return head.next;
    }
    public ListNode mergeTwoLists17(ListNode l1, ListNode l2) {
        ListNode holder = new ListNode(0);
        ListNode r = holder;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                r.next = l1;
                l1 = l1.next;
            } else {
                r.next = l2;
                l2 = l2.next;
            }
            r = r.next;
        }

        if (l1 != null) {
            r.next = l1;
        } else {
            r.next = l2;
        }
        return holder.next;
    }
    public ListNode mergeTwoLists18(ListNode list1, ListNode list2) {
        if (list1 == null)return list2;
        else if (list2 == null)return list1;
        ListNode result;
        ListNode operative;
        if(list1.val >= list2.val) {
            result = list2;
            operative = result;
            list2 = list2.next;
        } else {
            result = list1;
            operative = result;
            list1 = list1.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val >= list2.val) {
                operative.next = list2;
                operative = operative.next;
                list2 = list2.next;
            } else {
                operative.next = list1;
                operative = operative.next;
                list1 = list1.next;
            }
        }
        operative.next = list1 == null ? list2 : list1;
        return result;
    }
}

