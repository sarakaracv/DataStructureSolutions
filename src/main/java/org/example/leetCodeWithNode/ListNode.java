package org.example.leetCodeWithNode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class ListNode {
    int val;
    public ListNode next;
    ListNode head;
    ListNode tail;
    ListNode slow;
    ListNode fast;
    int size;
    ListNode left;
    ListNode right;
    ListNode root;
    List<ListNode> children;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public void add(int data){

        ListNode node= new ListNode(data);
        if (node==null){
        head=tail=node;
        }else{
        node.next=head;
        head=node;
        }
        size++;

    }
void printNode(){
ListNode current= head;
while (current!=null){
if (current.next==null) System.out.println(current.val);
else System.out.println(current.val);
current=current.next;
}

}
}
