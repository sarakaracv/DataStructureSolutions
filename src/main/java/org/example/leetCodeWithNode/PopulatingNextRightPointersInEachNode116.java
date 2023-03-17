package org.example.leetCodeWithNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode116 {
    public static void main(String[] args) {
    }

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node pol = queue.poll();
                if (i == size - 1) pol.next = null;
                else pol.next = queue.peek();
                if (pol.prev != null) queue.offer(pol.left);
                if (pol.right!=null) queue.offer(pol.right);
            }
        }
        return root;
    }

        public Node connect2(Node root) {
            if (root == null) return null;
            Node leftMost = root;
            while (leftMost.left != null) {
                Node head = leftMost;
                while (head != null) {
                    head.left.next = head.right;
                    if (head.next != null) head.right.next = head.next.left;
                    head = head.next;
                }
                leftMost = leftMost.left;
            }
            return root;
        }
    }


