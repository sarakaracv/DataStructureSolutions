package org.example.leetCodeWithNode;

import kotlin.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordSearch2212 {
    public static void main(String[] args) {

    }

    public List<String> findWordsNotPass(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            if (exist(board, word)) {
                result.add(word);
            }
        }
        return new ArrayList<>(result);
    }

    private boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i, j - 1, index + 1) ||
                dfs(board, word, i, j + 1, index + 1);
        board[i][j] = temp;
        return result;
    }

    //    private static class TrieNode{
//        TrieNode[] next;
//        String word;
//        public TrieNode(){
//            this.next = new TrieNode[26];
//            this.word = null;
//        }
//    }
    public void insertWord(TrieNode trie, String word) {
        char[] chars = word.toCharArray();
        for (char ch : chars) {
            if (trie.next[ch - 'a'] == null) trie.next[ch - 'a'] = new TrieNode();
            trie = trie.next[ch - 'a'];
        }
        trie.word = word;
    }

    private TrieNode trie;
    private Set<String> res;

    private void dfs(char[][] board, int i, int j, TrieNode trie, boolean[][] traversed) {
        if (trie.word != null) res.add(trie.word);
        if (i < 0 || j < 0 || i == board.length || j == board[0].length || traversed[i][j]) return;
        if (trie.next[board[i][j] - 'a'] == null) return;
        trie = trie.next[board[i][j] - 'a'];
        traversed[i][j] = true;
        dfs(board, i + 1, j, trie, traversed);
        dfs(board, i - 1, j, trie, traversed);
        dfs(board, i, j - 1, trie, traversed);
        dfs(board, i, j + 1, trie, traversed);
        traversed[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        trie = new TrieNode();
        for (String word : words) insertWord(trie, word);
        res = new HashSet<>();
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (trie.next[board[i][j] - 'a'] != null) {
                    dfs(board, i, j, trie, new boolean[n][m]);
                }
            }
        }
        return res.stream().collect(Collectors.toList());
    }

    public boolean dfs(int ind, int indi, int indj, char[][] board, String search, int row, int col) {
        if (ind == search.length()) {
            return true;
        }
        if (indi >= 0 && indi < row && indj >= 0 && indj < col) {
            if (board[indi][indj] != search.charAt(ind)) {
                return false;
            }
            char originalchar = board[indi][indj];
            board[indi][indj] = '$';
            boolean ans = dfs(ind + 1, indi + 1, indj, board, search, row, col) ||
                    dfs(ind + 1, indi - 1, indj, board, search, row, col) ||
                    dfs(ind + 1, indi, indj + 1, board, search, row, col) ||
                    dfs(ind + 1, indi, indj - 1, board, search, row, col);

            board[indi][indj] = originalchar;
            return ans;
        } else
            return false;
    }

    public List<String> findWords2(char[][] board, String[] words) {
        int row = board.length;
        int col = board[0].length;
        List<String> ans = new ArrayList<>();
        List<List<Pair<Integer, Integer>>> v = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            v.add(new ArrayList<>());
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                v.get(board[i][j] - 'a').add(new Pair<>(i, j));
            }
        }
        int start = 0, end = 0;

        for (String word : words) {
            if (word.charAt(0) == 'a')
                start++;
            if (word.charAt(word.length() - 1) == 'a')
                end++;
        }
        boolean reversehaikya = false;
        if (start > end) {
            for (int i = 0; i < words.length; i++) {
                reversehaikya = true;
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }
        for (String search : words) {
            boolean flag = false;
            for (Pair<Integer, Integer> ele : v.get(search.charAt(0) - 'a')) {
                flag = dfs(0, ele.getFirst(), ele.getSecond(), board, search, row, col);
                if (flag) {
                    if (reversehaikya)
                        search = new StringBuilder(search).reverse().toString();
                    ans.add(search);
                    break;
                }
            }
        }
        return ans;
    }
//new solutions


//    TrieNode[] children; // <key = letter, val = its node(next possible letters)>
//    boolean isWord;
//    int count;
//    String word;
//
//    TrieNode() {
//        children = new TrieNode[26];// we said link
//    }


    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<String> findWords4(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(i, j, board, root, root, res);

        return res;
    }

    private void dfs(int i, int j, char[][] board, TrieNode cur, TrieNode root, List<String> res) {
        if (cur.isWord) { // find a word, not a base case, don't return
            res.add(cur.word);
            cur.isWord = false;
            deleteWord(root, cur.word); // remove cur word from trie to dedup
        }
        // base case: out of bound, visited, or no next possible letters to check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char ch = board[i][j];
        if (ch == '#') return;
        cur = cur.links[ch - 'a'];
        if (cur == null) return;

        // check all branches
        board[i][j] = '#';
        for (var dir : DIRS) dfs(i + dir[0], j + dir[1], board, cur, root, res);
        board[i][j] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) insertWord1(root, word);
        return root;
    }

    private void insertWord1(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.links[word.charAt(i) - 'a'];
            if (next == null) cur.links[word.charAt(i) - 'a'] = next = new TrieNode();

            next.count++;
            cur = next;
        }

        cur.isWord = true;
        cur.word = word;
    }

    private void deleteWord(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            TrieNode next = cur.links[word.charAt(i) - 'a'];
            next.count--;
            if (next.count == 0) {      // only cur word path this node
                cur.links[word.charAt(i) - 'a'] = null; // delete the node
                return;                           // early termination
            }
            cur = next;
        }
        cur.isWord = false;
    }

    // new solutions

    List<String> result = new ArrayList<>();
    char[][] board;
    String[] words;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public List<String> findWords5(char[][] board, String[] words) {
        this.board = board;
        this.words = words;
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (Character c : word.toCharArray()) {
                if (!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }
            curr.word = word;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtrack(i, j, root);
                }
            }
        }
        return result;
    }

    private void backtrack(int i, int j, TrieNode parent) {
        Character c = board[i][j];
        TrieNode curr = parent.children.get(c);
        if (curr.word != null) {
            result.add(curr.word);
            curr.word = null;
        }
        board[i][j] = '#';
        for (int d = 0; d < 4; d++) {
            int newX = i + dx[d];
            int newY = j + dy[d];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length) continue;
            if (curr.children.containsKey(board[newX][newY])) {
                backtrack(newX, newY, curr);
            }
        }
        board[i][j] = c;
        if (curr.children.isEmpty()) {
            parent.children.remove(c);
        }
    }

//class TrieNode {
//    HashMap<Character, TrieNode> children = new HashMap<>();
//    String word = null;
//
//    public TrieNode() {}
//}


    // new solution

    public List<String> findWords6(char[][] board, String[] words) {
        TrieNode t = new TrieNode();
        if (board.length == 1 && board[0].length == 1) {
            List<String> list = new ArrayList<>();
            for (String word : words) {
                if (word.length() > 1) continue;
                if (word.charAt(0) == board[0][0]) {
                    list.add(word);
                    return list;
                }
            }
            return list;
        }
        for (String word : words) t.insert2(word);
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (t.node[board[i][j] - 'a'] != null) {
                    findMatches(board, i, j, set, t);
                }
            }
        }
        return new ArrayList<>(set);
    }

    private void findMatches(char board[][], int i, int j, Set<String> w, TrieNode t) {
        if (t.isWord) w.add(t.word);
        if (i < 0 || i == board.length || j < 0 || j == board[0].length || board[i][j] == ' ') return;
        if (t.node[board[i][j] - 'a'] == null) return;
        char c = board[i][j];
        board[i][j] = ' ';
        if (i > 0) findMatches(board, i - 1, j, w, t.node[c - 'a']);
        if (j > 0) findMatches(board, i, j - 1, w, t.node[c - 'a']);
        if (i < board.length - 1) findMatches(board, i + 1, j, w, t.node[c - 'a']);
        if (j < board[0].length - 1) findMatches(board, i, j + 1, w, t.node[c - 'a']);

        board[i][j] = c;

    }
//class Trie{
//    Trie node[];
//    boolean isWord;
//    String word;
//    public Trie(){
//        node = new Trie[26];
//        isWord = false;
//    insert method
//    }


}

