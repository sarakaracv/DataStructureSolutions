package org.example.leetCodeTask;

import java.util.Stack;

public class IsSubsequence392 {
    public static void main(String[] args) {
    String s="abc" , t= "ahbgdc";

        System.out.println(isSubsequence(s,t));

    }
    public static boolean isSubsequence(String s, String t) {

        int index1=0;
        for(int i=0;i<s.length();index1++,i++){

            while(index1<t.length() && s.charAt(i) != t.charAt(index1)){
                index1++;
            }

            if(index1==t.length()){
                return false;
            }
        }

        return true;
    }

    public boolean isSubsequence1(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            // i = pointer for iterating through string s

            final int index = s2.indexOf(s1.charAt(i));
            if (index == -1) {
                // if it was not found
                return false;
            }

            s2 = s2.substring(index + 1); // update t to be whatever is after this index
        }

        return true;
    }

public boolean isSubsequence2(String s, String t){
        if (s==null && t==null) return false;
        if (s.equals(" ") && t.equals(" ")) return false;
        if (s.length()>t.length()) return false;

    char []s1= s.toCharArray();
    char []t1= t.toCharArray();
    int index1=0;
    int index2=0;
    while (index2<t.length()){
        if (s1[index1]==t1[index2]){
            if (index1==s.length()-1){
                return true;
            }index1++;
        }
        index2++;
    }

        return false;
    }
    public boolean isSubsequence3(String s, String t) {
        if(s.length() == 0) return true;

        int i= 0, j = 0;
        while(i<s.length() && j<t.length()){
            if(t.charAt(j)==s.charAt(i)){
                i++;
            }
            j++;
        }

        if(i!=s.length())return false;
        return true;
    }
    public boolean isSubsequence4(String s, String t) {
        int i = 0;
        for(int j = 0;j<t.length() && i<s.length();j++)
            if(t.charAt(j) == s.charAt(i)) i++;
        return i == s.length();
    }
    public boolean isSubsequence5(String s, String t) {
        if(s.length() == 0){
            return true;
        }

        Stack<Character> subStack = new Stack<>();
        for(int i = s.length()-1; i >= 0 ; i--){
            subStack.push(s.charAt(i));
        }

        for(int i = 0; i < t.length(); i++){
            if(subStack.peek() == t.charAt(i)){
                subStack.pop();
            }

            if(subStack.isEmpty()){
                return true;
            }
        }

        return false;
    }
}
