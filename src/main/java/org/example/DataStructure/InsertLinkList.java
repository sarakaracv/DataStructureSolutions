package org.example.DataStructure;

import org.example.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertLinkList {
    public static List merge(int[] nums1, int m, int[] nums2, int n) {
        List list= new ArrayList<>();
        int j = 0;
        for(int i = m ; i < m + n  ; i++){
            nums1 [i] = nums2 [j++];
        }
        Arrays.sort(nums1);
        list.add(nums1);

        return list;
    }
    public static void merges(int [] nums1, int m, int [] nums2, int n){//space O (1) time O(n)
        int p1= m-1;
        int p2=n-1;
        int i= m+n-1;
        while (p2>=0){
            if (p1>=0 && nums1[p1]> nums2[p2]){
                nums1[i--]=nums1[p2--];
            }else nums1[i--]=nums2[p2--];
        }
    }
    public static void main(String[] args) {

    }

//    public Node insert(int data) {
//        // Create a new node with given data
//        Node1 node = new Node1(data);
//        node.next = null;
//
//        // If the Linked List is empty,
//        // then make the new node as head
//        if (node.head == null) {
//            node.head = node;
//        } else {
//            // Else traverse till the last node
//            // and insert the node there
//            Node1 last = node.head;
//            while (last.next != null) {
//                last = last.next;
//            }
//
//            // Insert the new_node at last node
//            last.next = node;
//        }
//
//        // Return the list by head
//        return node;
//    }

    // Method to print the LinkedList.
//    public void printList(Node list) {
//        Node currNode = list.head;
//
//        System.out.print("\nLinkedList: ");
//
//        // Traverse through the LinkedList
//        while (currNode != null) {
//            // Print the data at current node
//            System.out.print(currNode.data + " ");
//
//            // Go to next node
//            currNode = currNode.next;
//        }
//        System.out.println("\n");
//    }
//
//    // **************DELETION BY KEY**************
////
////    // Method to delete a node in the LinkedList by KEY
//    public static LinkedList deleteByKey(LinkedList list, int key) {
//        // Store head node
//        Node currNode = list.head, prev = null;
//
//        // CASE 1:
//        // If head node itself holds the key to be deleted
//
//        if (currNode != null && currNode.data == key) {
//            list.head = currNode.next; // Changed head
//
//            // Display the message
//            System.out.println(key + " found and deleted");
//
//            // Return the updated List
//            return list;
//        }
//
//// CASE 2:
//        // If the key is somewhere other than at head
//        //
//
//        // Search for the key to be deleted,
//        // keep track of the previous node
//        // as it is needed to change currNode.next
//        while (currNode != null && currNode.data != key) {
//            // If currNode does not hold key
//            // continue to next node
//            prev = currNode;
//            currNode = currNode.next;
//        }
//
//        // If the key was present, it should be at currNode
//        // Therefore the currNode shall not be null
//        if (currNode != null) {
//            // Since the key is at currNode
//            // Unlink currNode from linked list
//            prev.next = currNode.next;
//
//            // Display the message
//            System.out.println(key + " found and deleted");
//        }
//
//        //
//        // CASE 3: The key is not present
//        //
//
//        // If key was not present in linked list
//        // currNode should be null
//        if (currNode == null) {
//            // Display the message
//            System.out.println(key + " not found");
//        }
//
//        // return the List
//        return list;
//    }
}
