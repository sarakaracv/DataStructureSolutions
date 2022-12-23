package org.example.leetCodeTask;

public class DivideTwoIntegers29 {
    public static void main(String[] args) {

    }
    public int divide1(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        return (int) dividend/divisor;
    }

}
