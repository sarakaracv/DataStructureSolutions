package org.example.leetCodeTask;

public class RepeatedStringMatch686 {
    public static void main(String[] args) {
        String aman= "aaabbccc";

        System.out.println(repeatedStringMatch(aman,"a"));
    }

    public static int repeatedStringMatch(String a, String b) {

        String copyA = "";
        int count=0;
        while(copyA.length()<b.length()){
            copyA+=a;
            count++;
        }
        if(copyA.indexOf(b)>=0)
            return count;
        if((copyA+a).indexOf(b)>=0)
            return ++count;
        return -1;
    }

    static int repeatedStringMatch2(String  a, String b) {
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
