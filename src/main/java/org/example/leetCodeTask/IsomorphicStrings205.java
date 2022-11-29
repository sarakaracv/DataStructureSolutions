package org.example.leetCodeTask;

import java.util.HashMap;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        String s="egg", t="add";
        System.out.println(isIsomorphic(s,t));
    }
    public static boolean isIsomorphic(String s, String t) {
        if (s == null || t == " " || s == " " && t == null) return false;
        if (s.length()!=t.length()) return false;
        char [] s1= s.toCharArray();
        char [] t1= t.toCharArray();
        HashMap<Character,Character> map= new HashMap<>();
        map.put(s1[0],t1[0]);
        for (int i = 0; i < s1.length; i++) {
            char c1= s1[i];
            char c2=t1[i];
            if (map.containsKey(c1)){
                if (map.get(c1)!=c2) return false;
            }else if (map.containsValue(c2)){
                if (map.get(c1)==null|| map.get(c1)!=c2)return false;
            }else map.put(c1,c2);
        }
        return true;
    }
}
