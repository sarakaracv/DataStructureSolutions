package org.example.groupweeks.course;

import org.apache.http.annotation.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private Node next;
        private int value;

        public Node (int value){
            this.value=value;
        }

    }
    private Node first;
    private Node last;

    public void addLast(int item){
        Node node= new Node(item);

        if (isEmpty()) first=last=node;
        else {
            last.next=node;// not empty add last
            last=node; //add last
        }
    }
    public void addFirst(int item){
        Node node= new Node(item);
        if (isEmpty()) first=last=node;
        else {
            node.next=first;
            first=node;
        }

    }
    public boolean isEmpty(){
       return first==null;
    }
    public int indexOf(int item){
        int index=0;
        Node current=first;
        while(current!=null){
            if (current.value==item) return index;
            current=current.next;
            index++;

        }
        return -1;
    }
    public boolean contains(int item){
        return indexOf(item)!=-1;
    }
    public void removeFirst(){
        if (isEmpty()) throw new NoSuchElementException("no such an element");// no element
        if (first==last)first=last=null;// if we have one element remove it

        Node second=first.next;//2 or more element
        first.next=null;
        first=second;
    }
    public void removeLast(){
        if (isEmpty()) throw new NoSuchElementException("No such elemement your linklist");
        if (first==last){first=last=null;
            return;}// if we have 1 element we say return if one not continue

        //2 or more element
        Node previous= getPrevious(last);// before last index is last now
        last=previous;// assign last one to previous
        last.next=null;// we remove pointer link
    }
    @Nullable
   // @Contract(pure = true)
    private Node getPrevious(Node node){
    Node current=first;
    while(current!=null){
    if (current.next==node) return current;
    current=current.next;
        } return null;
    }



}
