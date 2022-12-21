package org.example.groupweeks.task29;

public class Node<T> {
    T values;
    Node<T> next;

    public Node(T values ){
        this.values=values;
        next=null;
    }
}
