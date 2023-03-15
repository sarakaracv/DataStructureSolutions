package org.example.leetCodeTask;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {

    }
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    String currentWord = queue.poll();

                    for (int j = 0; j < currentWord.length(); j++) {
                        char[] charArray = currentWord.toCharArray();
                        for (char c = 'a'; c <= 'z'; c++) {
                            charArray[j] = c;
                            String newWord = new String(charArray);
                            if (wordSet.contains(newWord)) {
                                if (newWord.equals(endWord)) {
                                    return level + 1;
                                }
                                queue.offer(newWord);
                                wordSet.remove(newWord);
                            }
                        }
                    }
                }
                level++;
            }
            return 0;
        }
        public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)) {
                return 0;
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int level = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String currentWord = queue.poll();
                    char[] charArray = currentWord.toCharArray();
                    for (int j = 0; j < charArray.length; j++) {
                        char originalChar = charArray[j];
                        for (char c = 'a'; c <= 'z'; c++) {
                            charArray[j] = c;
                            String newWord = new String(charArray);
                            if (wordSet.contains(newWord)) {
                                if (newWord.equals(endWord)) {
                                    return level + 1;
                                }
                                queue.offer(newWord);
                                wordSet.remove(newWord);
                            }
                        }
                        charArray[j] = originalChar;
                    }
                }
                level++;
            }

            return 0;
        }
    }

