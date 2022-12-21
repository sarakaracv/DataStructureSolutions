package org.example.groupweeks.task29;

import java.util.NoSuchElementException;

public class MyQueue<T> {
    Node<T> front;
    Node<T> back;
    int size;

    boolean isEmptyQueue(){
        return front==null;
    }
    T peek(){ return (T) front.values;
    }
    void enqueue(T items){ //add
        Node<T> node= new Node<>(items);
        if (isEmptyQueue()) front=back=node;
        else { back.next=node; back=node; } size++;
    }
    T dequeue(){// delete
        Node<T> frontNode;
        if (isEmptyQueue()) throw new NoSuchElementException("no such element found");
        if (front==back) {frontNode=front; front=back=null;}
        else { frontNode=front; front=front.next; } size--;
        return (T) frontNode.values;
    }
     int size(){return size;}
    void PrintQueue(){
        if (isEmptyQueue()) throw new NoSuchElementException("no such element");
        Node<T> current= front;
        while(current!=null){
            System.out.print(current.values);
            if (current.next!=null) System.out.print(", ");
            current=current.next;
        }
    }


}

