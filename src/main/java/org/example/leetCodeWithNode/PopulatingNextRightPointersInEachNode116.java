package org.example.leetCodeWithNode;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode116 {
    public static void main(String[] args) {
        Node node = new Node(1);

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
}
