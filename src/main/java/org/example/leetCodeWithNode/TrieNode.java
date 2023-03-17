package org.example.leetCodeWithNode;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {
     TrieNode root;
     TrieNode[] next;
    Map<Character, TrieNode> children;
    boolean isWord;
    int count;
    TrieNode[] links;
     boolean isEnd;
     String word;

    public TrieNode() {
        root= new TrieNode();
        links = new TrieNode[26];
        children = new HashMap<>();
        this.next = new TrieNode[26];
        this.word = null;
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
