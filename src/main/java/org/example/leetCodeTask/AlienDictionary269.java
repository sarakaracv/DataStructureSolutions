package org.example.leetCodeTask;

import java.util.*;

public class AlienDictionary269 {

        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> graph = new HashMap<>();
            Map<Character, Integer> inDegree = new HashMap<>();

            // Initialize in-degree for each character to 0
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    inDegree.put(c, 0);
                }
            }

            // Create edges between adjacent words
            for (int i = 0; i < words.length - 1; i++) {
                String word1 = words[i];
                String word2 = words[i+1];
                int j = 0;
                while (j < word1.length() && j < word2.length()) {
                    char c1 = word1.charAt(j);
                    char c2 = word2.charAt(j);
                    if (c1 != c2) {
                        Set<Character> set = graph.getOrDefault(c1, new HashSet<>());
                        if (!set.contains(c2)) {
                            set.add(c2);
                            graph.put(c1, set);
                            inDegree.put(c2, inDegree.get(c2) + 1);
                        }
                        break;
                    }
                    j++;
                }
                if (j == word2.length() && word1.length() > word2.length()) {
                    return "";
                }
            }

            // Perform topological sort
            StringBuilder sb = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            for (char c : inDegree.keySet()) {
                if (inDegree.get(c) == 0) {
                    queue.offer(c);
                }
            }
            while (!queue.isEmpty()) {
                char c = queue.poll();
                sb.append(c);
                if (graph.containsKey(c)) {
                    for (char neighbor : graph.get(c)) {
                        inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                        if (inDegree.get(neighbor) == 0) {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if (sb.length() < inDegree.size()) {
                return "";
            }
            return sb.toString();
        }
    }

