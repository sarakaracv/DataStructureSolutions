package org.example.leetCodeWithNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph133 {
    public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            Map<Node, Node> visited = new HashMap<>();
            visited.put(node, new Node(node.val));

            Queue<Node> queue = new LinkedList<>();
            queue.add(node);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();
                for (Node neighbor : curr.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        visited.put(neighbor, new Node(neighbor.val));
                        queue.add(neighbor);
                    }
                    visited.get(curr).neighbors.add(visited.get(neighbor));
                }
            }

            return visited.get(node);
        }
}
