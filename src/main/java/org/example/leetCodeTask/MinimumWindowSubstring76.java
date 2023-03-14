package org.example.leetCodeTask;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {

    }
    public static String minWindow1(String s, String t){
        int m=s.length();
        int n=t.length();
        HashMap<Character,Integer> hashMap= new HashMap<>();
        for (char cha:t.toCharArray()){
            int add=hashMap.getOrDefault(cha,0);
            hashMap.put(cha,add+1);
        }
        HashMap<Character,Integer> maps= new HashMap<>();
        int min=Integer.MAX_VALUE;
        String answer="";
        int i=0, j=0, found=0;
        while(i<m){
            while (j<m&&found!=m){
                char cc=s.charAt(j);
                if (hashMap.containsKey(cc)){
                    int ov=maps.getOrDefault(cc,0);
                    maps.put(cc,ov+1);
                    if (maps.get(cc)>hashMap.get(cc));
                    else found+=1;
                }
                j++;

            }
            int window=j-i;
            if (found==m&&window<min){
                min=window;
                answer=s.substring(i,j);
            }
            if (hashMap.containsKey(s.charAt(i))){
                int zep=maps.get(s.charAt(i));
                maps.put(s.charAt(i),zep-1);
                if (maps.get(s.charAt(i))<hashMap.get(s.charAt(i))) found-=1;

            }
            i++;
        }

        return answer;
    }
    public String minWindow(String s, String t) {
        String answer="";
        if(s == null || t == null)
            return answer;

        int letterCount[] = new int[128];
        int left = 0, count = 0, min = Integer.MAX_VALUE;

        //Counting characters in t
        for(char c: t.toCharArray()) {
            letterCount[c]++;
        }

        //iterating over characters in s
        for(int right=0;right<s.length();right++) {
            //if after decreasing the current char count, it is greater than 0, then it was part of t. So increase the count.
            if(--letterCount[s.charAt(right)] >= 0) {
                count++;
            }
            //loop while our count is equal to length of t and remove any extra char from left side.
            while(count == t.length()) {
                //set the min window size and res
                if(right-left+1 < min) {
                    min = right-left+1;
                    answer = s.substring(left, right+1);
                }
                //remove extra char from left side. We increase the curr left char by 1 since we earlier decreased it by 1. After increasing if it is more than 0, then it was part of t. Hence decrease the count.
                if(++letterCount[s.charAt(left)] > 0) {
                    count--;
                }
                //increase the left pointer and remove extra chars
                left++;
            }
        }
        return answer;
    }
    public String minWindow0(String s, String t) {
        // edge case
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // create a hashmap to store the frequency of characters in t
        Map<Character, Integer> mapT = new HashMap<>();
        for (char c : t.toCharArray()) {
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }

        // initialize variables
        int start = 0, end = 0, count = mapT.size(), minLength = Integer.MAX_VALUE, minStart = 0;

        // iterate through the string s
        while (end < s.length()) {
            char c = s.charAt(end);

            // if the character is in t, decrement its frequency in mapT
            if (mapT.containsKey(c)) {
                mapT.put(c, mapT.get(c) - 1);

                // if the frequency becomes 0, decrement count
                if (mapT.get(c) == 0) {
                    count--;
                }
            }

            // move the start pointer to right if the current window has all characters of t
            while (count == 0) {
                // update the minimum length and start index of the substring
                if (end - start + 1 < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }

                char startChar = s.charAt(start);

                // if the character is in t, increment its frequency in mapT
                if (mapT.containsKey(startChar)) {
                    mapT.put(startChar, mapT.get(startChar) + 1);

                    // if the frequency becomes greater than 0, increment count
                    if (mapT.get(startChar) > 0) {
                        count++;
                    }
                }

                // move the start pointer to right
                start++;
            }

            // move the end pointer to right
            end++;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLength);
    }

}
