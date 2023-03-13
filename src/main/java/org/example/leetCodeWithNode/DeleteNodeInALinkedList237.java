package org.example.leetCodeWithNode;

public class DeleteNodeInALinkedList237 {
    public static void main(String[] args) {

    }
    public void deleteNode(ListNode node){
        node.val=node.next.val;
        node.next=node.next.next;
        System.gc();
    }
}
