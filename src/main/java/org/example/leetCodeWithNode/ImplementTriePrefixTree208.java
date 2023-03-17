package org.example.leetCodeWithNode;

import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTree208 {
    TrieNode root= new TrieNode();

    public void insert(String word) {

            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) {
                    node.put(c, new TrieNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node != null && node.isEnd();
        }

        public boolean startsWith(String prefix) {
            return searchPrefix(prefix) != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.containsKey(c)) {
                    node = node.get(c);
                } else {
                    return null;
                }
            }
            return node;
        }

        // TrieNode second implementation


        class Trie {
            private TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                TrieNode current = root;
                for (int i = 0; i < word.length(); i++) {
                    char c= word.charAt(i);
                    if (!current.children.containsKey(c)) {
                        current.children.put(c, new TrieNode());
                    }
                    current = current.children.get(c);
                }
                current.isWord = true;
            }

            public boolean search(String word) {
                TrieNode current = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if (!current.children.containsKey(c)) {
                        return false;
                    }
                    current = current.children.get(c);
                }
                return current.isWord;
            }

            public boolean startsWith(String prefix) {
                TrieNode current = root;
                for (int i = 0; i < prefix.length(); i++) {
                    char c = prefix.charAt(i);
                    if (!current.children.containsKey(c)) {
                        return false;
                    }
                    current = current.children.get(c);
                }
                return true;
            }

        }


}

