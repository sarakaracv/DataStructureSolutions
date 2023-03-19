package org.example.leetCodeWithNode;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TrieNode {
     TrieNode root;
     TrieNode[] next;
     TrieNode[] node;
    Map<Character, TrieNode> children;
    boolean isWord;
    int count;
    TrieNode[] links;
     boolean isEnd;
     String word;

    public TrieNode() {
        node= new TrieNode[26];
        root= new TrieNode();
        links = new TrieNode[26];
        children = new HashMap<>();
        this.next = new TrieNode[26];
        this.word = null;
        isWord= false;
    }
    public void insert2(String word){
        TrieNode t = this;
        for(char ch: word.toCharArray()){
            if(t.node[ch-'a']==null) t.node[ch-'a'] = new TrieNode();
            t = t.node[ch-'a'];
        }
        t.isWord = true;
        t.word = word;
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
