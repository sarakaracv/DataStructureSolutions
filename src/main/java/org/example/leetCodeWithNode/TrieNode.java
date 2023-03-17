package org.example.leetCodeWithNode;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {
    private TrieNode root;
    Map<Character, TrieNode> children;
    boolean isWord;


    private TrieNode[] links;
    private boolean isEnd;

    public TrieNode() {
        root= new TrieNode();
        links = new TrieNode[26];
        children = new HashMap<>();
    }


    public boolean containsKey(char c) {
        return links[c - 'a'] != null;
    }

    public TrieNode get(char c) {
        return links[c - 'a'];
    }

    public void put(char c, TrieNode node) {
        links[c - 'a'] = node;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
    }
}
