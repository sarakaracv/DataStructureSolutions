package org.example.leetCodeTask;

public class WildcardMatching44 {
    public static void main(String[] args) {
        String str="aa";
        String match="a*x";
        System.out.println(isMatch(str,match));
        //? single //* every each character
    }
    public static boolean isMatch(String s, String p) {
        int i=0;
        int j=0;
        int star=-1;
        int last=-1;
        while(i<s.length()){
            if(j<p.length() && (s.charAt(i)==p.charAt(j) ||
                    p.charAt(j)=='?')){
                i++;
                j++;
            }else if(j<p.length() && p.charAt(j)=='*'){
                star=j;
                last=i;
                j++;
            }else if(star!=-1){
                j=star+1;
                last++;
                i=last;

            }else{
                return false;
            }
        }
        while(j<p.length() && p.charAt(j)=='*') j++;

        if(i!=s.length() || j!=p.length()) return false;

        return true;
    }
        public boolean isMatchNot1passed(String s, String p) {
          int n= p.length()-1;
            int m= s.length()-1;
           if (n<0&&m<0) return true;
           if (n<0&&m>=0) return false;
           if (n>=0&&m>=0) {
               for (int i = 0; i <= 0; i++) {
                   if (s.charAt(i) != '*') {
                       return false;
                   }
                   if (s.charAt(m) > p.charAt(n)) return false;
                   if (s.charAt(n) == p.charAt(m) || p.charAt(m) == '?') {
                       return true;
                   }
                   if (p.charAt(m) == '*') {
                       return true;
                   }

               }
           }

           return false;
        }
}
