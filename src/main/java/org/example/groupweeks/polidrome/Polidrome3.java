package org.example.groupweeks.polidrome;

import java.util.ArrayList;
import java.util.List;

public class Polidrome3 {

    public static void main(String[] args) {

        List<Node> list=new ArrayList<>();
        list.add(new Node(3));
        list.add(new Node(2));
        list.add(new Node(2));
        list.add(new Node(3));
        System.out.println(isthePalindrome(list.get(0)));

        }
    public static boolean isthePalindrome(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.value);
            head = head.next;
        }
        int size = list.size();
        if (size <= 1) {
            return true;
        }
        for (int i = 0; i < (size / 2); i++) {
            if (!list.get(i).equals(list.get(size - i - 1))) {
                return false;
            }
        }
        return true;

    }
}
