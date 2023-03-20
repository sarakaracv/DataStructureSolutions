package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FirstUniqueCharacterInAString387 {
    public static void main(String[] args) {

    }
    public int firstUniqChar1(String s) {
        int i = 0;
        int index = -1;
        while (i < s.length()){
            char tempChar = s.charAt(i);
            if (s.indexOf(tempChar) == s.lastIndexOf(tempChar)) {
                index = i;
                break;
            }
            i++;
        }
        System.gc();
        return index;
    }
    public int firstUniqChar2(String s) {
        Set<Character> test = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!test.contains(s.charAt(i)) && s.lastIndexOf(s.charAt(i)) == i) {
                return i;
            } else {
                test.add(s.charAt(i));
            }
        }
        return -1;
    }



        public int firstUniqChar3(String s) {
            // Create a HashMap to store character frequency
            HashMap<Character, Integer> map = new HashMap<>();

            // Populate the HashMap with character frequencies
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            // Iterate through the string again to find first unique character
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (map.get(c) == 1) {
                    return i;
                }
            }

            // If no unique character is found, return -1
            return -1;
        }
    }
