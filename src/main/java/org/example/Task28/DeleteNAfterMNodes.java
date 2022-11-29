package org.example.Task28;

public class DeleteNAfterMNodes {
    void push(Node head, int data) {
        // create a new linked list node from the heap
        Node newNode = new Node(head.data);

        newNode.data = data;
        newNode.next = head;
        head = newNode;
    }

    // Helper function to print a given linked list
    void printList(Node head) {
        Node ptr = head;
        while (ptr != null) {
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
        System.out.println("no list");
    }

    // Recursive function to delete every `n` nodes in a linked list after
// skipping `m` nodes
    void deleteNodes(Node head, int m, int n) {
        // base case
        if (head == null || head.next == null) {
            return;
        }

        Node prev = null, next = null;
        Node curr = head;

        // skip `m` nodes
        for (int i = 1; i <= m && curr!=null; i++) {
            prev = curr;
            curr = curr.next;
        }

        // delete next `n` nodes
        for (int i = 1; i <= n && next!=null; i++) {
            next = curr.next;
//            curr = next;
        }

        // link remaining nodes with the last node
        prev.next = curr;

        // recur for remaining nodes
        deleteNodes(curr, m, n);
    }

    public static void main(String[] args) {
        DeleteNAfterMNodes deleteNAfterMNodes= new DeleteNAfterMNodes();

        // input keys
        int keys[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Node head= new Node(keys[0]);

        for (int i = keys.length - 1; i >= 0; i--) {
            deleteNAfterMNodes.push(head, keys[i]);
        }

        deleteNAfterMNodes.deleteNodes(head, 1, 3);
        deleteNAfterMNodes.printList(head);

    }

}
