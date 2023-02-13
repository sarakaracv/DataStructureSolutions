package org.example.DataStructure;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor

public class Node1 {
    int val;
    int data;
    Node1 head;
    Node1 next;
    Node1 tail;
    int size;
    Node1 left;
    Node1 right;
    Node1 root;
    List<Node1> children;




    public Node1(int val) {
        this.val = val;
    }
    public Node1(int val, Node1 next) { this.val = val; this.next = next; }

    public void add(int data){

        Node1 node= new Node1(data);
        if (node==null){
        head=tail=node;
        }else{
        node.next=head;
        head=node;
        }
        size++;

    }
void printNode(){
Node1 current= head;
while (current!=null){
if (current.next==null) System.out.println(current.val);
else System.out.println(current.val);
current=current.next;
}

}
}
