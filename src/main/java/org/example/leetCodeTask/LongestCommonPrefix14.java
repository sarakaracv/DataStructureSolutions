package org.example.leetCodeTask;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        for(int i=0; i<strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String s:strs)
                if(s.length() == i || s.charAt(i) != c)
                    return strs[0].substring(0,i);
        }
        return strs[0];
    }
}
