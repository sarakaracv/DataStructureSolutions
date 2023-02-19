package org.example.leetCodeTask;

public class Pow50 {
    public static void main(String[] args) {
        double x = 2.00000;
        int n = 10;
        System.out.println(myPow(x,n));
    }
    public static double myPow(double x, int n){
        if (n==0) return 1;
        else if (n%2==0) {return myPow(x*x, n/2); }
        else if (n%2==1) {return x*myPow(x,n-1);}
        return 1/myPow(x,-n);
    }

}
