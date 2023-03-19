package org.example.leetCodeTask;

public class PowerOfThree326 {
    public static void main(String[] args) {

    }
    public boolean isPowerOfThree1(int n){
        if (n<=0) return false;
        while(n%3==0){
            n/=3;
        }
        return n==1;
    }
    public boolean isPowerOfThree2(int n) {
        while(n != 1){
            if(n < 3 || n % 3 != 0) return false;
            n /= 3;
        }
        return true;
    }
    public boolean isPowerOfThree3(int n) {
        if(n<=0) return false;
        if(n%3==0) return isPowerOfThree3(n/3);
        if(n==1) return true;
        return false;
    }
}
