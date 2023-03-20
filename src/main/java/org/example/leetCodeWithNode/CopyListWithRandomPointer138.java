package org.example.leetCodeWithNode;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer138 {

        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            // Create a mapping from original nodes to their copies
            Map<Node, Node> map = new HashMap<>();
            Node curr = head;
            while (curr != null) {
                map.put(curr, new Node(curr.val));
                curr = curr.next;
            }

            // Assign next and random pointers for each copy
            curr = head;
            while (curr != null) {
                map.get(curr).next = map.get(curr.next);
                map.get(curr).random = map.get(curr.random);
                curr = curr.next;
            }

            // Return the head of the copy list
            return map.get(head);
        }

        public Node copyRandomList2(Node head) {
            if (head == null) {
                return null;
            }

            // First pass: Create a deep copy of each node and insert it after the original node
            Node curr = head;
            while (curr != null) {
                Node copy = new Node(curr.val);
                copy.next = curr.next;
                curr.next = copy;
                curr = copy.next;
            }

            // Second pass: Assign random pointers for the copy nodes
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            // Third pass: Separate the original and copy lists
            Node newHead = head.next;
            Node copyCurr = newHead;
            curr = head;
            while (curr != null) {
                curr.next = copyCurr.next;
                if (copyCurr.next != null) {
                    copyCurr.next = copyCurr.next.next;
                }
                curr = curr.next;
                copyCurr = copyCurr.next;
            }

            return newHead;
        }
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val, next, null);
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head;
        Node copyHead = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node copy = cur.next;
            cur.next = next;
            if (next != null)
                copy.next = next.next;
            cur = next;
        }
        return copyHead;
    }
    public Node copyRandomList4(Node head) {
        Node curr = head;
        HashMap<Node, Node> hm = new HashMap<>();
        while(curr != null) {
            hm.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        curr = head;
        while(curr != null) {
            hm.get(curr).next = hm.get(curr.next);
            hm.get(curr).random = hm.get(curr.random);
            curr = curr.next;
        }
        return hm.get(head);
    }
}
