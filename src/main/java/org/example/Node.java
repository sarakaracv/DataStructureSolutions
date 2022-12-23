package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class Node {
    int val;
    int data;
    Node head;
    Node next;
    Node tail;
    int size;
    Node left;
    Node right;
    Node root;
    List<Node> children;




    public Node(int val) {
        this.val = val;
    }
    public Node(int val, Node next) { this.val = val; this.next = next; }

    public void add(int data){

        Node node= new Node(data);
        if (node==null){
        head=tail=node;
        }else{
        node.next=head;
        head=node;
        }
        size++;

    }
void printNode(){
Node current= head;
while (current!=null){
if (current.next==null) System.out.println(current.val);
else System.out.println(current.val);
current=current.next;
}

}
}
