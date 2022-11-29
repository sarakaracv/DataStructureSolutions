package org.example.leetCodeWithNode;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MiddleOfTheLinkedList876 {
    public static void main(String[] args) {
        ListNode node= new ListNode();
        node.add(1);
        node.add(3);
        node.add(4);


      //  System.out.println(middleNode7(node.printNode()));


    }

    public ListNode middleNode1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (true) {
            if (fast.next == null || fast.next.next == null) {
                return slow.next;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

    }
    public ListNode middleNode2(ListNode head) {
        if(head.next==null){
            return head;
        }
        ListNode prev = head, curr = head.next;
        while(curr.next!=null){
            prev = prev.next;
            curr = curr.next.next;
            if(curr==null){
                break;
            }
        }
        if(curr!=null){
            prev = prev.next;
        }
        return prev;
    }

    public ListNode middleNode3(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode middleNode4(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head;

        while (p != null && q != null) {
            p = p.next;
            q = q.next != null? q.next.next: null;

            if (q != null && q.next == null) {
                return p;
            }
        }

        return p;
    }
    public ListNode middleNode5(ListNode head) {

        int length = 0;
        ListNode temp = head;

        while(temp !=  null)
        {
            length ++;
            temp = temp.next;
        }


        length = length/2;

        temp = head;
        while(length > 0)
        {
            temp = temp.next;
            length --;
        }

        return temp;

    }
    public ListNode middleNode6(ListNode head) {
        ListNode curr = head;

        int total = 0;
        while(curr != null){
            total++;
            curr = curr.next;
        }

        //find the middle one
        total = total/2 + 1;

        ListNode cur = head;
        for(int i = 1; i < total; ++i){
            cur = cur.next;
        }

        return cur;
    }
    public static ListNode middleNode7(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode middleNode8(ListNode head) {
        int count =0;
        int middleValue=0;
        ListNode current = head;
        //First I calculated the length of the LinkedList
        while(current!=null){
            count++;
            current=current.next;
        }
        current=head;
        //System.out.print("Lenght is:"+count);

        // If the length is odd
        if(count%2!=0){
            middleValue = (count+1)/2;
            count=0;
            while(current!=null && count<middleValue-1){
                current=current.next;
                count++;
            }

        }
        // If the length is even.
        else{
            middleValue = ((count)/2)+1;
            count=0;
            while(current!=null && count<middleValue-1){
                current=current.next;
                count++;
            }
        }
        return current;
    }
    public ListNode middleNode9(ListNode head) {

        ListNode current = head;

        int size = 0;

        // calculate the size of Linked List by a while loop
        while(current != null){
            current = current.next;
            size++;
        }

        int pos = 0;

        // assign temporary variable to iterate
        ListNode temp = head;

        // set boundaries for the loop by dividing by 2
        for(temp = head; pos < size/2; pos++){
            temp = temp.next;
        }

        return temp;
    }
    public ListNode middleNode10(ListNode head) {
        if(head==null){
            return head;
        }
        int nodeCount = 0;
        ListNode temp = head;

        // count the total number of nodes
        while(head!=null){
            head = head.next;
            nodeCount++;
        }
        int i=0;

        // extract the middle node
        while(i!=(nodeCount/2)){
            temp = temp.next;
            i++;
        }
        return temp;
    }
    public ListNode middleNode11(ListNode head) {
        List<ListNode> list = Stream.iterate(head, Objects::nonNull, x -> x.next).collect(Collectors.toList());
        return list.get(list.size() / 2);
    }
    public ListNode middleNode12(ListNode head) {
        ListNode temp;
        if(head.next==null)
            return head;
        temp=head.next.next;
        while(temp!=null)
        {

            if(temp.next==null)
                break;
            head=head.next;
            temp=temp.next.next;



        }
        return head.next;
    }
}
