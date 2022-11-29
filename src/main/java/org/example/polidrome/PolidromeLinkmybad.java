package org.example.polidrome;

import java.util.Stack;

public class PolidromeLinkmybad {
    public static void main(String[] args) {
        Node node=new Node(1);
        Node node1=new Node(2);
        Node node2=new Node(2);
        Node node3=new Node(1);
        node.next=node1;
        node1.next=node2;
        node2.next=node3;
        System.out.println(polidrome(node));

    }

    public static boolean polidrome(Node head) {
        Node come = head;
        boolean ispolindrome = true;
        Stack<Integer> stack = new Stack<>();
        while (come != null) {   //iterating part
            stack.push(come.value);
            come = come.next;
        }
        while (head != null) {
            int num = stack.pop();
            if (head.value == num) {
                ispolindrome = true;
            } else {
                ispolindrome = false;
                break;
            }
            head = head.next;
        }
        return ispolindrome;
    }

}


