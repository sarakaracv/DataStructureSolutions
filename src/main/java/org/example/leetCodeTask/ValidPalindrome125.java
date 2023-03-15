package org.example.leetCodeTask;

public class ValidPalindrome125 {
    public static void main(String[] args) {
        String an="amma";
        System.out.println();
    }
    public static boolean isPalindrome(String s){
        if (s.isEmpty())return true;
        int start=0,last=s.length()-1;
        while (start<=last){
            char first=s.charAt(start);
            char end=s.charAt(last);
            if (!Character.isLetterOrDigit(first))start++;
            else if (!Character.isLetterOrDigit(end)) last--;
            else {
                if (Character.toLowerCase(first)!=Character.toLowerCase(end)) return false;
            }
            start++;
            last--;
        }
        return true;
    }
    public boolean isPalindrome2(String s) {
        // convert Strign s to lowerCase with regex
        String tempString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        // Reverse the tempString
        String rev = new StringBuffer(tempString).reverse().toString();
        // check tempString to rev String
        return tempString.equals(rev);
    }
    public boolean isPalindrome3(String s){
        String low=s.replaceAll("[^xA-Za-z0-9]","").toLowerCase();
        String rev=new StringBuffer(s).reverse().toString().toLowerCase();
        return low.equals(rev);
    }
    public boolean isPalindrome4(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
