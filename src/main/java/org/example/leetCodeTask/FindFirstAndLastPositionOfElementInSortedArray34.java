package org.example.leetCodeTask;

import java.util.HashSet;
import java.util.Set;

public class FindFirstAndLastPositionOfElementInSortedArray34 {
    public static void main(String[] args) {
String aman= "aaabbccc";

        System.out.println(repeatedStringMatch(aman,"a"));
    }

    static int repeatedStringMatch(String  a, String b) {
        int initLen = a.length();
        String aCopy = a;
        int count = 1;
        //multiply the string a until it will be >= to length of String b
        while(initLen < b.length()){
            aCopy = aCopy + a;
            initLen = initLen + a.length();
            count = count + 1;
        }

        //check if a is substring of b
        if(isSubString(aCopy , b) != -1){
            return count;
        }
        if(isSubString(aCopy+a , b) != -1){
            return count+1;
        }


        return -1;
    }
    private static int isSubString(String a, String b){
        return a.indexOf(b);
    }
}
