package org.example.leetCodeWithNode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data

public class Node {
    public List<Node> neighbors;
    int val;
    int data;
    Node head;
    Node next;
    Node tail;
    int size;
    int key;
    int value;
    Node left;
    Node right;
    Node root;
    Node prev;
    Node cur;
    Node random;
    List<Node> children;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int val, ArrayList<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


    public Node(int val, Node next) { this.val = val; this.next = next; }

    public Node(int val, Node next, Node random) {
        this.val=val;
        this.next=next;
        this.random=random;
    }

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
