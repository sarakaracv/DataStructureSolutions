package org.example.leetCodeTask;

public class ReverseString344 {
    public static void main(String[] args) {

    }
    public void reverseString(char [] s){
    int left=0, right=s.length-1;

    while (left<right){
        char temp=s[left];
        s[left++]=s[right];
        s[right--]=temp;
    }
    }

        public void reverseString2(char[] s) {
        StringBuilder sb= new StringBuilder();
        sb.append(s);
        sb.reverse();
        String reverse= sb.toString();
            for (int i = 0; i < s.length; i++) {
                s[i]=reverse.charAt(i);
            }
        }
}
