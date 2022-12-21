package org.example.groupweeks.task29;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class anagram {
    public static void main(String[] args) {
        char[] ana1 = {'s', 'a', 'a', 'r'};
        char[] ana2 = {'r', 's', 'a', 'a'};
        System.out.println(Anagram(ana1, ana2));
        String name1="RaanS";
        String name2= "Saran";
        System.out.println(isTheAnagram(name2,name1));
    }

    public static boolean Anagram(char[] str1, char[] str2) {
        Arrays.sort(str1);
        Arrays.sort(str2);
        if (str1.length != str2.length) return false;
        for (int i = 0; i < str1.length; i++) {
            if (str1[i] != str2[i]) return false;
        }
        return true;
    }




    public static boolean isTheAnagram(String s, String t) {
        String m= s.toLowerCase();
        String n= t.toLowerCase();
        char[] car = m.toCharArray();
        char[] car2 = n.toCharArray();
        Arrays.sort(car);
        Arrays.sort(car2);
        if (!Arrays.equals(car, car2)) return false;
        return true;
    }








    public boolean isAnagramleet(String s, String t) {
        boolean bool = false;
        int e = s.length();
        int f = t.length();
        if(e != f){
            bool = false;
        }
        else{
            int[] a = new int[256];
            int[] b = new int[256];
            for(char c: s.toCharArray()){
                int indx = (int) c ;
                a[indx] +=1;
            }
            for(char c: t.toCharArray()){
                int indx = (int) c ;
                b[indx] +=1;
            }
            for(int i=0;i<256;i+=1){
                if(a[i] != b[i]){
                    bool = false;
                    break;
                }
                else{
                    bool = true;
                }
            }
        }return bool;
    }
    public boolean isAnagramleet2(String s, String t) {
        int a[] = new int[26];
        Arrays.fill(a, 0);
        int n = s.length();
        int m = t.length();
        if(n!=m) return false;
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            a[(int)ch-'a'] += 1;
        }
        for(int j=0; j<m; j++){
            char ch1 = t.charAt(j);
            a[(int)ch1-'a'] -= 1;
        }

        for(int value : a){
            if(value!=0){
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramleet3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charCount = new int[26];
        for(int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for(int i : charCount) {
            if(i != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramHashMap(String s, String t) {
    HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    for(int i=0;i<s.length();i++){
        hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0)+1);
    }

        for(int i=0;i<t.length();i++){
        if(!hm.containsKey(t.charAt(i)))
            return false;
        if(hm.get(t.charAt(i)) == 1)
            hm.remove(t.charAt(i));
        else
            hm.put(t.charAt(i), hm.get(t.charAt(i))-1);
    }
        return hm.size() == 0;
}
    public boolean isAnagramMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characters = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (characters.containsKey(currentChar)) {
                int count = characters.get(currentChar);
                count++;
                characters.put(currentChar, count);
            } else {
                characters.put(currentChar, 1);
            }
        }

        for (int j = 0; j < t.length(); j++) {
            char currentChar = t.charAt(j);
            if (characters.containsKey(currentChar)) {
                int count = characters.get(currentChar);
                count--;
                if (count == 0) {
                    characters.remove(currentChar);
                } else {
                    characters.put(currentChar, count);
                }
            }
        }

        return characters.isEmpty();
    }



    public boolean isAnagram(String s, String t) {
        int a = s.length();
        int b = t.length();

        if (a != b) {
            return false;
        }

        int[] arr = new int[26];
        for (int i = 0; i < a; i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            arr[index]++;
        }
        for (int i = 0; i < b; i++) {
            char ch = t.charAt(i);
            int index = ch - 'a';
            arr[index]--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
    public boolean isAnagramHashAndSet(String s, String t) {
        if(s.length()!=t.length())
            return false;

        HashMap<Character,Integer> sMap= new HashMap<Character,Integer>();

        for(int i=0; i<s.length(); i++){
            if(sMap.containsKey(s.charAt(i))){
                sMap.put(s.charAt(i), sMap.get(s.charAt(i)) + 1);
            }
            else{
                sMap.put(s.charAt(i), 1);
            }
        }

        for(int i=0; i<t.length(); i++){
            if(sMap.containsKey(t.charAt(i))){
                sMap.put(t.charAt(i), sMap.get(t.charAt(i)) - 1);
            }
            else{
                return false;
            }
        }

        Set<Character> keys = sMap.keySet();
        // Loop over all keys and check if all keys are 0.
        // If so it means it is anagram.
        for (Character key : keys) {
            if (sMap.get(key) != 0) {
                return false;
            }
        }

        return true;
    }
}