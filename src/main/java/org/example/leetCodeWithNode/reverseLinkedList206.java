package org.example.leetCodeWithNode;

import java.util.Stack;

public class reverseLinkedList206 {
    public static void main(String[] args) {
        ListNode node= new ListNode();
        node.add(1);
        node.add(3);
        node.add(4);

        System.out.println(reverseList4(node));
    }
    public ListNode reverseList(ListNode head) {
        ListNode node= new ListNode();
        if (node==null||head.next==null) return head;
        ListNode nextNode= head.next;
        ListNode newHead= reverseList(nextNode);
        nextNode.next=head;
        head.next=null;
        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        /* iterative solution */
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    public ListNode reverseList3(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public  static ListNode reverseList4(ListNode head) {

        ListNode current = head, nextNode = null, reverseNode = null;

        while(current!=null){
            nextNode = current.next;
            current.next = reverseNode;
            reverseNode = current;
            current = nextNode;
        }

        return reverseNode;
    }
    public ListNode reverseList5(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public ListNode reverseList6(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode it = head, node = null;
        Stack<ListNode> stack = new Stack<>();
        while(it != null) {
            stack.push(it);
            it = it.next;
        }
        it = stack.pop();
        while(!stack.isEmpty()) {
            node = stack.pop();
            node.next.next = node;
            node.next = null;
        }

        return it;
    }
    public ListNode reverseList7(ListNode head) {
        ListNode node = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = node;
            node = head;
            head = nxt;
        }
        return node;
    }
    public ListNode reverseList8(ListNode head) {
        if(head == null) return head;
        ListNode point = head.next;
        ListNode tmp;
        while(point!=null){
            tmp = point;
            point = point.next;

            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}
