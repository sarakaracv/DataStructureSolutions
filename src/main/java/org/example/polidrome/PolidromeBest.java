package org.example.polidrome;


public class PolidromeBest {
    public static void main(String[] args) {
        Node listNode = new Node(3);
        listNode.next = new Node(2);
        listNode.next.next = new Node(0);
        listNode.next.next.next = new Node(4);
        listNode.next.next.next.next= new Node(5);
        listNode.next.next.next.next.next= listNode.next.next;

       System.out.println(isbestPalindrome(listNode));
// something wrong
    }

    public static boolean isbestPalindrome(Node head) {
        Node middle,secondStart,prevToSlow;
        boolean ans=true;
        Node fast=head,slow=head;
        if(head==null || head.next==null){
            return ans;
        }
        while(fast!=null && fast.next!=null){
            prevToSlow=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            middle=slow;
            slow=slow.next;
        }
        secondStart=slow;
        prevToSlow=null;

        reverseList(head);
        ans=compareLists(head,secondStart);

        return ans;
    }

    static boolean compareLists(Node head1, Node head2)
    {
        Node temp1 = head1;
        Node temp2 = head2;

        while (temp1 != null && temp2 != null) {
            if (temp1.value == temp2.value) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return false;
        }

//         /* Both are empty return 1*/
//         if (temp1 == null && temp2 == null)
//             return true;

//         /* Will reach here when one is NULL
//            and other is not */
        return true;
    }

    static void reverseList(Node head){

        Node curr=head.next;
        Node prev=null;
        Node nextTOcurr;
        while(curr!=null){
            nextTOcurr=curr.next;
            curr.next=prev;
            prev=curr;
            curr=nextTOcurr;
        }
        curr=prev;
    }
}
