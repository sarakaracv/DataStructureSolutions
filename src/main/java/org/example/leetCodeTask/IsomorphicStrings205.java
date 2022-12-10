package org.example.leetCodeTask;

import java.util.*;

public class IsomorphicStrings205 {
    public static void main(String[] args) {
        String s="egg", t="add";
        System.out.println(isIsomorphic1(s,t));
    }
    public static boolean isIsomorphic1(String s, String t) {
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

    public boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] map = new char[256];
        boolean[] used = new boolean[256];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            // if this character has not been mapped
            if (map[sc[i]] == 0) {
                if (used[tc[i]]) return false;
                map[sc[i]] = tc[i];
                used[tc[i]] = true;
            } else if (map[sc[i]] != tc[i]) {
                return false;
            }
        }
        return true;
    }
    public boolean isIsomorphic3(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] a1 = new int[128];
        int[] a2 = new int[128];

        for (int i = 0; i < s.length(); i++) {
            if (a1[s.charAt(i)] != a2[t.charAt(i)]) return false;
            a1[s.charAt(i)] = i + 1;
            a2[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public boolean isIsomorphic4(String s, String t) {

        Map<Character, Character> map = new HashMap<>();
        Character simS;
        Character simT;

        for (int i = 0; i < s.length(); i++) {
            simS = s.charAt(i);
            simT = t.charAt(i);

            if (map.containsKey(simS) || map.containsValue(simT)) {
                if (simT != map.get(simS)) {
                    return false;
                }
            } else {
                map.put(simS, simT);
            }
        }

        return true;
    }
    public boolean isIsomorphic5(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
    public boolean isIsomorphic6(String s, String t) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int[] verifyS = new int[256];
        int[] verifyT = new int[256];
        while(i < n) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(verifyS[c1] == 0 && verifyT[c2] == 0) {
                verifyS[c1] = c2;
                verifyT[c2] = c1;
            }

            if(verifyS[c1] != c2 && verifyT[c2] != c1){
                return false;
            }

            i++;
        }

        return true;

    }
    public boolean isIsomorphic7(String s, String t) {
        HashMap<Character,Character> map=new HashMap<>();
        Set<Character> set=new HashSet<>();

        for(int i=0;i<s.length();i++){
            char cs=s.charAt(i);
            char ct=t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs)!=ct){
                    return false;
                }
            }else{
                if(set.contains(ct)){
                    return false;
                }
                set.add(ct);
                map.put(cs,ct);
            }
        }
        return true;
    }
    public boolean isIsomorphic8(String s, String t) {
        if(s == null || s.length() <= 1) return true;
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        for(int i = 0 ; i< s.length(); i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(map.containsKey(a)){
                if(map.get(a).equals(b))
                    continue;
                else
                    return false;
            }else{
                if(!map.containsValue(b))
                    map.put(a,b);
                else return false;

            }
        }
        return true;
    }
    public boolean isIsomorphic9(String s1, String s2) {
        int[] m = new int[512];
        for (int i = 0; i < s1.length(); i++) {
            if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
            m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
        }
        return true;
    }
    public boolean isIsomorphic10(String s, String t) {
        int[] sMap=new int[128];
        int[] tMap=new int[128];
        char c,c1;
        for(int i=s.length()-1;i>=0;i--){
            c=s.charAt(i);
            c1=t.charAt(i);
            if(sMap[c]!=tMap[c1]){
                return false;
            }
            sMap[c]=i+1;
            tMap[c1]=i+1;
        }
        return true;
    }
    public boolean isIsomorphic11(String s, String t) {

        if(s.length()==t.length()){
            LinkedHashMap<Character, Character> smap=new LinkedHashMap();
            LinkedHashMap<Character, Character> tmap=new LinkedHashMap();
            for(int i=0;i<s.length();i++){
                if(!smap.containsKey(s.charAt(i))) smap.put(s.charAt(i),t.charAt(i));
                if(!tmap.containsKey(t.charAt(i))) tmap.put(t.charAt(i),s.charAt(i));
            }
            for(int i=0;i<t.length();i++){
                if(tmap.get(t.charAt(i)) != s.charAt(i) || smap.get(s.charAt(i)) != t.charAt(i)) return false;
            }
        }
        else return false;

        return true;
    }
    public boolean isIsomorphic12(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] map1 = new int[256];
        int[] map2 = new int[256];
        for(int idx = 0; idx < s.length(); idx++){
            if(map1[s.charAt(idx)] != map2[t.charAt(idx)])
                return false;
            map1[s.charAt(idx)] = idx + 1;
            map2[t.charAt(idx)] = idx + 1;
        }
        return true;
    }
    public boolean isIsomorphic13(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;

        Map<Character,Character> map = new HashMap<>();
        Map<Character,Character> rev = new HashMap<>();

        for(int i = 0; i < s.length();++i){
            Character sC = s.charAt(i);
            Character tC = t.charAt(i);

            if (!map.containsKey(sC) && !rev.containsKey(tC)){
                map.put(sC, tC);
                rev.put(tC, sC);
            } else {
                if (!tC.equals(map.get(sC)) || !sC.equals(rev.get(tC))){
                    return false;
                }
            }
        }

        return true;
    }

}
